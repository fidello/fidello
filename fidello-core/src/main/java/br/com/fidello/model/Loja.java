package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loja")
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "loja_matriz_id", referencedColumnName = "loja_id", updatable = false, insertable = false)  
    private Loja matriz;  
  
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "matriz")  
    private List<Loja> filiais;  

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loja_id", nullable = false, length = 11)
	private int id;


	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="loja_id")
	private Collection<LojaCampanha> lojaCampanhas;
	public void addLojaCampanha(LojaCampanha lojaCampanha){
		
		if (this.lojaCampanhas == null)
			lojaCampanhas = new ArrayList<LojaCampanha>();
		
		this.lojaCampanhas.add(lojaCampanha);
	}
    
	@Column(name = "nome_fantasia", nullable = true, length = 100)
	private String nomeFantasia;
	
	@Column(name = "indicador_matriz", nullable = true)
	private Boolean indicadorMatriz;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {

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

	public Collection<LojaCampanha> getLojaCampanhas() {
		return lojaCampanhas;
	}

	public void setLojaCampanhas(Collection<LojaCampanha> lojaCampanhas) {
		this.lojaCampanhas = lojaCampanhas;
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Boolean getIndicadorMatriz() {
		return indicadorMatriz;
	}

	public void setIndicadorMatriz(Boolean indicadorMatriz) {
		this.indicadorMatriz = indicadorMatriz;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Loja getMatriz() {
		return matriz;
	}

	public void setMatriz(Loja matriz) {
		this.matriz = matriz;
	}

	public List<Loja> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Loja> filiais) {
		this.filiais = filiais;
	}
	
}