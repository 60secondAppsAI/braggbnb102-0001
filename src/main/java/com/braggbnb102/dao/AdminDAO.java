package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Admin;





public interface AdminDAO extends GenericDAO<Admin, Integer> {
  
	List<Admin> findAll();
	






}


