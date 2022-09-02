package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministrationCertifications {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//		1.Launch the browser
		ChromeDriver driver=new ChromeDriver(option);
//		2.Load the url as https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();		
//		3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);	
//		Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));		
//		4. Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
//		5. Click Resources and mouse hover on Learning On Trailhead
		driver.findElement(By.linkText("Resources")).click();		
		Shadow dom=new Shadow(driver);		
		dom.findElementByXPath("//span[text()='Learning']").click();		
	    dom.findElementByXPath("//span[text()='Learning on Trailhead']").click();		
//		6. Clilck on Salesforce Certifications
		Thread.sleep(2000);		
		WebElement certificate = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();", certificate);
		
//		WebElement certifi = dom.findElementByXPath("//a[text()='Salesforce Certification']");
//      builder.scrollToElement(certifi).perform();
//      builder.click(certifi).perform();
		
//		6. Click on Ceritification Administrator
    	driver.findElement(By.linkText("Administrator")).click();
		
//		7. Navigate to Certification - Administrator Overview window
    	driver.findElement(By.linkText("Administrator")).click();
//		8. Verify the Certifications available for Administrator Certifications should be displayed
    	List<WebElement> list = driver.findElements(By.xpath("//div[text()='Certification']"));
    	System.out.println("Number of certifications available: "+list.size());
    	
    			

	}

}
