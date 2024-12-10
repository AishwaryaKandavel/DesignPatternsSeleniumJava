package designpatternseleniumjava.tests;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.designpatternseleniumjava.abstractcomponent.JsonDataLoader;

import designpatternseleniumjava.basetests.BaseTest;

public class MultiTripTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void flightTest(List<HashMap<String, String>> origDest){
        travelApp.setBookingStrategy("MultiCity");
        travelApp.checkAvail(origDest);
    }
    
    @DataProvider
    public Object[][] getData(){  	
    	List<List<HashMap<String, String>>> val = JsonDataLoader.getJsonData("MultiTrip");
    	return IntStream.range(0, val.size()).mapToObj(i -> new Object[] {val.get(i)}).toArray(Object[][]::new);
    }
}