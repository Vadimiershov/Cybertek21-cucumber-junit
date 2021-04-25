Feature: Order Process
@scenarioOutline
# Background: login
#  Given User is on the login page of SmartBear
#  When User enters below info
#   |username|Tester|
#   |password|test  |
#  Then User should see title changes to Web Orders

  Scenario Outline: As a user I should be able to place an order
    Given User is logged into SmartBear Tester account and on Order page
   And User selects "<product>" from product dropdown
   And User enters "<quantity>" to quantity
   And User enters "<customer name>" to customer name
   And User enters "<street>" to street
   And User enters "<city>" to city
   And User enters "<state>" to state
   And User enters "<zip>" to zip
   And User selects "<cardType>" as card type
   And User enters "<card number>" to card number
   And User enters "<expiration date>" to expiration date
   When User clicks process button
   Then User verifies "<customer name>" is in the list

Examples:
   |product|quantity|customer name|street |city       |state|zip          |cardType|card number       |expiration date|customer name|
   |MyMoney| 5      |David Bryan  |Madiwon|Orlando    |FL   |50684        |Visa    |5555000044443333  |05/22          |David Bryan  |
   |MyMoney| 8      |David Moll  |Madiwon|Orlando    |FL   |50684        |Visa    |5555000044443333  |05/22          |David Moll  |

