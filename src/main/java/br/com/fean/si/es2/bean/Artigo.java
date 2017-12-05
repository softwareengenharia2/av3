package br.com.fean.si.es2.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "artigo")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artigo")
    private Long idArtigo;
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
        this.idArtigo = idArtigo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tipoArtigo = tipoArtigo;
        this.data = data;
        this.aprovado = aprovado;
    }

    public Long getIdArtigo() {
        return idArtigo;
    }

    public void setIdArtigo(Long idArtigo) {
        this.idArtigo = idArtigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTipoArtigo() {
        return tipoArtigo;
    }

    public void setTipoArtigo(String tipoArtigo) {
        this.tipoArtigo = tipoArtigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

}
