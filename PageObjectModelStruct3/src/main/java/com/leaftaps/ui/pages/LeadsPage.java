
package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods {

	public LeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	
	public CreateLeadsPage clickCreateLead() {
		driver.findElement(By.linkText(prop2.getProperty("leadspage.createlead"))).click();
		return new CreateLeadsPage(driver);
	}
	
	public FindLeadsPage clickFindLeads() {
		driver.findElement(By.linkText(prop2.getProperty("leadspage.findleads"))).click();
		return new FindLeadsPage(driver);
	}


}
