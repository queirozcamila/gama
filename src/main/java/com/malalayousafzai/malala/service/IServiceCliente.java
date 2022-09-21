package com.malalayousafzai.malala.service;


import com.malalayousafzai.malala.model.Cliente;

import java.util.ArrayList;

public interface IServiceCliente {

    public Cliente criarNovo(Cliente novo);
    public ArrayList<Cliente> listar();
    public Cliente alterarDados(Cliente dados);
}
