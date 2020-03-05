package com.rmilan.behaviourDrivenVinyls.stepDefinitions;

import com.rmilan.behaviourDrivenVinyls.pages.*;
import com.rmilan.behaviourDrivenVinyls.utils.UserSettingsOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserProfileSettingsStepDefinitions {

    private final BasePage basePage;
    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;
    private final ProfileDetailsPage profileDetailsPage;
    private final ProfileSettingsPage profileSettingsPage;

    private String realName = "Milan Restar";
    private String location = "Budapest";
    private String description = "This is a description";

    @Autowired
    public UserProfileSettingsStepDefinitions(
            BasePage basePage, LoginPage loginPage, DashBoardPage dashBoardPage, ProfileSettingsPage profileSettingsPage,
            ProfileDetailsPage profileDetailsPage) {
        this.basePage = basePage;
        this.loginPage = loginPage;
        this.dashBoardPage = dashBoardPage;
        this.profileDetailsPage = profileDetailsPage;
        this.profileSettingsPage = profileSettingsPage;
    }

    @Given("I'm logged in as a registered user")
    public void iAmLoggedInAsARegisteredUser() {
        basePage.navigateTo("");
        basePage.clickOnLoginButton();
        loginPage.setLoginCredentials(System.getenv("DISCOGS_USERNAME"), System.getenv("DISCOGS_PASSWORD"));
    }

    @Given("I'm on the user profile settings page")
    public void iAmOnTheUserProfileSettingsPage() {
        dashBoardPage.navigateToUserProfileSettings();
    }

    @Given("I'm on my profile details page")
    public void iAmOnMyProfileDetailsPage() {
        dashBoardPage.navigateTo("user/" + System.getenv("DISCOGS_USERNAME"));
    }

    @When("I click on the Settings button")
    public void iClickOnTheSettingsButton() {
        profileDetailsPage.checkSettingsQuicklink();
    }

    @Then("I should be redirected to my profile settings page")
    public void iShouldBeRedirectedToMyProfileSettingsPage() {
        assertTrue(profileSettingsPage.isProfileSettingsPage());
    }

    @Given("I set my real name on profile settings page")
    public void iSetMyRealNameOnProfileSettingsPage() {
        profileSettingsPage.setUserRealName(realName);
    }

    @Then("I should see my real name on my profile details page")
    public void iShouldSeeMyRealNameOnMyProfileDetailsPage() {
        dashBoardPage.navigateTo("user/" + System.getenv("DISCOGS_USERNAME"));
        assertEquals(profileDetailsPage.getUserRealName(), realName);
        profileDetailsPage.navigateTo("settings/user");
        profileSettingsPage.restoreOriginalState(UserSettingsOptions.REALNAME);
    }

    @Given("I set my location on profile settings page")
    public void iSetMyLocationOnProfileSettingsPage() {
        profileSettingsPage.setUserLocation(location);
    }

    @Then("I should see my location on my profile details page")
    public void iShouldSeeMyLocationOnMyProfileDetailsPage() {
        dashBoardPage.navigateTo("user/" + System.getenv("DISCOGS_USERNAME"));
        assertEquals(profileDetailsPage.getUserLocation(), location);
        profileDetailsPage.navigateTo("settings/user");
        profileSettingsPage.restoreOriginalState(UserSettingsOptions.LOCATION);
    }

    @Given("I set a profile description on profile settings name")
    public void iSetAProfileDescriptionOnProfileSettingsName() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see this description on my profile details page")
    public void iShouldSeeThisDescriptionOnMyProfileDetailsPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see my username and avatar on this page")
    public void iShouldSeeMyUsernameAndAvatarOnThisPage() {
        assertTrue(profileDetailsPage.isCorrectUsernameVisible());
        assertTrue(profileDetailsPage.isCorrectUserAvatarVisible());
    }

    @Then("I should see a confirmation message about saved changes")
    public void iShouldSeeAConfirmationMessageAboutSavedChanges() {
        assertTrue(profileSettingsPage.isChangeConfirmed());

    }
}
