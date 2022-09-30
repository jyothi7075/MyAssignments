package week7.day2.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass  {
	
	@And("click on leads and find leads")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@And("click on phone and enter phone number as {string}")
	public void clickPhone(String phone) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
	}
	@And("click on find leads button")
	public void clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And("Capture lead ID of First Resulting lead and click")
	public void firstResult() throws InterruptedException {
		Thread.sleep(10000);
		WebElement lead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		leadID = lead.getText();
		System.out.println(leadID);
		lead.click();
	}
	@And("click Delete")
	public void clickDelete() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.linkText("Delete")).click();
	}
	@And("Click Find leads and Enter captured lead ID")
	public void FindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	@And("Click find leads button")
	public void click() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And("verify message")
	public void verifyMessage() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}

}
