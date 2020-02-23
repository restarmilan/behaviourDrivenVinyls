package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Page {

    CookieHandlerPage cookieHandlerPage;

    @FindBy(xpath = "//a[@id='log_in_link']")
    WebElement loginLink;

    public BasePage(WebDriver driver) {
        super(driver);
        cookieHandlerPage = new CookieHandlerPage(driver);
    }

    public void clickOnLoginButton() {
        cookieHandlerPage.acceptCookies();
        clickOnWebElement(loginLink);
        cookieHandlerPage.acceptCookies();
    }
}
