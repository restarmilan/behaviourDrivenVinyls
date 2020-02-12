Feature: login

  Check user login both with a "happy path" and with invalid credentials.

  Scenario: login with valid credentials.
    Given I'm on the Discogs.com page as a registered user
    And I click on the Log In button
    When I set the correct "username" and "password"
    Then I should see my profile after successful login