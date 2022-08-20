package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Jyothi");
		driver.findElement(By.id("ext-gen334")).click();
		//driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@id='ext-gen473']//table//tr//div/a)[1]")).click();		
		String title = driver.getTitle();
		System.out.println("title of  resulting page :" +title);
		driver.findElement(By.linkText("Edit")).click();
		String pageTitle="opentaps CRM";
		if(title.contains(pageTitle)) {
			System.out.println("Expected title is displayed " +title);
		}
		else {
			System.out.println("Expected title is not displayed");
		}
		WebElement companyNameUpdate = driver.findElement(By.id("updateLeadForm_companyName"));
		companyNameUpdate.clear();
		companyNameUpdate.sendKeys("TCS");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//Confirm the changed name appears
		WebElement newCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println(newCompanyName.getText());
		driver.close();
		
	}
}
