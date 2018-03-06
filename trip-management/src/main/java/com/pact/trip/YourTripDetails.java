package com.pact.trip;

import java.util.Date;

public class YourTripDetails {
		
	private String tolocation;
	private String fromlocation;
	private Date tripdate;
	private String triptime;
	private String vehiclename;
	private double cash;
	private String ratings;
	private String drivername;
	
	
	
	public YourTripDetails(){
		   
	   }

    public YourTripDetails(String tolocation,String fromlocation, String timetoreachdestination, String ShortestRouteToDestination, String estimatedTime, Date tripdate) {	
        //this.id = id;
        this.tolocation = tolocation;
		this.fromlocation = fromlocation;
		//this.location = location;
    }
    
    
	public String getTolocation() {
		return tolocation;
	}

	public String getFromlocation() {
		return fromlocation;
	}


	/*public String getEstimatedTime() {
		return estimatedTime;
	}


	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}


	public String getTimetoreachdestination() {
		return timetoreachdestination;
	}


	public String getShortestRouteToDestination() {
		return ShortestRouteToDestination;
	}
*/
	public Date getTripdate() {
		return tripdate;
	}

	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}

	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}

	/*public void setTimetoreachdestination(String timetoreachdestination) {
		this.timetoreachdestination = timetoreachdestination;
	}

	public void setShortestRouteToDestination(String shortestRouteToDestination) {
		ShortestRouteToDestination = shortestRouteToDestination;
	}*/

	public String getTriptime() {
		return triptime;
	}

	public void setTriptime(String triptime) {
		this.triptime = triptime;
	}

	/*public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}*/

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	/*public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}*/
	
	
	
	
}
