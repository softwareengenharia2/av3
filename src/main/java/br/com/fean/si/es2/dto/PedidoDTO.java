package br.com.fean.si.es2.dto;

import br.com.fean.si.es2.bean.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

    private Long id;

    private String mensagem;

    private Long usuarioId;

    private Double quantidade;

    public PedidoDTO(){

    }

    public PedidoDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoDTO setUsuarioId(Long usuarioId){
        this.usuarioId = usuarioId;
        return this;
    }

    public PedidoDTO setQuantidade(Double quantidade){
        this.quantidade = quantidade;
        return this;
    }
}
