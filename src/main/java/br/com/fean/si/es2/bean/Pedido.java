package br.com.fean.si.es2.bean;

import br.com.fean.si.es2.dto.PrePedidoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Pedido extends Bean {

    @ManyToOne
    private Usuario usuario;

    private Double quantidade;

    private String mensagem;

    public Pedido(){

    }

    public Pedido(PrePedidoDTO dto) {
        quantidade = dto.getQuantidade();
        mensagem = dto.getMensagem();
    }
}
