package com.leaftaps.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
	public static Properties prop2,prop1;
	public RemoteWebDriver driver;
	public String excelFileName;
	@BeforeMethod
	public void beforeMethod() throws IOException {
       prop1=new Properties();
		FileInputStream file=new FileInputStream("./configurations/config.properties");
		prop1.load(file);

		prop2=new Properties();
		FileInputStream file2=new FileInputStream("./configurations/"+prop1.getProperty("language")+".properties");
		prop2.load(file2);
		
		
		if(prop1.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(prop1.getProperty("browser").equalsIgnoreCase("mozilla")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop1.getProperty("url"));
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
