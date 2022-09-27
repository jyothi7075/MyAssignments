package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class DuplicateleadPage extends ProjectSpecificMethods {
	public DuplicateleadPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	public ViewLeadPage clicksubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
