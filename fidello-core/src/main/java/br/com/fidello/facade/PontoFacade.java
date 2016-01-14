package br.com.fidello.facade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.dao.PontoDAO;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Ponto;
import br.com.fidello.model.Campanha;
import br.com.fidello.model.Compra;
import br.com.fidello.util.Utils;

@RequestScoped
@Named
public class PontoFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject	private PontoDAO pontoDAO;
	@Inject	private Compra compra;

	public Ponto cadastrarPontos(Ponto ponto, Campanha campanha) throws Exception {

		try {
 			compra.setPessoa(ponto.getPessoa());
			compra.setLoja(ponto.getLoja());
			compra.setData(ponto.getData());
			compra.setValor(ponto.getValor());
			compra.setDescricao(ponto.getDescricao());
			compra.setData(Utils.getDataHoraAtual());
			compra.setCriado(Utils.getDataHoraAtual());
			compra.setModificado(Utils.getDataHoraAtual());
			
			ponto.setCompra(compra);

			Date validade = CalcularDataValidade(campanha.getValidadeTipo(), campanha.getValidade());
			ponto.setValidade(new java.sql.Date(validade.getTime()));
			CalcularPontosValor(campanha, ponto);
			ponto.setCodigoTipoConversao(campanha.getTipoConversao());
			ponto.setData(Utils.getDataHoraAtual());;

			beginTransaction();
			
			ponto = pontoDAO.cadastrarPonto(ponto);

			commit();
			
		} catch (Exception e) {
			rollback();
			throw e;
		}

		return ponto;

	}

	public Date CalcularDataValidade(Integer validadeTipo, Integer validade) throws Exception {

		try {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(Utils.getDataHoraAtual());
						
			if (validadeTipo == 1) {// dias
				cal.add(Calendar.DAY_OF_MONTH, validade);
			}
				
			if (validadeTipo == 2) {// semanas
				cal.add(Calendar.WEEK_OF_YEAR, validade);
			}
				
			if (validadeTipo == 3) {// meses
				cal.add(Calendar.MONTH, validade);
			}

			if (validadeTipo  == 4) {// anos
				cal.add(Calendar.YEAR, validade);
			}
							
			return cal.getTime();			
			
		} catch (Exception e) {
			rollback();
			throw e;
		}

	}

	public void CalcularPontosValor(Campanha campanha, Ponto ponto) throws Exception {

		try {
			Double d;
			Integer i;
						
			if (campanha.getTipoConversao() == 1) {// Ponto x Ponto
				d = ponto.getPontos() * campanha.getTaxa();
				i = d.intValue();
				ponto.setPontos(new Long(i));
			}
				
			
			if (campanha.getTipoConversao() == 1) {// Valor x Valor
				d = ponto.getValor() * campanha.getTaxa();
				ponto.setValor(d);
			}

			if (campanha.getTipoConversao() == 1) {// Valor x Ponto
				d = ponto.getValor() * campanha.getTaxa();
				i = d.intValue();
				ponto.setPontos(new Long(i));
			}

			if (campanha.getTipoConversao() == 1) {// Ponto x Valor
				d = ponto.getPontos() * campanha.getTaxa();
				ponto.setValor(d);
			}
			
		} catch (Exception e) {
			rollback();
			throw e;
		}

	}

	public Collection<Ponto> detalharPontosPorData(Pessoa pessoa, String dataInicio, String dataFim) throws Exception {

		try {
			beginTransaction();
			
			return pontoDAO.detalharPontosPorData(pessoa, dataInicio, dataFim);

			
		} catch (Exception e) {
			rollback();
			throw e;
		}

	}

}
