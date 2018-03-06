package com.pact.trip.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pact.trip.TripApplication;

import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TripApplication.class)
@WebAppConfiguration
//@PactFolder("../driver/target/pacts")
@PactBroker(host = "//test.pact.dius.com.au/", port = "443",
authentication = @PactBrokerAuth(username = "dXfltyFMgNOFZAxr8io9wJ37iUpY42M", password = "O5AIZWxelWbLvqMd8PkAVycBJh2Psyg1"))
public class TripMngmntApplicationTest {
	
	@Test
    public void contextLoads() {
    }

}
