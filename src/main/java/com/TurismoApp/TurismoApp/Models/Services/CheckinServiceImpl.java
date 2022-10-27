package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TurismoApp.TurismoApp.Models.Dao.CheckinRepository;
import com.TurismoApp.TurismoApp.Models.Entity.CheckIn;

@Service
public class CheckinServiceImpl implements ICheckinService {

    @Autowired
    private CheckinRepository checkInDao;

    @Override
    @Transactional
    public List<CheckIn> findAll() {
        return checkInDao.findAll();

    }

    @Override
    @Transactional
    public Optional<CheckIn> findById(int id) {
        return checkInDao.findById(id);

    }

    @Override
    @Transactional
    public CheckIn save(CheckIn checkIn) {
        return checkInDao.save(checkIn);

    }

    @Override
    @Transactional
    public void delete(int id) {
        checkInDao.deleteById(id);
        
    }
    
}
