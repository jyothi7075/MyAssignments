package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		1.Launch the browser
		ChromeDriver driver=new ChromeDriver();
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
//      Mobile publisher windows handling
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);		
//		3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
//		Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));		
//		Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
//		4. Click  On Resources
		driver.findElement(By.linkText("Resources")).click();
//		5. Select SalesForce Certification Under Learnings
		Shadow dom=new Shadow(driver);		
		dom.findElementByXPath("//span[text()='Learning']").click();		
	    dom.findElementByXPath("//span[text()='Learning on Trailhead']").click();		
//		6. Clilck on Salesforce Certifications		
		WebElement certificate = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();", certificate);
//		6. Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
//		7. Get the Text(Summary) of Salesforce Architect 
		WebElement sArchitect = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div[1]"));
		String summary = sArchitect.getText();
		System.out.println("Summary of Salesforce Architect is: " +summary);
//		8. Get the List of Salesforce Architect Certifications Available
		List<WebElement> list = driver.findElements(By.xpath("//div[text()='Certification']"));
		int sizeofCert = list.size();
		for(int i=1;i<=sizeofCert;i++) {
			String text = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)["+i+"]")).getText();
			System.out.println("List of salesForce Architect certifications are: " +text);
		}
//		9. Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
//		10.Get the List of Certifications available
		List<WebElement> list1 = driver.findElements(By.xpath("//div[text()='Certification']"));
		int size1 = list1.size();
		System.out.println("List of Application Architect certifications are : " +size1);
		for(int j=1; j<=size1; j++) {
			String text1= driver.findElement(By.xpath("(//div[@class='credentials-card_type']/following::div[1]/a)["+j+"]")).getText();
			System.out.println("List of Application Architect Certifications are: " +text1);
		}
	}

}
