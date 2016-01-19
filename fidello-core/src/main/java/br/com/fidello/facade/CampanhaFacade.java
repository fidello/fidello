package br.com.fidello.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.dao.CampanhaDAO;
import br.com.fidello.dao.CompraDAO;
import br.com.fidello.dao.LojaDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.dao.PontoDAO;
import br.com.fidello.json.CampanhaVO;
import br.com.fidello.json.CompraVO;
import br.com.fidello.model.Campanha;
import br.com.fidello.model.Compra;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Ponto;
import br.com.fidello.util.Utils;

@RequestScoped
@Named
public class CampanhaFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CampanhaDAO campanhaDAO;

	@Inject
	LojaDAO lojaDAO;

	@Inject
	PessoaDAO pessoaDAO;
	
	@Inject
	CompraDAO compraDAO;
	
	@Inject
	PontoDAO pontoDAO;

	public void cadastrarCampanha(CampanhaVO campanhaVO) throws Exception {

		Campanha campanha = new Campanha();

		campanha.setNome(campanhaVO.getNome());
		campanha.setTaxa(Double.parseDouble(campanhaVO.getTaxa()));
		campanha.setValidade(campanhaVO.getValidade());
		campanha.setValidadeTipo(campanhaVO.getTipoValidade());

		campanha.setTipoConversao(1);
		try {
			
			beginTransaction();
			
			campanhaDAO.cadastrarCampanha(campanha);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
	}

	public void pontuar(CompraVO compraVO) throws Exception {
		// TODO Auto-generated method stub

		List<Loja> lojas = (List<Loja>) lojaDAO.listarLojasPorPessoaId(11);

		Pessoa pessoa = pessoaDAO.detalharPessoaPorId(11);

		Compra compra = new Compra();

		compra.setDescricao("Descrição");
		compra.setValor(50.0);
		compra.setPessoa(pessoa);
		compra.setLoja(lojas.get(0));
		
		Ponto ponto = new Ponto();
		
		ponto.setCartao(1);
		ponto.setCodigoTipoConversao(1);
		ponto.setDescricao("Desc");
		ponto.setLoja(lojas.get(0));
		ponto.setPessoa(pessoa);
		ponto.setPontos(Long.parseLong("4500"));
		ponto.setValidade(Utils.getDataHoraAtual());
		
		try {
			
			beginTransaction();
			
			//compra = compraDAO.cadastrarCompra(compra);

			//compra.setId(1);
			ponto.setCompra(compra);
			
			pontoDAO.cadastrarPonto(ponto);
			
			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}
		
		

	}

}