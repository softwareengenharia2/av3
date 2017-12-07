package br.com.fean.si.es2.dto;

import br.com.fean.si.es2.bean.Endereco;
import br.com.fean.si.es2.bean.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String documento;

    private String email;

    private Endereco enderecoBean;

    private String telefone;

    private List<PedidoDTO> pedidos;

    public UsuarioDTO(Usuario bean){
        id = bean.getId();
        documento = bean.getDocumento();
        email = bean.getEmail();
        enderecoBean = bean.getEndereco();
        telefone = bean.getTelefone();
        pedidos = new ArrayList<>();
        bean.getPedidos().forEach( p -> pedidos.add(new PedidoDTO()
                                                        .setId(p.getId())
                                                        .setQuantidade(p.getQuantidade())
                                                        .setUsuarioId(p.getUsuario().getId()))    );
    }

    public UsuarioDTO(){

    }

}
