package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileDetailsPage extends Page {

    @FindBy(xpath = "//a[@class='button' and @href='/settings/user']")
    WebElement settingsBtn;

    @FindBy(xpath = "//div[@id='full-width-header-bar']//child::a")
    WebElement userNameHeader;

    @FindBy(xpath = "//img[@class='full_width']")
    WebElement userAvatar;

    @FindBy(xpath = "//span[@class='real_name']")
    WebElement realNameDisplay;

    @FindBy(xpath = "//ul[@class='list_no_style profile_bio']//child::li[1]")
    WebElement locationDisplay;

    @Autowired
    public ProfileDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void checkSettingsQuicklink() {
        clickOnWebElement(settingsBtn);
    }

    public boolean isCorrectUsernameVisible() {
        return userNameHeader.getText().equals(System.getenv("DISCOGS_USERNAME"));
    }

    public boolean isCorrectUserAvatarVisible() {
        return userAvatar.getAttribute("alt").equals(System.getenv("DISCOGS_USERNAME"));
    }

    public String getUserRealName() {
        return realNameDisplay.getText();
    }

    public String getUserLocation() {
        return locationDisplay.getText();
    }
}
