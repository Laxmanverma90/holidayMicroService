package com.hcl.holiday;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.holiday.repository.HolidayRepository;
import com.hcl.holiday.service.impl.HolidayServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HolidayServiceTest {

	@Mock
	private HolidayRepository holidayRepository;
	
	@InjectMocks
	private HolidayServiceImpl holidayServiceImpl;
	
	private static final String DATE_FORMATE = "yyyy-MM-dd";
	
	private List<LocalDate> localDates = new ArrayList<>();
	private List<String> myDays  = new ArrayList<>();
	Optional<List<LocalDate>> holidays =null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATE);
	
	@Before
	public void setUp() {
		localDates.add(LocalDate.now().plusDays(1));
		localDates.add(LocalDate.now().plusDays(3));
		
		myDays.add("2019-09-21");
		myDays.add("2019-09-22");
		myDays.add("2019-09-23");
		myDays.add("2019-09-24");
		myDays.add("2019-09-25");
		
		holidays = Optional.of(localDates);
	}
	
	@Test
	public void holidaysTest() {
		Mockito.when(holidayRepository.findHolidayDateIn(Mockito.anyList())).thenReturn(holidays);
		List<LocalDate> actualResult = holidayServiceImpl.holidays(myDays);
		assertEquals(LocalDate.now().plusDays(1), actualResult.get(0));
	}
}
