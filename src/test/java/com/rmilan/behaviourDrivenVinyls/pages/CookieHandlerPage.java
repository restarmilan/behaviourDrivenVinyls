package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")

public class CookieHandlerPage extends Page {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookiesButton;
    @FindBy(xpath = "//div[@class='onetrust-pc-dark-filter fade-in']")
    WebElement cookieHandler;

    @Autowired
    public CookieHandlerPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookiesButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieHandler));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

