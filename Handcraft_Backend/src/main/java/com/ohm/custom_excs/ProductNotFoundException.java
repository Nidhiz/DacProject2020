package com.ohm.custom_excs;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
