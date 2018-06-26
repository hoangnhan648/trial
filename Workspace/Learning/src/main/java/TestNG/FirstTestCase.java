package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class FirstTestCase {
//	private static final String ChromeDriverManager = null;
	public WebDriver driver;

	  @Test

	  public void main() {

		// Find the element that's ID attribute is 'account'(My Account)

	      driver.findElement(By.id("email")).click();

	      // Find the element that's ID attribute is 'log' (Username)

	      // Enter Username on the element found by above desc.

	      driver.findElement(By.id("email")).sendKeys("0979543063");

	      // Find the element that's ID attribute is 'pwd' (Password)

	      // Enter Password on the element found by the above desc.

	      driver.findElement(By.id("pass")).sendKeys("f@c3b00k");

	      // Now submit the form. WebDriver will find the form for us from the element

	      driver.findElement(By.id("loginbutton")).click();

	      // Print a Log In message to the screen

	      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	      // Find the element that's ID attribute is 'account_logout' (Log Out)

	     // driver.findElement(By.id("account_logout"));

	  }

	  @BeforeMethod

	  public void beforeMethod() {

		  // Create a new instance of the Firefox driver
		  
		  //ChromeDriverManager.getInstance().setup();
		  //System.setProperty("webdriver.chrome.driver","C:\Program Files (x86)\Google\Chrome\Application\chrome.exe");
		  
		  System.setProperty("webdriver.gecko.driver", "E:/Soft/geckodriver.exe");
		  
	      driver = new FirefoxDriver();
	      

	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get("https://www.facebook.com");

	  }

	  @AfterMethod

	  public void afterMethod () {

		  // Close the driver

	      driver.quit();

	  }

}
