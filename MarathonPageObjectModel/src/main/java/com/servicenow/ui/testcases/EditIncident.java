package com.servicenow.ui.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.servicenow.ui.pages.LoginPage;

import io.github.sukgu.Shadow;

public class EditIncident extends com.servicenow.ui.base.ServiceNowMethods {
	@BeforeTest
	public void setData() {
		excelFileName="tc002";
	}
	@Test(dataProvider = "sendData")
	public void runEditLead(String username, String password, String urgency, String status, String desc) {
		new LoginPage(shadow, driver).enterCred(username, password)
        .clickLogin()
        .clickAll()
        .clickIncident()
        .clickFirst()
        .update(status, urgency, desc)
        .verifyUpdate();



	}
}
