package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	public ViewLeadPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	public ViewLeadPage getLeadId() {
		System.out.println(driver.findElement(By.id("viewLead_companyName_sp")).getText());
		return this;
	}
	public EditLeadPage clickEdit() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	public LeadsPage clickDelete() {
		driver.findElement(By.linkText("Delete")).click();
		return new LeadsPage(driver);
	}
	public DuplicateleadPage clickDuplicate() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateleadPage(driver);
	}

}
