package com.leaftaps.ui.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.leaftaps.ui.utils.*;

public class ProjectSpecificMethods {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	@Parameters({"url","browser"})
	@BeforeMethod
	public void beforeMethod(String url, String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("mozilla")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	
	  @AfterMethod
	  public void afterMethod() { 
		  driver.close();
	  }
	 
	@DataProvider
	public String[][] sendData() throws IOException {
		return com.leaftaps.ui.utils.ReadExcelData.getData(excelFileName);
	}
	



}
