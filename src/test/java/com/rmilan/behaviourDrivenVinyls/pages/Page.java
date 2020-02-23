package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    final int TIMEOUT = 10;
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://www.discogs.com/";

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void navigateTo(String urlExtension){
        driver.get(baseUrl+urlExtension);
    }

    public void clickOnWebElement(WebElement element) {
          element.click();
        }

    public void setInput (WebElement element, String input){
        element.sendKeys(input);
    }
}
