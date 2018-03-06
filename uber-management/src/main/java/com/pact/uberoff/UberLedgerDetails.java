package com.pact.uberoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UberLedgerDetails {

	private String totalEarningPerDay;
	private String award;
	private String overallRating;
	private String dateTotalEarningPerDay;
	private String tripsCompletedPerDay;
	private String awardDate;
	private String driverName;
	private String driverNo;
	private String incentiveAmount;


	 public UberLedgerDetails(){

	   }

	 public UberLedgerDetails(String overallRating){

		 this.overallRating = overallRating;

	   }

	 public UberLedgerDetails(String award, String awardDate){

		 this.award = award;
		 this.awardDate = awardDate;

	   }

	 public UberLedgerDetails(String totalEarningPerDay, String dateTotalEarningPerDay, String tripsCompletedPerDay){

		 this.totalEarningPerDay = totalEarningPerDay;
		 this.dateTotalEarningPerDay = dateTotalEarningPerDay;
		 this.tripsCompletedPerDay = tripsCompletedPerDay;

	   }


	 public UberLedgerDetails(String driverName, String driverNo, String incentiveAmount, String totalEarningPerDay, String award, String overallRating, String dateTotalEarningPerDay, String tripsCompletedPerDay){

		 this.driverName = driverName;
		 this.driverNo = driverNo;
		 this.incentiveAmount = incentiveAmount;
		 this.totalEarningPerDay = totalEarningPerDay;
		 this.award = award;
		 this.overallRating = overallRating;
		 this.dateTotalEarningPerDay = dateTotalEarningPerDay;
		 this.tripsCompletedPerDay = tripsCompletedPerDay;

	   }


	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}

	public String getTotalEarningPerDay() {
		return totalEarningPerDay;
	}

	public void setTotalEarningPerDay(String totalEarningPerDay) {
		this.totalEarningPerDay = totalEarningPerDay;
	}

	public String getDateTotalEarningPerDay() {
		return dateTotalEarningPerDay;
	}

	public void setDateTotalEarningPerDay(String dateTotalEarningPerDay) {
		this.dateTotalEarningPerDay = dateTotalEarningPerDay;
	}

	public String getTripsCompletedPerDay() {
		return tripsCompletedPerDay;
	}

	public void setTripsCompletedPerDay(String tripsCompletedPerDay) {
		this.tripsCompletedPerDay = tripsCompletedPerDay;
	}

	public String getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(String awardDate) {
		this.awardDate = awardDate;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public String getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(String incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}




}
 