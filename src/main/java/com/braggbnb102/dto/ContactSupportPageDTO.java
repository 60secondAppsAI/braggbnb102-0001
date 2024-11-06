package com.braggbnb102.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactSupportPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<ContactSupportDTO> contactSupports;
}





