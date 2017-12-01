package br.com.fean.si.es2.response;

public class Error {

	private String campo;
	private String mensagem;

	public Error(String campo, String mensagem, boolean isTranslate) {
		super();
		this.campo = campo;
		this.mensagem = isTranslate ? mensagem : MessageSystem.formatMessage(mensagem);
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
