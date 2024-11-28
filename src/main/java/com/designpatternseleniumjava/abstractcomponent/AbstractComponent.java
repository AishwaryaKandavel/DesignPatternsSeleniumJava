package com.designpatternseleniumjava.abstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    WebElement section;
    WebDriverWait wait;

    public AbstractComponent(WebDriver driver, By section) {
        this.section = driver.findElement(section);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", this.section);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By elementBy){
        return section.findElement(elementBy);
    }
    
    public List<WebElement> findElements(By elementBy){
    	return section.findElements(elementBy);
    }
    
    public boolean waitForElementToDisappear(By elementBy) {
    	return wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
	}
    
    public WebElement findSelectElementDynamic(String value) {
    	String xpath = "//a[@value='"+value+"' and not(ancestor::div[contains(@style, 'display: none')])]";
    	return wait.until(ExpectedConditions.elementToBeClickable(section.findElement(By.xpath(xpath))));
	}

}
