package com.example.bookingorder.model;

public class MailRequest {
	
	private String to="aanchalmishrag@gmail.com";
	private String from;

	public String getTo() {
		return to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public MailRequest(String to, String from) {
		super();
		this.to = to;
		this.from = from;
	}
	public MailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
