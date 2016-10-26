@mypcpmobile
Feature: Test case for My PCP Mobile site
Scenario:To Verify the  My PCP Mobile site AboutUs contact us and Sign in page navigation
Given the user is on the My PCP mobile site landing page
When the user navigate to My PCP mobile site About Us Page
And the user navigate to My PCP mobile site Contact Us Page
And the user navigate to My PCP mobile site Access Your Account Page

@mypcpregistration
  Scenario Outline: Verify registration for members in My PCP mobile site
    Given the user is on registration page of My PCP mobile site
    When the user registers with below details in My PCP mobile site
      | Plan Member ID | <memberid1>   |
      | Date of birth  | <dateOfBirth> |
    Then the user validates the plan information on plan confirmation page in My PCP mobile site
    When the user confirms the personal and plan information in My PCP mobile site
    And the user registers with the following details in My PCP mobile site
      | Create a username     | <userName>        |
      | Create a password     | <password>        |
      | Confirm password      | <confirmPassword> |
      | Email address         | <email>           |
      | Confirm email address | <confirmEmail>    |
    Then the user registers successfully in My PCP mobile site

    Examples: 
      | memberid1 | dateOfBirth | userName  | password   | confirmPassword | email                   | confirmEmail            |
      | 930857169 | 06-28-1950  | blpcp_011 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |