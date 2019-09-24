package com.hcl.holiday.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.holiday.repository.HolidayRepository;
import com.hcl.holiday.service.HolidayService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Laxman
 * @date 19 SEPT 2019
 */
@Slf4j
@Service
public class HolidayServiceImpl implements HolidayService {

	private static final String DATE_FORMATE = "yyyy-MM-dd";

	@Autowired
	private HolidayRepository holidayRepository;

	/**
	 * @author Laxman
	 * @date 19 SEPT 2019
	 * 
	 *       This method is using for getting Holiday list if any exist between
	 *       them.
	 */
	@Override
	public List<LocalDate> holidays(List<String> myDays) {

		log.info(" :: holidays --- START ----");

		List<LocalDate> holidayDates = new ArrayList<>();
		List<LocalDate> localDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATE);

		myDays.stream().forEach(myDate -> localDates.add(LocalDate.parse(myDate, formatter)));
		Optional<List<LocalDate>> holidays = holidayRepository.findHolidayDateIn(localDates);

		if (holidays.isPresent()) {
			holidayDates = holidays.get();
		}

		log.info(" :: holidays --- END ----");
		return holidayDates;
	}

}
