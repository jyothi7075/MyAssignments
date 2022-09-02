package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//open a browser
		ChromeDriver driver=new ChromeDriver();
		//To load an URL
		driver.get("https://leafground.com/window.xhtml");
		//Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']/ancestor::button")).click();
		String windowHandle = driver.getWindowHandle();
		//driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		String title = driver.getTitle();
		if(title.contentEquals("Dashboard")){
			System.out.println("New Window opens");
		}
		driver.close();
		driver.switchTo().window(list.get(0));
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']/ancestor::button")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles1);
		System.out.println("Number of tabs opened: "+list.size());
		
				
		//Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']/ancestor::button")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(windowHandles2);
		System.out.println(windowHandles2.size());
		//driver.switchTo().window(windowHandle);
		for (String eachHandle : list2) {
			driver.switchTo().window(eachHandle);
			if(!driver.getTitle().equals("Window"))
			driver.close();
		}
		
		//System.out.println("Number of opened windows :" +list2.size());
		driver.switchTo().window(list2.get(0));
		System.out.println("Closed all windows except primary: " +driver.getTitle());
		
		//Wait for two new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']/ancestor::button")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));			
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(windowHandles3);
		System.out.println(list3.size());
		}
	
	

}
