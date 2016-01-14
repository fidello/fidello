package br.com.fidello.enums;

public enum CartaoPontoStatusEnum {
	
	ATIVO(1, "Ativo"), 
	INATIVO(2, "Inativo"),
	SUSPENSO(3, "Suspenso");
	
	private int codigo;
	private String texto;
	
	private CartaoPontoStatusEnum(int codigo, String texto) {
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