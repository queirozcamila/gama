package com.malalayousafzai.malala.service;

import com.malalayousafzai.malala.DAO.VideoDAO;
//import com.malalayousafzai.malala.model.Historico;
import com.malalayousafzai.malala.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVideoImpl implements IServiceVideo  {

    @Autowired
    public VideoDAO videoDao;

    @Override
    public List<Video> listar(){
        return videoDao.findAll();
    }

    @Override
    public Optional<Video> detalhar(Integer id){
        return videoDao.findById(id);
    }

    @Override
    public Video concluir(Integer id){
        Optional<Video> videoVerificacao = videoDao.findById(id);
        if(videoVerificacao.isPresent()) {
            Video videoClassificado = videoVerificacao.get();
            //Como pegar o id do cliente e inserir esse video na List<Video> videos desse cliente?.
          }
        return null;
    }


    //ESSE TRECHO AQUIIII!
    @Override
    public Video classificar(Integer id, Video dados){
       Optional<Video> videoVerificacao = videoDao.findById(id);
       if(videoVerificacao.isPresent()){

           Video videoClassificado = videoVerificacao.get();
           videoClassificado.setNotaVideo(dados.getNotaVideo());
           videoClassificado.setConcluido(true);

           //Historico  historico = new Historico();
           //videoClassificado.setHistorico(historico);
           //Historico historico = videoClassificado.getHistorico();
           //historico.setVideos();

           return videoDao.save(videoClassificado);
       }
       return null;
    }
}