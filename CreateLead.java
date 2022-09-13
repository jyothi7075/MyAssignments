package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends ProjectSpecificMethods {
    @Test(dataProvider="sendData")
	public void runCreateLead(String username, String password, String cName, String fName, String lName) {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		
}
    @DataProvider
    public String[][] sendData() {
    	//create a 2D array with 2 rows 5 cols
    	String[][] data= new String[2][5];
    	data[0][0]="DemoSalesManager";
    	data[0][1]="crmsfa";
    	data[0][2]="TL";
    	data[0][3]="Hari";
    	data[0][4]="R";
    	
    	data[1][0]="DemoCSR";
    	data[1][1]="crmsfa";
    	data[1][2]="TL";
    	data[1][3]="Babu";
    	data[1][4]="M";
    	
    	return data;
    			
    }
    
}