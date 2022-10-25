package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.ProductosRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductosRepository productoDao;

    @Override
    @Transactional
    public List<Producto> findAll() {
        return productoDao.findAll();

    }

    @Override
    @Transactional
    public Optional<Producto> findById(int id) {
        return productoDao.findById(id);

    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDao.save(producto);

    }

    @Override
    @Transactional
    public void delete(int id) {
        productoDao.deleteById(id);
        
    }
    
}
