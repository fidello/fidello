package br.com.fidello.enums;

public enum PessoaIdentificacaoTipoEnum {
	
	CPF(DocumentoTipoEnum.CPF.getCodigo(), "CPF"), 
	CNPJ(DocumentoTipoEnum.CNPJ.getCodigo(), "CNPJ"),
	EMAIL(3, "E-Mail");
	
	private int codigo;
	private String texto;
	
	private PessoaIdentificacaoTipoEnum(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public static PessoaIdentificacaoTipoEnum getPessoaIdentificacaoTipoFromCodigo(int codigo){
		
		for (PessoaIdentificacaoTipoEnum pessoaIdentificacaoTipo : values()) {

			if (pessoaIdentificacaoTipo.getCodigo() == codigo) {

				return pessoaIdentificacaoTipo;

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