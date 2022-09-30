package com.servicenow.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.ui.base.ServiceNowMethods;

import io.github.sukgu.Shadow;

public class CreateIncidentPage extends ServiceNowMethods {
	public CreateIncidentPage(Shadow recievedShadow, RemoteWebDriver receivedDriver ) {
		this.shadow=recievedShadow; 
		this.driver=receivedDriver;
		
	} 
	public IncidentPage clickSubmit(String description) {
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number: "+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys(description);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		return new IncidentPage(shadow, driver);
	}
	public IncidentPage delete() {
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		return new IncidentPage(shadow, driver);
	}
	public IncidentPage update(String status, String urgency, String desc) {
		WebElement sel = driver.findElement(By.name("incident.urgency"));
		Select s=new Select(sel);
		s.selectByValue(urgency);
		WebElement state = driver.findElement(By.name("incident.state"));
		Select s1=new Select(state);
		s1.selectByValue(status);

		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys(desc);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		return new IncidentPage(shadow, driver);
	}
}
