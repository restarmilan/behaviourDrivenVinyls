Feature: User access

  Test cases for user login and logout features. Login tests both checks the "happy path" (login with correct username / password credentials)
  and unsuccessful login scenarios with incorrect username and / or password value pairs. In this case only the simple logout
  is checked.

  Scenario: login with valid credentials.
    Given I'm on the Discogs.com page as a registered user
    And I click on the Log In button
    When I set the correct "username" and "password"
    Then I should see my profile after successful login