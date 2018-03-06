package com.pact.billing;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class BillingDetailApplication {
	
	final static Logger log = Logger.getLogger(BillingDetailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BillingDetailApplication.class, args);

	}
	
	@Autowired
    BillingPort billingPort;
	
	@RequestMapping(value="/trip-details")
    public String getTripDetail() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getTripDetail()...."+billingPort.getTripDetails());
		System.out.println("BillingDetailApplication getTripDetail()...."+billingPort.getTripDetails());
		return billingPort.getTripDetails();
    }
	
	@RequestMapping(value = "/billing-details/passenger", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getBillDetailPassenger() {
		log.info("In getBillDetailPassenger()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("02/03/2018", "205.67"),  HttpStatus.OK);
    	
    }
	
	@RequestMapping(value = "/billing-details/driver", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getBillDetailDriver() {
		log.info("In getBillDetailDriver()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("02/03/2018", "205.67"),  HttpStatus.OK);
    	
    }
	
	@RequestMapping(value = "/billing-details/uberledger", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getBillDetailUber() {
		log.info("In getBillDetailUber()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("02/03/2018", "205.67", "Sagar Sharma", "9999922245", "Mohan Kumar", "8023456124"),  HttpStatus.OK);
    	
    }
	@RequestMapping(value = "/billing-details/promo", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getPromoDetailPassenger() {
		log.info("In getPromoDetailPassenger()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("10%", "10 KM","Rs.99/-"),  HttpStatus.OK);

    }

	//@RequestMapping(value = "/billing-details/futurebookingpromo", method = RequestMethod.GET)
    //public ResponseEntity<BillingDetails> getFutureBookingDetailPassenger() {
	//	log.info("In getFutureBookingDetailPassenger()....");
    //	return new ResponseEntity<BillingDetails>(new BillingDetails("02/03/2018", "2nd"),  HttpStatus.OK);

    //}

	@RequestMapping(value = "/billing-details/holidaypromo", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getHolidayPromoPassenger() {
		log.info("In getHolidayPromoPassenger()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("Yes", "Holi", "5%", "Rs. 10/-"),  HttpStatus.OK);

    }

	@RequestMapping(value = "/billing-details/cabsharingpromo", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getCabSharingPromoPassenger() {
		log.info("In getCabSharingPromoPassenger()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("Yes", "No", "5%", "Rs. 10/-", "02/03/2018"),  HttpStatus.OK);

    }

	@RequestMapping(value = "/billing-details/peakhourdetails", method = RequestMethod.GET)
    public ResponseEntity<BillingDetails> getPeackHourBillDetails() {
		log.info("In getPeackHourBillDetails()....");
    	return new ResponseEntity<BillingDetails>(new BillingDetails("One third of Actual Fare"),  HttpStatus.OK);

    } 
	@RequestMapping(value = "/billing-details/gettripfareamount", method = RequestMethod.GET)
    public ResponseEntity<DriverBillingDetails> getTripFareamount() {
		log.info("In getTripFareamount()....");
		return new ResponseEntity<DriverBillingDetails>(new DriverBillingDetails("Sagar Sharma", "02/03/2018", "Rs.156/-"),  HttpStatus.OK);

	}	

	@RequestMapping(value = "/billing-details/incentiveoftheday", method = RequestMethod.GET)
    public ResponseEntity<DriverBillingDetails> getIncentiveDay() {
		log.info("In getIncentiveDay()....");
    	return new ResponseEntity<DriverBillingDetails>(new DriverBillingDetails("Yes","Rs.500/-"),  HttpStatus.OK);

    }

	@RequestMapping(value = "/billing-details/incentiveofthemonth", method = RequestMethod.GET)
    public ResponseEntity<DriverBillingDetails> getIncentiveMonth() {
		log.info("In getIncentiveMonth()....");
    	return new ResponseEntity<DriverBillingDetails>(new DriverBillingDetails("Rs.5000/-"),  HttpStatus.OK);

    } 
	@RequestMapping(value="/uber-ledger/totalearningperday")
    public String getEarningsPerDay() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getEarningsPerDay()...."+billingPort.getEarningsPerDay());
		System.out.println("BillingDetailApplication getEarningsPerDay()...."+billingPort.getEarningsPerDay());
		return billingPort.getEarningsPerDay();
    }

	@RequestMapping(value="/passenger-details/paymentoption")
    public String getPassengerPaymentOption() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getPassengerPaymentOption()...."+billingPort.getPassengerPaymentOption());
		System.out.println("BillingDetailApplication getPassengerPaymentOption()...."+billingPort.getPassengerPaymentOption());
		return billingPort.getPassengerPaymentOption();
    }

	@RequestMapping(value="/uber-ledger/overallrating")
    public String getOverallRating() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getOverallRating()...."+billingPort.getOverallRating());
		System.out.println("BillingrDetailApplication getOverallRating()...."+billingPort.getOverallRating());
		return billingPort.getOverallRating();
    }

	@RequestMapping(value="/trip-details/tripdetails")
	public String getTripDetailPassenger() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getTripDetailPassenger()...."+billingPort.getTripDetailPassenger());
		System.out.println("BillingrDetailApplication getTripDetailPassenger()...."+billingPort.getTripDetailPassenger());
		return billingPort.getTripDetailPassenger();
	}

	@RequestMapping(value="/passenger-details/passengerinfo")
	public String getPassengerInfo() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getPassengerInfo()...."+billingPort.getPassengerInfo());
		System.out.println("BillingrDetailApplication getPassengerInfo()...."+billingPort.getPassengerInfo());
		return billingPort.getPassengerInfo();
	}


	@RequestMapping(value="/driver-details/driver")
	public String getDriverDetail() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getDriverDetail()...."+billingPort.getDriverDetail());
		System.out.println("BillingrDetailApplication getDriverDetail()...."+billingPort.getDriverDetail());
		return billingPort.getDriverDetail();
	}

	@RequestMapping(value="/uber-ledger/award")
    public String getAward() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getAward()...."+billingPort.getAward());
		System.out.println("BillingrDetailApplication getAward()...."+billingPort.getAward());
		return billingPort.getAward();
    }


	@RequestMapping(value="/trip-details/futurebookingpromo")
	public String getFutureBookingDetailPassenger() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getFutureBookingDetailPassenger()...."+billingPort.getFutureBookingDetailPassenger());
		System.out.println("BillingrDetailApplication getPromoDetailPassenger()...."+billingPort.getFutureBookingDetailPassenger());
		return billingPort.getFutureBookingDetailPassenger();
	}

	@RequestMapping(value="/trip-details/cancelbooking")
	public String getCancelBookingDetails() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getCancelBookingDetails()...."+billingPort.getCancelBookingDetails());
		System.out.println("BillingrDetailApplication getCancelBookingDetails()...."+billingPort.getCancelBookingDetails());
		return billingPort.getCancelBookingDetails();
	}

	@RequestMapping(value="/uber-ledger/ledger")
	public String getUberLedger() throws RestClientException, IOException {
		log.debug("BillingrDetailApplication getCancelBookingDetails()...."+billingPort.getUberLedger());
		System.out.println("BillingrDetailApplication getCancelBookingDetails()...."+billingPort.getUberLedger());
		return billingPort.getUberLedger();
	}
 
}
