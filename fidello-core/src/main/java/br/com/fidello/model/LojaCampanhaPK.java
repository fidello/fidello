package br.com.fidello.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LojaCampanhaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public LojaCampanhaPK() {
		super();
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="loja_id")
	private Loja loja;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="campanha_id")
	private Campanha campanha;

	@Override
	public int hashCode() {
		return loja.getId()+campanha.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LojaCampanhaPK) {
			LojaCampanhaPK lojaCampanhaPK = (LojaCampanhaPK) obj;
			return lojaCampanhaPK.campanha == this.campanha && lojaCampanhaPK.loja == this.loja;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public Campanha getcampanha() {
		return campanha;
	}

	public void setcampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}