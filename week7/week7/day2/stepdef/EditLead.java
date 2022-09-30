package week7.day2.stepdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class EditLead extends BaseClass {
	@And("click on edit lead")
	public void clickEdit() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@And("update the company name as {string}")
	public void updateCName(String cname) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
	}

}
