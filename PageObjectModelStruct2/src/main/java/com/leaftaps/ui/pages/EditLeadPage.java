package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{
	public EditLeadPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.ID, using="updateLeadForm_companyName")
	private WebElement cname;
	@FindBy(how=How.NAME, using="submitButton")
	private WebElement update;
	public EditLeadPage updateCName(String cName) {
		cname.sendKeys(cName);
		return this;

	}
	public ViewLeadPage clickUpdate() {
		update.click();
		return new ViewLeadPage(driver);
	}

}
