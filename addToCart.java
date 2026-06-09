 package decathlon;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class addToCart {

	WebDriver driver;
	
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.decathlon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		@Test 
		public  void main() throws InterruptedException, IOException {
		//Pin Code
		driver.findElement(By.xpath("//span[@class='truncate text-xs font-medium text-cobalt-500']")).click();
		WebElement pinCode = driver.findElement(By.xpath("//input[@type='text']"));
		pinCode.sendKeys("625001");
		driver.findElement(By.xpath("//button[@aria-label='Submit pincode']")).click();
		
		Thread.sleep(3000);
	
		WebElement cityName = driver.findElement(By.xpath("//span[@data-test-id='header-desktop:delivery-address']"));
		String nameOfTheCity = cityName.getText();
		System.out.println("pin code City Name : "+nameOfTheCity);
		
		//Search The Product
		
		driver.findElement(By.xpath("//span[@data-test-id='All Sports:text']")).click();
		driver.findElement(By.xpath("//a[text()='Fishing']")).click();
		driver.findElement(By.xpath("(//img[@src='https://contents.mediadecathlon.com/p1997697/b4611281657a3604084736a2416ae028/p1997697.jpg?format=auto&quality=70&f=320x0'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		
		//Add to Cart checking it's updating or not
		
		WebElement addRoCartUpdating = driver.findElement(By.xpath("//span[@data-test-id='header-desktop:cart-count-badge']"));
		String cartNum = addRoCartUpdating.getText();
		System.out.println("Add To Cart is Working : "+cartNum);
		
		driver.findElement(By.xpath("//span[text()='Men']")).click();
		driver.findElement(By.xpath("//a[text()='Football Shoes']")).click();
		driver.findElement(By.xpath("//img[@src='https://contents.mediadecathlon.com/p2380445/52e7382f351c0fb380df4b4f188e4c18/mens-football-shoes-viralto-i-mg-ag-black-red.jpg?format=auto&quality=70&f=320x0']")).click();
        driver.findElement(By.xpath("//span[text()='10.5']")).click();
        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
        
        
        driver.findElement(By.xpath("//span[text()='Select products']")).click();
        driver.findElement(By.xpath("//img[@src='https://contents.mediadecathlon.com/p2970303/0c8432331f6cd13f9c8b39a0e6a60272/p2970303.jpg?format=auto&quality=70&f=92x0']")).click();
        driver.navigate().back();
        
        WebElement addRoCartUpdating1 = driver.findElement(By.xpath("//span[@data-test-id='header-desktop:cart-count-badge']"));
		String cartNum1 = addRoCartUpdating1.getText();
        System.out.println("Add to cart value : "+cartNum1);
        
        // Take a Screenshot 
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        File destination = new File ("D:\\eclipse\\myProject1\\screenShot\\img1.png");
        FileUtils.copyFile(source,destination);
        
        
        Thread.sleep(2000);
        //Mouse over function to set value
        WebElement mouseFunction = driver.findElement(By.xpath("//div[@class='absolute top-1/2 h-2 -translate-y-1/2 rounded-full bg-cobalt-500']"));
        
        Actions act = new Actions(driver);
        act.clickAndHold(mouseFunction).moveByOffset(1000,0).release().perform();
        
        //Print the Address
        
        WebElement locetingAddress = driver.findElement(By.xpath("//ol[@data-test-id='breadcrumbs-list']"));
		
		String locetingAdd = locetingAddress.getText();
		System.out.println("Addressing locetion : ");
		System.out.println(locetingAdd);
		System.out.println("****************************");
	
		//Checking Product's Value
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		WebElement actualProductvalue  = driver.findElement(By.xpath("//div[@data-test-id='cart:cart-checkout-total-price']"));
		System.out.println("Actual product values : "+actualProductvalue.getText());
		
		WebElement discountValue  = driver.findElement(By.xpath("//div[@data-test-id='cart:cart-checkout-discount']"));
		System.out.println("Discount value : "+discountValue.getText());
		
		WebElement totalValue = driver.findElement(By.xpath("(//p[@classname='font-semibold'])[2]"));
		System.out.println("Total Value : "+totalValue.getText());
		
		}
		
		@AfterMethod
		public void tearDown() {
		
		driver.quit();
	}

}
