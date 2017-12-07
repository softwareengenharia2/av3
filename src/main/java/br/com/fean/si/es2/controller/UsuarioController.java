package br.com.fean.si.es2.controller;

import br.com.fean.si.es2.bean.TipoDeUsuario;
import br.com.fean.si.es2.bean.Usuario;
import br.com.fean.si.es2.business.UsuarioBusiness;
import br.com.fean.si.es2.dto.UsuarioDTO;
import br.com.fean.si.es2.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioBusiness business;

    @RequestMapping(method = RequestMethod.GET, value = "/{cnpj}")
    public Response getByCnpj(@PathVariable("{cnpj}") String cnpj){
        Usuario cliente = business.getClienteByCnpj(cnpj);
        return Response.returnObject(cliente);
    }

    @RequestMapping(method = RequestMethod.POST, value = "insert-usuario-marketing")
    public Response insertUsuarioMarketing(UsuarioDTO dto) {
        business.insert(dto, TipoDeUsuario.MARKETING);
        return Response.returnMessage("Usuario do marketing cadastrado com sucesso");
    }

    @RequestMapping(method = RequestMethod.POST, value = "insert-usuario-cliente")
    public Response insertUsuarioCliente(UsuarioDTO dto) {
        business.insert(dto, TipoDeUsuario.CLIENTE);
        return Response.returnMessage("Cliente cadastrado com sucesso");
    }

    @RequestMapping(method = RequestMethod.POST, value = "completar-pre-cadastro")
    public Response completarPreCadastro(UsuarioDTO dto) {
        business.completarPreCadastro(dto);
        return Response.returnMessage("Pré cadastro completado com sucesso");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Response list(){
        List<UsuarioDTO> usuarios = business.list();
        return Response.returnObject(usuarios);
    }
}
