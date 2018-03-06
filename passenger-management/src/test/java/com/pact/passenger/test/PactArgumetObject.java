package com.pact.passenger.test;

public class PactArgumetObject {
	private String rule;
	private String args;
	public PactArgumetObject() {
		super();
	}
	public PactArgumetObject(String rule, String args) {
		super();
		this.rule = rule;
		this.args = args;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}

}
