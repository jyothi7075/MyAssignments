package tescases.servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillMandateFields extends ProjectSpecificMethods {

	@BeforeTest()
    public void setData() {
    	excelFileName="tc001";
    }
	@Test(dataProvider="sendData")
	public void fields(String username, String password) throws InterruptedException {
		//		2. Login with valid credentials		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		//		3. Enter Knowledge  in filter navigator and press enter
		/*
		 * WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		 * filter.click(); filter.sendKeys("Knowledge",Keys.ARROW_DOWN,Keys.ENTER);
		 */

		WebElement knowledge = driver.findElement(By.xpath("(//div[text()='Knowledge'])[1]"));
		driver.executeScript("arguments[0].click();", knowledge);
		//		4. Create new Article 
		driver.switchTo().frame("gsft_main");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@data-original-title='Create an Article']")).click();		
		//		5.Select knowledge base as IT and category as IT- java and Click Ok
		driver.findElement(By.xpath("//input[@data-name='kb_knowledge_base']")).sendKeys("IT", Keys.ENTER);
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@data-name='kb_category']")).sendKeys("Java");
		driver.findElement(By.id("lookup.kb_knowledge.kb_category")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.xpath("(//button[@id='ok_button'])")).click();
		//      6.Update the other mandatory fields
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("This is for automation purpose");
		//		7.Select the submit option		
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();


	}

}
