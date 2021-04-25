@1
Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboards
  Accounts are: librarian, student, admin

  Background: User is already is on login page
    Given user is on the login page

  @librarian
  Scenario: Login as librarian
    When user enters librarian username
    And user enter librarian password
    Then user should see dashboard

  @student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see dashboard

  @admin @employee @db
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see dashboard