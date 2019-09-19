package com.bsnc.rest.model;

public class CommonResponseBean implements ICommonResponseBean{
	private final long id;
	private final int code;
	private final String message;
	
	public CommonResponseBean(long id) {
		this.id = id;
		this.code = 0;
		this.message = null;
	}
	
	public CommonResponseBean(long id, int code, String message) {
		this.id = id;
		this.code = code;
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	
	public long getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
