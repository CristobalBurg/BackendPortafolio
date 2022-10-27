package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.CheckIn;

public interface CheckinRepository extends JpaRepository< CheckIn , Integer> {
    
}
