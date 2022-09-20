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

public class CreateNewCaller extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="tc003";
	}
	@Test(dataProvider="sendData")
	public void caller(String username, String password, String fname, String lname) {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.id("filter")).sendKeys("Callers");
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("sys_user.first_name")).sendKeys(fname);
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lname);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		WebElement sel = driver.findElement(By.xpath("//select[@role='listbox']"));
		Select s=new Select(sel);
		s.selectByValue("first_name");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Jyothi", Keys.ENTER);
		List<WebElement> elementRow = driver.findElements(By.xpath("//table[@id='sys_user_table']//tbody/tr"));
		List<WebElement> elementCol = driver.findElements(By.xpath("//table[@id='sys_user_table']//tbody/tr/td"));
		for(int i=1; i<=elementRow.size(); i++) {
			for(int j=1; j<=6; j++) {
				String text = driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody/tr["+i+"]/td["+j+"]")).getText();
				if(text.contains("Jyothi")){
					System.out.println("New Caller created");
				}
			}
			
		}



	}

}
