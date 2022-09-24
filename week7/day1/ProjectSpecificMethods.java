package week7.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public String excelFileName;
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String url, String username, String password) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement elementUserName = driver.findElement(By.id("username"));
	elementUserName.sendKeys(username);
	WebElement elementPassword = driver.findElement(By.id("password"));
	elementPassword.sendKeys(password);
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.close();
		
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		String[][] data=ReadExcelData.getData(excelFileName);
		return data;
	}

}
