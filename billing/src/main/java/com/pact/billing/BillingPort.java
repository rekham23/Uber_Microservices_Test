package com.pact.billing;

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
public class BillingPort {
	
	private String url;
	 private RestTemplate restTemplate;
	 
	 @Autowired
	    public BillingPort(@Value("${producer}") String url) {
	        this.url = url;
	        this.restTemplate = new RestTemplate();
	    }
	 private static HttpEntity<?> getHeaders() throws IOException {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(headers);
		} 
	 
	 public String getTripDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/trip-details", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8084/trip-details", HttpMethod.GET, getHeaders() , String.class); 
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }
	 public String getEarningsPerDay () throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8083/uber-ledger/totalearningperday", HttpMethod.GET, null, String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Uber Ledger.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
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

	 public String getOverallRating() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8083/uber-ledger/overallrating", HttpMethod.GET, null, String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Driver Could not get response from Uber Ledger Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();

	 }

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

	 public String getAward() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8083/uber-ledger/award", HttpMethod.GET, null, String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Driver Could not get response from Uber Ledger Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
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

	 public String getUberLedger() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8083/uber-ledger/ledger", HttpMethod.GET, null, String.class);

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Driver Could not get response from Uber Ledger Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    } 
}
