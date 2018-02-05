@gladiators
@registrationAccConfirmation
Feature: To test registration flow in redesign portal

 @memberRegistrationFlow
 Scenario Outline: To verify the member registration flow in redesign portal
    Given the member is on registration page of redesign portal
      | CREATE_ACCOUNT_USER_NAME | <userName> |
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name is displayed
      | Plan name | <planname> |
    And correct member ID value is displayed
      | Plan Member ID | <planMemberId> |
    And correct Member name value is displayed
      | Member name | <membername> |
    And correct Member date of birth value is displayed
      | Date of birth | <dateOfBirth> |
    And Previous button is displayed
    And Next button is displayed
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName> |
      | CREATE_ACCOUNT_PASSWORD         | <password> |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <password> |
      | CREATE_ACCOUNT_EMAIL            | <email>    |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <email>    |
    And click on confirm registration
    Then member navigate to plan confirmation page
    And Verify correct member name is displayed
      | Member name | <membername> |
    And correct Member DOB value is displayed
      | Date of birth | <dateOfBirth> |
    And correct username is displayed
      | User Name | <userName> |
    And correct email is displayed
      | Email | <email> |
    When member click on go to home page button
    Then member navigate to Rally dashboard home page

    Examples: 
      | planMemberId | dateOfBirth | planname                          | membername      | userName   | password   | email          |
      | 949291584    | 02-17-1952  | Preferred Choice Palm Beach (HMO) | ECCFF BFACFDAFA | Username@1 | Password@1 | member@uhc.com |

