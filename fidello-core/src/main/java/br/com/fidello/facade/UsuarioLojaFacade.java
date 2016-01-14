package br.com.fidello.facade;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.dao.UsuarioLojaDAO;
import br.com.fidello.enums.UsuarioLojaFuncaoEnum;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Usuario;
import br.com.fidello.model.UsuarioLoja;

@RequestScoped
@Named
public class UsuarioLojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioLojaDAO usuarioLojaDAO;
	
	public UsuarioLoja vincularLojaUsuario(Loja loja, Usuario usuario) throws Exception {
		
		if(usuarioLojaDAO.detalhar(loja, usuario) != null){
			throw new Exception("O vínculo ja existe.");
		}
		
		UsuarioLoja usuarioLoja = null;
		try {
			
			beginTransaction();
			
			Integer funcao = UsuarioLojaFuncaoEnum.PROPRIETARIO.getCodigo();
			
			usuarioLoja = usuarioLojaDAO.vincularLojaUsuario(loja, usuario, funcao);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		return usuarioLoja;
		
	}
	
}