package com.rmilan.behaviourDrivenVinyls.stepDefinitions;

import com.rmilan.behaviourDrivenVinyls.pages.BasePage;
import com.rmilan.behaviourDrivenVinyls.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAccessStepDefinitions extends BaseStepDefs {

    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

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
        throw new io.cucumber.java.PendingException();
    }

    @When("I set invalid credentials {string} or {string}")
    public void iSetInvalidCredentials(String username, String password) {
        loginPage.setLoginCredentials(username, password);
    }

    @Then("I should see a warning message")
    public void iShouldSeeAWarningMessage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }


}
