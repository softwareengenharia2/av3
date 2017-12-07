package br.com.fean.si.es2.dao;

import br.com.fean.si.es2.bean.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public class AbstractDAO <G extends Bean> {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(G bean) {
        entityManager.persist(bean);
    }

    public G getById(Long id) {
        return entityManager.find(getClazz(), id);
    }

    public List<G> list() {
        return entityManager.createQuery("Select bean FROM " + getClazz().getName() + " bean", getClazz() ).getResultList();
    }



    public void remove(Long id) {
        G bean = getById(id);
        entityManager.remove(bean);
    }

    public void update(G g){
        entityManager.merge(g);
    }

    public Class<G> getClazz() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class) (type).getActualTypeArguments()[0];
    }
}
