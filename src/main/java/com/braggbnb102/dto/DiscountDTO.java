package com.braggbnb102.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DiscountDTO {

	private Integer discountId;

	private Double percentage;

	private Date validFromDate;

	private Date validToDate;






}