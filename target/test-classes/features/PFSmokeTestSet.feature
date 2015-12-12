Feature: ability of user to get throught checkout process

  @forDemoOk
  Scenario: Initialization
    Given user is on Home page


  @forDemo
  Scenario: We need to make sure that user
    Given user is on log in page
    And user enters:
    |wting@discardmail.com | Test1234!|
    When user clicks button
    

  @forDemoOk
  Scenario: We need to make sure that user can navigate to search results page
    When user enters "Capsules" in search field
    And select "Vegetarian Capsules" category from search results
    Then system redirects user search results page

  @forDemoOk
  Scenario: We need to make sure that user can navigate to Product Detail Page
    Given user is on search results page
    When user opens first available product
    Then system redirects user to Product Detail Page

  @forDemoOk
  Scenario: We need to make sure that user can navigate to Shopping cart page
    Given user is on Product Detail Page
    When user clicks 'Add to cart' button
    And user clicks 'Go to cart and checkout' button
    Then system redirects user to Shopping cart page

  @forDemoOk
  Scenario: We need to make sure that user can proceed to Shipping Address page
    Given user has product in Your Shopping Cart page
    When user clicks 'Proceed to checkout' button
    Then system redirects user to Login page

  @forDemoOk
  Scenario: We need to make sure that registered user can log in with email
    When user enters in Email address field "SmithD@gmail.com"
    And user enters in Password field "123456"
    And user clicks checkout Login button
    Then system redirects user to Shipping Method page

  @forDemoOk
  Scenario: We need to make sure that user can proceed to Billing & Payment page
    Given user is on Shipping Method page
    When selects shipping method with cost "3-Business Day UPS"
    And user clicks Continue button on Shipping Method page
    Then system redirects user to Billing & Payment page

  @forDemoOk
  Scenario: We need to make sure that user can add new Credit Card
    Given user is on Billing & Payment page
    When user clicks 'Credit Card' as Payment Method
    And user enter credit card data
      | Visa | 4012000033330026 | Apr | 2016 |
    And user enter CVV/Security Code "636"
    And user enter personal data on credit card section
      | Mona | Malley |

  @forDemoOk
  Scenario: We need to make sure that user can open Add Address modal
    Given user is on Billing & Payment page
    When user clicks 'Add a New Address' link
    Then system opens Add Address modal

  @forDemoOk
  Scenario: We need to make sure that user can add new Billing Address
    Given user has Add Address modal open
    When user fill data into Add Address modal fields
      | Mona | Malley | 800 W RANDOL MILL RD | ARLINGTON | TX | 76012 | 2312322131 |
    And user save new address
    And AVS check pass validation
    Then new address added to the address list and selected on Billing & Payment page
      | 800 W RANDOL MILL RD | ARLINGTON | TX | 76012-2504 |
    And user clicks Continue button on Billing & Payment page
    And system redirects user to Review & Submit page

  @forDemoOk
  Scenario: We need to make sure that user can Submit Order
    Given user is on Review & Submit page
    When compare email to "SmithD@gmail.com"
    And compare address to previusly enterd
      | Mona | Malley | 800 W RANDOL MILL RD | ARLINGTON | TX | 76012 |
    And clicking submit button on Review & Submit page
    Then system redirects user to Confirmation page

  @forDemoOk
  Scenario: We need to delete Addresses created during Smoke test
    Given user navidates to the Account Overview page
    When user navigates to Address Book page
    And user deletes all addresses except firts
    Then System displays address on Address Book page
      | Do not Delete | 228 PARK AVE S, NEW YORK, NY 10003-1502, United States |

  @forDemoOk
  Scenario: We need to delete Credit Cards created during Smoke test
    Given user navidates to the Account Overview page
    When user navigates to Credit Cards page
    And user deletes all credit cards
    Then no credit cards are present on the Credit Cards page

  @forDemoOk
  Scenario: We need to make sure that logged in user can logout
    Given user navigates to Home page
    When user hovers mouse cursor on My Account link
    And user clicks LogOut link
    Then system redirects user to Login page
    And Login or Register link present on the page
