package com.pact.billing.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pact.billing.BillingDetailApplication;

import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BillingDetailApplication.class)
@WebAppConfiguration*/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BillingDetailApplication.class)
@WebAppConfiguration
//@PactFolder("../microservices-pact-consumer/target/pacts")
@PactBroker(host = "//test.pact.dius.com.au/", port = "443",
authentication = @PactBrokerAuth(username = "dXfltyFMgNOFZAxr8io9wJ37iUpY42M", password = "O5AIZWxelWbLvqMd8PkAVycBJh2Psyg1"))


public class BillingDetailApplicationTest {
	
	@Test
	public void contextLoads() {
	}

}
