package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class DashBoardPage extends Page {

    @FindBy(xpath = "//img[@class='user_image']")
    WebElement userProfileIcon;

    @FindBy(xpath = "//ul[@id='activity_menu']//child::i[1]")
    WebElement userActivityMenuDropdown;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutOption;

    @FindBy(xpath = "//a[@href='/settings/user']/child ::i")
    WebElement settingsOption;


    @Autowired
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedInUserDisplayed() {
        return userProfileIcon.getAttribute("alt").equals(System.getenv("DISCOGS_USERNAME"));
    }

    public void logoutFromPage() {
        clickOnWebElement(userActivityMenuDropdown);
        clickOnWebElement(logoutOption);
    }

    public void navigateToUserProfileSettings() {
        clickOnWebElement(userActivityMenuDropdown);
        clickOnWebElement(settingsOption);
    }
}
