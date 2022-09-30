package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class CreateLeadsPage extends ProjectSpecificMethods{
	
	public CreateLeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(how=How.ID, using="createLeadForm_companyName")
	private WebElement elementCompanyName;
	
	@FindBy(how=How.ID, using="createLeadForm_firstName")
	private WebElement elementFirstName;
	
	@FindBy(how=How.ID, using="createLeadForm_lastName")
	private WebElement elementLastName;
	
	@FindBy(how=How.CLASS_NAME, using="smallSubmit")
    private WebElement createButton;
	
	public CreateLeadsPage entercname(String cName) {
		elementCompanyName.sendKeys(cName);
		return this;
	}
	public CreateLeadsPage enterfname(String fName) {
		elementFirstName.sendKeys(fName);		
		return this;	
	}
	public CreateLeadsPage enterlname(String lName) {
		elementLastName.sendKeys(lName);
		return this;
	}
	public ViewLeadPage createButton() {
		createButton.click();
		return new ViewLeadPage(driver);
		
	}

}
