package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.ContactSupport;





public interface ContactSupportDAO extends GenericDAO<ContactSupport, Integer> {
  
	List<ContactSupport> findAll();
	






}


