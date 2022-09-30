package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
	}
	public LoginPage enterUsername(String username) {
		driver.findElement(By.id(prop2.getProperty("loginpage.username"))).sendKeys(username);
		return this;
		
		
	}
	public LoginPage enterPassword(String password) {
		WebElement elementPassword = driver.findElement(By.id(prop2.getProperty("loginpage.password")));
		elementPassword.sendKeys(password);
		return this;
		
	}
	public WelcomePage Clicklogin_positive() {
		WebElement elementLogin = driver.findElement(By.className(prop2.getProperty("loginpage.login")));
		elementLogin.click();
		return new WelcomePage(driver);
		
	}
	public LoginPage Clicklogin_negative() {
		WebElement elementLogin = driver.findElement(By.className(prop2.getProperty("loginpage.login")));
		elementLogin.click();
		return this;
	}	

}
