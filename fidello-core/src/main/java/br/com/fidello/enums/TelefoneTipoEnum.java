package br.com.fidello.enums;

public enum TelefoneTipoEnum {
	
	CELULAR(1, "Celular"), 
	RESIDENCIAL(2, "Residencial"),
	COMERCIAL(3, "Comercial");
	
	private int codigo;
	private String texto;
	
	private TelefoneTipoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static TelefoneTipoEnum getTelefoneTipoFromCodigo(int codigo){
		
		for (TelefoneTipoEnum telefoneTipo : values()) {

			if (telefoneTipo.getCodigo() == codigo) {

				return telefoneTipo;

			}

		}

		return null;
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