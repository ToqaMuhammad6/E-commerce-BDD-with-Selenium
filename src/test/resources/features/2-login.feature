Feature: User should be able to login to the site

  Background: User open the site and login page
    #Given LUser opens the site "https://demo.nopcommerce.com/"
    And  User clicks the login button from the homepage

  Scenario: User can login with valid data
    When User enters an email "test15@gmail.com"
    And User enters a password "123456"
    Then User clicks on the login button
    And the login  option become log out

  Scenario: User can not login with invalid email
    When User enters an email "try1.com"
    And User enters a password "123456"
    Then User clicks on the login button
    And error message for invalid email is displayed

  Scenario: User can not login with a non registered email
    When User enters an email "try12@gmail.com"
    And User enters a password "123456"
    Then User clicks on the login button
    And User can not login and error message displayed


