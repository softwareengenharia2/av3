package br.com.fean.si.es2.business;

import br.com.fean.si.es2.bean.Artigo;
import br.com.fean.si.es2.dao.ArtigoDAO;
import br.com.fean.si.es2.dto.ArtigoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    private ArtigoDAO artigoDAO;

    @Override
    public void add(ArtigoDTO artigoDTO) {
        artigoDTO.setData(Calendar.getInstance().getTime());
        artigoDAO.add(DTOToEntity(artigoDTO));
    }

    @Override
    public void remove(Long id) {
        Artigo artigo = artigoDAO.findById(id);
        artigoDAO.remove(artigo);
    }

    @Override
    public void update(ArtigoDTO artigoDTO) {
        artigoDTO.setData(Calendar.getInstance().getTime());
        artigoDAO.update(DTOToEntity(artigoDTO));
    }

    @Override
    public List<ArtigoDTO> artigos() {
        List<ArtigoDTO> artigoDTOS = new ArrayList<>();
        List<Artigo> artigos = artigoDAO.artigos();
        for (Artigo artigo: artigos) {
            ArtigoDTO artigoDTO = entityToDto(artigo);
            artigoDTOS.add(artigoDTO);
        }
        return artigoDTOS;
    }

    @Override
    public ArtigoDTO findById(Long id) {
        return entityToDto(artigoDAO.findById(id));
    }

    public String getData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public ArtigoDTO entityToDto(Artigo artigo) {
        ArtigoDTO artigoDTO = new ArtigoDTO();
        artigoDTO.setIdArtigo(artigo.getIdArtigo());
        artigoDTO.setTitulo(artigo.getTitulo());
        artigoDTO.setConteudo(artigo.getConteudo());
        artigoDTO.setTipoArtigo(artigo.getTipoArtigo());
        artigoDTO.setData(artigo.getData());
        artigoDTO.setAprovado(artigo.getAprovado());
        return artigoDTO;
    }

    public Artigo DTOToEntity(ArtigoDTO artigoDTO) {
        Artigo artigo = new Artigo();
        artigo.setIdArtigo(artigoDTO.getIdArtigo());
        artigo.setTitulo(artigoDTO.getTitulo());
        artigo.setConteudo(artigoDTO.getConteudo());
        artigo.setTipoArtigo(artigoDTO.getTipoArtigo());
        artigo.setData(artigoDTO.getData());
        artigo.setAprovado(artigoDTO.getAprovado());
        return artigo;
    }

}
