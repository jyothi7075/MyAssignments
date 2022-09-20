package tescases.servicenow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public String excelFileName;
	public ChromeDriver driver;
	@Parameters("url")
	@BeforeMethod
	public void beforeMethod(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@DataProvider
	public String[][] sendData() throws IOException{
		String[][] data=ReadExcelData.getData(excelFileName);
		return data;
	}

}
