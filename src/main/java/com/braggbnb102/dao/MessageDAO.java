package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Message;





public interface MessageDAO extends GenericDAO<Message, Integer> {
  
	List<Message> findAll();
	






}


