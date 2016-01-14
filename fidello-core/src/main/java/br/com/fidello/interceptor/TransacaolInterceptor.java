package br.com.fidello.interceptor;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fidello.qualifier.EntityManagerBancoXQualifier;
import br.com.fidello.qualifier.TransacaoQualifier;

@Interceptor
@TransacaoQualifier
public class TransacaolInterceptor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Inject @EntityManagerBancoXQualifier EntityManager entityManager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = entityManager.getTransaction();

		/**
		 * Não utilizar esse interceptor, pois está dando problema da forma qeu esta feito
		 * 
		 * Ao fazer a busca abaixo, combinada com outra busca em outro momento ele faz uma consulta a abnco automaticamente
		 * 
		 * usuario = this.buscarUsuarioPorDocumento(documento);
		 * usuario.setSenha("");
		 * 
		 * NEsse caso ali ele deleta a senha do usuario do BD, mesmo sem chamar outro metodo para salvar usuario
		 *
		 * 
		 */
		
		try {
			
			if (!transaction.isActive()) {
				transaction.begin();
			}
//			System.out.println("Antes");

			Object object =  context.proceed();
			
//			System.out.println("Depois");
			
			return object;
			
		} catch (Exception e) {
			
			if (transaction != null) {
				transaction.rollback();
			}

			throw e;

		} finally {
			
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
			
			// Não precisa fechar a transação pois o Producer ja cuida disso fechando ela após o request
		}

	}
}
