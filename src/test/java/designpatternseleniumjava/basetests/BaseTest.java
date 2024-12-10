package designpatternseleniumjava.basetests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.designpatternseleniumjava.abstractcomponent.JsonDataLoader;
import com.designpatternseleniumjava.pageobjects.TravelHomeApp;

public class BaseTest {
	protected WebDriver driver;
	protected TravelHomeApp travelApp;
	
	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        travelApp = new TravelHomeApp(driver);
        travelApp.gotoHomePage();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
