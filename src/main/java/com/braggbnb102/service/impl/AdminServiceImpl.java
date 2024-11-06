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
import com.braggbnb102.dao.AdminDAO;
import com.braggbnb102.domain.Admin;
import com.braggbnb102.dto.AdminDTO;
import com.braggbnb102.dto.AdminSearchDTO;
import com.braggbnb102.dto.AdminPageDTO;
import com.braggbnb102.dto.AdminConvertCriteriaDTO;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import com.braggbnb102.service.AdminService;
import com.braggbnb102.util.ControllerUtils;





@Service
public class AdminServiceImpl extends GenericServiceImpl<Admin, Integer> implements AdminService {

    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	AdminDAO adminDao;

	


	@Override
	public GenericDAO<Admin, Integer> getDAO() {
		return (GenericDAO<Admin, Integer>) adminDao;
	}
	
	public List<Admin> findAll () {
		List<Admin> admins = adminDao.findAll();
		
		return admins;	
		
	}

	public ResultDTO addAdmin(AdminDTO adminDTO, RequestDTO requestDTO) {

		Admin admin = new Admin();

		admin.setAdminId(adminDTO.getAdminId());


		admin.setLevel(adminDTO.getLevel());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		admin = adminDao.save(admin);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Admin> getAllAdmins(Pageable pageable) {
		return adminDao.findAll(pageable);
	}

	public Page<Admin> getAllAdmins(Specification<Admin> spec, Pageable pageable) {
		return adminDao.findAll(spec, pageable);
	}

	public ResponseEntity<AdminPageDTO> getAdmins(AdminSearchDTO adminSearchDTO) {
	
			Integer adminId = adminSearchDTO.getAdminId(); 
 			String level = adminSearchDTO.getLevel(); 
 			String sortBy = adminSearchDTO.getSortBy();
			String sortOrder = adminSearchDTO.getSortOrder();
			String searchQuery = adminSearchDTO.getSearchQuery();
			Integer page = adminSearchDTO.getPage();
			Integer size = adminSearchDTO.getSize();

	        Specification<Admin> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, adminId, "adminId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, level, "level"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("level")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Admin> admins = this.getAllAdmins(spec, pageable);
		
		//System.out.println(String.valueOf(admins.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(admins.getTotalPages()));
		
		List<Admin> adminsList = admins.getContent();
		
		AdminConvertCriteriaDTO convertCriteria = new AdminConvertCriteriaDTO();
		List<AdminDTO> adminDTOs = this.convertAdminsToAdminDTOs(adminsList,convertCriteria);
		
		AdminPageDTO adminPageDTO = new AdminPageDTO();
		adminPageDTO.setAdmins(adminDTOs);
		adminPageDTO.setTotalElements(admins.getTotalElements());
		return ResponseEntity.ok(adminPageDTO);
	}

	public List<AdminDTO> convertAdminsToAdminDTOs(List<Admin> admins, AdminConvertCriteriaDTO convertCriteria) {
		
		List<AdminDTO> adminDTOs = new ArrayList<AdminDTO>();
		
		for (Admin admin : admins) {
			adminDTOs.add(convertAdminToAdminDTO(admin,convertCriteria));
		}
		
		return adminDTOs;

	}
	
	public AdminDTO convertAdminToAdminDTO(Admin admin, AdminConvertCriteriaDTO convertCriteria) {
		
		AdminDTO adminDTO = new AdminDTO();
		
		adminDTO.setAdminId(admin.getAdminId());

	
		adminDTO.setLevel(admin.getLevel());

	

		
		return adminDTO;
	}

	public ResultDTO updateAdmin(AdminDTO adminDTO, RequestDTO requestDTO) {
		
		Admin admin = adminDao.getById(adminDTO.getAdminId());

		admin.setAdminId(ControllerUtils.setValue(admin.getAdminId(), adminDTO.getAdminId()));

		admin.setLevel(ControllerUtils.setValue(admin.getLevel(), adminDTO.getLevel()));



        admin = adminDao.save(admin);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public AdminDTO getAdminDTOById(Integer adminId) {
	
		Admin admin = adminDao.getById(adminId);
			
		
		AdminConvertCriteriaDTO convertCriteria = new AdminConvertCriteriaDTO();
		return(this.convertAdminToAdminDTO(admin,convertCriteria));
	}







}
