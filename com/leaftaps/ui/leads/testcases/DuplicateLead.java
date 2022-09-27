package com.leaftaps.ui.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class DuplicateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName="tc003";
	}
	
	@Test(dataProvider="sendData")
	public void runDuplicateLead(String username, String password, String phone) throws InterruptedException {
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password)
		.Clicklogin_positive()
		.clickCRMSFA()
		.leadsClick()
		.clickFindLeads()
		.enterPhone(phone)
		.clickFindLeads()
		.clickFirstResulting()
		.clickDuplicate()
		.clicksubmit();
	}

}
