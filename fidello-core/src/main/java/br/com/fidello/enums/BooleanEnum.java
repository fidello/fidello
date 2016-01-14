package br.com.fidello.enums;


public enum BooleanEnum {
	
	SIM(1, "Sim"), 
	NAO(0, "Não");
	
	private int codigo;
	private String texto;
	
	private BooleanEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static Boolean getBooleanFromCodigo(int codigo){
		
		for (BooleanEnum boo : values()) {

			if (boo.getCodigo() == codigo) {

				if(boo.getCodigo() == 1){
					return true;
				}else if(boo.getCodigo() == 2){
					return false;
				}else{
					return null;
				}

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