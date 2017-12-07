package br.com.fean.si.es2.bean;

public enum TipoDeUsuario {

    CLIENTE ("Usuario"),
    MARKETING ("Marketing");

    private String tipo;

    private TipoDeUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
