package br.com.fidello.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.fidello.enums.UsuarioTipoEnum;
import br.com.fidello.model.Email;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Usuario;
import br.com.fidello.util.Utils;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = 1L;

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
		usuario.setSenha(Utils.convertStringToMd5(usuario.getSenha()));
		usuario.setUsuarioTipo(UsuarioTipoEnum.CLIENTE);
		usuario.getPessoa().setCriado(Utils.getDataHoraAtual());
		usuario.getPessoa().setModificado(Utils.getDataHoraAtual());
		usuario.getPessoa().getEmails().iterator().next().setCriado(Utils.getDataHoraAtual());
		usuario.getPessoa().getEmails().iterator().next().setModificado(Utils.getDataHoraAtual());
		usuario.getPessoa().getEmails().iterator().next().setData_inicio(Utils.getDataHoraAtual());
		usuario.setCriado(Utils.getDataHoraAtual());
		usuario.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(usuario);
		
		return usuario;
		
	}
	
	public Usuario buscarUsuarioPorPessoaId(Integer pessoaId) throws Exception {

		return (Usuario) getSession().createCriteria(Usuario.class)
        	.add(Restrictions.eq("pessoa.id", pessoaId))
        	.uniqueResult();

	}
	
	public Usuario autenticarUsuarioPorPessoaId(Integer pessoaId, String senha) throws Exception {

		senha = Utils.convertStringToMd5(senha);
		
		Usuario usuario = (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("pessoa.id", pessoaId))
	        	.add(Restrictions.eq("senha", senha))
	        	.uniqueResult();
		
		if(usuario != null)
			usuario.setSenha(null);
		
		return usuario;

	}
	
	
	public Usuario buscarUsuarioPorNumeroSRF(Integer documentoTipo, String NumeroSRF) throws Exception {

		NumeroSRF = Utils.somenteNumeros(NumeroSRF);
		
		return (Usuario) getSession()
				.createCriteria(Usuario.class)
					.createCriteria("pessoa")
						.add(Restrictions.eq("numeroSRF", NumeroSRF))
						.add(Restrictions.eq("documentoTipo", documentoTipo))
				.uniqueResult();
	}
	
	public Usuario buscarUsuarioPorEmail(Collection<Email> emails) {
		List<String> emails_str = new ArrayList<String>();
		
		for (Email email2 : emails) {
			emails_str.add(email2.getEmail());
		}
		
		return (Usuario) getSession()
				.createCriteria(Email.class)
				.add(Restrictions.in("email", emails_str))
				.uniqueResult();
	}
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("email", email);
//		Usuario usuario = super.findOneResult(Usuario.BUSCAR_POR_EMAIL, parameters);
		
//		return usuario;
//		return null;
	
//	public Usuario verificarDadosLogin(String email, String documento, String senha) throws Exception {
//		
//		Usuario usuario = null;
//		
//		if(!Utils.isEmpty(email)){
//			
//			usuario = this.buscarUsuarioPorEmail(email);
//			
//		}else if(!Utils.isEmpty(documento)){
//			
//			usuario = this.buscarUsuarioPorDocumento(documento);
//			
//		}else{
//			
//			throw new Exception("Informar E-mail ou Documento.");
//			
//		}
		
//		if (usuario != null) {
//			
//			if(!Utils.convertStringToMd5(senha).equalsIgnoreCase(usuario.getSenha())){
////			if(!senha.equalsIgnoreCase(usuario.getSenha())){
//				usuario.setSenha("");
//				throw new Exception("Senha não confere.");
//			}
//			usuario.setSenha("");
//			
//			return usuario;
//			
//		}else{
//			throw new Exception("Dados do usuário não conferem.");
//		}
//		
//	}

//	public void delete(Usuario usuario) {
////        	super.delete(usuario.getId(), Usuario.class);
//	}
}
