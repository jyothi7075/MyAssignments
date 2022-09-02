package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		1.Launch the browser
		ChromeDriver driver=new ChromeDriver();
//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		2) Mouseover on Brands and Search L'Oreal Paris
        Actions a= new Actions(driver);
        WebElement brands = driver.findElement(By.xpath("//div[@id='brand_arrowUp']/ancestor::li/a"));
        a.moveToElement(brands).perform();
        driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");        
//		3) Click L'Oreal Paris
        driver.findElement(By.linkText("L'Oreal Paris")).click();
//      4) Check the title contains L'Oreal Paris(Hint-GetTitle)
        String lTitle = driver.getTitle();
        if(lTitle.contains("L'Oreal Paris")) {
        	System.out.println(lTitle);
        }      
//		5) Click sort By and select customer top rated
        driver.findElement(By.xpath("//span[contains(text(), 'popularity')]")).click();
        driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']/div[2]")).click();
//		6) Click Category and click Hair->Click haircare->Shampoo
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
        driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
//		7) Click->Concern->Color Protection
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[2]")).click();
//		8)check whether the Filter is applied with Shampoo
//		9) Click on L'Oreal Paris Colour Protect Shampoo      
        String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
        driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect ')]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> l=new ArrayList<String>(windowHandles);
        driver.switchTo().window(l.get(1));
//		10) GO to the new window and select size as 360ml
        WebElement dropDown = driver.findElement(By.xpath("//select[@title='SIZE']"));
        Select s=new Select(dropDown);
        s.selectByIndex(2);
//		11) Print the MRP of the product
        WebElement mrp = driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span"));
        String text = mrp.getText();
        System.out.println("MRP of selecetd product is :" +text);
//		12) Click on ADD to BAG
        driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
//		13) Go to Shopping Bag 
        driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
//		14) Print the Grand Total amount
        //WebElement grandTotal = driver.findElement(By.xpath("(//span[text()='Grand Total'])[2]/following-sibling::div"));
        //WebElement grandTotal = driver.findElement(By.xpath("(//span[text()='Grand Total']/ancestor::div[2]/div/span)[1]"));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
        driver.switchTo().frame(iframe);
        WebElement grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
        String text2 = grandTotal.getText();
        System.out.println("Grand total is :" +text2);
//		15) Click Proceed
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
//		16) Click on Continue as Guest
        driver.findElement(By.xpath("(//i[@class='proceed-arrow']/ancestor::button)[2]")).click();
//		17) Check if this grand total is the same in step 14
        WebElement grandTotal1 = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span"));
        String text3 = grandTotal1.getText();
        System.out.println("Final Grand total is: "+text3);
        if(text2.contains(text3)) {
        	System.out.println("Grand total is same");
        }
//		18) Close all windows
        driver.quit();


	}

}
