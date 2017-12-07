package br.com.fean.si.es2.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "artigo")
@Getter
@Setter
public class Artigo extends Bean {

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "conteudo")
    private String conteudo;
    @Column(name = "tipo_artigo")
    private String tipoArtigo;
    @Column(name = "data_criacao")
    private Date data;
    @Column(name = "aprovado")
    private Boolean aprovado;

    public Artigo() {
    }

    public Artigo(Long idArtigo, String titulo, String conteudo, String tipoArtigo, Date data, Boolean aprovado) {
        this.id = idArtigo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tipoArtigo = tipoArtigo;
        this.data = data;
        this.aprovado = aprovado;
    }

}
