package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        ChromeDriver dr=new ChromeDriver();
        dr.get("http://leaftaps.com/opentaps/control/login");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement elementUserName = dr.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		WebElement elementPassword = dr.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = dr.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		WebElement elementLink = dr.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		dr.findElement(By.linkText("Contacts")).click();
		// Click on Merge Contacts using Xpath Locator
		dr.findElement(By.linkText("Merge Contacts")).click();
		//Click on Widget of From Contact
		String windowHandle = dr.getWindowHandle();
		dr.switchTo().window(windowHandle);
		dr.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		//Click on First Resulting Contact
		Thread.sleep(6000);
		Set<String> windowHandles = dr.getWindowHandles();
		//System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
//		dr.manage().window().maximize();
		System.out.println(dr.getTitle());		
		dr.switchTo().window(list.get(1));
		System.out.println(dr.getTitle());
		dr.findElement(By.xpath("//div[@id='ext-gen247']/div[1]/table/tbody/tr/td[1]/div/a")).click();
		//Click on Widget of To Contact
		dr.switchTo().window(list.get(0));
		String windowHandle1 = dr.getWindowHandle();
		dr.switchTo().window(windowHandle1);
		dr.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
	    Set<String> windowHandles2 = dr.getWindowHandles();
	    List<String> list2=new ArrayList<String>(windowHandles2);
	    dr.switchTo().window(list2.get(1));
	    dr.findElement(By.xpath("//div[@id='ext-gen247']/div[2]/table//td[1]/div/a")).click();
	    //Click on Merge button using Xpath Locator
	    dr.switchTo().window(list2.get(0));
	    dr.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	    //Accept the Alert
	    Alert alert = dr.switchTo().alert();
	    alert.accept();
	    WebDriver defaultContent = dr.switchTo().defaultContent();
	    // Verify the title of the page
	    System.out.println("Title of the page: " +dr.getTitle());
	}       
	

}
