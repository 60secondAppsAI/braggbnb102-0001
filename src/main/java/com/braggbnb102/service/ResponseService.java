package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.Response;
import com.braggbnb102.dto.ResponseDTO;
import com.braggbnb102.dto.ResponseSearchDTO;
import com.braggbnb102.dto.ResponsePageDTO;
import com.braggbnb102.dto.ResponseConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ResponseService extends GenericService<Response, Integer> {

	List<Response> findAll();

	ResultDTO addResponse(ResponseDTO responseDTO, RequestDTO requestDTO);

	ResultDTO updateResponse(ResponseDTO responseDTO, RequestDTO requestDTO);

    Page<Response> getAllResponses(Pageable pageable);

    Page<Response> getAllResponses(Specification<Response> spec, Pageable pageable);

	ResponseEntity<ResponsePageDTO> getResponses(ResponseSearchDTO responseSearchDTO);
	
	List<ResponseDTO> convertResponsesToResponseDTOs(List<Response> responses, ResponseConvertCriteriaDTO convertCriteria);

	ResponseDTO getResponseDTOById(Integer responseId);







}





