package decathlon;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;
	@BeforeMethod
	public void setup() {
		
	
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.decathlon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
	@Test
		public void main() throws InterruptedException, IOException {
		// Checking we are actual Home page or not 
		String actualTitle = "Buy Sporting Goods, Sportswear and Equipments | Download App";
		String title = driver.getTitle();
		System.out.println(title);
		
		if (actualTitle.equals(title)) {
			System.out.println("We are in Home page ");
		}else {
			System.out.println("we are not in home page");
		}
		
		// Checking Login Page 

		wait(3000);
		
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		String actualLoginText = "Login";
		
		WebElement loginTextWE = driver.findElement(By.xpath("//h3[text()='Login']"));
		String expLoginText =loginTextWE.getText();
		System.out.println(expLoginText); 
		
		if (actualLoginText.equals(expLoginText)) {
			System.out.println("It's Sign In page");
		}else {
			System.out.println("It's not Sign In page");
		}
		
		// Take a Screenshot 
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        File destination = new File ("D:\\eclipse\\myProject1\\screenShot\\img2.png");
        FileUtils.copyFile(source,destination);
		
		// Automate Login Page 
		
		WebElement mail = driver.findElement(By.xpath("//input[@id='input-email']"));
		mail.sendKeys("deva.bharathi013@gmail.com");
		System.out.println("Enterd Mail : "+ mail.getAttribute("value"));
		
		  WebElement emailErrMsg = driver.findElement(By.xpath("(//p[starts-with(@Class,'vtmn-typo_font-weight')])[1]"));
		 
		  if(emailErrMsg.isDisplayed()) {
			  String emailErrMsgText = emailErrMsg.getText();
				 System.out.println(emailErrMsgText);
		  }
		 
		driver.findElement(By.xpath("//div[text()='Phone number']")).click();
		WebElement phoneNum = driver.findElement(By.xpath("//input[@id='input-mobile']"));
		phoneNum.sendKeys("0000000002");
		System.out.println("Phone Number value : "+phoneNum.getAttribute("value"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement phoneNumErrMsg = driver.findElement(By.xpath("(//p[starts-with(@class,'vtmn-typo_font-weight')])[1]"));
		
		if(phoneNumErrMsg.isDisplayed()) {
			String numErrMsgText= phoneNumErrMsg.getText();
			System.out.println(numErrMsgText);
			}
		}
		
		@AfterMethod
		public void after() {
			
		driver.quit();
		

}
		
	}
