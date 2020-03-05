package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePage extends Page {

    CookieHandlerPage cookieHandlerPage;

    @FindBy(xpath = "//a[@id='log_in_link']")
    WebElement loginLink;

    @FindBy(xpath = "//span[@class='alert-message-text']")
    WebElement logoutMessage;

    @Autowired
    public BasePage(WebDriver driver) {
        super(driver);
        cookieHandlerPage = new CookieHandlerPage(driver);
    }

    public void clickOnLoginButton() {
        cookieHandlerPage.acceptCookies();
        clickOnWebElement(loginLink);
        cookieHandlerPage.acceptCookies();
    }

    public boolean confirmLogout() {
        String url = driver.getCurrentUrl();
        return url.equals(baseUrl) && logoutMessage.isDisplayed();
    }

    public void browserNavigateBack() {
        driver.navigate().back();
    }
}
