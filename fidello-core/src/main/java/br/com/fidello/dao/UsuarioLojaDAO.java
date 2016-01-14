package br.com.fidello.dao;

import org.hibernate.criterion.Restrictions;

import br.com.fidello.model.Usuario;
import br.com.fidello.model.Loja;
import br.com.fidello.model.UsuarioLoja;
import br.com.fidello.util.Utils;

public class UsuarioLojaDAO extends GenericDAO<UsuarioLoja> {
	private static final long serialVersionUID = 1L;

	public UsuarioLojaDAO() {
		super(UsuarioLoja.class);
	}
	
	public UsuarioLoja detalhar(Loja loja, Usuario usuario) throws Exception {

		return (UsuarioLoja) getSession().createCriteria(UsuarioLoja.class)
	        	.add(Restrictions.eq("lojaId", loja.getId()))
	        	.add(Restrictions.eq("usuarioId", usuario.getId()))
	        	.uniqueResult();

	}
	
	public UsuarioLoja vincularLojaUsuario(Loja loja, Usuario usuario, Integer funcao) throws Exception {
		
		UsuarioLoja usuarioLoja = new UsuarioLoja();
		
		usuarioLoja.setUsuario(usuario);
		usuarioLoja.setLoja(loja);
		usuarioLoja.setFuncao(funcao);
		usuarioLoja.setCriado(Utils.getDataHoraAtual());
		usuarioLoja.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(usuarioLoja);
		
		return usuarioLoja;
		
	}
	
	public void delete(UsuarioLoja usuarioLoja) {
//        	super.delete(usuarioLoja.getId(), UsuarioLoja.class);
	}
}
