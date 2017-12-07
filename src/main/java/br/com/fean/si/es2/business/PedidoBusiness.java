package br.com.fean.si.es2.business;

import br.com.fean.si.es2.bean.Pedido;
import br.com.fean.si.es2.bean.TipoDeUsuario;
import br.com.fean.si.es2.bean.Usuario;
import br.com.fean.si.es2.dao.AbstractDAO;
import br.com.fean.si.es2.dto.PrePedidoDTO;
import br.com.fean.si.es2.response.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoBusiness {

    @Autowired
    private CNPJBusiness cnpjBusiness;

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @Autowired
    private AbstractDAO<Pedido> dao;

    public void processPrePedido(PrePedidoDTO dto) {
        validarCnpj(dto.getCnpj());
        Pedido pedido = new Pedido(dto);
        Usuario usuario = usuarioBusiness.insert(dto, TipoDeUsuario.CLIENTE);
        pedido.setUsuario(usuario);
        dao.persist(pedido);
    }

    private void validarCnpj(String cnpj) {

        if( usuarioBusiness.containsCnpj(cnpj) ) {
            throw new ResponseException("CNPJ já cadastrado. Acesse o ambiente interno para realizar novos pedidos.");
        }

        boolean statusCnpj = cnpjBusiness.verificarCnpjSerasa(cnpj);

        if (!statusCnpj) {
            throw new ResponseException("CNPJ não está ATIVO no SERASA");
        }
    }

}
