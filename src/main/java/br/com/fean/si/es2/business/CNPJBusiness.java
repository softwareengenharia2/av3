package br.com.fean.si.es2.business;

import br.com.fean.si.es2.response.ResponseException;
import br.com.fean.si.es2.utils.DocumentosUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
public class CNPJBusiness {

    @Autowired
    private RestTemplate rest;

    private Gson gson = new Gson();

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    public Boolean existsCnpj(String cnpj) {
        String cnpjApenasComLetras = DocumentosUtils.getCnpjApenasComLetras(cnpj);
        return usuarioBusiness.getClienteByCnpj(cnpjApenasComLetras) != null ? true : false;
    };

    public boolean verificarCnpjSerasa(String cnpj) {

        if(!DocumentosUtils.isValidCNPJ(cnpj)) {
            throw new ResponseException("CNPJ não é válido");
        }

        boolean status = true;
        String cnpjApenasComLetras= DocumentosUtils.getCnpjApenasComLetras(cnpj);
        try {
            String uri = "https://www.receitaws.com.br/v1/cnpj/" + cnpjApenasComLetras;
            String response = rest.getForObject(uri, String.class);
            JsonObject responseJson = gson.fromJson(response, JsonObject.class);
            status = responseJson.get("situacao").getAsString().equals("ATIVA");
        } catch (RestClientException e) {
            status = false;
        }
        return status;
    }


}
