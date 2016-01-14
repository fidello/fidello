package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loja_campanha")
@IdClass(LojaCampanhaPK.class)
public class LojaCampanha implements Serializable{
	private static final long serialVersionUID = 1L;

	public LojaCampanha() {
		super();
	}
	
	
	@Id
	@ManyToOne
    @JoinColumn(name = "loja_id", referencedColumnName = "loja_id")
    private Loja loja;

	@Id
	@ManyToOne
    @JoinColumn(name = "campanha_id", referencedColumnName = "campanha_id")
    private Campanha campanha;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campanha == null) ? 0 : campanha.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
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
		LojaCampanha other = (LojaCampanha) obj;
		if (campanha == null) {
			if (other.campanha != null)
				return false;
		} else if (!campanha.equals(other.campanha))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LojaCampanha [loja=" + loja + ", campanha=" + campanha + "]";
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
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
}