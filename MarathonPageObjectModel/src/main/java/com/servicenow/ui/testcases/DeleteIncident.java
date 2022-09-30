package com.servicenow.ui.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;
import com.servicenow.ui.base.ServiceNowMethods;
import com.servicenow.ui.pages.LoginPage;

public class DeleteIncident extends ServiceNowMethods{
	@BeforeTest
	public void setData() {
		excelFileName="tc003";
	}
	@Test(dataProvider = "sendData")
	public void runDeleteLead(String username, String password) {
		  new LoginPage(shadow, driver).enterCred(username, password)
          .clickLogin()
          .clickAll()
          .clickIncident()
          .clickFirst()
          .delete()
          .verifyDelete();

	}

}

