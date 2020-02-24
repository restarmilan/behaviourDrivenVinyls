package com.rmilan.behaviourDrivenVinyls.stepDefinitions;

import com.rmilan.behaviourDrivenVinyls.pages.BasePage;
import com.rmilan.behaviourDrivenVinyls.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccessStepDefinitions implements En {

   private final BasePage basePage;
   private final LoginPage loginPage;

   @Autowired
   public UserAccessStepDefinitions(BasePage basePage, LoginPage loginPage){
       this.loginPage = loginPage;
       this.basePage = basePage;
   }

    @Given("I'm on the Discogs.com page as a registered user")
    public void iAmOnTheDiscogsComPageAsARegisteredUser() {
        basePage.navigateTo("");
    }

    @Given("I click on the Log In button")
    public void iClickOnTheLogInButton() {
        basePage.clickOnLoginButton();
    }

    @When("I set the correct username and password")
    public void iSetTheCorrectUsernameAndPassword() {
        String username = System.getenv("DISCOGS_USERNAME");
        String password = System.getenv("DISCOGS_PASSWORD");
        loginPage.setLoginCredentials(username, password);
    }

    @When("I set invalid credentials {string} or {string}")
    public void iSetInvalidCredentials(String username, String password) {
        loginPage.setLoginCredentials(username, password);
    }

}
