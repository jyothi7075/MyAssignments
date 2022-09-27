package com.leaftaps.ui.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class MergeLead extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="Merge tc";
	}
	@Test(dataProvider = "sendData")
	public void runMergeLead(String username, String password) throws InterruptedException {
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password)
		.Clicklogin_positive()
		.clickCRMSFA()
		.leadsClick()
		.clickMergeLead()
		.fromLead()
		.enterFirstName()
		.clickresult()
		.toLead()
		.enterFromFirstName()
		.clickFromResult()
		.clickMerge()
		.clickFindLeads()
		.enterLeadIdMerge()
		.verifyMerge();
		
	}

}
