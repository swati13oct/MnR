@registrationAddplanpopup
Feature: To test add a plan flow and error for registration flow in redesign portal

  Scenario Outline: To verify member with additional plan is navigated to step 3 (Create Account) after adding another plan on Step2(Plan Information Page)
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then Confirm Plan Details pop up is displayed
    And verify Add Plan Popup Header is displayed
    And Cancel button in top right hand corner is displayed
    And correct second plans member ID value is displayed
      | Second Plan Member ID | <secplanMemberId> |
    And correct second plans Member name value is displayed
      | Second Member name | <secmembername> |
    And correct second plans name value is displayed
      | Second Plan name | <secplanname> |
    And correct second plans Member date of birth value is displayed
      | Second Date of birth | <secdateOfBirth> |
    And verify continue and cancel button is displayed
    When member clicks continue button
    Then the user is navigated to  Multiple Plan Variation View and the checkbox is checked for both the plans
    And Next button is displayed
    When member clicks on next button
    Then the member navigate to the create account page

    Examples: 
      | Plantype | planMemberId | dateOfBirth | planname                                     | membername   | secplanMemberId | secmembername | secplanname                        | secdateOfBirth |
      | PDP      |   0105048371 | 09-21-1945  | UnitedHealthcare MedicareRx for Groups (PDP) | BFFDBD CDBCD | 803983905-00    | BFFDBD CDBCD  | UnitedHealthcare Senior Supplement | 09-21-1945     |

  # | SSUP         | 803983905-00 | 09-21-1945  | UnitedHealthcare Senior Supplement           | BFFDBD CDBCD     |
  # | PDP          | 1011277011   | 05-13-1929  | AARP MedicareRx Saver Plus (PDP)             | EEDDAECC ABDEDFB |
  # | SHIP MedSupp | 101127701-11 | 05-13-1929  | AARP MEDICARE SUPPLEMENT PLAN                | EEDDAECC ABDEDFB |
  Scenario Outline: To verify error message if member enters invalid member id for a plan
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then error message of invalid member id is displayed

    Examples: 
      | Plantype | planMemberId | dateOfBirth | secplanMemberId |
      | PDP      |   0105048371 | 09-21-1945  |          123456 |

  Scenario Outline: To verify error messages if member enters same second plan member id as the first one
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then error message of same member id registered is displayed

    Examples: 
      | Plantype | planMemberId | dateOfBirth | secplanMemberId |
      | PDP      |   0105048371 | 09-21-1945  |      0105048371 |

  Scenario Outline: To verify error messages if member enters second plan member for future effective date plan
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then error message of plan has a future effective date is displayed

    Examples: 
      | planMemberId | dateOfBirth | secplanMemberId |
      | 969663858-00 | 05-20-1938  |      0099560331 |

  Scenario Outline: To verify error messages if member enters second plan member for terminated plan
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then error message of plan being terminated is displayed

    Examples: 
      | planMemberId | dateOfBirth | secplanMemberId |
      |   0096662331 | 06-14-1942  |       968640818 |

  Scenario Outline: To verify error messages if member enters second plan member for already registered
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Previous button is displayed
    And Next button is displayed
    When member clicks on Next button
    Then the member navigate to the Additional Plans section is displayed on Plan Information page
    When member enters memberid for second plan into member id text field
      | Second Plan Member ID | <secplanMemberId> |
    And clicks on Add a Plan button
    Then error message of member id already registered is displayed

    Examples: 
      | planMemberId | dateOfBirth | secplanMemberId |
      |   0096662331 | 06-14-1942  |       968640818 |
