package br.fidello.service;


import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

public class MyApplication extends Application {

	private final Set<Object> singletons_;

	private static final Logger logger = Logger.getLogger(MyApplication.class.getName());

	public MyApplication() {

		this.singletons_ = new HashSet<Object>();

		logger.info("## MyApplication: Inicializando MyApplication");
		
		UsuarioService usuarioService = new UsuarioService();
		
		LojaService lojaService = new LojaService();
		
		CampanhaService campanhaService = new CampanhaService();
		
		validarWebService(usuarioService);
		validarWebService(lojaService);
		validarWebService(campanhaService);
		
		singletons_.add(usuarioService);
		singletons_.add(lojaService);
		singletons_.add(campanhaService);
		
		logger.info("## GCS: WebService '" + usuarioService.getClass().getCanonicalName() + "' adicionado com sucesso.");

	}

	private void validarWebService(Object ws) {
		if (ws.getClass().getAnnotation(Path.class) == null) {
			throw new IllegalArgumentException("Os WebServices precisam declarar a anotação '" + Path.class.getCanonicalName() + "' e o WebService '" + ws.getClass().getCanonicalName() + "' não declara");
		}
	}

	public Set<Object> getSingletons() {

		return singletons_;

	}

}

	