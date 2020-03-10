package com.rmilan.behaviourDrivenVinyls.stepDefinitions;

import com.rmilan.behaviourDrivenVinyls.pages.BasePage;
import com.rmilan.behaviourDrivenVinyls.pages.DashBoardPage;
import com.rmilan.behaviourDrivenVinyls.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class UserAccessStepDefinitions {

    private final BasePage basePage;
    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;

    @Autowired
    public UserAccessStepDefinitions(BasePage basePage, LoginPage loginPage, DashBoardPage dashBoardPage) {
        this.loginPage = loginPage;
        this.basePage = basePage;
        this.dashBoardPage = dashBoardPage;
    }

    @Given("I'm on the Discogs.com page as a registered user")
    public void iAmOnTheDiscogsComPageAsARegisteredUser() {
        basePage.navigateTo();
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
        assertTrue(dashBoardPage.isLoggedInUserDisplayed());
    }

    @When("I set invalid credentials {string} or {string}")
    public void iSetInvalidCredentialsOr(String username, String password) {
        loginPage.setLoginCredentials(username, password);
    }

    @Then("I should see a warning message")
    public void iShouldSeeAWarningMessage() {
        assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @When("I select Log Out from my user options menu")
    public void iSelectLogOutFromMyUserOptionsMenu() {
        dashBoardPage.logoutFromPage();
    }

    @Then("I should see a logout message on the application homepage")
    public void iShouldSeeALogoutMessageOnTheApplicationHomepage() {
        assertTrue(basePage.confirmLogout());
    }

    @And("I navigate back the browser after logout")
    public void iNavigateBackTheBrowserAfterLogout() {
        basePage.browserNavigateBack();
    }

    @Then("I should be still logged out from the application")
    public void iShouldBeStillLoggedOutFromTheApplication() {
        assertTrue(loginPage.isLoginFormDisplayed());
    }
}

