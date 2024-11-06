package com.braggbnb102.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ListingDTO {

	private Integer listingId;

	private String title;

	private String description;

	private String location;

	private Double pricePerNight;






}
