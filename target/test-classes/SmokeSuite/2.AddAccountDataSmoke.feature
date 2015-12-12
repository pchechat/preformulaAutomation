Feature: My Account smoke test set
 
    Scenario: We need to make sure that user can create new address
    Given user is on Home page
    And user is not logged in
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Address Book page
    And user clicks 'Add a New Address' button
    And user fill address data
      | Andy | Smith | 11 Gallatin Street | Liberty | MO | 64068 | 3239772173 |
    And user saves changes on Address page
    When AVS check pass validation
    Then address wich contain "Andy  Smith" should be present in Address Book list
 
  Scenario: We need to make sure that user can edit/change address information
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Address Book page
    And user press on 'Edit' link for address that contain "Andy  Smith" name that should be present in list on Address Book page
    And user update address data
      | Pablo | Smith | 3502 West Northside Drive | Jackson | MS | 39213 | 3239772333 |
    And user saves changes on Address page
    When AVS check pass validation
    Then address wich contain "Pablo  Smith" should be present in Address Book list

   Scenario: We need to make sure that user can add and delete address from the system
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Address Book page
    And address wich contain "Pablo  Smith" should be present in Address Book list
    When user press on 'Delete' link for address that contain "Pablo  Smith" name that should be present in list on Address Book page
    Then address wich contain "Pablo  Smith" should be absent in Address Book list
  
  Scenario: We need to make sure that user can create new credit card
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Credit Cards page
    And user clicks 'Add a New Card' button
    And user enter credit card data
      | Visa | 4111111111111111 | Apr | 2016 |
    And user enter personal data on credit card section
      | Mona | Z | Malley |
    When user click 'Create Card' button
    Then credit card "Visa ending in 1111" should be present in credit card list

  Scenario: We need to make sure that user can edit/update credit card
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Credit Cards page
    And user press on 'Edit' link for item "Visa ending in 1111" that should be present in list on Credit Cards page
    And user update expiration date
      | Nov | 2019 | Monna | Z | Malley |
    When user click 'Update Card' button
    Then credit card "Expires 11/2019" should be present in credit card list
 
  Scenario: We need to make sure that can delete credit card from the system
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user navigates to Credit Cards page
    And credit card "Visa ending in 1111" should be present in credit card list
    When user press on 'Delete' link for item "Visa ending in 1111" that should be present in list on Credit Cards page
    Then credit card "Visa ending in 1111" should be absent in credit card list
  
  Scenario: We need to make sure that user can edit/change personal details, specified during registration by clicking on "Edit My Profile" button
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user navidates to the Account Overview page
    And user clicks 'Edit My profile' button
    And user change middle name to "M"
    And user clicks on 'Save changes' button
    Then system displays success message "Your profile was successfully updated."
    And system displays an updated name "Elena M Lim" on My Profile Page