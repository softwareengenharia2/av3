package br.com.fean.si.es2.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Endereco extends Bean {

    @OneToOne
    private Usuario usuario;

    private String cep;

    private Integer numero;

    private String  cidade;

    private String bairro;

    private String logradouro;

    private String complemento;

    private String estado;

    public Endereco(){
    }
}
