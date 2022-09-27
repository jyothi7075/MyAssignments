package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MergeLeadsPage extends ProjectSpecificMethods{
	
	public MergeLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	public FindLeadsPage fromLead() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		return new FindLeadsPage(driver);
	}
	public FindLeadsPage toLead() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		return new FindLeadsPage(driver);
	}
	public LeadsPage clickMerge() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		return new LeadsPage(driver);
	}

}
