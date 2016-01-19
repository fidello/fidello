package br.com.fidello.delegate;

import java.util.Collection;

import javax.inject.Inject;

import br.com.fidello.facade.CampanhaFacade;
import br.com.fidello.facade.PontoFacade;
import br.com.fidello.json.CampanhaVO;
import br.com.fidello.json.CompraVO;
import br.com.fidello.model.Ponto;

public class CampanhaDelegate {

	@Inject
	private CampanhaFacade campanhaFacade;
	
	@Inject
	private PontoFacade pontoFacade;

	public void cadastrarCampanha(CampanhaVO campanhaVO) throws Exception {

		campanhaFacade.cadastrarCampanha(campanhaVO);
		
		
	}

	public void pontuar(CompraVO compra) throws Exception {
		
		campanhaFacade.pontuar(compra);

		
	}
	
	public Double detalharPontosPorPessoa(Integer idPessoa) throws Exception {
		
		Collection<Ponto> pontos = pontoFacade.detalharPontosPorPessoa(idPessoa);
		Double pontosPessoa = 0.0;
		
		for (Ponto ponto : pontos) {
			pontosPessoa += ponto.getPontos();
		}
		
		return pontosPessoa;

		
	}

}
