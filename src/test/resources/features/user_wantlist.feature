Feature: User want list

  Test cases for check user created want lists and their modifications and fearures.

  Background:
    Given I'm logged in as a registered user

  Scenario: Add a record to my user want list.
    Given I select a specific record by url
    When I add this record to my want list
    Then I should see a confirmation message about addition
    And I should see the record on my want list

  Scenario: Record marked as item in my want list
    Given I have a record in my want list
    When I am on the record's page
    Then I should see that this record is in my want list

  Scenario: Add notes to a want list item
    Given I have a record in my want list
    When I add note to this record listed in my want list
    Then I should see this note on the given want list item

  Scenario: Edit notes of want list item from record's page
    Given I have a record in my want list
    When I am on the record's page
    And I set a note for this record
    Then I should see this note on the given want list item

  Scenario: Want list item as a quick link to artist's page
    Given I have a record in my want list
    When I click on the artist's name at want list listing
    Then I should be redirected to the artist's page

  Scenario: Want list item as a quick link to the records's page
    Given I have a record in my want list
    When I click on the records's title at want list listing
    Then I should be redirected to the given record's page

  Scenario: Want list item as a quick link to available copies

  Test case for check whether an item in user's want list serves as a quick link to the available ("For sale") copies,
  and there are the same available quantity listed than in the want list listing's "items for sale" field.

    Given I have a record in my want list
    When I click on the ForSale field at want list listing
    Then I should be redirected to the available copies' page
    And The available copies' number equals the amount of want list listing

  Scenario: Remove want list item
    Given I have a record in my want list
    When I remove this item
    Then The record should disappear from my want list

  Scenario: Remove want list item using record's page
    Given I have a record in my want list
    When I am on the record's page
    And I click on the remove button
    Then The record should disappear from my want list

  Scenario: Large covers option doesn't show added notes

  This test case checks whether the selectable "Large Covers" displaying option shows the added notes belongs to
  want list items or not.

    Given I have a record in my want list
    When I select Large Covers displaying option
    Then The added notes to want list items aren't displaying

  Scenario: Add multiple items to want list
    Given I add multiple items to my want list
    When I am on my want list page
    Then I should see every added item listed
    And Want list header should show the number of listed items

  Scenario: Remove multiple items from my want list
    Given I add multiple items to my want list
    When I am on my want list page
    And I select every items for removal
    Then My want list should be empty

  Scenario Outline: : Search want listed item
    Given I add multiple items to my want list
    When I am on my want list page
    And I set "<keyword>" into the search bar
    Then I should see "<result>" on my want list page

    Examples:
      | keyword          | result           |
      | La Dispute       | La Dispute       |
      | la dispute       | La Dispute       |
      | LA DISPUTE       | La Dispute       |
      | Wildlife         | Wildlife         |
      | No Sleep Records | No Sleep Records |
      | 2018             | 2018             |
  """
    Searched item already set in "I add multiple items to my want list" step. There will be three records added,
    but they are uniquely, so search terms fit only for one of those.
    Record as a base for check search functions: La Dispute - Wildlife (No Sleep Records, 2018)
    """

  Scenario: Show all listed item's available copies

  This scenario checks that if there are multiple items in marketplace, then "Show Items in Marketplace" feature
  shows every available copies of all of them.

    Given I add multiple items to my want list
    When I am on my want list page
    And I want to see every available copies
    Then A cumulative page appears with every copies for sale


