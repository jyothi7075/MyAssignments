package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	public ViewLeadPage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(how=How.ID, using="viewLead_companyName_sp")
	private WebElement leadID;
	
	@FindBy(how=How.LINK_TEXT, using="Edit")
	private WebElement edit;
	
	@FindBy(how=How.LINK_TEXT, using="Delete")
	private WebElement delete;
	
	
	public ViewLeadPage getLeadId() {
		leadID.getText();
		return this;
	}
	public EditLeadPage clickEdit() {
		edit.click();
		return new EditLeadPage(driver);
	}
	public LeadsPage clickDelete() {
		delete.click();
		return new LeadsPage(driver);
	}


}
