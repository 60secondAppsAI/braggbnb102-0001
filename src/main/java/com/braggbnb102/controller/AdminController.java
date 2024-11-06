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

import com.braggbnb102.domain.Admin;
import com.braggbnb102.dto.AdminDTO;
import com.braggbnb102.dto.AdminSearchDTO;
import com.braggbnb102.dto.AdminPageDTO;
import com.braggbnb102.service.AdminService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/admin")
@RestController
public class AdminController {

	private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Admin> getAll() {

		List<Admin> admins = adminService.findAll();
		
		return admins;	
	}

	@GetMapping(value = "/{adminId}")
	@ResponseBody
	public AdminDTO getAdmin(@PathVariable Integer adminId) {
		
		return (adminService.getAdminDTOById(adminId));
	}

 	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ResponseEntity<?> addAdmin(@RequestBody AdminDTO adminDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = adminService.addAdmin(adminDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/admins")
	public ResponseEntity<AdminPageDTO> getAdmins(AdminSearchDTO adminSearchDTO) {
 
		return adminService.getAdmins(adminSearchDTO);
	}	

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
	public ResponseEntity<?> updateAdmin(@RequestBody AdminDTO adminDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = adminService.updateAdmin(adminDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
