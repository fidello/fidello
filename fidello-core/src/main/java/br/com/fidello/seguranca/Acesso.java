package br.com.fidello.seguranca;

public enum Acesso {
	
	CADASTRAR_USUARIO(1, "Cadastrar Usuário"), 
	LISTAR_USUARIOS(2, "Listar Usuários"),
	INCLUIR_PONTOS(3, "Incluir Pontos");
	
	private int codigo;
	private String texto;
	
	private Acesso(int codigo, String texto) {
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