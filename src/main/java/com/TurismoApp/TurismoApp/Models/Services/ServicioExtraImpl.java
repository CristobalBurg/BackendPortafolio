package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TurismoApp.TurismoApp.Models.Dao.ServicioExtraRepository;
import com.TurismoApp.TurismoApp.Models.Entity.ServicioExtra;

@Service
public class ServicioExtraImpl  implements IServicioExtra {

    @Autowired
    private ServicioExtraRepository servicioExtraDAO;


    @Override
    @Transactional
    public List<ServicioExtra> findAll() {
        return servicioExtraDAO.findAll();

    };
    @Override
    @Transactional
    public Optional<ServicioExtra> findById(int id) {
        return servicioExtraDAO.findById(id);

    };
    @Override
    @Transactional
    public ServicioExtra save(ServicioExtra servicioExtra) {
        return servicioExtraDAO.save(servicioExtra);

    };
    @Override
    @Transactional
    public void delete(int id) {
        servicioExtraDAO.deleteById(id);

    }
     
}
