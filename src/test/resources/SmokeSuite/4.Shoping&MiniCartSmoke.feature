Feature: Shoping and Mini cart smoke test set

  Scenario: We should ensure that end user can remove products via mini-cart
    Given user is on Home page
    And user is not logged in
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    When user clicks on 'Remove' link for item "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in mini-cart list
    Then item "Omega-3 Pet - Unflavored - 180 Soft Gels" should be absent in mini-cart list
    
  Scenario: We should ensure that end user can update product quantity from cart
    Given user is on Home page
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And item "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shoping Cart page
    And user increase quantity to '3' for "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shoping Cart page
    When user press on 'Update Cart' link for item "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shoping Cart page
    Then system updates the quantiy to '3' for "Omega-3 Pet - Unflavored - 180 Soft Gels"  product
    And system recalculates order total price

  Scenario: We should ensure that end user can remove product from cart
    Given user is on Home page
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    When user clicks on 'Remove' link for item "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shopping Cart Page
    Then item "Omega-3 Pet - Unflavored - 180 Soft Gels" should be absent in list on Shopping Cart Page

  Scenario: We should ensure that user can view products individual prices and subtotal in shopping cart
    Given user is on Home page
    And user enters "LEAN BODY Meal Replacement Vanilla Ice" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user clicks 'Add to cart' button
    When user clicks 'Go to cart and checkout' button
    Then item "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" that should be present in list on Shoping Cart page
    And system displays autoship information for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item
    And system displays price per unit for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item on Shoping Cart page
    And system displays quantity of product for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item on Shoping Cart page
    And system displays total price for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item on Shoping Cart page
    And system display order total price
