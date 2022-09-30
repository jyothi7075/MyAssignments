package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{
	public EditLeadPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver; 
		
	}
	public EditLeadPage updateCName(String cName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		return this;

	}
	public ViewLeadPage clickUpdate() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
