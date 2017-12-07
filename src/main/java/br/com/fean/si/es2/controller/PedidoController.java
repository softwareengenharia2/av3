package br.com.fean.si.es2.controller;

import br.com.fean.si.es2.business.PedidoBusiness;
import br.com.fean.si.es2.dto.PrePedidoDTO;
import br.com.fean.si.es2.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoBusiness business;

    @RequestMapping(method = RequestMethod.POST, value = "/pre-pedido")
    public Callable<Response> process(@RequestBody PrePedidoDTO dto) {
        return () -> {
            business.processPrePedido(dto);
            return Response.returnMessage("Em breve você receberá um e-mail referente a resposta do cadastro");
        };
    }
}
