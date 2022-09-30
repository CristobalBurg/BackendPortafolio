package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.ClienteRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteDao;


    @Override
    @Transactional
    public List<Cliente> findAll() {
        return clienteDao.findAll();

    };
    @Override
    @Transactional
    public Optional<Cliente> findById(String rut) {
        return clienteDao.findById(rut);

    };
    @Override
    @Transactional
    public Cliente save(Cliente depto) {
        return clienteDao.save(depto);

    };
    @Override
    @Transactional
    public void delete(String rut) {
        clienteDao.deleteById(rut);

    }


    
}
