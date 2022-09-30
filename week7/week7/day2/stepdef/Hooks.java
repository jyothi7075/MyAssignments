package week7.day2.stepdef;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	
	@Before
	public void preConditions() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
	}
	@After
	public void postConditions() {
		driver.close();
	}
	

}
