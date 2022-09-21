package marathon.stepsdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateIncident {
    
	RemoteWebDriver driver;
	 public Shadow shadow;
	 public String text2;
	@Given("chrome browser is opened")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	@And("Load the application URL")
	public void loadUrl() {
		driver.get("https://dev135016.service-now.com/");
	}
	@And("maximise and set the timeout")
	public void maxAndTimeout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}
	@And("Login with valid credentials username as {string} and password as {string}")
	public void enterUserName(String username, String password) {
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
	}
	@And("click All")
	public void clickAll() {
	shadow=new Shadow(driver);
	shadow.setImplicitWait(20);
	shadow.findElementByXPath("//div[text()='All']").click();
	}
	@And("Click  Incidents in Filter navigator")
	public void clickIncidents() {
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Incidents']").click();			
	}
	@And("Click on Create new option and fill the mandatory fields")
	public void createNew() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Incident Number: "+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via automation");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
	}
	@And("Verify the newly created incident")
	public void verify() {
		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
	}
	@And("Confirm incident exists")
	public void confirm() {
		WebElement eleFrame3 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame3);
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text);
	}
	
	
}	