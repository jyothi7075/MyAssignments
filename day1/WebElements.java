package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStation.click();
		fromStation.clear();
		fromStation.sendKeys("MS" , Keys.TAB);
		WebElement toStation=driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStation.clear();
		toStation.sendKeys("PDY" , Keys.TAB);
		WebElement checkBox=driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		checkBox.click();
		driver.findElement(By.xpath("//input[@id='buttonFromTo']")).click();
		List<WebElement> elementRow = driver.findElements(By.xpath("(//table)[3]/tbody/tr"));
		List<WebElement> elementcol = driver.findElements(By.xpath("(//table)[3]/tbody/tr/td"));
		for(int i=1; i<=elementRow.size(); i++) {
			for(int j=1;j<=9;j++) {
		        String text = driver.findElement(By.xpath("(//table)[3]/tbody/tr["+i+"]/td["+j+"]")).getText();
		        System.out.println(text);
			}
			System.out.println();
		}
		

	}

}
