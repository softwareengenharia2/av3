package br.com.fean.si.es2.business;

import br.com.fean.si.es2.bean.TipoDeUsuario;
import br.com.fean.si.es2.bean.Usuario;
import br.com.fean.si.es2.dao.UsuarioDAO;
import br.com.fean.si.es2.dto.PrePedidoDTO;
import br.com.fean.si.es2.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioBusiness {

    @Autowired
    private UsuarioDAO dao;

    public Usuario getClienteByCnpj(String cnpj) {
        return dao.getByCnpj(cnpj);
    }

    public Boolean containsCnpj(String cnpj) {
        Usuario usuario = getClienteByCnpj(cnpj);
        return usuario == null ? true : false;
    }

    private Usuario insert(Usuario usuario, TipoDeUsuario tipo) {
        usuario.setTipoDeUsuario(tipo);
        dao.persist(usuario);
        return usuario;
    }


    public Usuario insert(PrePedidoDTO dto, TipoDeUsuario tipo){
        return insert(new Usuario(dto), tipo);
    }
    public Usuario insert(UsuarioDTO dto, TipoDeUsuario tipo){
        return insert(new Usuario(dto), tipo);
    }

    public List<UsuarioDTO> list() {
        Optional<List<Usuario>> beans = Optional.ofNullable(dao.list());
        List<UsuarioDTO> dtos = new ArrayList<>();

        beans.ifPresent(obj -> obj.forEach(b -> dtos.add(new UsuarioDTO(b))) );
        return dtos;
    }


    public void completarPreCadastro(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto);
        usuario.setTipoDeUsuario(TipoDeUsuario.CLIENTE);
        dao.update(usuario);
    }
}
