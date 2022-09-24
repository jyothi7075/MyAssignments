package week7.day1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends ProjectSpecificMethods {
	@Test(groups="smoke")
	public void runDeleteLead() throws InterruptedException {
		Thread.sleep(3000);
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		WebElement welcomeText = driver.findElement(By.tagName("h2"));
		String text = welcomeText.getText();
		System.out.println(text);
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		//Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Le')]")).click();
		//click first resulting lead
		Thread.sleep(5000);
		WebElement fL=driver.findElement(By.xpath("(//div[@id='ext-gen473']//table//tr//a)[1]"));
		String leadID = fL.getText();
		System.out.println(leadID);
		fL.click();
		//Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(leadID);
		//Click find leads button
		Thread.sleep(5000);
		WebElement findLead = driver.findElement(By.xpath("//button[contains(text(),'Find Le')]"));
		findLead.click();
		Thread.sleep(5000);
		String message = driver.findElement(By.id("ext-gen437")).getText();
		System.out.println(message);
		String compareMessage="No records ";
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		if(message.contains(compareMessage)) {
			System.out.println("Successful deletion " +message);
		}else {
			System.out.println("unsuccessful deletion " +message);
		}

		//Close the browser (Do not log out)
		//driver.close(); 

	}




}
