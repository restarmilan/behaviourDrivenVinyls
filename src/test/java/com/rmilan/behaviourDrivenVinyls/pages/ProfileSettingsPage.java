package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileSettingsPage extends Page {

    @Autowired
    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileSettingsPage() {
        return driver.getCurrentUrl().equals(baseUrl + "settings/user");
    }
}
