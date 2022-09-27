package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class CreateLeadsPage extends ProjectSpecificMethods{
	
	public CreateLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	public CreateLeadsPage entercname(String cName) {
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys(cName);
		return this;
	}
	public CreateLeadsPage enterfname(String fName) {
		
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys(fName);		
		return this;
	
	}
	public CreateLeadsPage enterlname(String lName) {
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys(lName);
		return this;
	}
	public ViewLeadPage createButton() {
		WebElement createButton = driver.findElement(By.className("smallSubmit"));
		createButton.click();
		return new ViewLeadPage(driver);
		
	}

}
