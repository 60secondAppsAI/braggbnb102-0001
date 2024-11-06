package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.CancellationPolicy;





public interface CancellationPolicyDAO extends GenericDAO<CancellationPolicy, Integer> {
  
	List<CancellationPolicy> findAll();
	






}


