package com.malalayousafzai.malala.service;


import com.malalayousafzai.malala.model.Cliente;

import java.util.ArrayList;
import java.util.Optional;

public interface IServiceCliente {

    public Cliente criarNovo(Cliente novo);
    public ArrayList<Cliente> listar();
    public Optional<Cliente> detalhar(Integer id);
    public Cliente alterarDados(Cliente dados);
}
