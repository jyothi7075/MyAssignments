package com.leaftaps.ui.leads.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="tc002";
	}
	@Test(dataProvider = "sendData")
	public void runEditLead(String username, String password,String phoneNumber, String cName) throws InterruptedException {
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password)
		.Clicklogin_positive()
		.clickCRMSFA()
		.leadsClick()
		.clickFindLeads()
		.enterPhone(phoneNumber)
		.clickFindLeads()
		.clickFirstResulting()
		.clickEdit()
		.updateCName(cName)
		.clickUpdate();		
		
	}
	


}
