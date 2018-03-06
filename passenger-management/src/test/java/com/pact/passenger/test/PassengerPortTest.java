
package com.pact.passenger.test;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestClientException;

import com.pact.passenger.PassengerPort;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class PassengerPortTest {
	
	final static Logger log = Logger.getLogger(PassengerPortTest.class);
	
	private    String serviceurl= "";
	private   String jsonArgs ="";
	private String reqmethod = "";
	private String serviceurlbill = "";
	
	
    @Rule
    public PactProviderRule rule1 = new PactProviderRule("driver-service", this);
    public PactProviderRule rule2 = new PactProviderRule("billing-details", this);
    
    private DslPart driverDetailResults;
    private DslPart billingrDetailResults;
    private static List<PactArgumetObject> allArgs = new ArrayList<PactArgumetObject>();
    
    public PassengerPortTest(){
    	/*serviceurl = System.getProperty("serviceurl");
    	serviceurlbill = System.getProperty("serviceurlbill");
    	jsonArgs = System.getProperty("jsonArgs");
    	reqmethod = System.getProperty("reqmethod");*/
    	serviceurl = "/driver-details/driver";
    	serviceurlbill = "/billing-details/passenger";
    	jsonArgs = "driver-service{phoneno:9739849842;location:Domalur;name:Tom};,billing-details{tripDate:28/12/2017;fareamount:205.6}";
    	reqmethod ="GET";
    	System.out.println(this);
    }
    
    public void prepareValues(){
    
    System.out.println("Inside  prepareValues()");
    
    String jsonarg = "driver-service{phoneno:9739849842;location:Domalur;name:Tom};,billing-details{tripDate:28/12/2017;fareamount:205.6}";
    	String[] jargs = jsonarg.split(";,");
    	System.out.println("jargs[0]....."+jargs[0]);
		System.out.println("jargs[1]....."+jargs[1]);
    	for (int i=0;i<jargs.length;i++){
    		System.out.println("jargs[i]."+jargs[i]);
    		System.out.println("alljargs..."+jargs[i].substring(0, jargs[i].indexOf("{")));
    		System.out.println("alljargs..."+jargs[i].substring( jargs[i].indexOf("{")+1, jargs[i].indexOf("}")));
    		allArgs.add(new PactArgumetObject(
    				jargs[i].substring(0, jargs[i].indexOf("{")),
    				jargs[i].substring( jargs[i].indexOf("{")+1, jargs[i].indexOf("}"))));
    	}  
    
    for(PactArgumetObject obj :allArgs)
    	{    		
    		System.out.println("allArgsRule....."+obj.getRule());
    		System.out.println("allArgsArgs....."+obj.getArgs());
    	
    	if(obj.getRule().equals("driver-service")){
    	
    	jsonArgs=obj.getArgs();
    
    	log.info("jsonArgs:-"+jsonArgs);
    	log.info("serviceurl:-"+serviceurl);
    	log.info("serviceurlbill.."+serviceurlbill);
    	log.info("reqmethod:-"+reqmethod);
		System.out.println("jsonArgs:-"+jsonArgs);
		System.out.println("serviceurl:-"+serviceurl);
		System.out.println("serviceurlbill..."+serviceurlbill);
		System.out.println("reqmethod:-"+reqmethod);
		driverDetailResults = new PactDslJsonBody();
		String[] args = jsonArgs.split(";");
		for(int i=0;i<args.length;i++){
			String params =args[i];
			System.out.println("params.........."+params);
			String pARAMaRR[] = params.split(":");
			String paramkey = pARAMaRR[0];
			String paramValue = pARAMaRR[1];
			System.out.println("paramKey:-"+paramkey);
			System.out.println("paramValue:-"+paramValue);
			/*if(StringUtils.isNumeric(paramValue)){

				driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberValue(paramkey, new Long(paramValue));

			}else{
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringValue(paramkey,paramValue );
			}*/
			
			if(StringUtils.isNumeric(paramValue)){

				driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberType(paramkey);

			}else{
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringType(paramkey);
			}
			
         	    driverDetailResults = driverDetailResults.asBody();
		}
	}else if(obj.getRule().equals("billing-details")){
			
			jsonArgs=obj.getArgs();
			
			log.info("jsonArgs:-"+jsonArgs);
	    	log.info("serviceurlbill:-"+serviceurlbill);
	    	log.info("reqmethod:-"+reqmethod);
			System.out.println("jsonArgs:-"+jsonArgs);
			System.out.println("serviceurlbill:-"+serviceurlbill);
			System.out.println("reqmethod:-"+reqmethod);
			billingrDetailResults = new PactDslJsonBody();
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
	
					billingrDetailResults = ((PactDslJsonBody)billingrDetailResults).numberType(paramkey);
	
				}else if(paramkey.contains("Date")){
	
					//convert String to time  and set that
					Date date = null;
					try {
						 date =  new SimpleDateFormat("dd/MM/yyyy").parse(paramValue);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					billingrDetailResults = ((PactDslJsonBody)billingrDetailResults).date(paramkey,"dd/MM/yyyy", date);	
				}else{
					//billingrDetailResults = ((PactDslJsonBody)billingrDetailResults).stringType(paramkey,paramValue );
					billingrDetailResults = ((PactDslJsonBody)billingrDetailResults).stringType(paramkey);
				}

				
	         	    billingrDetailResults = billingrDetailResults.asBody();
				
			}
		}
 }
		
    }
    
    @Pact(provider="driver-service", consumer="passenger-service")
    public PactFragment createFragment(PactDslWithProvider builder) {

/*    	System.out.println(this);
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl").toString());
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs").toString());
    	System.out.println("----------------------------------"+System.getProperty("reqmethod").toString());
*/    	
    	Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        prepareValues();	
  
        System.out.println(driverDetailResults.toString());    
        System.out.println("serviceurl:- "+serviceurl);
        System.out.println("reqmethod:-  "+reqmethod);
        	
        return getFragment(builder, headers, serviceurl, reqmethod, driverDetailResults);

     }

    private  PactFragment getFragment(PactDslWithProvider builder, Map<String, String> headers,String serviceurl1, String reqmethod1, DslPart driverDetailResults1){
 	   return builder
                .uponReceiving("get driver detail response")
                .path(serviceurl1)
                .method(reqmethod1)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(driverDetailResults1)
                .toFragment();
    }
    
   

        
    @Test
    @PactVerification(value = "driver-service", fragment = "createFragment")
    public void runTest1() throws RestClientException, IOException {
    	log.info("runTest1():---------------");
        assertEquals(new PassengerPort(rule1.getConfig().url()).getDriverDetails(), driverDetailResults.toString());
    }
    
    
     // Billing Service
    
    private  PactFragment getFragmentBilling(PactDslWithProvider builder, Map<String, String> headers,String serviceurlbill1, String reqmethod1, DslPart billingrDetailResults1){
 	   return builder
                .uponReceiving("get Billing details response")
                .path(serviceurlbill1)
                .method(reqmethod1)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(billingrDetailResults1)
                .toFragment();
    }
    
    @Pact(provider="billing-details", consumer="passenger-service")
    public PactFragment createFragmentBilling(PactDslWithProvider builder) {

  /*  	System.out.println(this);
    	System.out.println("----------------------------------------"+System.getProperty("serviceurlbill").toString());
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs").toString());
    	System.out.println("----------------------------------"+System.getProperty("reqmethod").toString());
  */  	
    	Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        prepareValues();	
  
        System.out.println(billingrDetailResults.toString());    
        System.out.println("serviceurlbill:- "+serviceurlbill);
        System.out.println("reqmethod:-  "+reqmethod);
        	
        return getFragmentBilling(builder, headers, serviceurlbill, reqmethod, billingrDetailResults);

     }
    
    @Test
    @PactVerification(value = "billing-details", fragment = "createFragmentBilling")
    public void runTest2() throws RestClientException, IOException {
    	log.info("runTest2():---------------");
        assertEquals(new PassengerPort(rule2.getConfig().url()).getBillDetails(), billingrDetailResults.toString());
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    
    	//String jsonarg = System.getProperty("jsonArgs");
    	String jsonarg = "driver-service{phoneno:9739849842;location:Domalur;name:Tom};,billing-details{tripDate:28/12/2017;fareamount:205.6}";
    	String[] args = jsonarg.split(";,");
    	System.out.println("args[0]....."+args[0]);
		System.out.println("args[1]....."+args[1]);
    	for (int i=0;i<args.length;i++){
    		System.out.println("args[i]."+args[i]);
    		System.out.println("allArgs..."+args[i].substring(0, args[i].indexOf("{")));
    		System.out.println("allArgs..."+args[i].substring( args[i].indexOf("{")+1, args[i].indexOf("}")));
    		allArgs.add(new PactArgumetObject(
    				args[i].substring(0, args[i].indexOf("{")),
    				args[i].substring( args[i].indexOf("{")+1, args[i].indexOf("}"))));
    	}  
    	
    	for(PactArgumetObject obj :allArgs)
    	{    		
    		System.out.println("allArgsRule....."+obj.getRule());
    		System.out.println("allArgsArgs....."+obj.getArgs());
    	}
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl"));
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs"));
    } 



}
