Feature: User profile settings

  Test cases for various user profile details, settings and modifications.

  Background:
    Given I'm logged in as a registered user

  Scenario: Username is visible on user profile details page
    Given I'm on my profile details page
    Then I should see my username and avatar on this page

  Scenario: Quick link for profile settings page
    Given I'm on my profile details page
    When I click on the Settings button
    Then I should be redirected to my profile settings page

  Scenario: Set real name for registered user
    Given I'm on the user profile settings page
    When I set my real name on profile settings page
    Then I should see my real name on my profile details page

  Scenario: Set geographic location for registered user
    Given I'm on the user profile settings page
    When I set my location on profile settings page
    Then I should see my location on my profile details page

  Scenario: Set profile description for registered user
    Given I'm on the user profile settings page
    When I set a profile description on profile settings name
    Then I should see this description on my profile details page