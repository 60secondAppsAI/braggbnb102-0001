package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Photo;





public interface PhotoDAO extends GenericDAO<Photo, Integer> {
  
	List<Photo> findAll();
	






}


