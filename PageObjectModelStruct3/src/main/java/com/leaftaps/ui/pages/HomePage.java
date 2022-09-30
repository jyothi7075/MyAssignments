package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	public LeadsPage leadsClick() {
		WebElement elementCreateLead = driver.findElement(By.linkText(prop2.getProperty("leadspage.createlead")));
		elementCreateLead.click();
		return new LeadsPage(driver);
	
	}

}
