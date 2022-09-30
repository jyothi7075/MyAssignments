package com.servicenow.ui.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.servicenow.ui.utils.ReadExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowMethods {
	public RemoteWebDriver driver;
	public Shadow shadow;
	public static String text2;
	public String excelFileName;
	@Parameters({"url","browser"})
	@BeforeMethod
	public void beforeMethod(String url, String browser) {
		//1. Launch ServiceNow application
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shadow=new Shadow(driver);
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		return ReadExcelData.getData(excelFileName);
	}

}
