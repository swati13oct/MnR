@registrationRedesign @Gladiators
Feature: To test registration flow in redesign portal


  Scenario Outline: To verify member is navigated to the registeration plan Information page
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

    Examples: 
      | Plantype           | planMemberId | dateOfBirth | planname                                             |
      | MAPD COSMOS        | 935442812    | 03-03-1952  | UnitedHealthcare MedicareComplete Plan 1 (HMO)       |

  Scenario Outline: To verify registration existing member error page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MAPD NICE         | 002776817    | 10-07-1943  |

  Scenario Outline: To verify registration inactive or terminated member error page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate inactive or terminated error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MA NICE           | 008437131    | 02-15-1952  |

  Scenario Outline: To verify registration Future effective member error page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate future effective error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MAPD NICE         | 008502739    | 02-02-1952  |

  Scenario Outline: To verify registration member not found error page
    Given the member is on sign in page
    And User click on the register button
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate member not found error message

    Examples: 
      | planMemberId | dateOfBirth |
      | 897948810    | 10-09-1946  |
      
 