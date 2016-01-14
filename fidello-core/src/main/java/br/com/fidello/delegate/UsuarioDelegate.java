package br.com.fidello.delegate;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.facade.UsuarioFacade;
import br.com.fidello.json.LoginVO;
import br.com.fidello.json.UsuarioVO;
import br.com.fidello.model.Email;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Usuario;

public class UsuarioDelegate {

	@Inject
	private UsuarioFacade usuarioFacade;

	public void cadastrarUsuario(UsuarioVO usuarioVO) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF
				.getCodigo()));
		usuario.getPessoa().addEmail(new Email(usuarioVO.getEmail(), false));

		usuario.getPessoa().setNome(usuarioVO.getNome());
		usuario.setSenha(usuarioVO.getSenha());
		usuario.getPessoa().setDocumentoTipo(1);
		usuario.getPessoa().setDocumento(usuarioVO.getDocumento());

		usuario = usuarioFacade.cadastrarUsuario(usuario);

	}

	public UsuarioVO loginUsuario(LoginVO login) throws Exception {

		Usuario usuarioRetorno = null;

		Usuario usuario = new Usuario();
		usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF
				.getCodigo()));

		usuario.getPessoa().setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
		usuario.getPessoa().setDocumento(login.getDocumento());
		usuario.getPessoa().setNumeroSRF(login.getDocumento());

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
			return usuarioVO;
		}

		throw new Exception("Falha no login. O login ou senha estão incorretos");

	}

}
