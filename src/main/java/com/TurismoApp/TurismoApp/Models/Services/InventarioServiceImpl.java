package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.InventarioRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Inventario;

@Service
public class InventarioServiceImpl implements IInventarioService {


    @Autowired
    private InventarioRepository inventarioDao;

    @Override
    public List<Inventario> findAll() {
        return inventarioDao.findAll();

    }

    @Override
    public Optional<Inventario> findById(int id) {
        return inventarioDao.findById(id);

    }

    @Override
    public Inventario save(Inventario inventario) {
        return inventarioDao.save(inventario);

    }

    @Override
    public void delete(int id) {
        inventarioDao.deleteById(id);
        
    }
    
}
