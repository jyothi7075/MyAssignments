package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//open a browser
		ChromeDriver driver=new ChromeDriver();
		//To load an URL
		driver.get("https://www.leafground.com/");
		//Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Alert']/ancestor::a")).click();
		driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[2]")).click();
		Alert alert=driver.switchTo().alert();
		//Alert confirm dialog
		String text = alert.getText();
		alert.accept();
		System.out.println(text);
		//sweet alert
		driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[3]")).click();
		//		WebElement sweetAlert = driver.findElement(By.tagName("(p)[1]"));
		//		String text2 = sweetAlert.getText();
		//		System.out.println(text2);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		Thread.sleep(3000);
		//		WebElement ModalDialog = driver.findElement(By.xpath("(//p[@class='m-0'])[2]"));
		//		String modalText = ModalDialog.getText();
		//		System.out.println(modalText);
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]")).click();

	}

}
