package tescases.servicenow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewProposal extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName="tc004";
	}
	@Test(dataProvider="sendData")
	public void proposal(String username, String password, String desc, String name) throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.id("filter")).sendKeys("Proposal");
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("//input[@aria-label='Template description']")).sendKeys(desc);
		driver.findElement(By.xpath("//input[@aria-label='Template name']")).sendKeys(name);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		WebElement sel = driver.findElement(By.xpath("//select[@role='listbox']"));
		Select s=new Select(sel);
		s.selectByValue("state");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("New", Keys.ENTER);
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']//tr"));
		List<WebElement> col = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']//tr/td"));
		for(int i=1; i<row.size()-1; i++) {
			for(int j=1; j<=9; j++) {
				String text = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']//tr["+i+"]/td["+j+"]")).getText();
				if(text.contains("Selenium")) {
					System.out.println("New Proposal is created");
				}
			}
		}
		
		
	}

}
