package com.provider.driver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class DriverMngmntApplication {
	
	final static Logger log = Logger.getLogger(DriverMngmntApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DriverMngmntApplication.class, args);

	}
	
	@Autowired
    DriverPort driverPort;
	
	@RequestMapping(value = "/driver-details/driver", method = RequestMethod.GET)
    public ResponseEntity<DriverDetails> getDriverDetail() {
        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
		log.info("In getDriverDetail()....");
		//log.debug("In getDriverDetail()"+getDriverDetail());
    	return new ResponseEntity<DriverDetails>(new DriverDetails("9739849842", "Domalur","Tom"),  HttpStatus.OK);
    	
    }
	
	@RequestMapping(value = "/driver-details", method = RequestMethod.GET)
    public ResponseEntity<DriverDetails> getDriverDetailsUberOfc() throws Exception {
		log.info("In getDriverDetailsUberOfc()....");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date tripdate = sdf.parse("26/12/2017");
		
		log.info("In getDriverDetailsUberOfc()....tripdate="+tripdate);
		
		Date today = new Date();
		System.out.println("today........."+today);
		
		Boolean incentiveBool = true;
		
		/*String da = "2017-12-26";
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(da);
		System.out.println("date....."+date);*/
		
    	return new ResponseEntity<DriverDetails>(new DriverDetails("9739849842", "Domalur","Tom",incentiveBool, today, "Fourth"),  HttpStatus.OK);
    	
    }
	
	
	@RequestMapping(value="/billing-details/driver")
    public String getBillDetails() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getBillDetail()...."+driverPort.getBillDetails());
		System.out.println("DriverDetailApplication getBillDetail()...."+driverPort.getBillDetails());
		return driverPort.getBillDetails();
    }
	@RequestMapping(value="/uber-ledger/totalearningperday")
    public String getEarningsPerDay() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getEarningsPerDay()...."+driverPort.getEarningsPerDay());
		System.out.println("DriverDetailApplication getBillDetail()...."+driverPort.getEarningsPerDay());
		return driverPort.getEarningsPerDay();
    }

	@RequestMapping(value="/uber-ledger/overallrating")
    public String getOverallRating() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getOverallRating()...."+driverPort.getOverallRating());
		System.out.println("DriverDetailApplication getOverallRating()...."+driverPort.getOverallRating());
		return driverPort.getOverallRating();
    }

	@RequestMapping(value="/uber-ledger/award")
    public String getAward() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getAward()...."+driverPort.getAward());
		System.out.println("DriverDetailApplication getAward()...."+driverPort.getAward());
		return driverPort.getAward();
    }

	@RequestMapping(value="/billing-details/cabsharingpromo")
	public String getCabSharingPromoPassenger() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getCabSharingPromoPassenger()...."+driverPort.getCabSharingPromoPassenger());
		System.out.println("DriverDetailApplication getCabSharingPromoPassenger()...."+driverPort.getCabSharingPromoPassenger());
		return driverPort.getCabSharingPromoPassenger();
	}

	@RequestMapping(value="/passenger-details/passengerinfo")
	public String getPassengerInfo() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getPassengerInfo()...."+driverPort.getPassengerInfo());
		System.out.println("DriverDetailApplication getPassengerInfo()...."+driverPort.getPassengerInfo());
		return driverPort.getPassengerInfo();
	}

	@RequestMapping(value="/trip-details/tripdetails")
	public String getTripDetailPassenger() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getTripDetailPassenger()...."+driverPort.getTripDetailPassenger());
		System.out.println("DriverDetailApplication getPassengerInfo()...."+driverPort.getTripDetailPassenger());
		return driverPort.getTripDetailPassenger();
	}

	@RequestMapping(value = "/billing-details/gettripfareamount")
    public String getTripFareamount() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getTripFareamount()...."+driverPort.getTripFareamount());
		System.out.println("DriverDetailApplication getTripFareamount()...."+driverPort.getTripFareamount());
		return driverPort.getTripFareamount();
	}

	@RequestMapping(value = "/billing-details/incentiveoftheday")
    public String getIncentiveDay() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getIncentiveDay()...."+driverPort.getIncentiveDay());
		System.out.println("DriverDetailApplication getIncentiveDay()...."+driverPort.getIncentiveDay());
		return driverPort.getIncentiveDay();
	}

	@RequestMapping(value = "/billing-details/incentiveofthemonth", method = RequestMethod.GET)
	 public String getIncentiveMonth() throws RestClientException, IOException {
		log.debug("DriverDetailApplication getIncentiveMonth()...."+driverPort.getIncentiveMonth());
		System.out.println("DriverDetailApplication getIncentiveMonth()...."+driverPort.getIncentiveMonth());
		return driverPort.getIncentiveMonth();
	}
 
}
