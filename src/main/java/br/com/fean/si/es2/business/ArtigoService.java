package br.com.fean.si.es2.business;

import br.com.fean.si.es2.dto.ArtigoDTO;

import java.util.List;

public interface ArtigoService {

    public void add(ArtigoDTO artigoDTO);

    public void remove(Long id);

    public void update(ArtigoDTO artigoDTO);

    public List<ArtigoDTO> artigos();

    public ArtigoDTO findById(Long id);

}
