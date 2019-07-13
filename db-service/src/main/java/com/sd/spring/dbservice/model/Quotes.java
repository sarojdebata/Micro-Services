package com.sd.spring.dbservice.model;

import java.util.List;

public class Quotes {

	public Quotes(String userName,List<String> quotes) {
		this.userName=userName;
		this.quotes=quotes;
	}
	
	public Quotes() {}
	
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	private List<String> quotes;
	
}
