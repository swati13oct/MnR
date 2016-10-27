@mypcp
Feature: Test case for My PCP site

  Scenario: To Verify the AboutUs contact us and Sign in page navigation
    Given the user is on the My PCP site landing page
    When the user navigate to About Us Page
    And the user navigate to Contact Us Page
    And the user navigate to My PCP site Access Your Account Page

@mypcpregistration
  Scenario Outline: Verify registration for members in My PCP site
    Given the user is on registration page of My PCP site
    When the user registers with below details in My PCP site
      | Plan Member ID | <memberid1>   |
      | Date of birth  | <dateOfBirth> |
    Then the user validates the plan information on plan confirmation page in My PCP site
    When the user confirms the personal and plan information in My PCP site
    And the user registers with the following details in My PCP site
      | Create a username     | <userName>        |
      | Create a password     | <password>        |
      | Confirm password      | <confirmPassword> |
      | Email address         | <email>           |
      | Confirm email address | <confirmEmail>    |
    Then the user registers successfully in My PCP site
		Then the user navigates to My Account home page in My PCP site
		
    Examples: 
      | memberid1 | dateOfBirth | userName  | password   | confirmPassword | email                   | confirmEmail            |
      | 950592474 | 12-12-1946  | blpcp_012 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |