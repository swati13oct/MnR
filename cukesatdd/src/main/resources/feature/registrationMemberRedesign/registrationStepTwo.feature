@registrationStepTwo
Feature: To test registration flow in redesign portal

  Scenario Outline: To verify member is navigated to Personal Information after clicking previous button on Plan Information page
    Given the member is on registration page of new portal part of redesign
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
    When member clicks on previous button
    Then the member navigate to the personal Information page
    And Member ID and Date of birth is prepopulated with previously entered values.
      | Plan Member ID | <planMemberId> |
      | Date of birth  | <dateOfBirth>  |

    Examples: 
    #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                        | membername     |
      | PDP      | 0187121481   | 06-23-1949  | AARP MedicareRx Walgreens (PDP) | BAECCEB CFCBBF |

  Scenario Outline: To verify member with no additional plan is navigated to Create Account after clicking next button on Plan Information
    Given the member is on registration page of new portal part of redesign
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
      | PDP      | 0187121481   | 06-23-1949  | AARP MedicareRx Walgreens (PDP) | BAECCEB CFCBBF |

  Scenario Outline: To verify member with additional plan is navigated to step 3 (Create Account) after clicking next button on Step 2 (plan Information)
    Given the member is on registration page of new portal part of redesign
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
    Then the member navigate to the Additional Plans section is displayed on Plan Information page

    Examples: 
      | Plantype     | planMemberId | dateOfBirth | planname                                     | membername       |
      | PDP          | 0105048371   | 09-21-1945  | UnitedHealthcare MedicareRx for Groups (PDP) | BFFDBD CDBCD     |
      | SSUP         | 803983905-00 | 09-21-1945  | UnitedHealthcare Senior Supplement           | BFFDBD CDBCD     |
      | PDP          | 1011277011   | 05-13-1929  | AARP MedicareRx Saver Plus (PDP)             | EEDDAECC ABDEDFB |
      | SHIP MedSupp | 101127701-11 | 05-13-1929  | AARP MEDICARE SUPPLEMENT PLAN                | EEDDAECC ABDEDFB |