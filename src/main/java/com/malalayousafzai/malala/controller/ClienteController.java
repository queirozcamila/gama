package com.malalayousafzai.malala.controller;

import com.malalayousafzai.malala.controller.Dto.DetalhesClienteDto;
import com.malalayousafzai.malala.model.Cliente;
import com.malalayousafzai.malala.service.ServiceClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ServiceClienteImpl serviceClienteImpl;


    @GetMapping
    public ArrayList<Cliente> listar(Cliente cLiente){
        return serviceClienteImpl.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional> detalhar(@PathVariable Integer id){
        Optional<Cliente> resp = serviceClienteImpl.detalhar(id);
        if(resp.isPresent()){
            return  ResponseEntity.ok(resp.map(DetalhesClienteDto::new));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente novo){
        Cliente resp = serviceClienteImpl.criarNovo(novo);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.badRequest().build();
    }

    //Retificar o put
    @PutMapping
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente dados){
        Cliente resp = serviceClienteImpl.alterarDados(dados);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.badRequest().build();
    }
}