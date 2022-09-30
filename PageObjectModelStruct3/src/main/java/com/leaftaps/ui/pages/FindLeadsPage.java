package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	public static String leadID;
	
	public FindLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	
	public FindLeadsPage enterPhone(String phoneNumber) {
		driver.findElement(By.xpath(prop2.getProperty("findleadspage.phone"))).click();
		driver.findElement(By.xpath(prop2.getProperty("findleadspage.phonenumber"))).sendKeys(phoneNumber);
		return this;
	}
	public FindLeadsPage clickFindLeads() {
		driver.findElement(By.xpath(prop2.getProperty("findleadspage.findleads"))).click();
		String text = driver.findElement(By.className(prop2.getProperty("findleadspage.text"))).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return this;
	}
	public ViewLeadPage clickFirstResulting() throws InterruptedException {
		Thread.sleep(5000);
		WebElement lead = driver.findElement(By.xpath(prop2.getProperty("findleadpage.lead")));
		leadID = lead.getText();
		lead.click();
		System.out.println(leadID);
		
		return new ViewLeadPage(driver);
	}
	public FindLeadsPage enterLeadId() {
		driver.findElement(By.xpath(prop2.getProperty("findleadspage.enterleadid"))).sendKeys(leadID);
		return this;
	}

}
