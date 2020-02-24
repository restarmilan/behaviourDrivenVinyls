package com.rmilan.behaviourDrivenVinyls.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends Page {

    @FindBy (xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy (xpath = "//input[@id='password']")
    WebElement passwordField;

    @Autowired
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginCredentials(String username, String password){
        setInput(usernameField, username);
        setInput(passwordField, password);
        passwordField.submit();

    }
}
