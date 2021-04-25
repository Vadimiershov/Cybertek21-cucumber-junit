Feature: Simple example of how dataTables work
@login
  Scenario: User should be able to login with correct credentials
    Given User is on the login page of SmartBear
    When User enters below info
    |username|Tester|
    |password|test  |
    Then User should see title changes to Web Orders

