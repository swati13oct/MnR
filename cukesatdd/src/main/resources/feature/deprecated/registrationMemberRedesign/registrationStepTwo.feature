@registrationStepTwo @Gladiators
Feature: To test registration step 2 flow in redesign portal

  Scenario Outline: To verify member with no additional plan is navigated to Create Account after clicking next button on Plan Information
    Given the member is on sign in page
    And User click on the register button
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
    Then the member navigate to the create account page

    Examples:
    #dev-c and team-h 
      | Plantype | planMemberId | dateOfBirth | planname                        | membername     |
      | MAPD COSMOS     | 930096952    | 08-05-1950  | AARP MedicareComplete Choice (PPO)| AAEDBF DAADCDAFA |
