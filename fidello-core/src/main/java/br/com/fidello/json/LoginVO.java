package br.com.fidello.json;


/**
 * 
 */
/**
 * @author guilh
 *
 */
public class LoginVO {
	
	
	private String documento;
	
	private String senha;
	
	private Integer tipoUsuario;

	
	public LoginVO() {
		super();
		
	}


	public LoginVO(String documento, String senha) {
		super();
			this.documento = documento;
		this.senha = senha;
	}



	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


		
	
	
	
	
	
}