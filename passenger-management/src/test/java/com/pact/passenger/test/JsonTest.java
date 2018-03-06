package com.pact.passenger.test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {

	public static void main(String[] args) {
		List<PactArgumetObject> allArgs = new ArrayList<PactArgumetObject>();
		String jsonarg = "driver-service{phoneno:9739849842;location:Domalur;name:Tom};,billing-details{tripDate:28/12/2017;fareamount:205.6}";
    	String[] args1 = jsonarg.split(";,");
    	System.out.println("args1[0]....."+args1[0]);
		System.out.println("args1[1]....."+args1[1]);
    	for (int i=0;i<args1.length;i++){
    		System.out.println("args1[i]."+args1[i]);
    		System.out.println("allArgs..."+args1[i].substring(0, args1[i].indexOf("{")));
    		System.out.println("allArgs..."+args1[i].substring( args1[i].indexOf("{")+1, args1[i].indexOf("}")));
    		allArgs.add(new PactArgumetObject(
    				args1[i].substring(0, args1[i].indexOf("{")),
    				args1[i].substring( args1[i].indexOf("{")+1, args1[i].indexOf("}"))));
    	}  
    	
    	for(PactArgumetObject obj :allArgs)
    	{    		
    		System.out.println("allArgsRule....."+obj.getRule());
    		System.out.println("allArgsArgs....."+obj.getArgs());
    	}

	}
	
	
	
}
