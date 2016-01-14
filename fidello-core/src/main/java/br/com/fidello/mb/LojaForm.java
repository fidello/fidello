package br.com.fidello.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.fidello.enums.BooleanEnum;
import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.TelefoneTipoEnum;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Telefone;

public class LojaForm implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer documentoTipoLoja = DocumentoTipoEnum.CNPJ.getCodigo();
	private String cpfLoja;
	private String cnpjLoja;
	private String nomeLoja;
	private Integer documentoTipoPessoa = DocumentoTipoEnum.CPF.getCodigo();
	private String cpfPessoa;
	private String cnpjPessoa;
	private String nomePessoa;
	
	private Integer documentoTipo = DocumentoTipoEnum.CNPJ.getCodigo();
	private String cpf;
	private String cnpj;
	private String nomeFantasia;
	private String email;
	private Integer indicadorMatriz = BooleanEnum.NAO.getCodigo();
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private long cep;
	private int tipo;

	private Collection<Loja> lojasClienteLogado;
	
	private Collection<LojaVincular> listaLojaVincular;
	private LojaVincular lojaVincularSelecionada;

	public LojaForm() {
		super();
		
		telefones.add(new Telefone("", "", "", TelefoneTipoEnum.RESIDENCIAL.getCodigo(), false));
		telefones.add(new Telefone("", "", "", TelefoneTipoEnum.RESIDENCIAL.getCodigo(), false));
		telefones.add(new Telefone("", "", "", TelefoneTipoEnum.RESIDENCIAL.getCodigo(), false));
		
	}

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getDocumentoTipoLoja() {
		return documentoTipoLoja;
	}

	public void setDocumentoTipoLoja(Integer documentoTipoLoja) {
		this.documentoTipoLoja = documentoTipoLoja;
	}

	public String getCpfLoja() {
		return cpfLoja;
	}

	public void setCpfLoja(String cpfLoja) {
		this.cpfLoja = cpfLoja;
	}

	public String getCnpjLoja() {
		return cnpjLoja;
	}

	public void setCnpjLoja(String cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}

	public Integer getDocumentoTipoPessoa() {
		return documentoTipoPessoa;
	}

	public void setDocumentoTipoPessoa(Integer documentoTipoPessoa) {
		this.documentoTipoPessoa = documentoTipoPessoa;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getCnpjPessoa() {
		return cnpjPessoa;
	}

	public void setCnpjPessoa(String cnpjPessoa) {
		this.cnpjPessoa = cnpjPessoa;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Collection<Loja> getLojasClienteLogado() {
		return lojasClienteLogado;
	}

	public void setLojasClienteLogado(Collection<Loja> lojasClienteLogado) {
		this.lojasClienteLogado = lojasClienteLogado;
	}

	public LojaVincular getLojaVincularSelecionada() {
		return lojaVincularSelecionada;
	}

	public void setLojaVincularSelecionada(LojaVincular lojaVincularSelecionada) {
		this.lojaVincularSelecionada = lojaVincularSelecionada;
	}

	public Collection<LojaVincular> getListaLojaVincular() {
		return listaLojaVincular;
	}

	public void setListaLojaVincular(Collection<LojaVincular> listaLojaVincular) {
		this.listaLojaVincular = listaLojaVincular;
	}

	public Integer getIndicadorMatriz() {
		return indicadorMatriz;
	}

	public void setIndicadorMatriz(Integer indicadorMatriz) {
		this.indicadorMatriz = indicadorMatriz;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
}
