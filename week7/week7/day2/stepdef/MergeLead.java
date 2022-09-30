package week7.day2.stepdef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class MergeLead extends BaseClass {
	public static List<String> allhandles;
	public static List<String> allhandles2;
	@And ("click on Merge Leads")
	public void clickMerge() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@And("click on first widget")
	public void firstWidget() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
	@And("handle the windows")
	public void handleWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}
	@And("enter first name")
	public void enterfname() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hari");
	}
		
	@And("click second widget")
	public void secondWidget() throws InterruptedException {
		driver.switchTo().window(allhandles.get(0));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	@And("handle the child window")
	public void handleChildWindow() {
		Set<String> allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}
	@And("enter name")
	public void enterName() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("babu");
	}
	@And("back to parent window")
	public void parentWindow() {
		driver.switchTo().window(allhandles2.get(0));
		
	}
	
	

}
