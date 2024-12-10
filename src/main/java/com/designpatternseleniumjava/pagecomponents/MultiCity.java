package com.designpatternseleniumjava.pagecomponents;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;
import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;

public class MultiCity extends AbstractComponent implements SearchFlightAvailable{
	
	private By multiCity = By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By alertOk = By.id("MultiCityModelAlert");
	private By originDropdown = By.xpath(".//input[contains(@id, 'origin')]"
			+ "/following-sibling::div[@class='search_options_menucontentbg' "
			+ "and contains(@style, 'display: block;')]");
	private By destinationDropdown = By.xpath(".//input[contains(@id, 'destination')]"
			+ "/following-sibling::div[@class='search_options_menucontentbg' "
			+ "and contains(@style, 'display: block;')]");
	private By cb = By.xpath(".//label[normalize-space(text())='Indian Armed Forces']/preceding-sibling::input");
	private By submit = By.xpath("//input[@value='Search']");

	public MultiCity(WebDriver driver, By searchFlightSection) {
		super(driver, searchFlightSection);
	}

	@Override
	public void checkAvailability(List<HashMap<String, String>> origDest) {
		makeStateReady(s->waitForElementToDisappear(alertOk));
		for(int i=0; i<origDest.size(); i++) {
			String origin = origDest.get(i).get("origin");
			String destination = origDest.get(i).get("destination");
			System.out.println("MultiCity: "+origin+" to "+destination);
			selectOriginCity(origin, i+1);
			selectDestinationCity(destination);
		}
		findElement(cb).click();
		findElement(submit).click();
	}
	
	public void selectOriginCity(String origin, int index) {
		By originElem = By.xpath(".//input[contains(@id,'originStation"+index+"')]");
		findElement(originElem).click();
		findSelectElementDynamic(origin).click();
		waitForElementToDisappear(originDropdown);
	}
	
	public void selectDestinationCity(String destination) {
		findSelectElementDynamic(destination).click();
		waitForElementToDisappear(destinationDropdown);
	}
	
	public void makeStateReady(Consumer<MultiCity> consumer) {
		findElement(multiCity).click();
		findElement(alertOk).click();
		consumer.accept(this);
	}
}
