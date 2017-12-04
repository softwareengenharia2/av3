package br.com.fean.si.es2.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fean.si.es2.bean.Cliente;
import br.com.fean.si.es2.dto.PreCadastroClienteDTO;
import br.com.fean.si.es2.response.ResponseException;
import br.com.fean.si.es2.utils.DocumentosUtils;
import br.com.fean.si.es2.utils.EnviadorDeEmail;

@Service
public class PreCadastroClienteBusiness {

    @Autowired
    private RestTemplate rest;

    private Gson gson = new Gson();

    public void process(PreCadastroClienteDTO dto) {
        Cliente bean = new Cliente(dto);
        if ( !DocumentosUtils.isValidCNPJ(bean.getCnpj()) ) {
            throw new ResponseException("CNPJ inválido");
        }

        boolean status = verificarCnpjSerasa(bean);
        EnviadorDeEmail.enviaEmailDePreCadastro(status, bean.getEmail());
        if (status) {
            //dao.persist(bean);
        }
    }

    private boolean verificarCnpjSerasa(Cliente bean) {
        boolean status = true;
        String cnpj= DocumentosUtils.getCnpjApenasComLetras(bean.getCnpj());
        try {
            String uri = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;
            String response = rest.getForObject(uri, String.class);
            JsonObject responseJson = gson.fromJson(response, JsonObject.class);
            status = responseJson.get("situacao").getAsString().equals("ATIVA");
        } catch (RestClientException e) {
            status = false;
        }
        return status;
    }
}
