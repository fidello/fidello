package br.com.fidello.facade;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.dao.EmailDAO;
import br.com.fidello.dao.EnderecoDAO;
import br.com.fidello.dao.LojaDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.model.Loja;

@RequestScoped
@Named
public class LojaFacade extends AbstractFacade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LojaDAO lojaDAO;
	@Inject
	private EmailDAO emailDAO;
	@Inject
	private EnderecoDAO enderecoDAO;
	@Inject
	private PessoaDAO pessoaDAO;

	public Loja cadastrarLoja(Loja loja) throws Exception {

		if (emailDAO.isEmailsExistente(loja.getPessoa().getEmails())) {
			throw new Exception(
					"O e-mail utilizado ja consta na base de dados.");
		}
		if (pessoaDAO.isNumeroSRFCadastrado(loja.getPessoa().getNumeroSRF(),
				DocumentoTipoEnum.getFromCodigo(loja.getPessoa()
						.getDocumentoTipo()))) {
			throw new Exception(
					"O documento utilizado ja consta na base de dados.");
		}

		try {

			beginTransaction();

			loja = lojaDAO.cadastrarLoja(loja);

			commit();

		} catch (Exception e) {
			rollback();
			throw e;
		}

		return loja;

	}

	public List<Loja> listarLojasPorUsuario(Integer pessoaId) throws Exception {

		return null;
	}

	public Collection<Loja> listarTodasLojas() throws Exception {

		return lojaDAO.listarTodasLojas();
	}

}