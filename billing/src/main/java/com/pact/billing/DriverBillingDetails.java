package com.pact.billing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DriverBillingDetails {
	
	private String passengerName;
	@JsonFormat(pattern="dd/MM/yyyy")
	private String passengerTripDate;
	private String fareamount;
	
	private String incentiveOftheDay;
	private String incentiveAmount;
	
	private String incentiveOfTheMonth;
	
	
	
	public DriverBillingDetails(){
		
	}
	
	public DriverBillingDetails(String passengerName, String passengerTripDate, String fareamount){
		
		this.passengerName = passengerName;
		this.passengerTripDate = passengerTripDate;
		this.fareamount = fareamount;
		
	}

	public DriverBillingDetails(String incentiveOftheDay, String incentiveAmount){
	
	this.incentiveOftheDay = incentiveOftheDay;
	this.incentiveAmount = incentiveAmount;
	
	}
	
	public DriverBillingDetails(String incentiveOfTheMonth){
		
		this.incentiveOfTheMonth = incentiveOfTheMonth;
		
		}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerTripDate() {
		return passengerTripDate;
	}

	public void setPassengerTripDate(String passengerTripDate) {
		this.passengerTripDate = passengerTripDate;
	}

	public String getFareamount() {
		return fareamount;
	}

	public void setFareamount(String fareamount) {
		this.fareamount = fareamount;
	}

	public String getIncentiveOftheDay() {
		return incentiveOftheDay;
	}

	public void setIncentiveOftheDay(String incentiveOftheDay) {
		this.incentiveOftheDay = incentiveOftheDay;
	}

	public String getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(String incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	public String getIncentiveOfTheMonth() {
		return incentiveOfTheMonth;
	}

	public void setIncentiveOfTheMonth(String incentiveOfTheMonth) {
		this.incentiveOfTheMonth = incentiveOfTheMonth;
	}
	
	

}
