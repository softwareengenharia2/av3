package br.com.fean.si.es2.response;

public class Error {

	private String campo;
	private String mensagem;

	public Error(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
