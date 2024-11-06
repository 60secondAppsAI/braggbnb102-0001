package com.braggbnb102.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.braggbnb102.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.braggbnb102.domain.Response;
import com.braggbnb102.dto.ResponseDTO;
import com.braggbnb102.dto.ResponseSearchDTO;
import com.braggbnb102.dto.ResponsePageDTO;
import com.braggbnb102.service.ResponseService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/response")
@RestController
public class ResponseController {

	private final static Logger logger = LoggerFactory.getLogger(ResponseController.class);

	@Autowired
	ResponseService responseService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Response> getAll() {

		List<Response> responses = responseService.findAll();
		
		return responses;	
	}

	@GetMapping(value = "/{responseId}")
	@ResponseBody
	public ResponseDTO getResponse(@PathVariable Integer responseId) {
		
		return (responseService.getResponseDTOById(responseId));
	}

 	@RequestMapping(value = "/addResponse", method = RequestMethod.POST)
	public ResponseEntity<?> addResponse(@RequestBody ResponseDTO responseDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = responseService.addResponse(responseDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/responses")
	public ResponseEntity<ResponsePageDTO> getResponses(ResponseSearchDTO responseSearchDTO) {
 
		return responseService.getResponses(responseSearchDTO);
	}	

	@RequestMapping(value = "/updateResponse", method = RequestMethod.POST)
	public ResponseEntity<?> updateResponse(@RequestBody ResponseDTO responseDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = responseService.updateResponse(responseDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
