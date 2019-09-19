package com.hcl.holiday.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class HolidayDto {

	private Integer holidaysId;
	private LocalDate holidayDate;
	private String remarks;
}
