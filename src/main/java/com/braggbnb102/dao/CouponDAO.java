package com.braggbnb102.dao;

import java.util.List;

import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.domain.Coupon;





public interface CouponDAO extends GenericDAO<Coupon, Integer> {
  
	List<Coupon> findAll();
	






}


