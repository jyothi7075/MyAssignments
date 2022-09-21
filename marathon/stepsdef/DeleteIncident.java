package marathon.stepsdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident {
	RemoteWebDriver driver;
	Shadow shadow;
	public String text;	
	@And("Delete the incident")
	public void delete() {
		shadow=new Shadow(driver);
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement inc = driver.findElement(By.xpath("(//th[@name='number']/following::a[@class='linked formlink'])[1]"));
		inc.click();
		text = inc.getText();
		System.out.println(text);
		
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
	}
	@And("Verify the deleted incident")
	public void verifyDelete() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(text, Keys.ENTER);
		WebElement records = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']"));
		String display = records.getText();
		System.out.println(display);
		if(display.contains("No")) {
			System.out.println("deletion successful");
		}
	}
}
