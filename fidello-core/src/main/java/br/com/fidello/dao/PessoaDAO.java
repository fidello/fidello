package br.com.fidello.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.model.Email;
import br.com.fidello.model.Pessoa;
import br.com.fidello.util.Utils;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	@Inject
	private Email email;
	@Inject
	private EmailDAO emailDAO;

	public PessoaDAO() {
		super(Pessoa.class);
	}

	public Pessoa cadastrarPessoa(Pessoa pessoa) throws Exception {

		pessoa.setDocumento(Utils.somenteNumeros(pessoa.getDocumento()));

		pessoa.setCriado(Utils.getDataHoraAtual());
		pessoa.setModificado(Utils.getDataHoraAtual());

		getSession().persist(pessoa);

		return pessoa;

	}

	public Pessoa detalharPessoaPorId(Integer pessoaId) throws Exception {

		return (Pessoa) getSession().createCriteria(Pessoa.class)
				.add(Restrictions.eq("id", pessoaId)).uniqueResult();

	}

	public Pessoa detalharPessoaPorNumeroSRF(DocumentoTipoEnum documentoTipo,
			String NumeroSRF) throws Exception {

		NumeroSRF = Utils.somenteNumeros(NumeroSRF);

		return (Pessoa) getSession()
				.createCriteria(Pessoa.class)
				.add(Restrictions.eq("documentoTipo", documentoTipo.getCodigo()))
				.add(Restrictions.eq("numeroSRF", NumeroSRF)).uniqueResult();

	}

	public Pessoa detalharPessoaPorUsuarioIdentificacao(
			Integer usuarioIdentificacaoTipo, String numeroSRF)
			throws Exception {

		numeroSRF = Utils.somenteNumeros(numeroSRF);

		if (numeroSRF == null || numeroSRF.isEmpty()) {
			if (usuarioIdentificacaoTipo.equals(DocumentoTipoEnum.CPF
					.getCodigo()))
				throw new Exception("Por favor informe um número de CPF");
			else
				throw new Exception("Por favor informe um número de CNPJ");
		}
		return (Pessoa) getSession()
				.createCriteria(Pessoa.class)
				.add(Restrictions.eq("documentoTipo", usuarioIdentificacaoTipo))
				.add(Restrictions.eq("numeroSRF", numeroSRF)).uniqueResult();
	}

	public Pessoa detalharPessoaPorEmail(Collection<Email> emails)
			throws Exception {
		// String sql = "select * from pessoa where pessoa_id in "
		// + "(select pessoa_id from email where email = \"" + email + "\" )";
		// Query query =
		// getSession().createSQLQuery(sql).addEntity(Pessoa.class);
		// return (Pessoa) query.uniqueResult();
		// email = emailDAO.detalharEmail(strEmail);
		//
		// return this.detalharPessoaPorId(email.getPessoa().getId());

		List<String> emails_str = new ArrayList<String>();
		for (Email email2 : emails) {
			emails_str.add(email2.getEmail());
		}

		return (Pessoa) getSession().createCriteria(Email.class)
				.add(Restrictions.in("email", emails_str)).uniqueResult();

	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarPessoasFisicas()
			throws Exception {
		// String sql = "select * from pessoa where pessoa_id in "
		// + "(select pessoa_id from email where email = \"" + email + "\" )";
		// Query query =
		// getSession().createSQLQuery(sql).addEntity(Pessoa.class);
		// return (Pessoa) query.uniqueResult();
		// email = emailDAO.detalharEmail(strEmail);
		//
		// return this.detalharPessoaPorId(email.getPessoa().getId());

		

		return (List<Pessoa>) getSession().createCriteria(Pessoa.class)
				.add(Restrictions.eq("documentoTipo", 1)).list();

	}
	public boolean isNumeroSRFCadastrado(String numeroSRF,
			DocumentoTipoEnum documentoTipo) {

		numeroSRF = Utils.somenteNumeros(numeroSRF);

		Long qtd = (Long) getSession()
				.createCriteria(Pessoa.class)
				.add(Restrictions.eq("numeroSRF", numeroSRF))
				.add(Restrictions.eq("documentoTipo", documentoTipo.getCodigo()))
				.setProjection(Projections.rowCount()).uniqueResult();

		return qtd >= 1;

	}

}
