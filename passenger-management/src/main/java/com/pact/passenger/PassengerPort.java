package com.pact.passenger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.http.util.EntityUtils;
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

import au.com.dius.pact.model.Request;

@Component
public class PassengerPort {
	
	 private String url;
	 private RestTemplate restTemplate;
	 
	 @Autowired
	    public PassengerPort(@Value("${producer}") String url) {
	        this.url = url;
	        this.restTemplate = new RestTemplate();
	    }
	 private static HttpEntity<?> getHeaders() throws IOException {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(headers);
		} 
	 
	 /*public static Map<String, String> getHeaders()
	    {
	        @SuppressWarnings("unchecked")
			Map<String, String> headers = MapUtils.putAll(new HashMap<String, String>(),
	                new String[]{"Content-Type", "application/json;charset=UTF-8"});
	        return headers;
	    }*/
	 
	 public String getDriverDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange("http://localhost:8082/driver-details/driver", HttpMethod.GET, getHeaders(), String.class); //to check consumer end point
	    		//response=restTemplate.exchange(url + "/driver-details/driver", HttpMethod.GET, null, String.class); 

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from driver.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }
	 
	 public String getBillDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/billing-details/passenger", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8085/billing-details/passenger", HttpMethod.GET, getHeaders() , String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Billing Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }
	 
	 public String getTripDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/trip-details", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8084/trip-details", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
	    			System.out.println(ex);
	    		}
	    		System.out.println(response.getBody());
	    	return response.getBody();
	    }

	 public String getBookingDetails()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		//response=restTemplate.exchange(url + "/trip-details/booking", HttpMethod.GET, null, String.class); 
	    		response=restTemplate.exchange("http://localhost:8084/trip-details/booking", HttpMethod.GET, null, String.class);
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

	 public String getFutureBookingDetailPassenger()throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    	//	response=restTemplate.exchange(url + "/billing-details/futurebookingpromo", HttpMethod.GET, null, String.class); 
	    	response=restTemplate.exchange("http://localhost:8084/trip-details/futurebookingpromo", HttpMethod.GET, null, String.class);
	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from Trip Service.", ex);
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
	 
	 
}
