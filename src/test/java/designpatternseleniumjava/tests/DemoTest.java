package designpatternseleniumjava.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.designpatternseleniumjava.pagecomponents.MultiCity;
import com.designpatternseleniumjava.pagecomponents.OneWay;
import com.designpatternseleniumjava.pagecomponents.RoundTrip;
import com.designpatternseleniumjava.pageobjects.TravelHomeApp;

public class DemoTest {
	By searchFlightSection = By.id("flightSearchContainer");
    @Test
    public void flightTest(){
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        TravelHomeApp travelApp = new TravelHomeApp(driver);
        travelApp.gotoHomePage();
        
        System.out.println(travelApp.getFooterNav().getFooterFlightAttribute());
        System.out.println(travelApp.getNavigationBar().getHeaderFlightAttribute());
        System.out.println(travelApp.getFooterNav().getLinksCount());
        System.out.println(travelApp.getNavigationBar().getLinksCount());
        
        travelApp.setBookingStrategy(new OneWay(driver, searchFlightSection));
        travelApp.checkAvail("MAA", "BLR");
        travelApp.setBookingStrategy(new RoundTrip(driver, searchFlightSection));
        travelApp.checkAvail("KQH", "SAG");
        travelApp.setBookingStrategy(new MultiCity(driver, searchFlightSection));
        travelApp.checkAvail("HBX", "SXR");
        
        driver.quit();
    }
}
