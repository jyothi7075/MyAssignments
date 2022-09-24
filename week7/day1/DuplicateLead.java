package week7.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends ProjectSpecificMethods {
	@Test(groups="smoke")
	public void runDuplicateLead() {
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
		WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		elementFirstNameLocal.sendKeys("Pko");
		WebElement elementDepartment = driver.findElement(By.id("createLeadForm_departmentName"));
		elementDepartment.sendKeys("EEE");
		WebElement elementDescription = driver.findElement(By.id("createLeadForm_description"));
		elementDescription.sendKeys("Creating the lead form with my details");
		WebElement elementEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		elementEmail.sendKeys("jyothieee04@gmail.com");
		WebElement elementState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd= new Select(elementState);
		dd.selectByVisibleText("New York");
		WebElement createButton = driver.findElement(By.className("smallSubmit"));
		createButton.click();
		String title = driver.getTitle();
		System.out.println("Title of the resulting page is :"+ title);
		WebElement duplicateLead = driver.findElement(By.linkText("Duplicate Lead"));
		duplicateLead.click();
		WebElement clearCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		clearCompanyName.clear();
		clearCompanyName.sendKeys("CTS");
		WebElement clearFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		clearFirstName.clear();
		clearFirstName.sendKeys("Koy");
		WebElement createLeadButton = driver.findElement(By.className("smallSubmit"));
		createLeadButton.click();
		String title1 = driver.getTitle();
		System.out.println("Title of the duplicate resulting page is :"+ title1);


	}

}
