package br.com.fidello.delegate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.facade.UsuarioFacade;
import br.com.fidello.json.LoginVO;
import br.com.fidello.json.UsuarioVO;
import br.com.fidello.model.Email;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Usuario;

public class UsuarioDelegate {

	@Inject
	private UsuarioFacade usuarioFacade;

	public void cadastrarUsuario(UsuarioVO usuarioVO) throws Exception {

		Usuario usuario = new Usuario();
		if(usuarioVO.getTipoUsuario().equals(PessoaIdentificacaoTipoEnum.CPF.getCodigo()))
			usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF.getCodigo()));
		else
			usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CNPJ.getCodigo()));
		
		usuario.getPessoa().addEmail(new Email(usuarioVO.getEmail(), true));

		usuario.getPessoa().setNome(usuarioVO.getNome());
		usuario.setSenha(usuarioVO.getSenha());
		usuario.getPessoa().setDocumentoTipo(usuarioVO.getTipoUsuario());
		usuario.getPessoa().setDocumento(usuarioVO.getDocumento());
		usuario.getPessoa().setNumeroSRF(usuarioVO.getDocumento());

		usuario = usuarioFacade.cadastrarUsuario(usuario);

	}

	public UsuarioVO loginUsuario(LoginVO login) throws Exception {

		Usuario usuarioRetorno = null;

		Usuario usuario = new Usuario();

		switch (login.getTipoUsuario()) {

		case 1:
			usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF
					.getCodigo()));

			usuario.getPessoa().setDocumentoTipo(
					DocumentoTipoEnum.CPF.getCodigo());
			usuario.getPessoa().setDocumento(login.getDocumento());
			usuario.getPessoa().setNumeroSRF(login.getDocumento());
			break;

		case 2:
			usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CNPJ
					.getCodigo()));

			usuario.getPessoa().setDocumentoTipo(
					DocumentoTipoEnum.CNPJ.getCodigo());
			usuario.getPessoa().setDocumento(login.getDocumento());
			usuario.getPessoa().setNumeroSRF(login.getDocumento());
			break;

		case 3:
			usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.EMAIL
					.getCodigo()));

			List<Email> emails = new ArrayList<Email>();
			emails.add(new Email(login.getDocumento(), true));
			usuario.getPessoa().setEmails(emails);
			break;
		}

		
		usuario.setSenha(login.getSenha());

		if (usuario.getPessoa().getEmails() != null
				|| usuario.getPessoa().getNumeroSRF() != null) {

			usuarioRetorno = usuarioFacade.autenticarUsuario(usuario);

		} else {

			throw new Exception(
					"Falha no login. O login ou senha não estão preenchidos");
		}

		if (usuarioRetorno != null) {
			UsuarioVO usuarioVO = new UsuarioVO();

			usuarioVO.setDocumento(usuarioRetorno.getPessoa().getDocumento());
			usuarioVO.setNome(usuarioRetorno.getPessoa().getNome());

			for (Email email : usuarioRetorno.getPessoa().getEmails()) {
				if (email.getPreferencial())
					usuarioVO.setEmail(email.getEmail());
			}
			usuarioVO.setIdPessoa(usuarioRetorno.getPessoa().getId());
			
			for(Loja loja : usuarioRetorno.getPessoa().getLojas()){
				usuarioVO.setIdLoja(loja.getId());	
			}
				
			
			return usuarioVO;
		}

		throw new Exception("Falha no login. O login ou senha estão incorretos");

	}

}
