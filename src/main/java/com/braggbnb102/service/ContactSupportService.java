package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.ContactSupport;
import com.braggbnb102.dto.ContactSupportDTO;
import com.braggbnb102.dto.ContactSupportSearchDTO;
import com.braggbnb102.dto.ContactSupportPageDTO;
import com.braggbnb102.dto.ContactSupportConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ContactSupportService extends GenericService<ContactSupport, Integer> {

	List<ContactSupport> findAll();

	ResultDTO addContactSupport(ContactSupportDTO contactSupportDTO, RequestDTO requestDTO);

	ResultDTO updateContactSupport(ContactSupportDTO contactSupportDTO, RequestDTO requestDTO);

    Page<ContactSupport> getAllContactSupports(Pageable pageable);

    Page<ContactSupport> getAllContactSupports(Specification<ContactSupport> spec, Pageable pageable);

	ResponseEntity<ContactSupportPageDTO> getContactSupports(ContactSupportSearchDTO contactSupportSearchDTO);
	
	List<ContactSupportDTO> convertContactSupportsToContactSupportDTOs(List<ContactSupport> contactSupports, ContactSupportConvertCriteriaDTO convertCriteria);

	ContactSupportDTO getContactSupportDTOById(Integer contactSupportId);







}





