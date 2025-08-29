Feature: User should be able to register on the website

  Background: User directed to the registration page and fill some data
    Given RUser opens the site "https://demo.nopcommerce.com/"
    And User clicks on the registration button from homepage
    When User selects a gender
    And User fills the first name "Try"
    And User fills the last name "Trying"


  Scenario: User should be able to register an account on the site after filling the required data

    And User adds an email "try111@gmail.com"
    And User adds a company details "Test"
    And User adds a password "123456"
    And User confirms the password "123456"
    Then User clicks on the resister button
    And User should see a confirmation message
    And User clicks on continue button

  Scenario: an error message displayed if the password doesn't match
    And User adds an email "try111@gmail.com"
    And User adds a company details "Test"
    And User adds a password "123456"
    And User confirms the password "123457"
    Then User clicks on the resister button
    And error message displayed

  Scenario: User can not register an account with invalid data
    And User adds an email "try1114gmail.com"
    And User adds a company details "Test"
    And User adds a password "123456"
    And User confirms the password "123456"
    Then User clicks on the resister button
    And error message for invalid email displayed


