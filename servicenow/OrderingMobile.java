package tescases.servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="tc002";
	}
    @Test(dataProvider="sendData")
	public void mobile(String username, String password, String colour, String size) {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("(//div[text()='Service Catalog'])[1]")).click();
		Shadow dom=new Shadow(driver);
		WebElement iframe = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		WebElement mobile = driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]"));
		mobile.click();
		dom.findElementByXPath("//a[contains(text(),'Apple iPhone 6')]").click();
		//driver.findElement(By.xpath("(//table[@aria-label='Apple iPhone 6s']//select)[2]//option[text()='Rose Gold']")).click();
		WebElement dd = driver.findElement(By.xpath("(//table[@aria-label='Apple iPhone 6s']//select)[2]"));
		Select s=new Select(dd);
		s.selectByVisibleText(colour);
		WebElement storage = driver.findElement(By.xpath("(//table[@aria-label='Apple iPhone 6s']//select)[3]"));
		Select s1=new Select(storage);
		s1.selectByValue(size);
		driver.findElement(By.xpath("//button[@aria-label='Order Now']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String orderSummary = driver.findElement(By.xpath("//div[@class='order_summary']/div/span")).getText();
		if(orderSummary.contains("Thank you")) {
			System.out.println("Order placed successfully: " +orderSummary);
		}
		String requestId = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request Number is: " +requestId);
		
	}

}
