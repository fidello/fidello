package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "email")
//@IdClass(EmailPK.class)
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;

	public Email() {
		super();
	}
	
	public Email(String email, Boolean preferencial) {
		super();
		this.email = email;
		this.preferencial = preferencial;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id", nullable = false, length = 11)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
 
	@Column(name = "email", nullable = true, length = 50)
	private String email;

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
		if (obj instanceof Email) {
			Email email = (Email) obj;
			return email.id == this.id;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getPreferencial() {
		return preferencial;
	}

	public void setPreferencial(Boolean preferencial) {
		this.preferencial = preferencial;
	}

}