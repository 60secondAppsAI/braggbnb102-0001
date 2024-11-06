package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Response;





public interface ResponseDAO extends GenericDAO<Response, Integer> {
  
	List<Response> findAll();
	






}


