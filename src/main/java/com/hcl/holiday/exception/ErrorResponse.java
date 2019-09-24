package com.hcl.holiday.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 * @date 19 SEPT 2019
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private String message;
	private String status;
}
