package com.designpatternseleniumjava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.designpatternseleniumjava.abstractcomponent.SearchFlightAvailable;
import com.designpatternseleniumjava.pagecomponents.FooterNav;
import com.designpatternseleniumjava.pagecomponents.NavigationBar;

public class TravelHomeApp {

    WebDriver driver;
    private By footerSection = By.id("traveller-home");
    private By headerSection = By.id("buttons");
    SearchFlightAvailable searchFlightAvailable;

    public TravelHomeApp(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, headerSection);
    }
    public FooterNav getFooterNav(){
        return new FooterNav(driver, footerSection);
    }
    public void gotoHomePage(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public void setBookingStrategy(SearchFlightAvailable searchFlightAvailable) {
		this.searchFlightAvailable = searchFlightAvailable;
	}
    public void checkAvail(String origin, String destination) {
		searchFlightAvailable.checkAvailability(origin, destination);
	}
}
