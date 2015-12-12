Feature: Checkout process smoke test set

  Scenario: We need to make sure that user can navigate to Shopping cart page
    Given user is on Home page
    And user is not logged in
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    When user clicks 'Go to cart and checkout' button
    Then system redirects user to Shopping cart page

  Scenario: We need to make sure that user can proceed to Shipping Address page
    Given user is on Home page
    And user is not logged in
    And user enters "LEAN BODY Meal Replacement Vanilla Ice" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    When user clicks 'Proceed to checkout' button
    Then system redirects user to Login page

  Scenario: We need to make sure that registered user can log in with email
    Given user is on Home page
    And user is not logged in
    And user enters "LEAN BODY Meal Replacement Vanilla Ice" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user enters in Email address field "wting@discardmail.com"
    And user enters in Password field "Test1234!"
    And user clicks checkout Login button
    Then system redirects user to Shipping Method page


  Scenario: We need to make sure that user can add new Credit Card
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user clicks 'Continue' button on Shipping Method page
    And user clicks 'Add a New Credit Card' button
    And user enter credit card data in Credit Card modal
      | Master Card | 5424180279791732 | Apr | 2016 | Mona | Malley |
    When user clicks 'Add Credit Card' button
    Then credit card "Master Card ending in 1732" should be present in Checkout Billing & Payment Page

  Scenario: We need to make sure that registered user with saved shipping and billing information can perform express checkout
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navidates to Express Checkout page
    And user select '1' index as default shipping address on Express Checkout page
    And user select '1' index as default shipping method on Express Checkout page
    And user select '1' index as default billing address on Express Checkout page
    And user select '1' index as default payment method on Express Checkout page
    And user clicks 'Save Changes' button on Express Checkout page
    And user clicks 'Go to cart and checkout' button
    And user click on 'Express Checkout' button
    And user enter CVV/Security Code "636"
    When user clicks on 'Submit my order' button on Review & Submit page
    Then system redirects user to Confirmation page

  Scenario: We should ensure that end user can proceed to checkout from shopping cart
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    When user clicks 'Proceed to checkout' button
    Then system redirects user to Shipping Method page

  Scenario: We need to make sure that user can proceed to Billing & Payment page
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    When user clicks 'Continue' button on Shipping Method page
    Then system redirects user to Billing & Payment page

  Scenario: We need to make sure that user can open Add Address modal
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user clicks 'Continue' button on Shipping Method page
    When user clicks 'Add a New Address' link
    Then system opens Add Address modal

  Scenario: We need to make sure that user can add new Billing Address
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user clicks 'Continue' button on Shipping Method page
    And user clicks 'Add a New Address' link
    And user fill data into Add Address modal fields
      #And user fill address data
      | Mona | Malley | 800 W RANDOL MILL RD | ARLINGTON | TX | 76012 | 2312322133 |
    And user saves changes on Address page
    And AVS check pass validation
    Then new address added to the address list and selected on Billing & Payment page
      | 800 W RANDOL MILL RD | ARLINGTON | TX | 76012-2504 |
    And user enter CVV/Security Code "105"
    When user clicks 'Continue' button on Billing & Payment page
    Then system redirects user to Review & Submit page

  Scenario: We need to make sure that user can Submit Order
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user clicks 'Continue' button on Shipping Method page
    And user enter CVV/Security Code "636"
    And user clicks 'Continue' button on Billing & Payment page
    When user clicks on 'Submit my order' button on Review & Submit page
    Then system redirects user to Confirmation page

  Scenario: We need to make sure that loged in user can checkout via paypal
    Given user is on Home page
    And user is not logged in
    And user enters "LEAN BODY Meal Replacement Vanilla Ice" in search field
    And select "LEAN BODY Meal Replacement Vanilla Ice Cream - 2.47 lb (1,120 Grams)" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user clicks 'Proceed to checkout' button
    And user enters in Email address field "wting@discardmail.com"
    And user enters in Password field "Test1234!"
    And user clicks checkout Login button
    And selects shipping method with cost "3-Business Day UPS"
    And user clicks 'Continue' button on Shipping Method page
    When user clicks 'PayPal' as Payment Method
    And user clicks on 'Checkout with PayPal' button
    And user login into PayPal
      | test_b_1352213977_per@go-vsg.com | abcd1234 |
    And user clicks on 'Log in' button
    And user clicks on 'Continue' button
    When user clicks on 'Submit my order' button on Review & Submit page
    And system redirects user to Confirmation page
 
  Scenario: We should ensure that end user can proceed to International Checkout
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    When user clicks on 'International Checkout' button
    Then system redirects user to Bongos transaction page
 
  Scenario: We should ensure that end user can apply promo coupon on shopping cart
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user enters "Omega-3 Pet - Unflavored - 180 Soft Gels" in search field
    And select "Omega-3 Pet - Unflavored - 180 Soft Gels" category from search results
    And user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    And user increase quantity to '15' for "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shoping Cart page
    When user press on 'Update Cart' link for item "Omega-3 Pet - Unflavored - 180 Soft Gels" that should be present in list on Shoping Cart page
    Then system displays success message "Omega-3 Pet - Unflavored - 180 Soft Gels is updated."
    And user doesnt have applied promo code
    When user enter "10OFF100" in promo code field
    And user clicks on 'Apply' button
    Then system displays "10OFF100" code name and amount of saving in order price area
    And system recalculates order total price considering applied promo code value