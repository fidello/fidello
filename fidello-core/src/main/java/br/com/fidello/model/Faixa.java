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
@Table(name = "faixa")
public class Faixa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faixa_id", nullable = false, length = 11)
	private int id;
	
	@Id
	@Column(name = "campanha_id", nullable = false, length = 11)
	private int campanhaId;

	@Column(name = "valor_inicio", nullable = true)
	private Double valor_inicio;
	
	@Column(name = "valor_fim", nullable = true)
	private Double valor_fim;
	
	@Column(name = "data_inicio", nullable = true)
	private Date dataInicio;
	
	@Column(name = "data_fim", nullable = true)
	private Date dataFim;
	
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

	public int getCampanhaId() {
		return campanhaId;
	}

	public void setCampanhaId(int campanhaId) {
		this.campanhaId = campanhaId;
	}

	public Double getValor_inicio() {
		return valor_inicio;
	}

	public void setValor_inicio(Double valor_inicio) {
		this.valor_inicio = valor_inicio;
	}

	public Double getValor_fim() {
		return valor_fim;
	}

	public void setValor_fim(Double valor_fim) {
		this.valor_fim = valor_fim;
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

}