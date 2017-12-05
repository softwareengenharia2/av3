package br.com.fean.si.es2.dto;

import java.util.Date;

public class ArtigoDTO {

    private Long idArtigo;
    private String titulo;
    private String conteudo;
    private String tipoArtigo;
    private Date data;
    private Boolean aprovado;

    public ArtigoDTO() {
    }

    public ArtigoDTO(Long idArtigo, String titulo, String conteudo, String tipoArtigo, Date data, Boolean aprovado) {
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
