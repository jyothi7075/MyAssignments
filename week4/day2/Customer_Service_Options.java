package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customer_Service_Options {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the browser
		ChromeDriver driver=new ChromeDriver(options);
		//	1. Launch Salesforce application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();		
		//	3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();	    
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);	
//		Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));		
//		Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//	4. Clilck on Products and Mousehover on Service 
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Products']").click();
		Actions a=new Actions(driver);
		WebElement mouseHover = dom.findElementByXPath("//span[contains(text(),'Service')]");
		a.moveToElement(mouseHover).perform();
		Thread.sleep(5000);
		//	5. Click on Customer Services
		dom.findElementByXPath("//a[text()='Customer Service']").click();
		//	6. Get the names Of Services Available 
		List<WebElement> list = driver.findElements(By.xpath("//a[text()='Customer Service']/following::ul[1]/li/a"));
		int size = list.size();
		System.out.println("Size of list is: " +size);
		for(int i=1; i<=size; i++) {
			String text = driver.findElement(By.xpath("(//a[text()='Customer Service']/following::ul[1]/li/a)["+i+"]")).getText();
			System.out.println("Services available are: " +text);
		}
		//	7. Verify the title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " +title);
	}
}
