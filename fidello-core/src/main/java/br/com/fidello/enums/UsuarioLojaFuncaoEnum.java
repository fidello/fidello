package br.com.fidello.enums;


public enum UsuarioLojaFuncaoEnum {
	
	PROPRIETARIO(1, "Proprietário"), 
	VENDEDOR(2, "Vendedor");
	
	private int codigo;
	private String texto;
	
	private UsuarioLojaFuncaoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static UsuarioLojaFuncaoEnum getUsuarioLojaFuncaoFromCodigo(int codigo){
		
		for (UsuarioLojaFuncaoEnum usuarioLojaFuncao : values()) {

			if (usuarioLojaFuncao.getCodigo() == codigo) {

				return usuarioLojaFuncao;

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