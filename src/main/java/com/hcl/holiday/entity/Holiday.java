package com.hcl.holiday.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 * @date 19 SEPT 2019
 */
@Getter
@Setter
@Entity
@Table
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer holidaysId;
	private LocalDate holidayDate;
	private LocalDate createdDate;
	private String remarks;
}

