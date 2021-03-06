package br.com.fidello.dao;
 

import org.hibernate.criterion.Restrictions;

import br.com.fidello.enums.UsuarioTipoEnum;
import br.com.fidello.model.Campanha;
import br.com.fidello.util.Utils;
 
public class CampanhaDAO extends GenericDAO<Campanha> {
	private static final long serialVersionUID = 1L;

	public CampanhaDAO() {
        super(Campanha.class);
    }
	
	public Campanha detalharCampanha(Integer campanhaId) throws Exception {
		
		return (Campanha) getSession()
				.createCriteria(Campanha.class)
				.add(Restrictions.conjunction()
					.add(Restrictions.eq("id", campanhaId))
					.add(Restrictions.disjunction()
						.add(Restrictions.isNull("dataFim")) 
						.add(Restrictions.gt("dataFim", new java.sql.Date(System.currentTimeMillis())))))
				.uniqueResult();
				
	}
	
	public Campanha cadastrarCampanha(Campanha campanha) throws Exception {
	
		campanha.setCriado(Utils.getDataHoraAtual());
		campanha.setModificado(Utils.getDataHoraAtual());		
		campanha.setDataInicio(Utils.getDataHoraAtual());
		getSession().persist(campanha);
		
		return campanha;
		
	}
}