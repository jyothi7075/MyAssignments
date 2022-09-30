package com.servicenow.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.servicenow.ui.base.ServiceNowMethods;

import io.github.sukgu.Shadow;

public class LoginPage extends ServiceNowMethods {
	
	public LoginPage(Shadow recievedShadow, RemoteWebDriver receivedDriver) {
		this.shadow=recievedShadow;		
		this.driver=receivedDriver;
	}
	
	public LoginPage enterCred(String username, String password) {
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		return this;
	}
	public HomePage clickLogin() {
		driver.findElement(By.id("sysverb_login")).click();
		return new HomePage(shadow, driver);
	}

}
	
