package com.leaftaps.ui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	
	public static String leadID1;
	public List<String> allhandles;
	public List<String> allhandles2;
	
	public FindLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		
	}
	
	public FindLeadsPage enterPhone(String phoneNumber) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		return this;
	}
	public FindLeadsPage clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public ViewLeadPage clickFirstResulting() throws InterruptedException {
		Thread.sleep(3000);
		WebElement lead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		Thread.sleep(5000);
		leadID = lead.getText();
		System.out.println(lead.getText());		
		lead.click();
		return new ViewLeadPage(driver);
	}
	public FindLeadsPage enterLeadId() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;
	}
	public FindLeadsPage enterFirstName() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public MergeLeadsPage clickresult() throws InterruptedException {
		Thread.sleep(1000);
		leadID1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
		return new MergeLeadsPage(driver);
		
	}
	public FindLeadsPage enterFromFirstName() throws InterruptedException {
		Set<String> allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public MergeLeadsPage clickFromResult() throws InterruptedException {
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
		return new MergeLeadsPage(driver);
		
	}
	public FindLeadsPage enterLeadIdMerge() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public FindLeadsPage verifyMerge() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return this;
	}

}
