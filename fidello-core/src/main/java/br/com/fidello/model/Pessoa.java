package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}
	public Pessoa(Integer identificacaoTipo) {
		super();
		this.setIdentificacaoTipo(identificacaoTipo);
	}

	@Transient
	private Integer identificacaoTipo;
	
	@OneToOne(mappedBy = "pessoa")
	private Usuario usuario;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="pessoa_id")
	private Collection<Email> emails;
	public void addEmail(Email email){
		
		if (this.emails == null)
			emails = new ArrayList<Email>();
		
		this.emails.add(email);
	}
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="pessoa_id")
	private Collection<Telefone> telefones;
	public void addTelefone(Telefone telefone){
		
		if (this.telefones == null)
			telefones = new ArrayList<Telefone>();
		
		this.telefones.add(telefone);
	}
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="pessoa_id")
	private Collection<Endereco> enderecos;
	public void addEndereco(Endereco endereco){
		
		if (this.enderecos == null)
			enderecos = new ArrayList<Endereco>();
		
		this.enderecos.add(endereco);
	}
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="pessoa_id")
	private Collection<Loja> lojas;
	public void addLoja(Loja loja){
		
		if (this.lojas == null)
			lojas = new ArrayList<Loja>();
		
		this.lojas.add(loja);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "numero_srf", nullable = true, unique = true, length = 14)
	private String numeroSRF;

	@Column(name = "nome", nullable = true, length = 50)
	private String nome;
	
	@Column(name = "documento", nullable = true, length = 18)
	private String documento;
	
	@Column(name = "documento_tipo", nullable = true, length = 1)
	private Integer documentoTipo;
	
	@Column(name = "data_nascimento", nullable = true)
	private Date dataNascimento;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) obj;
			return pessoa.getId() == id;
		}

		return false;
	}

	public Integer getIdentificacaoTipo() {
		return identificacaoTipo;
	}

	public void setIdentificacaoTipo(Integer identificacaoTipo) {
		this.identificacaoTipo = identificacaoTipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroSRF() {
		return numeroSRF;
	}

	public void setNumeroSRF(String numeroSRF) {
		this.numeroSRF = numeroSRF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Collection<Email> getEmails() {
		return emails;
	}

	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Collection<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(Collection<Loja> lojas) {
		this.lojas = lojas;
	}
	public Collection<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}
	public Integer getDocumentoTipo() {
		return documentoTipo;
	}
	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}