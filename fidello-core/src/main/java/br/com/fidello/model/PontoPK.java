package br.com.fidello.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PontoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public PontoPK() {
	}
	
	public PontoPK(int id, Loja loja) {
		super();
		this.id = id;
		this.loja.setId(loja.getId()) ;
	}
	
	@Column(name = "ponto_id", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="loja_id")
	private Loja loja;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PontoPK other = (PontoPK) obj;
		if (id != other.id)
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
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Loja getLojaId() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}