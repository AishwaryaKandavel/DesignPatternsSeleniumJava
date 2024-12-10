package com.designpatternseleniumjava.pagecomponents;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;
import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;

public class OneWay extends AbstractComponent implements SearchFlightAvailable{
	
	private By origin = By.xpath(".//input[contains(@id,'origin')]");
	private By cb = By.xpath(".//label[normalize-space(text())='Indian Armed Forces']/preceding-sibling::input");
	private By submit = By.xpath("//input[@value='Search']");
	private By originDropdown = By.xpath("//input[contains(@id, 'origin')]"
			+ "/following-sibling::div[@class='search_options_menucontentbg' "
			+ "and contains(@style, 'display: block;')]");

	public OneWay(WebDriver driver, By searchFlightSection) {
		super(driver, searchFlightSection);
	}

	@Override
	public void checkAvailability(List<HashMap<String,String>> origDest) {
		String origin = origDest.get(0).get("origin");
		String destination = origDest.get(0).get("destination");
		System.out.println("One way: "+origin+" to "+destination);
		makeStateReady(s->findSelectElementDynamic(origin).click());
		waitForElementToDisappear(originDropdown);
		findSelectElementDynamic(destination).click();
		findElement(cb).click();
		findElement(submit).click();
	}
	public void makeStateReady(Consumer<OneWay> consumer) {
		findElement(this.origin).click();
		consumer.accept(this);
	}
}
