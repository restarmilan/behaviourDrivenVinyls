package behaviourDrivenVinyls;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;

public class AutenthicationStepDefinitions extends BaseStepDefs {

    BasePage basePage = new BasePage(driver);

    @Given("I'm on the Discogs.com page as a registered user")
    public void i_m_on_the_Discogs_com_page_as_a_registered_user() {
        basePage.navigateTo();
    }

    @Given("I click on the Log In button")
    public void i_click_on_the_Log_In_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I set the correct {string} and {string}")
    public void i_set_the_correct_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see my profile after successful login")
    public void i_should_see_my_profile_after_successful_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @After()
    public void closeBrowser(){
        this.driver.quit();
    }


}