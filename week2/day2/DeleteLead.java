package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		WebElement welcomeText = driver.findElement(By.tagName("h2"));
		String text = welcomeText.getText();
		System.out.println(text);
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("12345678");
		//Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Le')]")).click();
		//click first resulting lead
		Thread.sleep(5000);
		WebElement fL=driver.findElement(By.xpath("(//div[@id='ext-gen473']//table//tr//a)[1]"));
		String leadID = fL.getText();
		System.out.println(leadID);
		fL.click();
		//Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(leadID);
		//Click find leads button
		Thread.sleep(5000);
		WebElement findLead = driver.findElement(By.xpath("//button[contains(text(),'Find Le')]"));
		findLead.click();
		Thread.sleep(5000);
		String message = driver.findElement(By.id("ext-gen437")).getText();
		System.out.println(message);
		String compareMessage="No records ";
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		if(message.contains(compareMessage)) {
			System.out.println("Successful deletion " +message);
		}else {
			System.out.println("unsuccessful deletion " +message);
		}
		
		//Close the browser (Do not log out)
		//driver.close(); 
		
	}

}
