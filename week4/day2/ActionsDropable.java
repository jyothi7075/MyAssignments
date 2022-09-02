package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDropable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//open a browser
		ChromeDriver driver=new ChromeDriver();
		//To load an URL
		driver.get("https://jqueryui.com/droppable/");
		//Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement elementDraggable = driver.findElement(By.id("draggable"));
	    WebElement elementDroppable = driver.findElement(By.id("droppable"));
	    Actions builder=new Actions(driver);
	    builder.dragAndDrop(elementDraggable, elementDroppable).perform();
	    System.out.println("Dropped");

	}

}
