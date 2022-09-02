package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaarnSnapshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		//open a browser
		ChromeDriver driver=new ChromeDriver();
		//To load an URL
		driver.get("http://leaftaps.com/opentaps");
		//Maximise the browser
		driver.manage().window().maximize();
		//Type "Bags" in the Search box
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement img = driver.findElement(By.tagName("img"));
		// Take Screen shot
		File source = driver.getScreenshotAs(OutputType.FILE);
		// Creating an empty image to store my ss
        File dest=new File("./snaps/Pic001.jpg");
        //Merge the SS with image
        FileUtils.copyFile(source, dest);
        
	}

}
