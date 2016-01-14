package br.com.fidello.util;

import javax.inject.Inject;

public class SelecaoUsuario{

	private Integer tipoUsuario;
	private String strCpf;
	private String strCnpj;
	private String strEmail;
	
	public String getStrCpf() {
		return strCpf;
	}

	public void setStrCpf(String strCpf) {
		this.strCpf = strCpf;
	}

	public String getStrCnpj() {
		return strCnpj;
	}

	public void setStrCnpj(String strCnpj) {
		this.strCnpj = strCnpj;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}