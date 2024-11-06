package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.Discount;
import com.braggbnb102.dto.DiscountDTO;
import com.braggbnb102.dto.DiscountSearchDTO;
import com.braggbnb102.dto.DiscountPageDTO;
import com.braggbnb102.dto.DiscountConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface DiscountService extends GenericService<Discount, Integer> {

	List<Discount> findAll();

	ResultDTO addDiscount(DiscountDTO discountDTO, RequestDTO requestDTO);

	ResultDTO updateDiscount(DiscountDTO discountDTO, RequestDTO requestDTO);

    Page<Discount> getAllDiscounts(Pageable pageable);

    Page<Discount> getAllDiscounts(Specification<Discount> spec, Pageable pageable);

	ResponseEntity<DiscountPageDTO> getDiscounts(DiscountSearchDTO discountSearchDTO);
	
	List<DiscountDTO> convertDiscountsToDiscountDTOs(List<Discount> discounts, DiscountConvertCriteriaDTO convertCriteria);

	DiscountDTO getDiscountDTOById(Integer discountId);







}





