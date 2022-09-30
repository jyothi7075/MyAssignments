package week7.day2.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{	
	@Given("Login with valid credentials username as {string} and password as {string}")
	public void login(String username, String password) {
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys(username);
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		WebElement welcomeText = driver.findElement(By.tagName("h2"));
		String text = welcomeText.getText();
		System.out.println(text);
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}
	@And("click on create lead")
	public void createLead() {
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
	}
	@And("enter company name as {string} first name as {string} and last name as {string}")
	public void details(String cname, String fname, String lname) {
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys(cname);
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys(fname);
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys(lname);
	}
	@Then("click submit button")
	public void submit() {
		WebElement createButton = driver.findElement(By.className("smallSubmit"));
		createButton.click();
	}
	

}
