package week7.day2.stepdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class DuplicateLead extends BaseClass{
	@And("click on Duplicate lead")
	public void clickDuplicate() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@And("click on submit button")
	public void clicksubmit() {
		driver.findElement(By.name("submitButton")).click();
	}
	

}
