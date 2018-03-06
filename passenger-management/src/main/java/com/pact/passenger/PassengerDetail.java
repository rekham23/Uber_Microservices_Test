package com.pact.passenger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PassengerDetail {
	
	private String passengerName;
	private String passenegerPhoneNo;
	private String pickUpLoc;
	private String paymentOption;
	private String fareAmount;
	public PassengerDetail(String passengerName, String passenegerPhoneNo, String pickUpLoc){
		
		this.passengerName = passengerName;
		this.passenegerPhoneNo = passenegerPhoneNo;
		this.pickUpLoc = pickUpLoc;
		
		
	}
	public PassengerDetail(String paymentOption, String fareAmount){

		this.paymentOption = paymentOption;
		this.fareAmount = fareAmount;

	} 
public PassengerDetail(){
		
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassenegerPhoneNo() {
		return passenegerPhoneNo;
	}

	public void setPassenegrPhoneNo(String passenegerPhoneNo) {
		this.passenegerPhoneNo = passenegerPhoneNo;
	}

	public String getPickUpLoc() {
		return pickUpLoc;
	}

	public void setPickUpLoc(String pickUpLoc) {
		this.pickUpLoc = pickUpLoc;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getFareAmount() {
		return fareAmount;
	}
	public void setFareAmount(String fareAmount) {
		this.fareAmount = fareAmount;
	}
	public void setPassenegerPhoneNo(String passenegerPhoneNo) {
		this.passenegerPhoneNo = passenegerPhoneNo;
	}


}
