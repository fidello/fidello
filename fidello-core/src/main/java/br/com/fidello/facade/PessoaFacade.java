package br.com.fidello.facade;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import br.com.fidello.dao.EmailDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.enums.UsuarioTipoEnum;
import br.com.fidello.model.Email;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Usuario;
import br.com.fidello.util.Utils;

public class PessoaFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private PessoaDAO pessoaDAO;
	@Inject private EmailDAO emailDAO;
	
	public Pessoa autenticarPessoa(Pessoa pessoa) throws Exception {
		
		try {
			
			Pessoa pessoaRetorno = null;
			
			if(pessoa.getEmails() != null || pessoa.getNumeroSRF() != null){
				
				beginTransaction();
				
				if(pessoa.getIdentificacaoTipo() == PessoaIdentificacaoTipoEnum.EMAIL.getCodigo()){
					pessoaRetorno = this.detalharPessoaPorEmail(pessoa.getEmails());
				}else{
					pessoaRetorno = this.detalharPessoaPorNumeroSRF(PessoaIdentificacaoTipoEnum.getPessoaIdentificacaoTipoFromCodigo(pessoa.getIdentificacaoTipo()), pessoa.getNumeroSRF());
				}
				
				return pessoaRetorno;
				
			}else{
				throw new Exception("Dados para login insuficientes.");
			}
			
		} catch (Exception e) {
			rollback();
			throw e;
		}

	}

	// Essa implementa a de baixo mas convete o tipo
	private Pessoa detalharPessoaPorNumeroSRF(PessoaIdentificacaoTipoEnum pessoaIdentificacaoTipoEnum, String NumeroSRF) throws Exception {
		
		DocumentoTipoEnum documentoTipoEnum = DocumentoTipoEnum.getFromCodigo(pessoaIdentificacaoTipoEnum.getCodigo());
		
		return this.detalharPessoaPorNumeroSRF(documentoTipoEnum, NumeroSRF);
		
	}

	private Pessoa detalharPessoaPorNumeroSRF(DocumentoTipoEnum documentoTipo, String NumeroSRF) throws Exception {
		
		return pessoaDAO.detalharPessoaPorNumeroSRF(documentoTipo, NumeroSRF);
		
	}
	
	private Pessoa detalharPessoaPorEmail(Collection<Email> emails) throws Exception {
		
		return pessoaDAO.detalharPessoaPorEmail(emails);
		
	}
	
	public Pessoa cadastrarCliente(Pessoa pessoa) throws Exception {
		
		pessoa.getUsuario().setUsuarioTipo(UsuarioTipoEnum.CLIENTE);
		
//		pessoa.getUsuarios().setUsuarioTipo(UsuarioTipoEnum.CLIENTE);
		
		return this.cadastrarPessoa(pessoa);
		
	}
	
	private Pessoa cadastrarPessoa(Pessoa pessoa) throws Exception {

		if(emailDAO.isEmailsExistente(pessoa.getEmails())){
			throw new Exception("O e-mail utilizado ja consta na base de dados.");
		}
		if(pessoaDAO.isNumeroSRFCadastrado(pessoa.getNumeroSRF(), DocumentoTipoEnum.getFromCodigo(pessoa.getDocumentoTipo()))){
			throw new Exception("O documento utilizado ja consta na base de dados.");
		}
	
		try {
			
			beginTransaction();
			
			pessoa.getUsuario().setSenha(Utils.convertStringToMd5(pessoa.getUsuario().getSenha()));
		
			pessoa = pessoaDAO.cadastrarPessoa(pessoa);
			
			commit();
	
		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		pessoa.getUsuario().setSenha(null);
		
		return pessoa;
	
	}

}