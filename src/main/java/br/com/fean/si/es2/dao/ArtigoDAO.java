package br.com.fean.si.es2.dao;

import br.com.fean.si.es2.bean.Artigo;

import java.util.List;

public interface ArtigoDAO {

    public void add(Artigo artigo);

    public void remove(Artigo artigo);

    public void update(Artigo artigo);

    public List<Artigo> artigos();

    public Artigo findById(Long id);

}
