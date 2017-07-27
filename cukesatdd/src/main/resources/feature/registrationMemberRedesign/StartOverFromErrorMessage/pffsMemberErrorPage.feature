@pffsMemberErrorPage

Feature: To validate pffs error on the registration page

  Scenario Outline: To verify member is navigated to the registration page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validates pffs member error message
    
    Examples: 
      | planMemberId | dateOfBirth |
      | 929173773    | 02-09-1952  |