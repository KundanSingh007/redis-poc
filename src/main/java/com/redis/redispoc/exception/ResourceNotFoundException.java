package com.redis.redispoc.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	String fieldValue;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resourceName, String fieldName, String Id) {
		super(String.format("%s Not found with %s : %s" + Id, resourceName, fieldName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = Id;
	}

}