package designpatternseleniumjava.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.designpatternseleniumjava.pageobjects.TravelHomeApp;

public class DemoTest {
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
        
        List<HashMap<String, String>> origDest = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> keyValue = new HashMap<String, String>();
        
        keyValue.put("origin", "MAA");
        keyValue.put("destination", "BLR");
        origDest.add(new HashMap<String, String>(keyValue));
        travelApp.setBookingStrategy("OneWay");
        travelApp.checkAvail(origDest);
        
        origDest.clear();
        keyValue.put("origin", "KQH");
        keyValue.put("destination", "SAG");
        origDest.add(new HashMap<String, String>(keyValue));
        travelApp.setBookingStrategy("RoundTrip");
        travelApp.checkAvail(origDest);
        
        origDest.clear();
        keyValue.put("origin", "HBX");
        keyValue.put("destination", "AMD");
        origDest.add(new HashMap<String, String>(keyValue));
        keyValue.put("origin", "AMD");
        keyValue.put("destination", "GOI");
        origDest.add(new HashMap<String, String>(keyValue));
        keyValue.put("origin", "GOI");
        keyValue.put("destination", "HBX");
        origDest.add(new HashMap<String, String>(keyValue));
        travelApp.setBookingStrategy("MultiCity");
        travelApp.checkAvail(origDest);
        
        driver.quit();
    }
}
