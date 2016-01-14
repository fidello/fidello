package br.com.fidello.facade;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import br.com.fidello.dao.EmailDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.dao.UsuarioDAO;
import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.model.Email;
import br.com.fidello.model.Usuario;
import br.com.fidello.util.Utils;

public class UsuarioFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioDAO usuarioDAO;
	@Inject private PessoaDAO pessoaDAO;
	@Inject private EmailDAO emailDAO;
	public Usuario autenticarUsuario(Usuario usuario) throws Exception {
		
		try {
			
			Usuario usuarioRetorno = null;
			
			if(usuario.getPessoa().getEmails() != null || usuario.getPessoa().getNumeroSRF() != null){
				
				beginTransaction();
				
				if(usuario.getPessoa().getIdentificacaoTipo() == PessoaIdentificacaoTipoEnum.EMAIL.getCodigo()){
					usuarioRetorno = this.detalharUsuarioPorEmail(usuario.getPessoa().getEmails());
				}else{
					usuarioRetorno = this.detalharUsuarioPorDocumento(usuario.getPessoa().getIdentificacaoTipo(), usuario.getPessoa().getNumeroSRF());
				}
				
				if (autenticarUsuario(usuarioRetorno.getId(), usuario.getSenha()) == false)
					return null;
				
				return usuarioRetorno;
				
			}else{
				throw new Exception("Dados para login insuficientes.");
			}
			
		} catch (Exception e) {
			rollback();
			throw e;
		}

	}

	
//	public boolean autenticarUsuarioPorEmail(String email, String senha) throws Exception {
//		
//		Pessoa pessoa = pessoaDAO.detalharPessoaPorEmail(email);
//		return autenticarUsuario(pessoa.getId(), senha);
//		
//	}
//	
//	public boolean autenticarUsuarioPorDocumento(DocumentoTipoEnum documentoTipo, String documento, String senha) throws Exception {
//		
//		Pessoa pessoa = pessoaDAO.detalharPessoaPorDocumento(documentoTipo, documento);
//		return autenticarUsuario(pessoa.getId(), senha);
//		
//	}
//	
	private boolean autenticarUsuario(Integer pessoaId, String senha) throws Exception {
		
		try {
			
			if(pessoaId != null){
				
				beginTransaction();
				
				return usuarioDAO.autenticarUsuarioPorPessoaId(pessoaId, senha) != null;
				
			}else{
				throw new Exception("Dados para login insuficientes.");
			}
			
		} catch (Exception e) {
			rollback();
			throw e;
		}
		
	}
//	
	public Usuario detalharUsuarioPorEmail(Collection<Email> emails) throws Exception {
		
		return usuarioDAO.buscarUsuarioPorEmail(emails);
		
	}
	
	public Usuario detalharUsuarioPorDocumento(Integer documentoTipo, String numeroSRF) throws Exception {
		
		return usuarioDAO.buscarUsuarioPorNumeroSRF(documentoTipo, numeroSRF);

	}
	
//	private Usuario detalharUsuarioCompleto(Pessoa pessoa, Email email) throws Exception {
//		
//		try {
//			
//			beginTransaction();
//			
//			Integer pessoaId = null;
//			if(pessoa != null) {
//				
//				pessoaId = pessoa.getId();
//				
//			} else if(email != null){
//				
////				pessoaId = email.getPessoaId();
//				
//			}else{
//				throw new Exception("Dados para login insuficientes.");
//			}
//			
//			Usuario usuario = usuarioDAO.buscarUsuarioPorPessoaId(pessoaId);
//			
//			if(pessoa == null)
//				pessoa = pessoaDAO.detalharPessoaPorId(pessoaId);
//			/*
//			pessoa.setLojas(lojaDAO.detalharLojaPorPessoaId(pessoaId));
//			usuario.setPessoa(pessoa);
//			*/
//			usuario.setSenha(null);
//			
//			return usuario;
//			
//		} catch (Exception e) {
//			rollback();
//			throw e;
//		}
//		
//	}	

	public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
	
		if(emailDAO.isEmailsExistente(usuario.getPessoa().getEmails())){
			throw new Exception("O e-mail utilizado ja consta na base de dados.");
		}
		if(pessoaDAO.isNumeroSRFCadastrado(usuario.getPessoa().getNumeroSRF(), DocumentoTipoEnum.getFromCodigo(usuario.getPessoa().getDocumentoTipo()))){
			throw new Exception("O documento utilizado ja consta na base de dados.");
		}
	
		try {
			
			beginTransaction();
			
			usuario = usuarioDAO.cadastrarUsuario(usuario);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		usuario.setSenha(null);
		
		return usuario;
		
	}

}