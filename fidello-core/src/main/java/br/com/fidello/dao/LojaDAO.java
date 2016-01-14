package br.com.fidello.dao;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.criterion.Restrictions;

import br.com.fidello.model.Loja;
import br.com.fidello.model.Telefone;
import br.com.fidello.util.Utils;

public class LojaDAO extends GenericDAO<Loja> {
	private static final long serialVersionUID = 1L;

	public LojaDAO() {
		super(Loja.class);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Loja> detalharLojaPorPessoaId(Integer pessoaId) throws Exception {

		return getSession().createCriteria(Loja.class)
        	.add(Restrictions.eq("pessoa.id", pessoaId))
        	.list();

	}
	
	@SuppressWarnings("unchecked")
	public Collection<Loja> listarTodasLojas() throws Exception {

		return getSession().createCriteria(Loja.class).list();

	}
	
	public Loja cadastrarLoja(Loja loja) throws Exception {
		
//		loja.setNomeFantasia(nomeFantasia);
//		loja.setIndicadorMatriz(indicadorMatriz);

		loja.setCriado(Utils.getDataHoraAtual());
		loja.setModificado(Utils.getDataHoraAtual());
		loja.getPessoa().setCriado(Utils.getDataHoraAtual());
		loja.getPessoa().setModificado(Utils.getDataHoraAtual());
		
		loja.getPessoa().getEnderecos().iterator().next().setCriado(Utils.getDataHoraAtual());
		loja.getPessoa().getEnderecos().iterator().next().setModificado(Utils.getDataHoraAtual());
		loja.getPessoa().getEnderecos().iterator().next().setData_inicio(Utils.getDataHoraAtual());
		
		Telefone telefone;
		Iterator it;
		it = loja.getPessoa().getTelefones().iterator();
		while(it.hasNext()){
			telefone = (Telefone)it.next();
			if (telefone.getNumero() != "") {
				telefone.setCriado(Utils.getDataHoraAtual());
				telefone.setModificado(Utils.getDataHoraAtual());
				telefone.setData_inicio(Utils.getDataHoraAtual());
			}
			else
				it.remove();
		}

		loja.getPessoa().getTelefones().iterator().next().setCriado(Utils.getDataHoraAtual());
		loja.getPessoa().getTelefones().iterator().next().setModificado(Utils.getDataHoraAtual());
		loja.getPessoa().getTelefones().iterator().next().setData_inicio(Utils.getDataHoraAtual());
		
		loja.getPessoa().getEmails().iterator().next().setCriado(Utils.getDataHoraAtual());
		loja.getPessoa().getEmails().iterator().next().setModificado(Utils.getDataHoraAtual());
		loja.getPessoa().getEmails().iterator().next().setData_inicio(Utils.getDataHoraAtual());

		
		getSession().persist(loja);
		
		return loja;
		
	}
	
}
