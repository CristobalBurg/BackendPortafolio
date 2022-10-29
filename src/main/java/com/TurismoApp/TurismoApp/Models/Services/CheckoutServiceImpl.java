package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.CheckoutRepository;
import com.TurismoApp.TurismoApp.Models.Entity.CheckOut;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

    @Autowired
    private CheckoutRepository checkoutDao;

    @Override
    public List<CheckOut> findAll() {
        return checkoutDao.findAll();

    }

    @Override
    public Optional<CheckOut> findById(int id) {
        return checkoutDao.findById(id);

    }

    @Override
    public CheckOut save(CheckOut checkout) {
        return checkoutDao.save(checkout);

    }

    @Override
    public void delete(int id) {
        checkoutDao.deleteById(id);
        
    }
    
}
