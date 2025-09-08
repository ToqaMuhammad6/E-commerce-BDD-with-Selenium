Feature: The user will be able to add items to cart and pay for it
  Scenario: User can add item to the cart then checkout any continue to payment
    #Given CUser opens the site "https://demo.nopcommerce.com/"
    And User checks the shopping cart is empty or not
    When User selects camera and photo option when hover the electronics section
    And User selects a products and adds it to the cart
    And User clicks the "x" icon to close the confirmation bar
    Then User checks that the product added to the cart successfully
    And User hover over the shopping cart button and click go to cart
    And User check the product name is the same in the cart page
    And User agrees on terms and conditions
    And User clicks on the checkout button
    When User fills first name "Test"
    And User fills last name "Automation"
    And User enters a valid email "testing12@gmail.com"
    And User selects the country and state "Egypt" "Alexandria"
    And User adds the city "Alexandria"
    And User adds the address "80,AboQeer,Alex"
    And User adds a zip code "12589"
    And User adds a phone number "0123456789"
    Then User clicks the continue button
    And User choose a shipping method and continue
    And User Select payment via visa
    And User fill the payment information "Visa" "Rebecca Gonzales" "4463969775927948" "03" "2028" "190" and user click continue
    Then User clicks on the Confirm button
    And User checks that the order is successfully completed
    And User clicks continue and goes to homepage


