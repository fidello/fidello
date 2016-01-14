package br.com.fidello.mb;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;

@Named
@ApplicationScoped
public class Aplicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	public LabelValue[] getDocumentoTiposLabelValue(){
		
		LabelValue labelValue[] = new LabelValue[DocumentoTipoEnum.values().length];
		int i = 0;
		for (DocumentoTipoEnum documentoTipoEnum : DocumentoTipoEnum.values()) {
			labelValue[i] = new LabelValue(documentoTipoEnum.getTexto(), String.valueOf(documentoTipoEnum.getCodigo()));
			i++;
		}
		
		return labelValue;
			
	}

}