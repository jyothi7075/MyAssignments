package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelenium {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		WebElement welcomeText = driver.findElement(By.tagName("h2"));
		String text = welcomeText.getText();
		System.out.println(text);
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys("TCS");
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys("Koyyani");
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys("Jyothi");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		source.sendKeys("Cold Call");
		//By Index
		Select dd =new Select(source);
		dd.selectByIndex(1);
		//By VisibleText
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd1=new Select(industry);
		dd1.selectByVisibleText("Aerospace");
		//select by value
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd2=new Select(ownership);
		dd2.selectByValue("OWN_PROPRIETOR");
		WebElement createButton = driver.findElement(By.className("smallSubmit"));
		createButton.click();
	
		
		
		
		
		//driver.close();

	}

}
