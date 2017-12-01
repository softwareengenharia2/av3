package br.com.fean.si.es2.dao;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fean.si.es2.bean.Cliente;

@Repository
@Transactional
public class PreCadastroClienteDAO {

	private EntityManager em;

	public void persist(Cliente bean) {
		em.persist(bean);
	}

}
