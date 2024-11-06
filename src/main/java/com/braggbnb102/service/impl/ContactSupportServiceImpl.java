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
import com.braggbnb102.dao.ContactSupportDAO;
import com.braggbnb102.domain.ContactSupport;
import com.braggbnb102.dto.ContactSupportDTO;
import com.braggbnb102.dto.ContactSupportSearchDTO;
import com.braggbnb102.dto.ContactSupportPageDTO;
import com.braggbnb102.dto.ContactSupportConvertCriteriaDTO;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import com.braggbnb102.service.ContactSupportService;
import com.braggbnb102.util.ControllerUtils;





@Service
public class ContactSupportServiceImpl extends GenericServiceImpl<ContactSupport, Integer> implements ContactSupportService {

    private final static Logger logger = LoggerFactory.getLogger(ContactSupportServiceImpl.class);

	@Autowired
	ContactSupportDAO contactSupportDao;

	


	@Override
	public GenericDAO<ContactSupport, Integer> getDAO() {
		return (GenericDAO<ContactSupport, Integer>) contactSupportDao;
	}
	
	public List<ContactSupport> findAll () {
		List<ContactSupport> contactSupports = contactSupportDao.findAll();
		
		return contactSupports;	
		
	}

	public ResultDTO addContactSupport(ContactSupportDTO contactSupportDTO, RequestDTO requestDTO) {

		ContactSupport contactSupport = new ContactSupport();

		contactSupport.setContactSupportId(contactSupportDTO.getContactSupportId());


		contactSupport.setIssueDescription(contactSupportDTO.getIssueDescription());


		contactSupport.setSubmittedDate(contactSupportDTO.getSubmittedDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		contactSupport = contactSupportDao.save(contactSupport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<ContactSupport> getAllContactSupports(Pageable pageable) {
		return contactSupportDao.findAll(pageable);
	}

	public Page<ContactSupport> getAllContactSupports(Specification<ContactSupport> spec, Pageable pageable) {
		return contactSupportDao.findAll(spec, pageable);
	}

	public ResponseEntity<ContactSupportPageDTO> getContactSupports(ContactSupportSearchDTO contactSupportSearchDTO) {
	
			Integer contactSupportId = contactSupportSearchDTO.getContactSupportId(); 
 			String issueDescription = contactSupportSearchDTO.getIssueDescription(); 
   			String sortBy = contactSupportSearchDTO.getSortBy();
			String sortOrder = contactSupportSearchDTO.getSortOrder();
			String searchQuery = contactSupportSearchDTO.getSearchQuery();
			Integer page = contactSupportSearchDTO.getPage();
			Integer size = contactSupportSearchDTO.getSize();

	        Specification<ContactSupport> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, contactSupportId, "contactSupportId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, issueDescription, "issueDescription"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("issueDescription")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<ContactSupport> contactSupports = this.getAllContactSupports(spec, pageable);
		
		//System.out.println(String.valueOf(contactSupports.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(contactSupports.getTotalPages()));
		
		List<ContactSupport> contactSupportsList = contactSupports.getContent();
		
		ContactSupportConvertCriteriaDTO convertCriteria = new ContactSupportConvertCriteriaDTO();
		List<ContactSupportDTO> contactSupportDTOs = this.convertContactSupportsToContactSupportDTOs(contactSupportsList,convertCriteria);
		
		ContactSupportPageDTO contactSupportPageDTO = new ContactSupportPageDTO();
		contactSupportPageDTO.setContactSupports(contactSupportDTOs);
		contactSupportPageDTO.setTotalElements(contactSupports.getTotalElements());
		return ResponseEntity.ok(contactSupportPageDTO);
	}

	public List<ContactSupportDTO> convertContactSupportsToContactSupportDTOs(List<ContactSupport> contactSupports, ContactSupportConvertCriteriaDTO convertCriteria) {
		
		List<ContactSupportDTO> contactSupportDTOs = new ArrayList<ContactSupportDTO>();
		
		for (ContactSupport contactSupport : contactSupports) {
			contactSupportDTOs.add(convertContactSupportToContactSupportDTO(contactSupport,convertCriteria));
		}
		
		return contactSupportDTOs;

	}
	
	public ContactSupportDTO convertContactSupportToContactSupportDTO(ContactSupport contactSupport, ContactSupportConvertCriteriaDTO convertCriteria) {
		
		ContactSupportDTO contactSupportDTO = new ContactSupportDTO();
		
		contactSupportDTO.setContactSupportId(contactSupport.getContactSupportId());

	
		contactSupportDTO.setIssueDescription(contactSupport.getIssueDescription());

	
		contactSupportDTO.setSubmittedDate(contactSupport.getSubmittedDate());

	

		
		return contactSupportDTO;
	}

	public ResultDTO updateContactSupport(ContactSupportDTO contactSupportDTO, RequestDTO requestDTO) {
		
		ContactSupport contactSupport = contactSupportDao.getById(contactSupportDTO.getContactSupportId());

		contactSupport.setContactSupportId(ControllerUtils.setValue(contactSupport.getContactSupportId(), contactSupportDTO.getContactSupportId()));

		contactSupport.setIssueDescription(ControllerUtils.setValue(contactSupport.getIssueDescription(), contactSupportDTO.getIssueDescription()));

		contactSupport.setSubmittedDate(ControllerUtils.setValue(contactSupport.getSubmittedDate(), contactSupportDTO.getSubmittedDate()));



        contactSupport = contactSupportDao.save(contactSupport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ContactSupportDTO getContactSupportDTOById(Integer contactSupportId) {
	
		ContactSupport contactSupport = contactSupportDao.getById(contactSupportId);
			
		
		ContactSupportConvertCriteriaDTO convertCriteria = new ContactSupportConvertCriteriaDTO();
		return(this.convertContactSupportToContactSupportDTO(contactSupport,convertCriteria));
	}







}
