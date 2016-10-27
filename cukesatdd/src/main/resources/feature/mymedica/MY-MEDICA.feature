@mymedica
Feature: Test case for My MEDICA site

  Scenario: To Verify the My MEDICA AboutUs contact us and Sign in page navigation
    Given the user is on the My MEDICA site landing page
    When the user navigate to my medica About Us Page
    And the user navigate to my medica Contact Us Page

  @mymedicaregistration
  Scenario Outline: Verify registration for members in My Medica site
    Given the user is on registration page of My Medica site
    When the user registers with below details in My Medica site
      | Plan Member ID | <memberid1>   |
      | Date of birth  | <dateOfBirth> |
    Then the user validates the plan information on plan confirmation page in My Medica site
    When the user confirms the personal and plan information in My Medica site
    And the user registers with the following details in My Medica site
      | Create a username     | <userName>        |
      | Create a password     | <password>        |
      | Confirm password      | <confirmPassword> |
      | Email address         | <email>           |
      | Confirm email address | <confirmEmail>    |
    Then the user registers successfully in My Medica site
    Then the user navigates to My Account home page in My Medica site

    Examples: 
      | memberid1 | dateOfBirth | userName      | password   | confirmPassword | email          | confirmEmail   |
      | 968993858 | 11-11-1945  | mmc_blayer003 | Password@1 | Password@1      | TEST@OPTUM.COM | TEST@OPTUM.COM |
