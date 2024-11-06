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
@Table(name="contact_supports")
@Getter @Setter @NoArgsConstructor
public class ContactSupport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="contact_support_id")
	private Integer contactSupportId;
    
  	@Column(name="issue_description")
	private String issueDescription;
    
  	@Column(name="submitted_date")
	private Date submittedDate;
    
	




}
