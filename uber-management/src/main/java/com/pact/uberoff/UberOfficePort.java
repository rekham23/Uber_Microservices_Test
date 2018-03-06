package com.pact.uberoff;

import java.io.IOException;
import org.apache.log4j.helpers.LogLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UberOfficePort {
	@Value("producer")
	 private String url;
	 private RestTemplate restTemplate = new RestTemplate();;
	 
	 public UberOfficePort(@Value("${producer}") String url) {
	        this.url = url;
	        this.restTemplate = new RestTemplate();
	    }
	 
	 public UberOfficePort() {
	        super();
	    }
	 
	 private static HttpEntity<?> getHeaders() throws IOException {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(headers);
		} 
	 public String getDriverDetailsUberOfc() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/driver-details", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8082/driver-details", HttpMethod.GET, getHeaders(), String.class);
	    		}catch (Exception ex)
	    		{
	    			//LogLog.error("Could not get response from Uber office service.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }
	 
	 public String getBillDetailsUberOfc() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/uberledger", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/uberledger", HttpMethod.GET, getHeaders(), String.class); 
	    		}catch (Exception ex)
	    		{
	    			//LogLog.error("Could not get response from Uber office service.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getPassengerInfo()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8081/passenger-details/passengerinfo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Passenger Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getPassengerPaymentOption () throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8081/passenger-details/paymentoption", HttpMethod.GET, null, String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Passenger.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getFutureBookingDetailPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8084/trip-details/futurebookingpromo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 /*public String getTripDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8084/trip-details", HttpMethod.GET, getHeaders(), String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }*/

	 public String getTripDetailPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8084/trip-details/tripdetails", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getCancelBookingDetails()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/trip-details/cancelbooking", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8084/trip-details/cancelbooking", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getDriverDetail()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8082/driver-details/driver", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Driver Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getPeackHourBillDetails()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/peakhourdetails", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getCabSharingPromoPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getHolidayPromoPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/holidaypromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/holidaypromo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getIncentiveDay()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/incentiveoftheday", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }


	 public String getIncentiveMonth()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/incentiveofthemonth", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getTripFareamount()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/cabsharingpromo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/gettripfareamount", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getPromoDetailPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/promo", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/promo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }
}
