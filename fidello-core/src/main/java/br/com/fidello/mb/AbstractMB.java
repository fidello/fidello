package br.com.fidello.mb;


public class AbstractMB {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	public AbstractMB() {
		super();
	}
	
//	@Inject private Conversation conversation;
	
	/**
     * Inicia o conversation scope.
     */
//    public void initConversation() {
//        if (!conversation.isTransient()) {
//            conversation.begin();
//        }
//    }
    
    /**
     * Termina o conversation scoped.
     */
//    public void endConversation() {
//        if (conversation.isTransient()) {
//            conversation.end();
//        }
//    }
	
//	public ControleAcesso getControleAcesso(){
//		
//		ControleAcesso controleAcesso = (ControleAcesso) getSession().getAttribute("controleAcesso");
//		
//		if(controleAcesso == null){
//			controleAcesso = new ControleAcesso();
//			getSession().setAttribute("controleAcesso", controleAcesso);
//		}
//		
//		return (ControleAcesso) getSession().getAttribute("controleAcesso");
//	}

//	public HttpServletRequest getRequest() {
//		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//	}

//	public FacesContext getContext() {
//		return (FacesContext) FacesContext.getCurrentInstance();
//	}

//	public HttpSession getSession() {
//		return (HttpSession) getContext().getExternalContext().getSession(false);
//	}
	
	
	/**
	 * Ja estavam no exemplo, ver se continuarão
	 * */

	protected void displayErrorMessageToUser(String message, String detalhe) {
	
	}
	
	protected void displayErrorMessageToUser(String message) {
		
	}

	protected void displayInfoMessageToUser(String message, String detalhe) {
	
	}
	
	protected void displayInfoMessageToUser(String message) {
		
	}
	
	protected void closeDialog(){
	}
	
	protected void keepDialogOpen(){
	}
	
	protected Object getRequestContext(){
		return null;
	}
}