package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://en-gb.facebook.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		dr.findElement(By.linkText("Create New Account")).click();
		WebElement firstName = dr.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("jyo");
		WebElement surName = dr.findElement(By.xpath("//input[@name='lastname']"));
		surName.sendKeys("koy");
		WebElement mobileNum = dr.findElement(By.xpath("//input[@name='reg_email__']"));
		mobileNum.sendKeys("7075");
		WebElement password= dr.findElement(By.id("password_step_input"));
		password.sendKeys("kjkjwi");
		WebElement date=dr.findElement(By.id("day"));
		Select dd1=new Select(date);
		dd1.selectByIndex(4);
		WebElement month=dr.findElement(By.id("month"));
		month.sendKeys("Oct");
		WebElement year=dr.findElement(By.id("year"));
		Select dd2=new Select(year);
		dd2.selectByIndex(6);
		WebElement radioButton=dr.findElement(By.xpath("//input[@value=1]"));
		radioButton.click();		
		}

}
