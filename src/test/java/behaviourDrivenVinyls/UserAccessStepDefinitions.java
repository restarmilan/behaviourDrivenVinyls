package behaviourDrivenVinyls;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;

public class UserAccessStepDefinitions extends BaseStepDefs {

    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I'm on the Discogs.com page as a registered user")
    public void iAmOnTheDiscogsComPageAsARegisteredUser() {
        basePage.navigateTo("");
    }

    @When("I click on the Log In button")
    public void iClickOnTheLogInButton() {
        basePage.clickOnLoginButton();
    }

    @When("I set the correct {string} and {string}")
    public void iSetTheCorrectCredentials(String username, String password) {
        username = System.getenv("DISCOGS_USERNAME");
        password = System.getenv("DISCOGS_PASSWORD");
        loginPage.setLoginCredentials(username, password);
    }

    @Then("I should see my profile after successful login")
    public void iShouldSeeMyProfileAfterSuccessfulLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @After()
    public void closeBrowser(){
        this.driver.quit();
    }


}
