package br.com.fidello.mb;

import java.io.Serializable;




import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.seguranca.ControleAcesso;
import br.com.fidello.util.SelecaoUsuario;
import br.com.fidello.util.Utils;
import br.com.fidello.facade.PontoFacade;
import br.com.fidello.facade.UsuarioFacade;
import br.com.fidello.model.Pessoa;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.model.Ponto;
import br.com.fidello.model.LojaCampanha;
import br.com.fidello.model.Campanha;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Named
@RequestScoped
public class ExtratoPontosMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	@Inject private PontoFacade pontoFacade;

	private String nomeCliente;

	private Collection<Ponto> pontos;
	private String dataInicio;
	private String dataFim;
	

	
	@PostConstruct
	protected void init() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(Utils.getDataHoraAtual());
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  

//		if (dataFim == null)
//		{
//			dataFim = fmt.format(cal.getTime());
//		}	
//
//		if (dataInicio == null)
//		{
//			cal.add(Calendar.MONTH, -1);
//			dataInicio = fmt.format(cal.getTime());
//		}	
		
	}

	public String pesquisar() {
		try {
			setPontos(pontoFacade.detalharPontosPorData(controleAcesso.getUsuario().getPessoa(), dataInicio, dataFim));
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.",
					e.getLocalizedMessage());
			e.printStackTrace();
		}
		return "";
	}
	
	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Collection<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(Collection<Ponto> pontos) {
		this.pontos = pontos;
	}
	
}


