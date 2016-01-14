package br.com.fidello.enums;

public enum EnderecoTipoEnum {
	
	RESIDENCIAL(1, "Residencial"), 
	COMERCIAL(2, "Comercial");
	
	private int codigo;
	private String texto;
	
	private EnderecoTipoEnum(int codigo, String texto) {
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