package com.servicenow.ui.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.servicenow.ui.base.ServiceNowMethods;
import com.servicenow.ui.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateIncident extends ServiceNowMethods {
    @BeforeTest
    public void setData() {
    	excelFileName="tc001";
    }
	@Test(dataProvider = "sendData")
	public void runCreateLead(String username, String password, String description) throws InterruptedException {
          new LoginPage(shadow, driver).enterCred(username, password)
          .clickLogin()
          .clickAll()
          .clickIncident()
          .clickNew()
          .clickSubmit(description)
          .verify()
          .confirm();
	}		
}


