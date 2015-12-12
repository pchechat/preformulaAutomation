Feature: Remove My Account Data smoke test set

  Scenario: We need to delete Credit Cards created during Smoke test
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Credit Cards page
    When user deletes all credit cards
    Then no credit cards are present on the Credit Cards page

  Scenario: We need to delete Addresses created during Smoke test
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Address Book page
    And user deletes all addresses except firts
#    Then system displays address on Address Book page
#      | Elena  Lim | 1225 WILSHIRE BLVD, LOS ANGELES, CA 90017-1901, United States |

  Scenario: We need to make sure that user can view a list of placed orders from My Orders page
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    When user navigates to My Orders page
    Then system displays list of My Orders

  Scenario: We need to make sure that user can cancel an order
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to My Orders page
    And user select first order in list with status "New Order"
    And user clicks 'Cancel Order' button
    When user clicks 'Yes' button to cancel order
    Then system displays success message "Your order was successfully canceled."
