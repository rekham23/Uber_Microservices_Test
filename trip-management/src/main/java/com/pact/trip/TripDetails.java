package com.pact.trip;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TripDetails {

   //private final long id;
    /*private final String name;
	private final String phoneno;
	private final String location;*/
	
	private String tolocation;
	private String fromlocation;
	private String timetoreachdestination;
	private String ShortestRouteToDestination;
	//private String estimatedTime;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date tripdate;
	private String tripStartTime;
	private String tripEndTime;
	private String vehicleno;
	private String vehiclemodel;
	private String drivername;
	private String passengername;
	private String fareamount;
	private String otp;
	private String tripDate;
	private String tripCancelDate; 
	 private String tripDateString;
	 private String tripTurn; 
	 private String tripCompletionTime; 
	   public String getTripDateString() {
		   if(tripdate!=null)
		   tripDateString = new SimpleDateFormat("dd/MM/yyyy").format(tripdate);
		   return tripDateString;
	}

	public void setTripDateString(String tripDateString) {
		this.tripDateString = tripDateString;
	}
	
	
	
	public TripDetails(){
		   
	   }

	public TripDetails(String tripCancelDate) {	
        //this.id = id;
        this.tripCancelDate = tripCancelDate;
		//this.fromlocation = fromlocation;
		//this.location = location;
    } 
	public TripDetails(String tripDate, String tripTurn,  String fareamount) {	

		this.tripDate = tripDate;
		this.tripTurn = tripTurn;
		this.fareamount = fareamount;
    } 
    public TripDetails(String tolocation,String fromlocation,String tripDate, String tripStartTime,  String tripEndTime, String drivername, String passengername, String fareamount) {	
        this.tripStartTime = tripStartTime;
        this.tripEndTime = tripEndTime;
        this.tolocation = tolocation;
		this.fromlocation = fromlocation;
		this.tripDate = tripDate;
		this.drivername = drivername;
		this.passengername = passengername;
		this.fareamount = fareamount;
		
    }
    
    
	 public TripDetails(String tolocation,String fromlocation) {	
	        //this.id = id;
	        this.tolocation = tolocation;
			this.fromlocation = fromlocation;
			//this.location = location;
	    }
	 public TripDetails(String fromlocation, String tolocation,  String fareamount, String tripCompletionTime) {	

			this.fromlocation = fromlocation;
			this.tolocation = tolocation;
			this.fareamount = fareamount;
			this.tripCompletionTime = tripCompletionTime;
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
	}*/


	public String getTimetoreachdestination() {
		return timetoreachdestination;
	}


	public String getShortestRouteToDestination() {
		return ShortestRouteToDestination;
	}

	/*public Date getTripdate() {
		return tripdate;
	}

	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}
*/
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}

	public void setTimetoreachdestination(String timetoreachdestination) {
		this.timetoreachdestination = timetoreachdestination;
	}

	public void setShortestRouteToDestination(String shortestRouteToDestination) {
		ShortestRouteToDestination = shortestRouteToDestination;
	}

	/*public String getTriptime() {
		return triptime;
	}

	public void setTriptime(String triptime) {
		this.triptime = triptime;
	}*/

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}


	
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getTripdate() {
		return tripdate;
	}

	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}

	public String getTripStartTime() {
		return tripStartTime;
	}

	public void setTripStartTime(String tripStartTime) {
		this.tripStartTime = tripStartTime;
	}

	public String getTripEndTime() {
		return tripEndTime;
	}

	public void setTripEndTime(String tripEndTime) {
		this.tripEndTime = tripEndTime;
	}

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getFareamount() {
		return fareamount;
	}

	public void setFareamount(String fareamount) {
		this.fareamount = fareamount;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public String getTripCancelDate() {
		return tripCancelDate;
	}

	public void setTripCancelDate(String tripCancelDate) {
		this.tripCancelDate = tripCancelDate;
	}

	public String getTripTurn() {
		return tripTurn;
	}

	public void setTripTurn(String tripTurn) {
		this.tripTurn = tripTurn;
	}

	public String getTripCompletionTime() {
		return tripCompletionTime;
	}

	public void setTripCompletionTime(String tripCompletionTime) {
		this.tripCompletionTime = tripCompletionTime;
	}
	
	

    /*public long getId() {
        return id;
    }*/

    /*public String getName() {
        return name;
    }
	
	 public String getPhoneno() {
        return phoneno;
    }
	
	 public String getLocation() {
        return location;
    }*/
    
    
	
}
