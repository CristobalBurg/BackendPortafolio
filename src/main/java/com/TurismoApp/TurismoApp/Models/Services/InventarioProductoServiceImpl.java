package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.InventarioProductoRepository;
import com.TurismoApp.TurismoApp.Models.Entity.InventarioProducto;
@Service
public class InventarioProductoServiceImpl implements IInventarioProductoService {

    @Autowired
    private InventarioProductoRepository invProdDao;

    @Override
    @Transactional
    public List<InventarioProducto> findAll() {
        return invProdDao.findAll();

    }

    @Override
    @Transactional
    public Optional<InventarioProducto> findById(int id) {
        return invProdDao.findById(id);

    }

    @Override
    @Transactional
    public InventarioProducto save(InventarioProducto ip) {
        return invProdDao.save(ip);

    }

    @Override
    @Transactional
    public void delete(int id) {
        invProdDao.deleteById(id);

        
    }

    
}
