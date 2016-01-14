package br.com.fidello.json;

import javax.xml.bind.annotation.XmlRootElement;

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


		
	
	
	
	
	
}