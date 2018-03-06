package com.pact.trip;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException; 

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class TripApplication {

	private final String tolocation="BTM";
	private final String fromlocation="DOMLUR";
	DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
	String dateString = dateFormat.format(new Date()).toString();
	String tripDate="02/03/2018";
	final static Logger log = Logger.getLogger(TripApplication.class);

	    public static void main(String[] args) {
	        SpringApplication.run(TripApplication.class, args);
	    }
	    @Autowired
		TripPort tripPort; 
	    @RequestMapping(value = "/trip-details", method = RequestMethod.GET)
	    public ResponseEntity<TripDetails> getTripDetails() {
	        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
			log.info("In getTripDetails()....");
			//log.debug("In getDriverDetail()"+getDriverDetail());
	    	return new ResponseEntity<TripDetails>(new TripDetails(tolocation,fromlocation,tripDate,"4 PM","6 PM","Mohan Kumar", "Sagar Sharma", "155.23"),  HttpStatus.OK);
	    	
	    }
	  
	    @RequestMapping(value = "/trip-details/booking", method = RequestMethod.GET)
	    public ResponseEntity<TripDetails> getBookingDetails() {
	        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
			log.info("In getTripDetails()....");
			//log.debug("In getDriverDetail()"+getDriverDetail());
	    	return new ResponseEntity<TripDetails>(new TripDetails(tolocation,fromlocation),  HttpStatus.OK);

	    }

	    @RequestMapping(value = "/trip-details/cancelbooking", method = RequestMethod.GET)
	    public ResponseEntity<TripDetails> getCancelBookingDetails() {
			log.info("In getCancelBookingDetails()....");
	    	return new ResponseEntity<TripDetails>(new TripDetails("02/03/2018"),  HttpStatus.OK);

	    } 
	    @RequestMapping(value = "/trip-details/futurebookingpromo", method = RequestMethod.GET)
	    public ResponseEntity<TripDetails> getFutureBookingDetailPassenger() {
			log.info("In getFutureBookingDetailPassenger()....");
	    	return new ResponseEntity<TripDetails>(new TripDetails("02/03/2018", "2nd", "145"),  HttpStatus.OK);

	    } 
	    @RequestMapping(value = "/trip-details/tripdetails", method = RequestMethod.GET)
	    public ResponseEntity<TripDetails> getTripDetailPassenger() {
			log.info("In getTripDetailPassenger()....");
	    	return new ResponseEntity<TripDetails>(new TripDetails("DOMLUR", "BTM", "145", "1 hr 15 mins"),  HttpStatus.OK);

	    } 
	    @RequestMapping(value="/passenger-details/passengerinfo")
		public String getPassengerInfo() throws RestClientException, IOException {
			log.debug("TripApplication getPassengerInfo()...."+tripPort.getPassengerInfo());
			System.out.println("TripApplication getPassengerInfo()...."+tripPort.getPassengerInfo());
			return tripPort.getPassengerInfo();
		}

		@RequestMapping(value="/passenger-details/paymentoption")
	    public String getPassengerPaymentOption() throws RestClientException, IOException {
			log.debug("TripApplication getPassengerPaymentOption()...."+tripPort.getPassengerPaymentOption());
			System.out.println("TripApplication getPassengerPaymentOption()...."+tripPort.getPassengerPaymentOption());
			return tripPort.getPassengerPaymentOption();
	    }

		@RequestMapping(value="/driver-details/driver")
		public String getDriverDetail() throws RestClientException, IOException {
			log.debug("TripApplication getDriverDetail()...."+tripPort.getDriverDetail());
			System.out.println("TripApplication getDriverDetail()...."+tripPort.getDriverDetail());
			return tripPort.getDriverDetail();
		}

		@RequestMapping(value="/uber-ledger/overallrating")
	    public String getOverallRating() throws RestClientException, IOException {
			log.debug("TripApplication getOverallRating()...."+tripPort.getOverallRating());
			System.out.println("TripApplication getOverallRating()...."+tripPort.getOverallRating());
			return tripPort.getOverallRating();
	    }

		@RequestMapping(value="/billing-details/cabsharingpromo")
		public String getCabSharingPromoPassenger() throws RestClientException, IOException {
			log.debug("TripApplication getCabSharingPromoPassenger()...."+tripPort.getCabSharingPromoPassenger());
			System.out.println("TripApplication getCabSharingPromoPassenger()...."+tripPort.getCabSharingPromoPassenger());
			return tripPort.getCabSharingPromoPassenger();
		}

		@RequestMapping(value="/billing-details/promo")
		public String getPromoDetailPassenger() throws RestClientException, IOException {
			log.debug("TripApplication getPromoDetailPassenger()...."+tripPort.getPromoDetailPassenger());
			System.out.println("TripApplication getPromoDetailPassenger()...."+tripPort.getPromoDetailPassenger());
			return tripPort.getPromoDetailPassenger();
		}


		@RequestMapping(value="/billing-details/peakhourdetails")
		public String getPeackHourBillDetails() throws RestClientException, IOException {
			log.debug("TripApplication getPeackHourBillDetails()...."+tripPort.getPeackHourBillDetails());
			System.out.println("TripApplication getPeackHourBillDetails()...."+tripPort.getPeackHourBillDetails());
			return tripPort.getPeackHourBillDetails();
		}

		@RequestMapping(value = "/billing-details/gettripfareamount")
	    public String getTripFareamount() throws RestClientException, IOException {
			log.debug("TripApplication getTripFareamount()...."+tripPort.getTripFareamount());
			System.out.println("TripApplication getTripFareamount()...."+tripPort.getTripFareamount());
			return tripPort.getTripFareamount();
		}

		@RequestMapping(value="/billing-details/holidaypromo")
		public String getHolidayPromoPassenger() throws RestClientException, IOException {
			log.debug("TripApplication getHolidayPromoPassenger()...."+tripPort.getHolidayPromoPassenger());
			System.out.println("TripApplication getHolidayPromoPassenger()...."+tripPort.getHolidayPromoPassenger());
			return tripPort.getHolidayPromoPassenger();
		}
}
