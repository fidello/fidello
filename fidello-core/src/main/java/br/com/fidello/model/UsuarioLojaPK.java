package br.com.fidello.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioLojaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public UsuarioLojaPK() {
		super();
	}
	
//	public UsuarioLojaPK(int usuarioId, int lojaId) {
//		super();
//		this.usuario = usuario;
//		this.loja = loja;
//	}
//
//	private int usuarioId;
//	private int lojaId;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="loja_id")
	private Loja loja;

	@Override
	public int hashCode() {
		return usuario.getId()+loja.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UsuarioLojaPK) {
			UsuarioLojaPK usuarioLojaPK = (UsuarioLojaPK) obj;
			return usuarioLojaPK.usuario == this.usuario && usuarioLojaPK.loja == this.loja;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

//	public int getUsuarioId() {
//		return usuarioId;
//	}
//
//	public void setUsuarioId(int usuarioId) {
//		this.usuarioId = usuarioId;
//	}
//
//	public int getLojaId() {
//		return lojaId;
//	}
//
//	public void setLojaId(int lojaId) {
//		this.lojaId = lojaId;
//	}


}