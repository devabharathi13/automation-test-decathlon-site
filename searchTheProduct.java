package decathlon;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchTheProduct {

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
		//Select the product in EMI Page
		driver.findElement(By.xpath("(//span[@class='text-base font-medium text-white'])[3]")).click();
		driver.findElement(By.xpath("//img[@src='https://contents.mediadecathlon.com/p2571076/b9d48291bb6811c5899b09117d54be44/size-5-machine-stitched-football-training-ball-white.jpg?format=auto&quality=70&f=320x0']"))
        .click();
		
		//Change the product Delivery address 
		driver.findElement(By.xpath("//button[@aria-label='Change delivery pincode']")).click();
		driver.findElement(By.xpath("//input[@id='pincode-input-login']")).sendKeys("636701");
		driver.findElement(By.xpath("//button[@aria-label='Submit pincode']")).click();
		
		Thread.sleep(2000);
		//Print the address 
		WebElement cityName = driver.findElement(By.xpath("//span[@class='truncate text-xs font-medium text-cobalt-500']"));
		String pinCodeCity = cityName.getText();
		System.out.println("Name Of The City : "+pinCodeCity);
		
		//Trying to get Delivery date and time
		WebElement getDate = driver.findElement(By.xpath("(//span[@class='text-sm text-rock-900'])[1]"));
		String date = getDate.getText();
		System.out.println("Delivery Date : "+date);
		
		WebElement getTime = driver.findElement(By.xpath("//button[@class='cursor-pointer border-none bg-transparent p-0 text-green-600']"));
		String time = getTime.getText();
		System.out.println("Delivery Timing : "+time);
		
		//Checking availability of stores 
		WebElement viewAvailableStores  = driver.findElement(By.xpath("//span[@class='pl-7 text-xs text-red-400']"));
		String viewStores = viewAvailableStores.getText();
		
		String store = "View stores";
		
		if (store.equals(viewStores)) {
			System.out.println("Stores are available ");
		}else {
			System.out.println("Stores are not available ");
		}
		
		//Search Particular Product
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("football shoes",Keys.ENTER);
		
		//Search a Product variations
		driver.findElement(By.xpath("//span[text()='Gender']")).click();
		WebElement gender = driver.findElement(By.xpath("(//span[text()='Men'])[2]"));
		gender.click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		WebElement product = driver.findElement(By.xpath("//span[text()='Football boots']"));
		product.click();
		
		driver.findElement(By.xpath("//span[text()='Size']")).click();
		WebElement size = driver.findElement(By.xpath("//span[text()='11']"));
		size.click();
		
		driver.findElement(By.xpath("//span[text()='Color']")).click();
		WebElement color = driver.findElement(By.xpath("(//span[text()='Black'])[1]"));
		color.click();
		
		// Take a Screenshot 
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        File destination = new File ("D:\\eclipse\\myProject1\\screenShot\\img3.png");
        FileUtils.copyFile(source,destination);
		}
		
        @AfterMethod
        public void after() {
        
		driver.quit();
        }
	}


