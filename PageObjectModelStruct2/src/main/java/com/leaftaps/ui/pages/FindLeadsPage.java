package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	public static String leadID;
	
	public FindLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH, using="//span[text()='Phone']")
	private WebElement phone;
	@FindBy(how=How.XPATH, using="//input[@name='phoneNumber']")
	private WebElement number;
	@FindBy(how=How.XPATH, using="//button[text()='Find Leads']")
	private WebElement findLeads;
	@FindBy(how=How.XPATH, using="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement lead;
	@FindBy(how=How.XPATH, using="//input[@name='id']")
	private WebElement enterLead;
	
	public FindLeadsPage enterPhone(String phoneNumber) {
		phone.click();
		number.sendKeys(phoneNumber);
		return this;
	}
	public FindLeadsPage clickFindLeads() {
		findLeads.click();
		return this;
	}
	public ViewLeadPage clickFirstResulting() throws InterruptedException {
		Thread.sleep(3000);
		leadID = lead.getText();
		System.out.println(lead.getText());		
		lead.click();
		return new ViewLeadPage(driver);
	}
	public FindLeadsPage enterLeadId() {
		enterLead.sendKeys(leadID);
		return this;
	}

}
