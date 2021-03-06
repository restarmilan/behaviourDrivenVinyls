package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class LoginPage extends Page {

    @FindBy (xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy (xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='messages']")
    WebElement errorMsg;

    @FindBy(xpath = "//form[@id='login-form']")
    WebElement loginForm;

    @Autowired
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginCredentials(String username, String password){
        setInput(usernameField, username);
        setInput(passwordField, password);
        passwordField.submit();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMsg.isDisplayed();
    }

    public boolean isLoginFormDisplayed() {
        return loginForm.isDisplayed();
    }


}
