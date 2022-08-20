package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {

			public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps");
			driver.manage().window().maximize();
			WebElement elementUserName = driver.findElement(By.xpath("//input[@name='USERNAME']"));
			elementUserName.sendKeys("Demosalesmanager");
			WebElement elementPassword = driver.findElement(By.xpath("//input[@name='PASSWORD']"));
			elementPassword.sendKeys("crmsfa");
			WebElement elementLogin = driver.findElement(By.xpath("//input[@type='submit']"));
			elementLogin.click();
			WebElement welcomeText = driver.findElement(By.tagName("h2"));
			String text = welcomeText.getText();
			System.out.println(text);
			WebElement elementLink = driver.findElement(By.xpath("//a[contains(text() , 'CRM/SF')]"));
			elementLink.click();
			WebElement elementCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lea')]"));
			elementCreateLead.click();
			WebElement elementCompanyName = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
			elementCompanyName.sendKeys("TCS");
			WebElement elementLastName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
			elementLastName.sendKeys("Koyyani");
			WebElement elementFirstName = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
			elementFirstName.sendKeys("Jyothi");
			WebElement createButton = driver.findElement(By.xpath("//input[@name='submitButton']"));
			createButton.click();

	}

}
