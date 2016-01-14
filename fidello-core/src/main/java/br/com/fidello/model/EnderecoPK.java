package br.com.fidello.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public EnderecoPK() {
	}
	
	public EnderecoPK(int id, int pessoaId) {
		super();
		this.id = id;
		this.pessoaId = pessoaId;
	}

	@Column(name = "endereco_id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;

	@Override
	public int hashCode() {
		return id+pessoaId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnderecoPK) {
			EnderecoPK enderecoPK = (EnderecoPK) obj;
			return enderecoPK.id == this.id && enderecoPK.pessoaId == this.pessoaId;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

}