package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
//		Launch the browser
		ChromeDriver driver=new ChromeDriver();
//		https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		2. Go to Mens Fashion
		Actions a=new Actions(driver);		
		WebElement mensFashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		a.moveToElement(mensFashion).perform();
//		3. Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
//		4. Get the count of the sports shoes
		WebElement count = driver.findElement(By.xpath("//h1[@category='Sports Shoes for Men']/following-sibling::span"));
		String sCount = count.getText();
		System.out.println("Shoes Count is: " +sCount);
//		5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
//		6. Sort by Low to High
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
//		7. Check if the items displayed are sorted correctly
//		8.Select the price range (900-1200)
		WebElement fromValue = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("900");
		WebElement toValue = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='toVal']"));
		toValue.clear();
		toValue.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
//		9.Filter with color Navy 
//		driver.findElement(By.linkText(" Navy")).click();		
//		10 verify the all applied filters 
		
//		11. Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-listing')])[1]"));
		driver.executeScript("arguments[0].click();", firstResult);
        //WebElement firstResult = driver.findElement(By.xpath(" (//div[contains(text(),'Quick View')])[1]"));
//		12. click QuickView button
        a.moveToElement(firstResult).perform();
        Thread.sleep(5000);
        //facing element click interceptor exception
        driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
//		13. Print the cost and the discount percentage
        String cost = driver.findElement(By.xpath("(//div[contains(text(),'Price')])[1]/following::div[1]/div[2]/span[1]")).getText();
        System.out.println("cost of the product is: " +cost);
        String discount = driver.findElement(By.xpath("(//div[contains(text(),'Price')])[1]/following::div[1]/div[2]/span[2]")).getText();
        System.out.println("discount of the product is: " +discount);
//		14. Take the snapshot of the shoes.
        File source = driver.getScreenshotAs(OutputType.FILE);
		// Creating an empty image to store my ss
        File dest=new File("./snaps/Pic002.jpg");
        //Merge the SS with image
        FileUtils.copyFile(source, dest);
//		15. Close the current window
        driver.close();
//		16. Close the main window
        driver.quit();
	}

}
