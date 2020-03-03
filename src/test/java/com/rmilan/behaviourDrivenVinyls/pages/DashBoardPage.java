package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashBoardPage extends Page {

    @FindBy(xpath = "//img[@class='user_image']")
    WebElement userProfileIcon;


    @Autowired
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedInUserDisplayed() {
        return userProfileIcon.getAttribute("alt").equals(System.getenv("DISCOGS_USERNAME"));
    }
}
