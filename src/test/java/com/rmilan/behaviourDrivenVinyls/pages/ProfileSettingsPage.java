package com.rmilan.behaviourDrivenVinyls.pages;

import com.rmilan.behaviourDrivenVinyls.utils.UserSettingsOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileSettingsPage extends Page {

    @FindBy(xpath = "//input[@id='user_prefs_name']")
    WebElement nameSettingsField;
    @FindBy(xpath = "//input[@id='user_prefs_geo']")
    WebElement locationSettingsField;
    @FindBy(xpath = "//textarea[@id='settings']")
    WebElement profileDescriptionField;
    @FindBy(xpath = "//span[@class='alert-message-text']")
    WebElement changeConfirmMsg;
    @FindBy(xpath = "//button[@type='submit' and @name='Action.Save']")
    WebElement saveChangesBtn;

    @Autowired
    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileSettingsPage() {
        return driver.getCurrentUrl().equals(baseUrl + "settings/user");
    }

    public void setUserRealName(String realName) {
        setInput(nameSettingsField, realName);
        this.waitForConfirm();
    }

    public void waitForConfirm() {
        saveChangesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(changeConfirmMsg));
    }

    public boolean isChangeConfirmed() {
        return changeConfirmMsg.isDisplayed();
    }

    public void restoreOriginalState(UserSettingsOptions userSettingsOptions) {
        navigateTo("settings/user");
        switch (userSettingsOptions) {
            case REALNAME:
                setInput(nameSettingsField, "");
                saveChangesBtn.click();
                break;
            case LOCATION:
                setInput(locationSettingsField, "");
                saveChangesBtn.click();
                break;
            case DESCRIPTION:
                setInput(profileDescriptionField, "");
                saveChangesBtn.click();
                break;
        }
    }
}
