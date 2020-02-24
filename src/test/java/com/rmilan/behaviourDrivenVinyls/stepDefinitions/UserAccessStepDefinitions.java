package com.rmilan.behaviourDrivenVinyls.stepDefinitions;

import com.rmilan.behaviourDrivenVinyls.pages.BasePage;
import com.rmilan.behaviourDrivenVinyls.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccessStepDefinitions {

    private final BasePage basePage;
    private final LoginPage loginPage;

    @Autowired
    public UserAccessStepDefinitions(BasePage basePage, LoginPage loginPage) {
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

    @Then("I should see my profile after successful login")
    public void iShouldSeeMyProfileAfterSuccessfulLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I set invalid credentials {string} or {string}")
    public void iSetInvalidCredentialsOr(String username, String password) {
        loginPage.setLoginCredentials(username, password);
    }

    @Then("I should see a warning message")
    public void iShouldSeeAWarningMessage() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}

