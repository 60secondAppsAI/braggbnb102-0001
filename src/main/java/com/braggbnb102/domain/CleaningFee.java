package com.braggbnb102.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="cleaning_fees")
@Getter @Setter @NoArgsConstructor
public class CleaningFee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="cleaning_fee_id")
	private Integer cleaningFeeId;
    
  	@Column(name="amount")
	private Double amount;
    
	




}
