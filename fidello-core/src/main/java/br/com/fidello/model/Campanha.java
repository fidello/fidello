package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campanha")
public class Campanha implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "campanha_id", nullable = false, length = 11)
	private int id;

	@Column(name = "nome", nullable = false, length = 11)
	private String nome;

	@Column(name = "validade_tipo", nullable = false, length = 2)
	private Integer validadeTipo;

	@Column(name = "validade", nullable = true)
	private Integer validade;
	
	@Column(name = "taxa", nullable = true)
	private Double taxa;
	
	@Column(name = "data_inicio", nullable = true)
	private Date dataInicio;
	
	@Column(name = "data_fim", nullable = true)
	private Date dataFim;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Column(name = "tipo_conversao", nullable = true)
	private Integer tipoConversao;
	
	private Boolean campanhaPorPontos;
		
	@Override
	public int hashCode() {
		return id;
	}

	public Boolean getCampanhaPorPontos() {
		return campanhaPorPontos;
	}

	public void setCampanhaPorPontos(Boolean campanhaPorPontos) {
		this.campanhaPorPontos = campanhaPorPontos;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValidadeTipo() {
		return validadeTipo;
	}

	public void setValidadeTipo(Integer validadeTipo) {
		this.validadeTipo = validadeTipo;
	}

	public Integer getValidade() {
		return validade;
	}

	public void setValidade(Integer validade) {
		this.validade = validade;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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

	public Integer getTipoConversao() {
		return tipoConversao;
	}

	public void setTipoConversao(Integer tipoConversao) {
		this.tipoConversao = tipoConversao;
		if ((tipoConversao == 1) || (tipoConversao == 4) ||
		(tipoConversao == 6) || (tipoConversao == 8))
		{
			campanhaPorPontos = true;
		} else {
			campanhaPorPontos = false;
		}
	}


}