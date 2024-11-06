package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.CleaningFee;





public interface CleaningFeeDAO extends GenericDAO<CleaningFee, Integer> {
  
	List<CleaningFee> findAll();
	






}


