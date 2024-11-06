package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}

