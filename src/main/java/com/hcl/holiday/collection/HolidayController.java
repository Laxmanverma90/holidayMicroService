package com.hcl.holiday.collection;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.holiday.service.HolidayService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Laxman
 * @date 19 SEPT 2019
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class HolidayController {

	@Autowired
	private HolidayService holidayService;
	
	/**
	 * @param myDays
	 * @return List<LocalDate>
	 */
	@GetMapping("/holidays")
	public ResponseEntity<List<LocalDate>> holidays(@RequestParam List<String> myDays){
		
		log.info("HolidayController :: holidays --- ");
		return new ResponseEntity<>(holidayService.holidays(myDays),HttpStatus.OK);
	}
}
