package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.IdClass;;

@Entity
@Table(name = "ponto")
@IdClass(PontoPK.class)
public class Ponto implements Serializable{
	private static final long serialVersionUID = 1L;

	public Ponto() {
		super();
	}
	
	@Id
	@ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;
	
	@Id
	@Column(name = "ponto_seq", nullable = false, length = 17)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "compra_id")
    private Compra compra;

	@Column(name = "codigo_tipo_conversao", nullable = false, length = 2)
	private Integer codigoTipoConversao;

	@Column(name = "cartao", nullable = true)
	private Integer cartao;
	
	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "pontos", nullable = true)
	private Long pontos;
	
	@Column(name = "valor", nullable = true)
	private Double valor;
	
	@Column(name = "data", nullable = true)
	private Date data;

	@Column(name = "validade", nullable = true)
	private Date validade;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

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
		Ponto other = (Ponto) obj;
		if (id != other.id)
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Integer getCodigoTipoConversao() {
		return codigoTipoConversao;
	}

	public void setCodigoTipoConversao(Integer codigoTipoConversao) {
		this.codigoTipoConversao = codigoTipoConversao;
	}

	public Integer getCartao() {
		return cartao;
	}

	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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