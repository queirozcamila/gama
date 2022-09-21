package com.malalayousafzai.malala.DAO;


import com.malalayousafzai.malala.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

}
