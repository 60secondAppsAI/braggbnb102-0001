package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.Admin;
import com.braggbnb102.dto.AdminDTO;
import com.braggbnb102.dto.AdminSearchDTO;
import com.braggbnb102.dto.AdminPageDTO;
import com.braggbnb102.dto.AdminConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AdminService extends GenericService<Admin, Integer> {

	List<Admin> findAll();

	ResultDTO addAdmin(AdminDTO adminDTO, RequestDTO requestDTO);

	ResultDTO updateAdmin(AdminDTO adminDTO, RequestDTO requestDTO);

    Page<Admin> getAllAdmins(Pageable pageable);

    Page<Admin> getAllAdmins(Specification<Admin> spec, Pageable pageable);

	ResponseEntity<AdminPageDTO> getAdmins(AdminSearchDTO adminSearchDTO);
	
	List<AdminDTO> convertAdminsToAdminDTOs(List<Admin> admins, AdminConvertCriteriaDTO convertCriteria);

	AdminDTO getAdminDTOById(Integer adminId);







}





