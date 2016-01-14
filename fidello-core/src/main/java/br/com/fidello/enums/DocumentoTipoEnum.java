package br.com.fidello.enums;

public enum DocumentoTipoEnum {
	
	CPF(1, "CPF"), 
	CNPJ(2, "CNPJ");
	
	private int codigo;
	private String texto;
	
	private DocumentoTipoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getTexto() {
		return texto;
	}
	
	public static DocumentoTipoEnum getFromCodigo(int codigo){
		
		for (DocumentoTipoEnum documentoTipo : values()) {

			if (documentoTipo.getCodigo() == codigo) {

				return documentoTipo;

			}

		}

		return null;
	}
	
	@Override
	public String toString() {
		return this.getTexto();
	}
	
}