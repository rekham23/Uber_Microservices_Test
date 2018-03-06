package com.pact.uberoff;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException; 

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class UberOfficeApplication {
	
	static Logger log = Logger.getLogger(UberOfficeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UberOfficeApplication.class, args);

	}
	
	@Autowired
	UberOfficePort uberPort;

	@RequestMapping(value="/driver-details")
    @ResponseBody
    public String getDriverDetailsUberOfc()  throws RestClientException, IOException {
		log.debug("UberOfficeApplication getDriverDetailsUberOfc()...."+uberPort.getDriverDetailsUberOfc());
		System.out.println("UberOfficeApplication getDriverDetailsUberOfc()...."+uberPort.getDriverDetailsUberOfc());
		return uberPort.getDriverDetailsUberOfc();
    }
	
	@RequestMapping(value="/billing-details/uberledger")
    @ResponseBody
    public String getBillDetailsUberOfc()  throws RestClientException, IOException {
		log.debug("UberOfficeApplication getBillDetailsUberOfc()...."+uberPort.getBillDetailsUberOfc());
		System.out.println("UberOfficeApplication getDriverDetailsUberOfc()...."+uberPort.getBillDetailsUberOfc());
		return uberPort.getBillDetailsUberOfc();
    }
	@RequestMapping(value = "/uber-ledger/totalearningperday", method = RequestMethod.GET)
    public ResponseEntity<UberLedgerDetails> getEarningsPerDay() {
		log.info("In getOverallRating()....");
    	return new ResponseEntity<UberLedgerDetails>(new UberLedgerDetails("Rs.2600/-", "02/03/2018", "7 Trips"),  HttpStatus.OK);

    }

	@RequestMapping(value = "/uber-ledger/overallrating", method = RequestMethod.GET)
    public ResponseEntity<UberLedgerDetails> getOverallRating() {
		log.info("In getEarningsPerDay()....");
    	return new ResponseEntity<UberLedgerDetails>(new UberLedgerDetails("5"),  HttpStatus.OK);

    }

	@RequestMapping(value = "/uber-ledger/award", method = RequestMethod.GET)
    public ResponseEntity<UberLedgerDetails> getAward() {
		log.info("In getEarningsPerDay()....");
    	return new ResponseEntity<UberLedgerDetails>(new UberLedgerDetails("Gold Coin Award", "02/03/2018"),  HttpStatus.OK);

    } 
	@RequestMapping(value = "/uber-ledger/ledger", method = RequestMethod.GET)
    public ResponseEntity<UberLedgerDetails> getUberLedger() {
		log.info("In getUberLedger()....");
    	return new ResponseEntity<UberLedgerDetails>(new UberLedgerDetails("Tom", "9999923235", "Rs.500/-", "Rs.2600/-","Gold Coin Award", "5", "02/03/2018", "7"),  HttpStatus.OK);

    }

	//Get Uber Ledger Scenarios

	@RequestMapping(value="/passenger-details/passengerinfo")
	public String getPassengerInfo() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getPassengerInfo()...."+uberPort.getPassengerInfo());
		System.out.println("UberOfficeApplication getPassengerInfo()...."+uberPort.getPassengerInfo());
		return uberPort.getPassengerInfo();
	}

	@RequestMapping(value="/passenger-details/paymentoption")
    public String getPassengerPaymentOption() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getPassengerPaymentOption()...."+uberPort.getPassengerPaymentOption());
		System.out.println("UberOfficeApplication getPassengerPaymentOption()...."+uberPort.getPassengerPaymentOption());
		return uberPort.getPassengerPaymentOption();
    }

	@RequestMapping(value="/trip-details/tripdetails")
	public String getTripDetailPassenger() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getTripDetailPassenger()...."+uberPort.getTripDetailPassenger());
		System.out.println("UberOfficeApplication getTripDetailPassenger()...."+uberPort.getTripDetailPassenger());
		return uberPort.getTripDetailPassenger();
	}

	@RequestMapping(value="/trip-details/futurebookingpromo")
	public String getFutureBookingDetailPassenger() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getFutureBookingDetailPassenger()...."+uberPort.getFutureBookingDetailPassenger());
		System.out.println("UberOfficeApplication getPromoDetailPassenger()...."+uberPort.getFutureBookingDetailPassenger());
		return uberPort.getFutureBookingDetailPassenger();
	}

	@RequestMapping(value="/trip-details/cancelbooking")
	public String getCancelBookingDetails() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getCancelBookingDetails()...."+uberPort.getCancelBookingDetails());
		System.out.println("UberOfficeApplication getCancelBookingDetails()...."+uberPort.getCancelBookingDetails());
		return uberPort.getCancelBookingDetails();
	}

	@RequestMapping(value="/driver-details/driver")
	public String getDriverDetail() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getDriverDetail()...."+uberPort.getDriverDetail());
		System.out.println("UberOfficeApplication getDriverDetail()...."+uberPort.getDriverDetail());
		return uberPort.getDriverDetail();
	}

	@RequestMapping(value = "/billing-details/gettripfareamount")
    public String getTripFareamount() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getTripFareamount()...."+uberPort.getTripFareamount());
		System.out.println("UberOfficeApplication getTripFareamount()...."+uberPort.getTripFareamount());
		return uberPort.getTripFareamount();
	}

	@RequestMapping(value = "/billing-details/incentiveoftheday")
    public String getIncentiveDay() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getIncentiveDay()...."+uberPort.getIncentiveDay());
		System.out.println("UberOfficeApplication getIncentiveDay()...."+uberPort.getIncentiveDay());
		return uberPort.getIncentiveDay();
	}

	@RequestMapping(value="/billing-details/holidaypromo")
	public String getHolidayPromoPassenger() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getHolidayPromoPassenger()...."+uberPort.getHolidayPromoPassenger());
		System.out.println("UberOfficeApplication getHolidayPromoPassenger()...."+uberPort.getHolidayPromoPassenger());
		return uberPort.getHolidayPromoPassenger();
	}

	@RequestMapping(value = "/billing-details/incentiveofthemonth", method = RequestMethod.GET)
	 public String getIncentiveMonth() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getIncentiveMonth()...."+uberPort.getIncentiveMonth());
		System.out.println("UberOfficeApplication getIncentiveMonth()...."+uberPort.getIncentiveMonth());
		return uberPort.getIncentiveMonth();
	}

	@RequestMapping(value="/billing-details/cabsharingpromo")
	public String getCabSharingPromoPassenger() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getCabSharingPromoPassenger()...."+uberPort.getCabSharingPromoPassenger());
		System.out.println("UberOfficeApplication getCabSharingPromoPassenger()...."+uberPort.getCabSharingPromoPassenger());
		return uberPort.getCabSharingPromoPassenger();
	}

	@RequestMapping(value="/billing-details/promo")
	public String getPromoDetailPassenger() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getPromoDetailPassenger()...."+uberPort.getPromoDetailPassenger());
		System.out.println("UberOfficeApplication getPromoDetailPassenger()...."+uberPort.getPromoDetailPassenger());
		return uberPort.getPromoDetailPassenger();
	}


	@RequestMapping(value="/billing-details/peakhourdetails")
	public String getPeackHourBillDetails() throws RestClientException, IOException {
		log.debug("UberOfficeApplication getPeackHourBillDetails()...."+uberPort.getPeackHourBillDetails());
		System.out.println("UberOfficeApplication getPeackHourBillDetails()...."+uberPort.getPeackHourBillDetails());
		return uberPort.getPeackHourBillDetails();
	}
	//End
	
}
