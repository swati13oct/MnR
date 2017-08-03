@existingMemberErrorPage
Feature: To test Start Over link present on existing member error page

  Scenario Outline: To verify member is navigated to the personal Information page on clicking start over link
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message
    When member click on start over link on  existing member page
    Then the member navigate to the personal Information page
    And no previously information is retained

    Examples: 
      | planMemberId | dateOfBirth |
      #dev-c
     # | 957566851    | 03-26-1952  |
     # | 008511769    | 05-09-1946  |
   #team-h member 
   | 9809909891   | 10-13-1927  |
  Scenario Outline: To verify member is navigated to the username and password help page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message
    When member click on username and password help link on existing member page
    Then the member navigate to the username and password help page

    Examples: 
      | planMemberId | dateOfBirth |
      #dev-c
     # | 930564080    | 03-01-1952  |
     # | 002776817    | 10-07-1943  |
      #team-h member 
   | 9809909891   | 10-13-1927  |  
  Scenario Outline: To verify member is navigated to the sign In page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message
    When member click on Sign in link on existing member page
    Then the member navigate to the Sign in page

    Examples: 
    #dev-c and team-h
      | planMemberId | dateOfBirth |
      | 9809909891   | 10-13-1927  |
      | 980990989-11 | 10-13-1927  |
