package com.designpatternseleniumjava.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;
import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;

public class OneWay extends AbstractComponent implements SearchFlightAvailable{
	
	private By origin = By.xpath(".//input[contains(@id,'origin')]");
	private By cb = By.xpath(".//label[normalize-space(text())='Indian Armed Forces']/preceding-sibling::input");
	private By submit = By.xpath("//input[@value='Search']");

	public OneWay(WebDriver driver, By searchFlightSection) {
		super(driver, searchFlightSection);
	}

	@Override
	public void checkAvailability(String origin, String destination) {
		System.out.println("One way: "+origin+" to "+destination);
		findElement(this.origin).click();
		findSelectElementDynamic(origin).click();
		findSelectElementDynamic(destination).click();
		findElement(cb).click();
		findElement(submit).click();
	}
	
}
