Feature: User access

  Test cases for user login and logout features. Login tests both checks the "happy path" (login with correct username / password credentials)
  and unsuccessful login scenarios with incorrect username and / or password value pairs. In this case only the simple logout
  is checked.

  Background:
    Given I'm on the Discogs.com page as a registered user
    And  I click on the Log In button

  Scenario: Login with valid credentials
    When I set the correct username and password
    Then I should see my profile after successful login

  Scenario Outline: Login with invalid credentials
    When I set invalid credentials "<username>" or "<password>"
    Then I should see a warning message

    Examples:
      | username | password     |
      | ermilan  | passwd       |
      | rmilan   | wrong_passwd |
      | ermilan  |              |

  Scenario: Logout from page
    When I set the correct username and password
    And I select Log Out from my user options menu
    Then I should see a logout message on the application homepage

  Scenario: Logout after browser backwards navigation
    When I set the correct username and password
    And I select Log Out from my user options menu
    And I navigate back the browser after logout
    Then I should be still logged out from the application