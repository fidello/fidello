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
@Table(name = "telefone")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Telefone(){}
	public Telefone(String ddi, String ddd, String numero, Integer telefoneTipo, Boolean preferencial) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numero = numero;
		this.telefoneTipo = telefoneTipo;
		this.preferencial = preferencial;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "telefone_id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "ddi", nullable = true, length = 5)
	private String ddi;

	@Column(name = "ddd", nullable = true, length = 5)
	private String ddd;

	@Column(name = "numero", nullable = true, length = 15)
	private String numero;

	@Column(name = "telefone_tipo", nullable = true, length = 2)
	private Integer telefoneTipo;

	@Column(name = "indicador_preferencial", nullable = true)
	private Boolean preferencial;
	
	@Column(name = "data_inicio", nullable = true)
	private Date data_inicio;
	
	@Column(name = "data_fim", nullable = true)
	private Date data_fim;

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
		if (obj instanceof Telefone) {
			Telefone telefone = (Telefone) obj;
			return telefone.id == this.id;
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

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getTelefoneTipo() {
		return telefoneTipo;
	}

	public void setTelefoneTipo(Integer telefoneTipo) {
		this.telefoneTipo = telefoneTipo;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
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

	public Boolean getPreferencial() {
		return preferencial;
	}

	public void setPreferencial(Boolean preferencial) {
		this.preferencial = preferencial;
	}
}