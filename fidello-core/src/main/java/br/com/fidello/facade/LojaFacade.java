package br.com.fidello.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.dao.EmailDAO;
import br.com.fidello.dao.EnderecoDAO;
import br.com.fidello.dao.LojaDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.enums.EnderecoTipoEnum;
import br.com.fidello.enums.TelefoneTipoEnum;
import br.com.fidello.json.EnderecoVO;
import br.com.fidello.json.LojaVO;
import br.com.fidello.model.Endereco;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Telefone;

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

	public Loja cadastrarLoja(LojaVO lojaVO, Integer idPessoa) throws Exception {

		Pessoa pessoa = pessoaDAO.detalharPessoaPorId(idPessoa);
		
		Loja loja = new Loja();
		
		loja.setPessoa(pessoa);
		
		loja.setNomeFantasia(lojaVO.getNome());
		loja.setIndicadorMatriz(true);
		
		List<Endereco> enderecos =  (List<Endereco>) loja.getPessoa().getEnderecos();
		if(enderecos == null)
			enderecos = new ArrayList<Endereco>();
		
		Endereco novoEndereco = new Endereco();
		novoEndereco.setBairro(lojaVO.getEndereco().getBairro());
		novoEndereco.setCep(Long.parseLong(lojaVO.getEndereco().getCep()));
		novoEndereco.setCidade(lojaVO.getEndereco().getCidade());
		novoEndereco.setComplemento(lojaVO.getEndereco().getComplemento());
		novoEndereco.setEstado(lojaVO.getEndereco().getEstado());
		novoEndereco.setLogradouro(lojaVO.getEndereco().getLogradouro());
		novoEndereco.setNumero(lojaVO.getEndereco().getNumero());
		novoEndereco.setPais(lojaVO.getEndereco().getPais());
		novoEndereco.setPreferencial(true);
		
		novoEndereco.setTipo(EnderecoTipoEnum.COMERCIAL.getCodigo());
		enderecos.add(novoEndereco);
		
		loja.getPessoa().setEnderecos(enderecos);
		
		Telefone telefone = new Telefone("55", "67", lojaVO.getTelefone(), TelefoneTipoEnum.CELULAR.getCodigo(), true);
		
		List<Telefone> telefones = (List<Telefone>) loja.getPessoa().getTelefones();
		
		if(telefones == null || telefones.isEmpty())
			telefones = new ArrayList<Telefone>();
		
		telefones.add(telefone);
		
		loja.getPessoa().setTelefones(telefones);
		
		
//		if (emailDAO.isEmailsExistente(loja.getPessoa().getEmails())) {
//			throw new Exception(
//					"O e-mail utilizado ja consta na base de dados.");
//		}
//		if (pessoaDAO.isNumeroSRFCadastrado(loja.getPessoa().getNumeroSRF(),
//				DocumentoTipoEnum.getFromCodigo(loja.getPessoa()
//						.getDocumentoTipo()))) {
//			throw new Exception(
//					"O documento utilizado ja consta na base de dados.");
//		}

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

	public List<LojaVO> listarLojasPorUsuario(Integer pessoaId) throws Exception {

		Collection<Loja> lojas = lojaDAO.listarLojasPorPessoaId(pessoaId);
		List<LojaVO> lojasVO = new ArrayList<LojaVO>();

		for (Loja loja : lojas) {
			List<Telefone>  telefones = (List<Telefone>) loja.getPessoa().getTelefones();
			LojaVO lojaVO = new LojaVO(loja.getNomeFantasia(), telefones.get(0).getNumero(), pessoaId);
			List<Endereco> enderecos = (List<Endereco>) loja.getPessoa().getEnderecos(); 
			
			Endereco endereco = enderecos.get(0);
			
			EnderecoVO enderecoVO = new EnderecoVO(); 
			
			enderecoVO.setLogradouro(endereco.getLogradouro());
			enderecoVO.setComplemento(enderecoVO.getComplemento());
			enderecoVO.setNumero(endereco.getNumero());
			enderecoVO.setBairro(endereco.getBairro());
			enderecoVO.setCep(String.valueOf(endereco.getCep()));
			enderecoVO.setCidade(endereco.getCidade());
			enderecoVO.setEstado(endereco.getEstado());
			enderecoVO.setPais(endereco.getPais());
			
			lojaVO.setEndereco(enderecoVO);
			lojasVO.add(lojaVO);
			
		}
		
		return lojasVO;
	}

	public Collection<Loja> listarTodasLojas() throws Exception {

		return lojaDAO.listarTodasLojas();
	}

}