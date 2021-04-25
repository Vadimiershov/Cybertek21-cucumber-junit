Feature: Etsy search feature

  Scenario: Etsy default title verification
    Given User is on Etsy home page
    Then User sees title as expected "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"
#expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
  Scenario: Etsy search functionality
    Given User is on Etsy home page
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden spoon" is in the title