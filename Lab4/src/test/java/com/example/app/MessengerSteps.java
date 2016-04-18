package com.example.app;


import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.messenger.MessageService;
import com.example.messenger.MessageServiceSimpleImpl;
import com.example.app.Messenger;

public class MessengerSteps {

	private Messenger mess;
	private MessageService ms = new MessageServiceSimpleImpl();
	private String server;
	private String message;

	@Given("a messenger")
	public void messengerSetup(){
		mess = new Messenger(ms);
	}

	@When("set argument to $address")
	public void setAddress (String address){
		this.server = address;
	}

		@When("set arguments to $address and $message")
	public void setAddressMessage(String address, String message) {
		this.server = address;
		this.message = message;
	}

	@Then("connection should return $result")
	public void checkConnection(int result) {
		assertEquals(result, mess.testConnection(server));
	}

		@Then("send message should return $result")
	public void shouldSendMessage(int result) {
		assertEquals(result, mess.sendMessage(server
                                             , message));
	}
}
