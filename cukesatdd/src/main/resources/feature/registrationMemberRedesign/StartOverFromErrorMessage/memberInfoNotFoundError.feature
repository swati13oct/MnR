@memberInfoNotFoundError @Gladiators
Feature: To test links present on member Info Not Found Error page

  Scenario Outline: To verify member is navigated to the personal Information page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate member not found error message
    When member click on start over link on member not found error page
    Then the member navigate to the personal Information page
    And no previously information is retained

    Examples: 
      | planMemberId | dateOfBirth |
      #dev-c and team-h
      | 897948810    | 10-09-1946  |
