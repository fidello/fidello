//package br.com.fidello.mb;
//
//import java.io.Serializable;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.Conversation;
//import javax.enterprise.context.ConversationScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.servlet.http.HttpServletRequest;
//
//import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
//import br.com.fidello.facade.UsuarioFacade;
//import br.com.fidello.model.Loja;
//import br.com.fidello.model.Pessoa;
//import br.com.fidello.model.Usuario;
//import br.com.fidello.seguranca.ControleAcesso;
//
//
//@Named
//@ConversationScoped
//public class LoginMB extends AbstractMB implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	@Inject private Conversation conversation;
//	@Inject private HttpServletRequest httpServletRequest;
//	
//	@Inject private ControleAcesso controleAcesso;
//	
//	@Inject private UsuarioFacade usuarioFacade;
//	
//	@Inject private Usuario usuario;
//
//	private Loja lojaEscolhida;
//	
//	@PostConstruct
//	protected void init() {  
//		usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF.getCodigo()));
//		if (controleAcesso.getUsuario() != null)
//			setUsuario(controleAcesso.getUsuario());
//
//	}
//
//	public String loginUsuario() {
//		
//		try {
//			
//			Usuario usuarioRetorno = null;
//			if(this.usuario.getPessoa().getEmails() != null || this.usuario.getPessoa().getNumeroSRF() != null){
//				
//				usuarioRetorno = usuarioFacade.autenticarUsuario(usuario);
//				
//			}else{
//				displayErrorMessageToUser("Falha no login", "Preencha corretamente os dados de login.");
//				return null;
//			}
//			
//			if(usuarioRetorno != null) {
//				
//				usuario = usuarioRetorno;
//				this.gravarDadosLogin();
//				
//				if(this.usuario.getUsuarioLojas() == null || this.usuario.getUsuarioLojas().isEmpty()){
//					
//					return this.retornarAoIndex();
//					
//				}else{
//					
//					return "escolherPerfilLogin";
//					
//				}
//			}else{
//				displayErrorMessageToUser("Falha no login", "Os dados de autenticação não são válidos.");
//				return null;
//			}
//		} catch (Exception e) {
//			displayErrorMessageToUser("Falha ao efetuar login.", e.getLocalizedMessage());
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//	
//	public String gravarDadosLogin(){
//		
//		if(getUsuario() != null){
//			controleAcesso.logar(usuario);
//			return null;
//		}else{
//			displayErrorMessageToUser("Falha ao efetuar login.", "Usuário está nulo.");
//			return null;
//		}
//	}
//		
//	public String retornarAoIndex(){
//
//		if(!conversation.isTransient())
//		conversation.end();
//				
//		return "/index.xhtml";
//		
//	}
//
//	public String escolherPerfilLogin(Loja loja){
//		controleAcesso.setLoja(loja);
//		return retornarAoIndex();
//	}
//
//	public String logOut() {
//		controleAcesso.logout();
//		httpServletRequest.getSession().invalidate();
//		return "/index.xhtml";
//	}
//
//	/**
//	 * GETs e SETs
//	 * */
//	
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	public Loja getLojaEscolhida() {
//		return lojaEscolhida;
//	}
//
//	public void setLojaEscolhida(Loja lojaEscolhida) {
//		this.lojaEscolhida = lojaEscolhida;
//	}
//
//}