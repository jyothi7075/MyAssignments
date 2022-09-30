package com.servicenow.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.ui.base.ServiceNowMethods;

import io.github.sukgu.Shadow;

public class IncidentPage extends ServiceNowMethods {
	public static String text;
	public IncidentPage(Shadow recievedShadow, RemoteWebDriver receivedDriver ) {
		this.shadow=recievedShadow; 
		this.driver=receivedDriver;
		
	} 
	
	public CreateIncidentPage clickNew() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		return new CreateIncidentPage(shadow, driver);

	}
	public IncidentPage verify() {
		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
		return this;
	}
	public IncidentPage confirm() {

		WebElement eleFrame3 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame3);
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 
		return this;
	}
	public CreateIncidentPage clickFirst() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement inc = driver.findElement(By.xpath("(//th[@name='number']/following::a[@class='linked formlink'])[1]"));
		text = inc.getText();
		System.out.println(text);
		inc.click();
		return new CreateIncidentPage(shadow, driver);
	}
	public IncidentPage verifyDelete() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(text, Keys.ENTER);
		
		return this;
	}
	public IncidentPage verifyUpdate() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(text, Keys.ENTER);
		String update = driver.findElement(By.xpath("(//th[@name='number']/following::td[@class='vt'])/a")).getText();	
		System.out.println("updated " +update);
        return this;
	}

}
