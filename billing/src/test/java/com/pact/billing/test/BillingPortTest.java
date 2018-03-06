package com.pact.billing.test;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestClientException;

import com.pact.billing.BillingPort;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class BillingPortTest {
	
final static Logger log = Logger.getLogger(BillingPortTest.class);
	
	private    String serviceurl= "";
	private   String jsonArgs ="";
	private String reqmethod = "";
	
	
    @Rule
    public PactProviderRule rule = new PactProviderRule("trip-service", this);
    
    private DslPart tripDetailResults;
    
    public BillingPortTest(){
    	serviceurl = System.getProperty("serviceurl");
    	jsonArgs = System.getProperty("jsonArgs");
    	reqmethod = System.getProperty("reqmethod");
    	System.out.println(this);
    }
    
    public void prepareValues(){
    	log.info("jsonArgs:-"+jsonArgs);
    	log.info("serviceurl:-"+serviceurl);
    	log.info("reqmethod:-"+reqmethod);
		System.out.println("jsonArgs:-"+jsonArgs);
		System.out.println("serviceurl:-"+serviceurl);
		System.out.println("reqmethod:-"+reqmethod);
		tripDetailResults = new PactDslJsonBody();
		String[] args = jsonArgs.split(";");
		for(int i=0;i<args.length;i++){
			String params =args[i];
			System.out.println("params.........."+params);
			String pARAMaRR[] = params.split(":");
			String paramkey = pARAMaRR[0];
			String paramValue = pARAMaRR[1];
			System.out.println("paramKey:-"+paramkey);
			System.out.println("paramValue:-"+paramValue);
			if(StringUtils.isNumeric(paramValue)){

				//driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberType(paramkey, new Long(paramValue));
				tripDetailResults = ((PactDslJsonBody)tripDetailResults).numberType(paramkey);

			}else if(paramkey.contains("date")){

				//convert String to time  and set that
			//driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringMatcher("t", "\\d{2}\\/\\d{2}\\/\\d{2}");
					//stringType(paramkey,paramValue );
				Date date = null;
				try {
					 date =  new SimpleDateFormat("dd/MM/yyyy").parse(paramValue);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tripDetailResults = ((PactDslJsonBody)tripDetailResults).date(paramkey,"dd/MM/yyyy", date);	
			}else if(paramkey.contains("Bool")){

				//convert String to boolean and set that  
			//driverDetailResults = ((PactDslJsonBody)driverDetailResults).booleanType(paramkey,paramValue );
				tripDetailResults = ((PactDslJsonBody)tripDetailResults).booleanType(paramkey);
			}else if(paramkey.contains("Time")){
				
				DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
				String dateString = dateFormat.format(new Date()).toString();

				//convert String to boolean and set that  
			//driverDetailResults = ((PactDslJsonBody)driverDetailResults).booleanType(paramkey,paramValue );
				tripDetailResults = ((PactDslJsonBody)tripDetailResults).time(paramkey, dateString);
			}else{
				//driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringType(paramkey,paramValue );
				tripDetailResults = ((PactDslJsonBody)tripDetailResults).stringType(paramkey);
			}
			
			tripDetailResults = tripDetailResults.asBody();
		} 
    }
    
    @Pact(provider="trip-service", consumer="billing-service")
    public PactFragment createFragment(PactDslWithProvider builder) {

    	System.out.println(this);
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl").toString());
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs").toString());
    	System.out.println("----------------------------------"+System.getProperty("reqmethod").toString());
    	
    	Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        prepareValues();	
  
        System.out.println(tripDetailResults.toString());    
        System.out.println("serviceurl:- "+serviceurl);
        System.out.println("reqmethod:-  "+reqmethod);
        	
        return getFragment(builder, headers, serviceurl, reqmethod, tripDetailResults);

     }

    private  PactFragment getFragment(PactDslWithProvider builder, Map<String, String> headers,String serviceurl1, String reqmethod1, DslPart tripDetailResults1){
 	   return builder
                .uponReceiving("get trip detail response")
                .path(serviceurl1)
                .method(reqmethod1)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(tripDetailResults1)
                .toFragment();
    }
    
    @Test
    @PactVerification(value = "trip-service", fragment = "createFragment")
    public void runTest() throws RestClientException, IOException {
    	log.info("runTest():---------------");
        assertEquals(new BillingPort(rule.getConfig().url()).getTripDetails(), tripDetailResults.toString());
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl"));
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs"));
    } 


}
