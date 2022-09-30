
package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods {

	public LeadsPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how=How.LINK_TEXT, using="Create Lead")
	private WebElement createLead;
	@FindBy(how=How.LINK_TEXT, using="Find Leads")
	private WebElement findLeads;
	
	public CreateLeadsPage clickCreateLead() {
		createLead.click();
		return new CreateLeadsPage(driver);
	}

	public FindLeadsPage clickFindLeads() {
		findLeads.click();
		return new FindLeadsPage(driver);
	}

}
