package com.malalayousafzai.malala.service;

import com.malalayousafzai.malala.DAO.ClienteDAO;
import com.malalayousafzai.malala.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceClienteImpl implements IServiceCliente {

    @Autowired
    private ClienteDAO clienteDao;

    @Override
    public Cliente criarNovo(Cliente novo){
        if(novo.getNome() != null){
            return clienteDao.save(novo);
        }
        return null;
    }

    @Override
    public Optional<Cliente> detalhar(Integer id){
        return clienteDao.findById(id);
    }

    @Override
    public List<Cliente> listar(){
        return clienteDao.findAll();
    }

    //Retificar o metodo abaixo
    @Override
    public Cliente alterarDados(Cliente dados){
        if (dados.getId() != null && dados.getNome() != null){
            return clienteDao.save(dados);
        }
        return null;
    }

}
