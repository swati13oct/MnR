@inactiveTerminatedPlanError
Feature: To test links present on inactive Terminated Plan page

  Scenario Outline: To verify member is navigated to the personal Information page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate inactive or terminated error message
    When member click on start over link on inactive or terminated error page
    Then the member navigate to the personal Information page
    And no previously information is retained

    Examples: 
      | planMemberId | dateOfBirth |
      # | 004560292    | 05-01-1945  |
      #  | 0152322881   | 06-11-1949  |
      | 363335622-11 | 02-01-1939  |
