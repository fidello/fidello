package br.com.fidello.delegate;

import java.util.List;

import javax.inject.Inject;

import br.com.fidello.facade.LojaFacade;
import br.com.fidello.json.LojaVO;
import br.com.fidello.model.Loja;

public class LojaDelegate {

	@Inject
	private LojaFacade lojaFacade;

	public void cadastrarLoja(LojaVO loja, Integer idPessoa) throws Exception {

		lojaFacade.cadastrarLoja(loja, idPessoa);
		
		
	}
	
	public List<LojaVO> listarLojasPorUsuario(Integer idPessoa) throws Exception {

		return lojaFacade.listarLojasPorUsuario(idPessoa);
		
		
	}


}
