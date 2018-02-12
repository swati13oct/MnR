@futureEffectivePlanError @Gladiators
Feature: To test links present on future Effective Plan page

  Scenario Outline: To verify member is navigated to the personal Information page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate future effective error message
    When member click on start over link on future effective page
    Then the member navigate to the personal Information page
    And no previously information is retained

    Examples: 
      | planMemberId | dateOfBirth |
     # | 0184295991   | 10-25-1963  |
     # | 399492182-11 | 12-01-1956  |
     #team-h 
      | 968085825    | 07-22-1930  |
