
package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods {

	public LeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	
	public CreateLeadsPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadsPage(driver);
	}
	
	public FindLeadsPage clickFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadsPage(driver);
	}
	
	public MergeLeadsPage clickMergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLeadsPage(driver);
	}

}
