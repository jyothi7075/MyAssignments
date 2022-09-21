package marathon.stepsdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class EditIncident {
	RemoteWebDriver driver;
	Shadow shadow;
	public String text;

	/*
	 * @Given("Launch ServiceNow application") public void openBrowser() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.get("https://dev135016.service-now.com/");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); }
	 */
	@And("Search for the existing incident and click on the incident")
	public void searchIncidents() throws InterruptedException {
		shadow=new Shadow(driver);
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement inc = driver.findElement(By.xpath("(//th[@name='number']/following::td[@class='vt'])[1]/a"));
		inc.click();
		text = inc.getText();
		System.out.println(text);
		
	}
	@And("Update the incident with Urgency as High and State as In Progress")
	public void update() {
		WebElement sel = driver.findElement(By.name("incident.urgency"));
		Select s=new Select(sel);
		s.selectByValue("1");
		WebElement state = driver.findElement(By.name("incident.state"));
		Select s1=new Select(state);
		s1.selectByValue("2");

		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("Edited via automation");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@And("Verify the update information")
	public void verifyEdit() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(text, Keys.ENTER);
		WebElement verify = driver.findElement(By.xpath("//table[@id='incident_table']//tbody/tr/td[7]"));
		String text2 = verify.getText();
		System.out.println(text2);
		if(text2.contains("In Progress")) {
			System.out.println("update info is available") ;


		}
	}

}
