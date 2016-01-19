package br.com.fidello.dao;
 

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Restrictions;

import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Ponto;
import br.com.fidello.util.Utils;
 
public class PontoDAO extends GenericDAO<Ponto> {
	private static final long serialVersionUID = 1L;

	public PontoDAO() {
        super(Ponto.class);
    }
	
	public Ponto cadastrarPonto(Ponto ponto) throws Exception {
		
		String sql = "select max(p.ponto_id)+1 from fidello.ponto p where p.loja_id = " + ponto.getLoja().getId();
		Query query = getSession().createSQLQuery(sql);
		ScrollableResults result = query.scroll();
		if (result.first())
			ponto.setId(((BigInteger) result.get(0)).intValue());
		else
			ponto.setId(1);
		ponto.setCriado(Utils.getDataHoraAtual());
		ponto.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(ponto);
		
		return ponto;
		
	}

	@SuppressWarnings("unchecked")
	public Collection<Ponto> detalharPontosPorData(Pessoa pessoa, String dataInicio, String dataFim) throws Exception {
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		
		return getSession().createCriteria(Ponto.class)
				.add(Restrictions.eq("pessoa.id", pessoa.getId()))
				.add(Restrictions.ge("data", (Date)formatter.parse(dataInicio)))
				.add(Restrictions.le("data", (Date)formatter.parse(dataFim))).list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Ponto> detalharPontosPorPessoa(Pessoa pessoa) throws Exception {
		
  

		return getSession().createCriteria(Ponto.class)
				.add(Restrictions.eq("pessoa.id", pessoa.getId())).list();
	}

	
}