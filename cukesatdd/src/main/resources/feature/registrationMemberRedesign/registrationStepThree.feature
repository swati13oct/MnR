@registrationStepThree
Feature: To test registration flow in redesign portal

  Scenario Outline: To verify member with no additional plan is navigated to Create Account after clicking next button on Plan Information
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
      | PDP      |    949291584 | 02-17-1952  | Preferred Choice Palm Beach (HMO) | ECCFF BFACFDAFA| Username@1 | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
