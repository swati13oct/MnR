@gladiators
@existingMemberErrorPage
Feature: To test Start Over link present on existing member error page

@existinMemberError
Scenario Outline: To verify already existing member error message page
    Given the member is on sign in page
    And User click on the register button
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
      | 004606801-1    | 05-28-1947  |

@navigationToPasswordHelpPage
  Scenario Outline: To verify member is navigated to the username and password help page from existing member error page
    Given the member is on sign in page
    And User click on the register button
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
      | 004606801-1    | 05-28-1947  |

@navigationToSignInPage
  Scenario Outline: To verify member is navigated to the sign In page from existing member error page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message
    When member click on Sign in link on existing member page
    Then the member navigate to the Sign in page

    Examples: 
      | planMemberId | dateOfBirth |
      | 004606801-1    | 05-28-1947  |

  @futureEffectivePlanError
  Scenario Outline: To verify future effective member error message page
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
      | 968085825    | 07-22-1930  |

  @inactiveTerminatedPlanError
  Scenario Outline: To verify inactive or terminated member error message page
    Given the member is on sign in page
    And User click on the register button
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
      | 015232288    | 06-11-1949  |

  @memberInfoNotFoundError
  Scenario Outline: To verify unable to confirm personal infomation member error message page
    Given the member is on sign in page
    And User click on the register button
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
      | 897948810    | 10-09-1946  |
      

@pffsMemberErrorPage
  Scenario Outline: To verify member is navigated to the registration page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validates pffs member error message
    
    Examples: 
      | planMemberId | dateOfBirth |
      #dev-c and team-h
      | 929173773    | 02-09-1952  |
     
 @memberIdRequiredError
  Scenario Outline: To verify registration member id required field error message
    Given the member is on sign in page
    And User click on the register button
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate member id required error message

    Examples: 
      | dateOfBirth |
      | 12-12-1920  |

 @dobRequiredError
  Scenario Outline: To verify registration dob required field error message
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    When member click Next
    Then the member validate dob required error message

    Examples: 
      | planMemberId |
      | 897948810    |

 @thirteenYearOrYoungerError
  Scenario Outline: To verify registration dob fields thirteen years or younger error message
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate dob fields thirteen years or younger error message

    Examples: 
      | planMemberId | dateOfBirth |
      #team-h and dev-c
      | 897948810    | 12-12-2016  |


 @snpMemberError
  Scenario Outline: To verify registration snp error message
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate snp error message

    Examples: 
      | planMemberId | dateOfBirth |
      #team-h and dev-c
      | 910454755    | 12-31-1957  |

