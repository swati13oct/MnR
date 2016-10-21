@mymedicamobile
Feature: Test case for My MEDICA Mobile site

  Scenario: To Verify the My MEDICA  Mobile site AboutUs contact us and Sign in page navigation
    Given the user is on the My MEDICA mobile site landing page
    When the user navigate to my medica mobile site About Us Page
    And the user navigate to my medica mobile site Contact Us Page

  @mymedicaregistration
  Scenario Outline: Verify registration for members in My Medica mobile site
    Given the user is on registration page of My Medica mobile site
    When the user registers with below details in My Medica mobile site
      | Plan Member ID | <memberid1>   |
      | Date of birth  | <dateOfBirth> |
    Then the user validates the plan information on plan confirmation page in My Medica mobile site
    When the user confirms the personal and plan information in My Medica mobile site
    And the user registers with the following details in My Medica mobile site
      | Create a username     | <userName>        |
      | Create a password     | <password>        |
      | Confirm password      | <confirmPassword> |
      | Email address         | <email>           |
      | Confirm email address | <confirmEmail>    |
    Then the user registers successfully in My Medica mobile site

    Examples: 
      | memberid1 | dateOfBirth | userName      | password   | confirmPassword | email          | confirmEmail   |
      | 968993858 | 11-11-1945  | mmc_blayer003 | Password@1 | Password@1      | TEST@OPTUM.COM | TEST@OPTUM.COM |
