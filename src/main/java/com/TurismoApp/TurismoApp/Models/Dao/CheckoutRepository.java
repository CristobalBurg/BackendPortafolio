package com.TurismoApp.TurismoApp.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoApp.TurismoApp.Models.Entity.CheckOut;

public interface CheckoutRepository extends JpaRepository<CheckOut,Integer> {
    
}
