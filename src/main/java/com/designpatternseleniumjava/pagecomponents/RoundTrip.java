package com.designpatternseleniumjava.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;
import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailable{
	
	private By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By origin = By.xpath(".//input[contains(@id,'origin')]");
	private By cb = By.xpath(".//label[normalize-space(text())='Indian Armed Forces']/preceding-sibling::input");
	private By submit = By.xpath("//input[@value='Search']");

	public RoundTrip(WebDriver driver, By searchFlightSection) {
		super(driver, searchFlightSection);
	}

	@Override
	public void checkAvailability(String origin, String destination) {
		System.out.println("Round Trip: "+origin+" to "+destination);	
		findElement(roundTrip).click();
		findElement(this.origin).click();
		findSelectElementDynamic(origin).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findSelectElementDynamic(destination).click();
		findElement(cb).click();
		findElement(submit).click();
	}

}
