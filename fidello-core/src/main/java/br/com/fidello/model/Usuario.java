package br.com.fidello.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.fidello.enums.UsuarioTipoEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id", nullable = false, length = 11)
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="usuario_id")
	private Collection<UsuarioLoja> usuarioLojas;
	public void addUsuarioLoja(UsuarioLoja usuarioLoja){
		
		if (this.usuarioLojas == null)
			usuarioLojas = new ArrayList<UsuarioLoja>();
		
		this.usuarioLojas.add(usuarioLoja);
	}

	@Column(name = "senha", nullable = true, length = 100)
	private String senha;
	
	@Column(name = "usuario_tipo", nullable = true, length = 2)
	private Integer usuarioTipo;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	public String getUsuarioTipoTexto(){
		return UsuarioTipoEnum.fromCodigo(this.usuarioTipo).getTexto();
	}
	
	public boolean isAdmin() {
		return UsuarioTipoEnum.ADMIN.equals(usuarioTipo);
	}

	public boolean isCliente() {
		return UsuarioTipoEnum.CLIENTE.equals(usuarioTipo);
	}

	public boolean isLoja() {
		return UsuarioTipoEnum.LOJA.equals(usuarioTipo);
	}
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return usuario.getId() == id;
		}

		return false;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioTipoEnum getUsuarioTipo() {
		return UsuarioTipoEnum.fromCodigo(usuarioTipo);
	}

	public void setUsuarioTipo(UsuarioTipoEnum usuarioTipo) {
		this.usuarioTipo = usuarioTipo.getCodigo();
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<UsuarioLoja> getUsuarioLojas() {
		return usuarioLojas;
	}

	public void setUsuarioLojas(Collection<UsuarioLoja> usuarioLojas) {
		this.usuarioLojas = usuarioLojas;
	}
	
}