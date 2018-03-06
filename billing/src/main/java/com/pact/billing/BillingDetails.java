package com.pact.billing;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BillingDetails {
	
	   private String passengerphoneno;
	   private String driverphoneno;
	   private String tolocation;
	   private String fromlocation;
	   private String passengername;
	   private String drivername;
	   private Boolean incentiveBool;
	   private String fareamount;
	   @JsonFormat(pattern="dd/MM/yyyy")
	   private Date tripDate;
	   private String tripDateString;
	   private String tripdate;
	   private String promoinpercentage;
	   private String distance;
	   private String promofare;
	   private String tripTurn;
	   private String isHoliday;
	   private String dayHoliday;
	   private String isSingleSeat;
	   private String isDoubleSeat; 
	   public BillingDetails(){
		   
	   }
	   public BillingDetails(String promoinpercentage, String distance, String promofare) {	

			this.promoinpercentage = promoinpercentage;
			this.distance = distance;
			this.promofare = promofare;
	    }
	   public BillingDetails(String promofare) {	

			this.promofare = promofare;


	    } 
	   
	  // public BillingDetails(String tripdate, String tripTurn) {	

		//	this.tripdate = tripdate;
	//		this.tripTurn = tripTurn;
	 //   }

	   public BillingDetails(String isHoliday, String dayHoliday, String promoinpercentage, String promofare) {	

			this.isHoliday = isHoliday;
			this.dayHoliday = dayHoliday;
			this.promoinpercentage = promoinpercentage;
			this.promofare = promofare;
	    }

	   public BillingDetails(String isSingleSeat, String isDoubleSeat, String promoinpercentage, String promofare, String tripdate) {	

			this.isSingleSeat = isSingleSeat;
			this.promoinpercentage = promoinpercentage;
			this.promofare = promofare;
			this.isDoubleSeat = isDoubleSeat;
			this.tripdate = tripdate;
	    }

	   public BillingDetails(String tripdate, String fareamount) {	

			this.tripdate = tripdate;
			this.fareamount = fareamount;
	    } 
	   
	   public BillingDetails(String tripdate, String fareamount,String passengername, String passengerphoneno, String drivername,String driverphoneno ) {	
	       
			this.tripdate = tripdate;
			this.fareamount = fareamount;
			this.passengername = passengername;
			this.passengerphoneno = passengerphoneno;
			this.drivername  = drivername;
			this.driverphoneno = driverphoneno;
			
			
	    }
	   
	   public String getTripDateString() {
		   if(tripDate!=null)
		   tripDateString = new SimpleDateFormat("dd/MM/yyyy").format(tripDate);
		   return tripDateString;
	}

	public void setTripDateString(String tripDateString) {
		this.tripDateString = tripDateString;
	}

	public String getPassengerphoneno() {
		return passengerphoneno;
	}

	public void setPassengerphoneno(String passengerphoneno) {
		this.passengerphoneno = passengerphoneno;
	}

	public String getTolocation() {
		return tolocation;
	}

	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	public String getFromlocation() {
		return fromlocation;
	}

	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public Boolean getIncentiveBool() {
		return incentiveBool;
	}

	public void setIncentiveBool(Boolean incentiveBool) {
		this.incentiveBool = incentiveBool;
	}

	public String getFareamount() {
		return fareamount;
	}

	public void setFareamount(String fareamount) {
		this.fareamount = fareamount;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public String getDriverphoneno() {
		return driverphoneno;
	}

	public void setDriverphoneno(String driverphoneno) {
		this.driverphoneno = driverphoneno;
	}

	public String getTripdate() {
		return tripdate;
	}

	public void setTripdate(String tripdate) {
		this.tripdate = tripdate;
	}

	public String getPromoinpercentage() {
		return promoinpercentage;
	}

	public void setPromoinpercentage(String promoinpercentage) {
		this.promoinpercentage = promoinpercentage;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPromofare() {
		return promofare;
	}

	public void setPromofare(String promofare) {
		this.promofare = promofare;
	}

	public String getTripTurn() {
		return tripTurn;
	}

	public void setTripTurn(String tripTurn) {
		this.tripTurn = tripTurn;
	}

	public String getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}

	public String getDayHoliday() {
		return dayHoliday;
	}

	public void setDayHoliday(String dayHoliday) {
		this.dayHoliday = dayHoliday;
	}

	public String getIsSingleSeat() {
		return isSingleSeat;
	}

	public void setIsSingleSeat(String isSingleSeat) {
		this.isSingleSeat = isSingleSeat;
	}

	public String getIsDoubleSeat() {
		return isDoubleSeat;
	}

	public void setIsDoubleSeat(String isDoubleSeat) {
		this.isDoubleSeat = isDoubleSeat;
	}
	
	

}
