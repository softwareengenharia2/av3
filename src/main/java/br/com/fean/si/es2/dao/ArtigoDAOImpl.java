package br.com.fean.si.es2.dao;

import br.com.fean.si.es2.bean.Artigo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArtigoDAOImpl implements ArtigoDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(Artigo artigo) {
        manager.persist(artigo);
        manager.close();
    }

    @Override
    public void remove(Artigo artigo) {
        manager.remove(manager.contains(artigo)? artigo: manager.merge(artigo));
        manager.close();
    }

    @Override
    public void update(Artigo artigo) {
        manager.merge(artigo);
        manager.close();
    }

    @Override
    public List<Artigo> artigos() {
        List<Artigo> artigos = manager.createQuery("select a from Artigo a order by a.id asc", Artigo.class).getResultList();
        manager.close();
        return artigos;
    }

    @Override
    public Artigo findById(Long id) {
        return manager.find(Artigo.class, id);
    }

}
