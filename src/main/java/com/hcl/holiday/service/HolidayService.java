package com.hcl.holiday.service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Laxman
 * @date 19 SEPT 2019
 */
public interface HolidayService {

	/**
	 * @param myDays
	 * @return
	 */
	List<LocalDate> holidays(List<String> myDays);

}
