@registrationStepTwo
Feature: To test registration flow in redesign portal

  Scenario Outline: To verify member is navigated to step 1 (Personal Information) after clicking previous button on Step 2 (plan Information)
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name id displayed
      | Plan name | <planname> |
    And Member ID field and its value is displayed
    And Member name field and its value is displayed
    And Member date of birth field and its value is displayed
    And Previous button is displayed
    And Next button is displayed
    When member clicks on previous button
    Then Step 1 personal information page is displayed
    And Member ID and Date of birth is prepopulated with previously entered values.
    
    Examples: 
      | Plantype   | planMemberId | dateOfBirth | planname |
      | PDP        | 0187121481    | 06-23-1949  | AARP MedicareRx Walgreens (PDP)  |
      
      
 Scenario Outline: To verify member with no additional plan is navigated to step 3 (Create Account) after clicking next button on Step 2 (plan Information)
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name id displayed
      | Plan name | <planname> |
    And Member ID field and its value is displayed
    And Member name field and its value is displayed
    And Member date of birth field and its value is displayed
    And Previous button is displayed
    And Next button is displayed
    When member clicks on next button
    Then Step 3 create account page is displayed
        
    Examples: 
      | Plantype   | planMemberId | dateOfBirth | planname |
      | PDP        | 0187121481    | 06-23-1949  | AARP MedicareRx Walgreens (PDP)  |
      
 
 Scenario Outline: To verify member with additional plan is navigated to step 3 (Create Account) after clicking next button on Step 2 (plan Information)
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name id displayed
      | Plan name | <planname> |
    And Member ID field and its value is displayed
    And Member name field and its value is displayed
    And Member date of birth field and its value is displayed
    And Previous button is displayed
    And Next button is displayed
    When member clicks on next button
    Then Additional Plans section is displayed on step 2 Plan Information page
        
    Examples: 
      | Plantype   | planMemberId | dateOfBirth | planname |
      | PDP        | 0187121481    | 06-23-1949  | AARP MedicareRx Walgreens (PDP)  |