package com.te.ems.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private T data;

	public GeneralResponse(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

}
