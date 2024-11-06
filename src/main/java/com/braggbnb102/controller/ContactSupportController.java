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

import com.braggbnb102.domain.ContactSupport;
import com.braggbnb102.dto.ContactSupportDTO;
import com.braggbnb102.dto.ContactSupportSearchDTO;
import com.braggbnb102.dto.ContactSupportPageDTO;
import com.braggbnb102.service.ContactSupportService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/contactSupport")
@RestController
public class ContactSupportController {

	private final static Logger logger = LoggerFactory.getLogger(ContactSupportController.class);

	@Autowired
	ContactSupportService contactSupportService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<ContactSupport> getAll() {

		List<ContactSupport> contactSupports = contactSupportService.findAll();
		
		return contactSupports;	
	}

	@GetMapping(value = "/{contactSupportId}")
	@ResponseBody
	public ContactSupportDTO getContactSupport(@PathVariable Integer contactSupportId) {
		
		return (contactSupportService.getContactSupportDTOById(contactSupportId));
	}

 	@RequestMapping(value = "/addContactSupport", method = RequestMethod.POST)
	public ResponseEntity<?> addContactSupport(@RequestBody ContactSupportDTO contactSupportDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = contactSupportService.addContactSupport(contactSupportDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/contactSupports")
	public ResponseEntity<ContactSupportPageDTO> getContactSupports(ContactSupportSearchDTO contactSupportSearchDTO) {
 
		return contactSupportService.getContactSupports(contactSupportSearchDTO);
	}	

	@RequestMapping(value = "/updateContactSupport", method = RequestMethod.POST)
	public ResponseEntity<?> updateContactSupport(@RequestBody ContactSupportDTO contactSupportDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = contactSupportService.updateContactSupport(contactSupportDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
