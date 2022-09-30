package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods{
	
	public WelcomePage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver; 
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.LINK_TEXT, using="CRM/SFA")
	private WebElement elementLink;
	@FindBy(how=How.CLASS_NAME, using="decorativeSubmit")
	private WebElement elementLogin;
	
	public HomePage clickCRMSFA() {
		elementLink.click();
		return new HomePage(driver);
		
	}
	public LoginPage clickLogout() {
		 elementLogin.click();
		 return new LoginPage(driver);
	}

}
