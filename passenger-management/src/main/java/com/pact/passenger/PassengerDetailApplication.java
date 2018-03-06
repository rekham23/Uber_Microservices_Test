package com.pact.passenger;
import java.io.IOException;
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
public class PassengerDetailApplication {

	final static Logger log = Logger.getLogger(PassengerDetailApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PassengerDetailApplication.class, args);

	}
	
	@Autowired
    PassengerPort passengerPort;
	
	@RequestMapping(value="/driver-details/driver")
    public String getDriverDetail() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getDriverDetail()...."+passengerPort.getDriverDetails());
		System.out.println("PassengerDetailApplication getDriverDetail()...."+passengerPort.getDriverDetails());
		return passengerPort.getDriverDetails();
    }
	
	@RequestMapping(value="/billing-details/passenger")
    public String getBillDetails() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getBillDetail()...."+passengerPort.getBillDetails());
		System.out.println("PassengerDetailApplication getBillDetail()...."+passengerPort.getBillDetails());
		return passengerPort.getBillDetails();
    }
	@RequestMapping(value="/trip-details")
	public String getTripDetails() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getTripDetails()...."+passengerPort.getTripDetails());
		System.out.println("PassengerDetailApplication getTripDetails()...."+passengerPort.getTripDetails());
		return passengerPort.getTripDetails();
	}

	@RequestMapping(value="/trip-details/booking")
	public String getBookingDetails() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getBookingDetails()...."+passengerPort.getBookingDetails());
		System.out.println("PassengerDetailApplication getBookingDetails()...."+passengerPort.getBookingDetails());
		return passengerPort.getBookingDetails();
	}

	@RequestMapping(value="/trip-details/cancelbooking")
	public String getCancelBookingDetails() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getCancelBookingDetails()...."+passengerPort.getCancelBookingDetails());
		System.out.println("PassengerDetailApplication getCancelBookingDetails()...."+passengerPort.getCancelBookingDetails());
		return passengerPort.getCancelBookingDetails();
	}


	@RequestMapping(value="/billing-details/promo")
	public String getPromoDetailPassenger() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getPromoDetailPassenger()...."+passengerPort.getPromoDetailPassenger());
		System.out.println("PassengerDetailApplication getPromoDetailPassenger()...."+passengerPort.getPromoDetailPassenger());
		return passengerPort.getPromoDetailPassenger();
	}

	@RequestMapping(value="/trip-details/futurebookingpromo")
	public String getFutureBookingDetailPassenger() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getFutureBookingDetailPassenger()...."+passengerPort.getFutureBookingDetailPassenger());
		System.out.println("PassengerDetailApplication getPromoDetailPassenger()...."+passengerPort.getFutureBookingDetailPassenger());
		return passengerPort.getFutureBookingDetailPassenger();
	}

	@RequestMapping(value="/billing-details/holidaypromo")
	public String getHolidayPromoPassenger() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getHolidayPromoPassenger()...."+passengerPort.getHolidayPromoPassenger());
		System.out.println("PassengerDetailApplication getHolidayPromoPassenger()...."+passengerPort.getHolidayPromoPassenger());
		return passengerPort.getHolidayPromoPassenger();
	} 
	@RequestMapping(value="/billing-details/cabsharingpromo")
	public String getCabSharingPromoPassenger() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getCabSharingPromoPassenger()...."+passengerPort.getCabSharingPromoPassenger());
		System.out.println("PassengerDetailApplication getCabSharingPromoPassenger()...."+passengerPort.getCabSharingPromoPassenger());
		return passengerPort.getCabSharingPromoPassenger();
	}

	@RequestMapping(value="/billing-details/peakhourdetails")
	public String getPeackHourBillDetails() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getPeackHourBillDetails()...."+passengerPort.getPeackHourBillDetails());
		System.out.println("PassengerDetailApplication getPeackHourBillDetails()...."+passengerPort.getPeackHourBillDetails());
		return passengerPort.getPeackHourBillDetails();
	} 
	@RequestMapping(value = "/passenger-details/passengerinfo", method = RequestMethod.GET)
    public ResponseEntity<PassengerDetail> getPassengerInfo() {
        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
		log.info("In getDriverDetail()....");
		//log.debug("In getDriverDetail()"+getDriverDetail());
    	return new ResponseEntity<PassengerDetail>(new PassengerDetail("Sagar Sharma", "9867345623","BTM"),  HttpStatus.OK);

    } 
	@RequestMapping(value = "/passenger-details/paymentoption", method = RequestMethod.GET)
    public ResponseEntity<PassengerDetail> getPassengerPaymentOption() {
        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
		log.info("In getPassengerPaymentOption()....");
		//log.debug("In getDriverDetail()"+getDriverDetail());
    	return new ResponseEntity<PassengerDetail>(new PassengerDetail("By Cash", "Rs.145/-"),  HttpStatus.OK);

    } 
}
