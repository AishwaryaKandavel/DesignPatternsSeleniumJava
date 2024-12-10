package designpatternseleniumjava.tests;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.designpatternseleniumjava.abstractcomponent.JsonDataLoader;

import designpatternseleniumjava.basetests.BaseTest;

public class E2ETest extends BaseTest {
	
	@Test
	public void UITest() {      
        System.out.println(travelApp.getFooterNav().getFooterFlightAttribute());
        System.out.println(travelApp.getNavigationBar().getHeaderFlightAttribute());
        System.out.println(travelApp.getFooterNav().getLinksCount());
        System.out.println(travelApp.getNavigationBar().getLinksCount());
        
	}
	
    @Test(dataProvider = "oneWayGetData")
    public void oneWay(List<HashMap<String, String>> origDest){         
        travelApp.setBookingStrategy("OneWay");
        travelApp.checkAvail(origDest);
    }
    
    @DataProvider
    public Object[][] oneWayGetData(){
    	List<List<HashMap<String, String>>> val = JsonDataLoader.getJsonData("OneWay");
    	return IntStream.range(0, val.size()).mapToObj(i -> new Object[] {val.get(i)}).toArray(Object[][]::new);
    }
    
    @Test(dataProvider = "roundTripGetData", dependsOnMethods = "oneWay")
    public void roundTrip(List<HashMap<String, String>> origDest){
        travelApp.setBookingStrategy("RoundTrip");
        travelApp.checkAvail(origDest);
    }
    
    @DataProvider
    public Object[][] roundTripGetData(){
    	List<List<HashMap<String, String>>> val = JsonDataLoader.getJsonData("RoundTrip");
    	return IntStream.range(0, val.size()).mapToObj(i -> new Object[] {val.get(i)}).toArray(Object[][]::new);
    }
    
    @Test(dataProvider = "multiTripGetData", dependsOnMethods = "roundTrip")
    public void multiTrip(List<HashMap<String, String>> origDest){
        travelApp.setBookingStrategy("MultiCity");
        travelApp.checkAvail(origDest);
    }
    
    @DataProvider
    public Object[][] multiTripGetData(){    	
    	List<List<HashMap<String, String>>> val = JsonDataLoader.getJsonData("MultiTrip");
    	return IntStream.range(0, val.size()).mapToObj(i -> new Object[] {val.get(i)}).toArray(Object[][]::new);
    }
}
