package br.com.fidello.dao;

import java.util.Collection;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.fidello.model.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco> {
	private static final long serialVersionUID = 1L;

	public EnderecoDAO() {
		super(Endereco.class);
	}

	private int getNovoId(int pessoaId){
		
		Integer retorno = (Integer) getSession().createCriteria(Endereco.class)
	        	.add(Restrictions.eq("pessoaId", pessoaId))
	        	  .setProjection( Projections.max("id") )
	        	  .uniqueResult();
	        
		if(retorno != null){
			return ++retorno;
		}
		return 0;
		
	}

	
	@SuppressWarnings("unchecked")
	public Collection<Endereco> detalharEnderecoPorPessoaId(Integer pessoaId) throws Exception {

		return getSession().createCriteria(Endereco.class)
        	.add(Restrictions.eq("pessoaId", pessoaId))
        	.list();

	}
	
	@SuppressWarnings("unchecked")
	public Collection<Endereco> listarTodasEnderecos() throws Exception {

		return getSession().createCriteria(Endereco.class).list();

	}
	
	public Endereco cadastrarEndereco(Integer pessoaId, String logradouro, String complemento, String numero, String bairro, String cidade, String estado, String pais, long cep, int tipo, boolean preferencial) throws Exception {
		
		Endereco enderecoGravar = new Endereco();
		
		enderecoGravar.setId(getNovoId(pessoaId));
//		enderecoGravar.setPessoaId(pessoaId);
		
		enderecoGravar.setLogradouro(logradouro);
		enderecoGravar.setComplemento(complemento);
		enderecoGravar.setNumero(numero);
		enderecoGravar.setBairro(bairro);
		enderecoGravar.setCidade(cidade);
		enderecoGravar.setEstado(estado);
		enderecoGravar.setPais(pais);
		enderecoGravar.setCep(cep);
		enderecoGravar.setTipo(tipo);
		enderecoGravar.setPreferencial(preferencial);

		getSession().persist(enderecoGravar);
		
		return enderecoGravar;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public List<Endereco> listarEnderecosPorId(List<Integer> enderecos_id){
//		
////		beginTransaction();
//		
//		Criteria criteria = getSession().createCriteria(Endereco.class);
//		Criterion paramUsuarioId = Restrictions.in("id", enderecos_id);
//		criteria.add(paramUsuarioId);
//		
//		return criteria.list();
//
//	}
//	
//	public Endereco buscarEnderecoPorDocumento(String documento){
//		
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("documento", documento);
////		Endereco endereco = super.findOneResult(Endereco.BUSCAR_LOJA_POR_DOCUMENTO, parameters);
//		
////		return endereco;
//		return null;
//	}
//	
//	public void delete(Endereco endereco) {
//        	super.delete(endereco.getId(), Endereco.class);
//	}
}
