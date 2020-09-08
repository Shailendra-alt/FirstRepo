package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class AutomationAssign {
	WebDriver driver;
	Actions action;
	 

	@Test
	public void BLaunch() {
		String path = System.getProperty("user.dir") + "\\src\\BrowserDrivers\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@Test(dependsOnMethods = "BLaunch")
	public void AppLaunch() {
		driver.get("http://automationpractice.com/index.php");

	}

	@Test(dependsOnMethods = "AppLaunch")
	public void Operations() throws InterruptedException {
		//Click on T_shirt
		WebElement elm = driver.findElement(By.xpath("//div[@id='block_top_menu']/child::ul/child::li[3]"));
		action= new Actions(driver);
		action.moveToElement(elm).click().perform();
		
		
		Thread.sleep(2000);
         //Select Size
		WebElement elm1= driver.findElement(By.xpath("//a[text()='M']/parent::label"));
	
		action.moveToElement(elm1).click().perform();
		
		Thread.sleep(2000);
		//Select Color
		driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_13']")).click();
		
		Thread.sleep(3000);
		//highlight the product
		WebElement elm3=driver.findElement(By.xpath("//img[@class='replace-2x img-responsive'][@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(elm3).perform();
		
		//Click on moveTo cart
		WebElement elm4=driver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default'][@title='Add to cart']"));
		action.moveToElement(elm4).click().perform();
		
		Thread.sleep(5000);
		//Continue Shopping
		WebElement elm5 = driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']"));
		action.moveToElement(elm5).click().perform();
	}
}

