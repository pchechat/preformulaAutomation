Feature: Authentication smoke test set

  Scenario: We need to make sure that end user can create a new account
    Given user is on Registration page
    When user enters registration data
      | Elena | Lim | 1225 WILSHIRE BLVD | LosAngeles | CA | 90016 | 3239772122 | {auto^a1^5^@gmail.com} | Test1234! |
    And user clicks Create my account button
    And AVS check pass validation
    Then system redirects user to Thank you Registration page / Survey page

  Scenario: We need to make sure that end user can log out from the site
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    When user clicks LogOut link
    Then system redirects user to Login page
    And Login or Register link present on the page

  Scenario: We need to make sure that end user can log in with email, specified during registration
    Given user is on Login page
    When user enters in Email address field "wting@discardmail.com"
    And user enters in Password field "Test1234!"
    And user clicks Login button
    Then system redirects user to the Account Overview page

  Scenario: We need to make sure that end user can logout and reset a forgotten password
    Given user is on Home page
    And user is logged in the system with credentials
      | wting@discardmail.com | Test1234! |
    And user clicks LogOut link
    And user clicks 'Forgot password' link
    And user enters in Email address field "wting@discardmail.com"  on Forgot Password page
    When user clicks Continue button on Forgot Password page
    Then system displays success message "Your reset password email has been successfully sent."

  Scenario: We need to make sure that end user can logout and login with Facebook credentials
    Given user is on Login page
    And user is not logged in
    And user clicks 'Login with Facebook' button
    When user enter Facebook data
      | testfacebook@i.ua | 18071991 |
    Then system redirects user to the Account Overview page
