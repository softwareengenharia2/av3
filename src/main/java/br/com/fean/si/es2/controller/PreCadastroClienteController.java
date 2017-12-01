package br.com.fean.si.es2.controller;

import br.com.fean.si.es2.business.PreCadastroClienteBusiness;
import br.com.fean.si.es2.dto.PreCadastroClienteDTO;
import br.com.fean.si.es2.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
@RequestMapping("pre-cadastro-cliente")
public class PreCadastroClienteController {

    @Autowired
	private PreCadastroClienteBusiness business;

    @RequestMapping(method = RequestMethod.POST)
    public Callable<Response> process(@RequestBody PreCadastroClienteDTO dto) {
        return () -> {
            business.process(dto);
            return Response.returnMessage("Em breve você receberá um e-mail referente a resposta do cadastro");
        };
    }
}
