package com.hcl.holiday.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.holiday.entity.Holiday;

/**
 * @author Laxman
 * @date 20 SEPT 2019
 *
 */
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

	/**
	 * @param myDays
	 * @return
	 */
	@Query("SELECT holidayDate FROM Holiday WHERE holidayDate IN :myDays")
	Optional<List<LocalDate>> findHolidayDateIn(List<LocalDate> myDays);
}
