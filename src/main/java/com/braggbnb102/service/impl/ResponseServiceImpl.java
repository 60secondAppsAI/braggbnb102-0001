package com.braggbnb102.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.braggbnb102.dao.GenericDAO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.service.impl.GenericServiceImpl;
import com.braggbnb102.dao.ResponseDAO;
import com.braggbnb102.domain.Response;
import com.braggbnb102.dto.ResponseDTO;
import com.braggbnb102.dto.ResponseSearchDTO;
import com.braggbnb102.dto.ResponsePageDTO;
import com.braggbnb102.dto.ResponseConvertCriteriaDTO;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import com.braggbnb102.service.ResponseService;
import com.braggbnb102.util.ControllerUtils;





@Service
public class ResponseServiceImpl extends GenericServiceImpl<Response, Integer> implements ResponseService {

    private final static Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);

	@Autowired
	ResponseDAO responseDao;

	


	@Override
	public GenericDAO<Response, Integer> getDAO() {
		return (GenericDAO<Response, Integer>) responseDao;
	}
	
	public List<Response> findAll () {
		List<Response> responses = responseDao.findAll();
		
		return responses;	
		
	}

	public ResultDTO addResponse(ResponseDTO responseDTO, RequestDTO requestDTO) {

		Response response = new Response();

		response.setResponseId(responseDTO.getResponseId());


		response.setResponseText(responseDTO.getResponseText());


		response.setResponseDate(responseDTO.getResponseDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		response = responseDao.save(response);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Response> getAllResponses(Pageable pageable) {
		return responseDao.findAll(pageable);
	}

	public Page<Response> getAllResponses(Specification<Response> spec, Pageable pageable) {
		return responseDao.findAll(spec, pageable);
	}

	public ResponseEntity<ResponsePageDTO> getResponses(ResponseSearchDTO responseSearchDTO) {
	
			Integer responseId = responseSearchDTO.getResponseId(); 
 			String responseText = responseSearchDTO.getResponseText(); 
   			String sortBy = responseSearchDTO.getSortBy();
			String sortOrder = responseSearchDTO.getSortOrder();
			String searchQuery = responseSearchDTO.getSearchQuery();
			Integer page = responseSearchDTO.getPage();
			Integer size = responseSearchDTO.getSize();

	        Specification<Response> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, responseId, "responseId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, responseText, "responseText"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("responseText")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Response> responses = this.getAllResponses(spec, pageable);
		
		//System.out.println(String.valueOf(responses.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(responses.getTotalPages()));
		
		List<Response> responsesList = responses.getContent();
		
		ResponseConvertCriteriaDTO convertCriteria = new ResponseConvertCriteriaDTO();
		List<ResponseDTO> responseDTOs = this.convertResponsesToResponseDTOs(responsesList,convertCriteria);
		
		ResponsePageDTO responsePageDTO = new ResponsePageDTO();
		responsePageDTO.setResponses(responseDTOs);
		responsePageDTO.setTotalElements(responses.getTotalElements());
		return ResponseEntity.ok(responsePageDTO);
	}

	public List<ResponseDTO> convertResponsesToResponseDTOs(List<Response> responses, ResponseConvertCriteriaDTO convertCriteria) {
		
		List<ResponseDTO> responseDTOs = new ArrayList<ResponseDTO>();
		
		for (Response response : responses) {
			responseDTOs.add(convertResponseToResponseDTO(response,convertCriteria));
		}
		
		return responseDTOs;

	}
	
	public ResponseDTO convertResponseToResponseDTO(Response response, ResponseConvertCriteriaDTO convertCriteria) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		responseDTO.setResponseId(response.getResponseId());

	
		responseDTO.setResponseText(response.getResponseText());

	
		responseDTO.setResponseDate(response.getResponseDate());

	

		
		return responseDTO;
	}

	public ResultDTO updateResponse(ResponseDTO responseDTO, RequestDTO requestDTO) {
		
		Response response = responseDao.getById(responseDTO.getResponseId());

		response.setResponseId(ControllerUtils.setValue(response.getResponseId(), responseDTO.getResponseId()));

		response.setResponseText(ControllerUtils.setValue(response.getResponseText(), responseDTO.getResponseText()));

		response.setResponseDate(ControllerUtils.setValue(response.getResponseDate(), responseDTO.getResponseDate()));



        response = responseDao.save(response);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ResponseDTO getResponseDTOById(Integer responseId) {
	
		Response response = responseDao.getById(responseId);
			
		
		ResponseConvertCriteriaDTO convertCriteria = new ResponseConvertCriteriaDTO();
		return(this.convertResponseToResponseDTO(response,convertCriteria));
	}







}
