package com.servicenow.ui.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.servicenow.ui.base.ServiceNowMethods;

import io.github.sukgu.Shadow;

public class HomePage extends ServiceNowMethods {
	
	public HomePage(Shadow recievedShadow, RemoteWebDriver receivedDriver ) {
		this.shadow=recievedShadow;
		this.driver=receivedDriver;
		
	}

	public HomePage clickAll() {
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		return this;
	}
	public IncidentPage clickIncident() {
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		return new IncidentPage(shadow, driver);			
	}

}
