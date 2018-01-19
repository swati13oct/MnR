@registrationAddplanpopup
Feature: To test add a plan flow and error for registration flow in redesign portal

  Scenario Outline: To verify member with additional plan is navigated to step 3 (Create Account) after adding another plan on Step2(Plan Information Page)
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then Confirm Plan Details pop up is displayed with correct header
    And Cancel button in top right hand corner is displayed
    And correct second plans member ID value is displayed
      | Second Plan Member ID | <secplanMemberId> |
    And correct second plans Member name value is displayed
      | Second Member name | <secmembername> |
    And correct second plans name value is displayed
      | Second Plan name | <secplanname> |
    And correct second plans Member date of birth value is displayed
      | Second Date of birth | <secdateOfBirth> |
    And verify continue button and cancel link is displayed
    When member clicks continue button
    Then the user is navigated to  Multiple Plan Variation View and the checkbox is checked for both the plans
    And Next button is displayed
    When member clicks on next button
    Then the member navigate to the create account page

    Examples: 
      | Plantype | planMemberId | dateOfBirth | planname                                     | membername   | secplanMemberId | secmembername | secplanname                        | secdateOfBirth |
      | PDP      |   0105048371 | 09-21-1945  | UnitedHealthcare MedicareRx for Groups (PDP) | BFFDBD CDBCD | 803983905-00    | BFFDBD CDBCD  | UnitedHealthcare Senior Supplement | 09-21-1945     |

 