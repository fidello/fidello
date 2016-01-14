package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_loja")
@IdClass(UsuarioLojaPK.class)
public class UsuarioLoja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuario;

	@Id
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="loja_id", referencedColumnName = "loja_id")
	private Loja loja;
	
	@Column(name = "funcao", nullable = true)
	private Integer funcao;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioLoja other = (UsuarioLoja) obj;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Integer getFuncao() {
		return funcao;
	}

	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}