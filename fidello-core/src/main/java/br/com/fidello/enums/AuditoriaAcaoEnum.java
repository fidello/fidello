package br.com.fidello.enums;

public enum AuditoriaAcaoEnum {
	
	ATIVAR_CLIENTE(1, "Ativar Cliente"), 
	ATIVAR_LOJA(2, "Ativar loja");
	
	private int codigo;
	private String texto;
	
	private AuditoriaAcaoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getTexto() {
		return texto;
	}
	
	@Override
	public String toString() {
		return this.getTexto();
	}
	
}