package com.designpatternseleniumjava.abstractcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.pagecomponents.MultiCity;
import com.designpatternseleniumjava.pagecomponents.OneWay;
import com.designpatternseleniumjava.pagecomponents.RoundTrip;

public class StrategyFactor {
	
	private By searchFlightSection = By.id("flightSearchContainer");
	WebDriver driver;
	
	public StrategyFactor(WebDriver driver) {
		this.driver = driver;
	}

	public SearchFlightAvailable checkStrategy(String strategy){
		SearchFlightAvailable searchFlightAvailable = null;
		if(strategy.equalsIgnoreCase("multicity"))
			searchFlightAvailable = new MultiCity(driver, searchFlightSection);
		else if(strategy.equalsIgnoreCase("roundtrip"))
			searchFlightAvailable = new RoundTrip(driver, searchFlightSection);
		else if(strategy.equalsIgnoreCase("oneway"))
			searchFlightAvailable = new OneWay(driver, searchFlightSection);
		return searchFlightAvailable;
	}
}
