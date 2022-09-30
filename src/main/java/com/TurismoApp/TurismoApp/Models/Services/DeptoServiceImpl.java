package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.DepartamentoRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Comuna;
import com.TurismoApp.TurismoApp.Models.Entity.Departamento;

@Service
public class DeptoServiceImpl implements IDeptoService {

    @Autowired
    private DepartamentoRepository deptoDao;
    @Override
    @Transactional
    public List<Departamento> findAll() {
        return deptoDao.findAll();

    };
    @Override
    @Transactional
    public Optional<Departamento> findById(int id) {
        return deptoDao.findById(id);

    };
    @Override
    @Transactional
    public Departamento save(Departamento depto) {
        return deptoDao.save(depto);

    };
    @Override
    @Transactional
    public void delete(int id) {
        deptoDao.deleteById(id);

    };
    @Override
    @Transactional
    public List<Comuna> findAllComunas() {
        return deptoDao.findAllComunas();

    };

}
