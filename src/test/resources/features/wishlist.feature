Feature: The user will be able to add items to the wishlist
  Scenario: User can add item to the wish and delete it
    #Given WUser opens the site "https://demo.nopcommerce.com/"
    And User checks the wishlist is empty or not
    When User navigates to the homepage
    And User selects a products and adds it to the wishlist
    And User clicks the "x" icon to close the confirm bar
    Then User checks that the product added successfully
    And User deletes the product from the wishlist and check it's emptiness
