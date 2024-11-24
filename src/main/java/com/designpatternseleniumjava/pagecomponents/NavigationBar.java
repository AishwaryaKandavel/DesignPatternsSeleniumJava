package com.designpatternseleniumjava.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;

public class NavigationBar extends AbstractComponent {

	private By flight = By.xpath(".//a[@title='Flights']");
	private By links = By.tagName("a");

	public NavigationBar(WebDriver driver, By headerSection) {
		super(driver, headerSection);
	}

	public String getHeaderFlightAttribute() {
		return findElement(flight).getAttribute("class");
	}
	
	public int getLinksCount() {
		return findElements(links).size();
	}
	
}
