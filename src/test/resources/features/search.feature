Feature: If user searches for a product the results should return related to that search

  Background: User open the site
    Given SUser opens the site "https://demo.nopcommerce.com/"

  Scenario: User finds a results related to that search
    When User enters a word for search "samsung"
    And User clicks on the search button
    Then User finds the results contain the same word of the search "samsung"

  Scenario: User can not search with word less than 3 characters
    When User enters a word for search "hp"
    And User clicks on the search button
    Then An error message display that minimum length is 3 characters
    And No results is returned

  Scenario: User finds a list related to the search
    When User enters a word for search "samsung"
    Then A list is displayed with the related word before click search "samsung"
