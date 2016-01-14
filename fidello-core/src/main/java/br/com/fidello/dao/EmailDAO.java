package br.com.fidello.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



import br.com.fidello.model.Email;
import br.com.fidello.util.Utils;

public class EmailDAO extends GenericDAO<Email> {

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	public EmailDAO() {
		super(Email.class);
	}
	
	private int getNovoId(int pessoaId){
		
		Integer retorno = (Integer) getSession().createCriteria(Email.class)
	        	.add(Restrictions.eq("pessoaId", pessoaId))
	        	  .setProjection( Projections.max("id") )
	        	  .uniqueResult();
	        
		if(retorno != null){
			return ++retorno;
		}
		return 0;
		
	}
	
	public Email cadastrarEmail(Integer pessoaId, String email, boolean preferencial) throws Exception {
		
		Email emailGravar = new Email();
		
		emailGravar.setId(getNovoId(pessoaId));
//		emailGravar.setPessoaId(pessoaId);
		emailGravar.setData_fim(null);
		emailGravar.setEmail(email);
		emailGravar.setPreferencial(preferencial);
		
		emailGravar.setData_inicio(Utils.getDataHoraAtual());
		emailGravar.setCriado(Utils.getDataHoraAtual());
		emailGravar.setModificado(Utils.getDataHoraAtual());
			
		getSession().persist(emailGravar);
		
		return emailGravar;
		
	}
	
	public Email detalharEmail(String email) throws Exception {

		return (Email) getSession().createCriteria(Email.class)
        	.add(Restrictions.eq("email", email))
        	.uniqueResult();

	}
	
	public Email detalharEmailPorPessoaId(Integer pessoaId) throws Exception {

		return (Email) getSession().createCriteria(Email.class)
        	.add(Restrictions.eq("pessoaId", pessoaId))
        	.uniqueResult();

	}

	public boolean isEmailsExistente(Collection<Email> emails){
		
		List<String> emails_str = new ArrayList<String>();
		for (Email email2 : emails) {
			emails_str.add(email2.getEmail());
		}
		
		Long qtd = (Long) getSession()
							.createCriteria(Email.class)
							.add(Restrictions.in("email", emails_str))
							.setProjection(Projections.rowCount())
							.uniqueResult();
		
		return qtd >= 1;
		
	}

	public boolean isEmailExistente(String email){
		
		Long qtd = (Long) getSession()
							.createCriteria(Email.class)
							.add(Restrictions.eq("email", email))
							.setProjection(Projections.rowCount())
							.uniqueResult();
		
		return qtd >= 1;
		
	}
	
}
