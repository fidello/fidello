package br.com.fidello.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fidello.enums.BooleanEnum;
import br.com.fidello.enums.TelefoneTipoEnum;

@Named
@RequestScoped
public class IntefaceHelper extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<BooleanEnum> getIsMatrizTipos(){
		return Arrays.asList(BooleanEnum.values());
	}
	
	public List<TelefoneTipoEnum> getTelefoneTipos(){
		return Arrays.asList(TelefoneTipoEnum.values());
	}
	
	
}