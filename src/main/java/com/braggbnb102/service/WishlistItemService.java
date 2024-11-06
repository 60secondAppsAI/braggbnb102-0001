package com.braggbnb102.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb102.domain.WishlistItem;
import com.braggbnb102.dto.WishlistItemDTO;
import com.braggbnb102.dto.WishlistItemSearchDTO;
import com.braggbnb102.dto.WishlistItemPageDTO;
import com.braggbnb102.dto.WishlistItemConvertCriteriaDTO;
import com.braggbnb102.service.GenericService;
import com.braggbnb102.dto.common.RequestDTO;
import com.braggbnb102.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface WishlistItemService extends GenericService<WishlistItem, Integer> {

	List<WishlistItem> findAll();

	ResultDTO addWishlistItem(WishlistItemDTO wishlistItemDTO, RequestDTO requestDTO);

	ResultDTO updateWishlistItem(WishlistItemDTO wishlistItemDTO, RequestDTO requestDTO);

    Page<WishlistItem> getAllWishlistItems(Pageable pageable);

    Page<WishlistItem> getAllWishlistItems(Specification<WishlistItem> spec, Pageable pageable);

	ResponseEntity<WishlistItemPageDTO> getWishlistItems(WishlistItemSearchDTO wishlistItemSearchDTO);
	
	List<WishlistItemDTO> convertWishlistItemsToWishlistItemDTOs(List<WishlistItem> wishlistItems, WishlistItemConvertCriteriaDTO convertCriteria);

	WishlistItemDTO getWishlistItemDTOById(Integer wishlistItemId);







}





