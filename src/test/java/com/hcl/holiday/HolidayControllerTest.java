package com.hcl.holiday;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.holiday.collection.HolidayController;
import com.hcl.holiday.service.impl.HolidayServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HolidayControllerTest {

	@Mock
	private HolidayServiceImpl holidayServiceImpl;
	
	@InjectMocks
	private HolidayController holidayController;
	
	private List<LocalDate> localDates = new ArrayList<>();
	private List<String> myDays  = new ArrayList<>();
	
	@Before
	public void setUp() {
		localDates.add(LocalDate.now().plusDays(1));
		localDates.add(LocalDate.now().plusDays(3));
		
		myDays.add("2019-09-21");
		myDays.add("2019-09-22");
		myDays.add("2019-09-23");
		myDays.add("2019-09-24");
		myDays.add("2019-09-25");
	}
	
	@Test
	public void holidaysTest() {
		Mockito.when(holidayServiceImpl.holidays(myDays)).thenReturn(localDates);
		ResponseEntity<List<LocalDate>> actualReslut = holidayController.holidays(myDays);
		
		assertEquals(LocalDate.now().plusDays(3), actualReslut.getBody().get(1));
	}
}
