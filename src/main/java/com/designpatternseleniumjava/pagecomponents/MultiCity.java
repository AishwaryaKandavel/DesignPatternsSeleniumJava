package com.designpatternseleniumjava.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;
import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;

public class MultiCity extends AbstractComponent implements SearchFlightAvailable{
	
	private By multiCity = By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By alertOk = By.id("MultiCityModelAlert");
	private By origin = By.xpath(".//input[contains(@id,'origin')]");
	private By cb = By.xpath(".//label[normalize-space(text())='Indian Armed Forces']/preceding-sibling::input");
	private By submit = By.xpath("//input[@value='Search']");

	public MultiCity(WebDriver driver, By searchFlightSection) {
		super(driver, searchFlightSection);
	}

	@Override
	public void checkAvailability(String origin, String destination) {
		System.out.println("MultiCity: "+origin+" to "+destination);
		findElement(multiCity).click();
		findElement(alertOk).click();
		findElement(this.origin).click();
		findSelectElementDynamic(origin).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findSelectElementDynamic(destination).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findSelectElementDynamic("BLR").click();
		findElement(cb).click();
		findElement(submit).click();
	}

}
