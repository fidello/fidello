package br.com.fidello.json;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */
/**
 * @author guilh
 *
 */
public class UsuarioVO{
	
	private String nome; 
	
	private String documento;
	
	private String email;
	
	private String senha;
	
	
	public UsuarioVO() {
		super();
		
	}


	public UsuarioVO(String nome, String documento, String email, String senha) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "UsuarioJson [nome=" + nome + ", documento=" + documento
				+ ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
	
	
	
}