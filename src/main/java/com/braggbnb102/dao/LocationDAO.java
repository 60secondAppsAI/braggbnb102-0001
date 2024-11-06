package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Location;





public interface LocationDAO extends GenericDAO<Location, Integer> {
  
	List<Location> findAll();
	






}


