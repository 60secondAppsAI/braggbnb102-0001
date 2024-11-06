package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.CleaningFee;
import com.braggbnb102.dto.CleaningFeeDTO;
import com.braggbnb102.dto.CleaningFeeSearchDTO;
import com.braggbnb102.dto.CleaningFeePageDTO;
import com.braggbnb102.dto.CleaningFeeConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CleaningFeeService extends GenericService<CleaningFee, Integer> {

	List<CleaningFee> findAll();

	ResultDTO addCleaningFee(CleaningFeeDTO cleaningFeeDTO, RequestDTO requestDTO);

	ResultDTO updateCleaningFee(CleaningFeeDTO cleaningFeeDTO, RequestDTO requestDTO);

    Page<CleaningFee> getAllCleaningFees(Pageable pageable);

    Page<CleaningFee> getAllCleaningFees(Specification<CleaningFee> spec, Pageable pageable);

	ResponseEntity<CleaningFeePageDTO> getCleaningFees(CleaningFeeSearchDTO cleaningFeeSearchDTO);
	
	List<CleaningFeeDTO> convertCleaningFeesToCleaningFeeDTOs(List<CleaningFee> cleaningFees, CleaningFeeConvertCriteriaDTO convertCriteria);

	CleaningFeeDTO getCleaningFeeDTOById(Integer cleaningFeeId);







}





