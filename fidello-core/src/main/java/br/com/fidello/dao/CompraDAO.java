package br.com.fidello.dao;
 

import br.com.fidello.model.Compra;
import br.com.fidello.util.Utils;
 
public class CompraDAO extends GenericDAO<Compra> {
	private static final long serialVersionUID = 1L;

	public CompraDAO() {
        super(Compra.class);
    }
	
	public Compra cadastrarCompra(Compra compra) throws Exception {
		
		compra.setCriado(Utils.getDataHoraAtual());
		compra.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(compra);
		
		return compra;
		
	}
}