package com.designpatternseleniumjava.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.AbstractComponent;


public class FooterNav extends AbstractComponent{

	private By flight = By.xpath(".//a[@title='Flights']");
	private By links = By.tagName("a");

    public FooterNav(WebDriver driver, By footerSection) {
        super(driver, footerSection);
    }

    public String getFooterFlightAttribute(){
        return findElement(flight).getAttribute("class");
    }
    
    public int getLinksCount() {
		return findElements(links).size();
	}

}
