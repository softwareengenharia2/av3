package br.com.fean.si.es2.dao;

import br.com.fean.si.es2.bean.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @PersistenceContext
    private EntityManager entityManager;

    public Usuario getByCnpj(String cnpj) {
        try {
            Query query = entityManager.createQuery("Select c From Cliente WHERE c.documento = :documento", Usuario.class);
            query.setParameter("cnpj", cnpj);
            return (Usuario) query.getSingleResult();
        }catch(NoResultException e) {
            return null;
        }
    }
}
