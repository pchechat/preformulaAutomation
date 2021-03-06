Feature: Favorite and Autoship smoke test set

  Scenario: We need to make sure that user can add to cart from Favorites list
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "LEAN BODY Meal Replacement Vanilla Ice" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user clicks 'ADD TO FAVORITES' button
    And user navidates to the Account Overview page
    And user navigate to Favorites Settings page
    When user press on 'Add to Cart' link for item "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" that should be present in list on Favorites Settings page
    Then system displays confirmation message "1 item added to Cart"

 
  Scenario: We need to make sure that user can delete products from Favorites list
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    Then user navidates to the Account Overview page
    And user navigate to Favorites Settings page
    When user press on 'Remove' link for item "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" that should be present in list on Favorites Settings page
    Then system displays success message "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams) was removed"

  Scenario: We need to make sure that user can add item with Autoship settings
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    When user enters "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user choose "Every 15 Days" from autoship dropdown
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user clicks 'Continue' button on Shipping Method page
    Then system redirects user to Billing & Payment page
    When user clicks 'Credit Card' as Payment Method
    And user enters required payment information
    And user clicks 'Continue' button on Billing & Payment page
    And user clicks on 'Submit my order' button on Review & Submit page
    And system redirects user to Confirmation page
    Then user navidates to the Account Overview page
    And user navigate to Autoship Settings page
    And "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" should be present in list on Autoship Settings page

  Scenario: We need to make sure that user can edit Autoship settings
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    Then user navidates to the Account Overview page
    And user navigate to Autoship Settings page
    And "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" should be present in list on Autoship Settings page
    When user click on 'Edit' link for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item on Autoship product
    And user change frequency to "Every 30 Days"
    And user clicks on 'Save Autoship Settings' button
    #Then system displays success message
    And autoship frequency is change to "Autoship: Every 30 Days" for item "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)"

  Scenario: We need to make sure that user can cancel Autoship
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    Then user navidates to the Account Overview page
    And user navigate to Autoship Settings page
    And "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" should be present in list on Autoship Settings page
    When user click on 'Edit' link for "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" item on Autoship product
    And user clicks on "Cancel Autoship for this Item" link
    #Then system displays success message "Autoship Item #10900011 deleted successfully"
    And Item "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)"  removes from Autoship Item list
