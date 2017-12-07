package br.com.fean.si.es2.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Endereco extends Bean {

    @OneToOne
    private Usuario usuario;

    public Endereco(){
    }
}
