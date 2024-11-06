package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Host;





public interface HostDAO extends GenericDAO<Host, Integer> {
  
	List<Host> findAll();
	






}


