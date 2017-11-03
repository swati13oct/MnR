@goGreen
Feature: To test go green splash page

  @goGreen
  Scenario Outline: Verify go green splash page
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And the user selects the paperless prefereneces
    Then the preferences should be saved
    Then the user validates confirmation message on go green confirmation page

    Examples: 
      | memberId     |  | dob        |
      | 000343946-1  |  | 15/09/1941 |
      | 316454846-11 |  | 08/01/1945 |
      | 960450657-1  |  | 21/08/1942 |

  @goGreen
  Scenario Outline: Verify go green splash page for COMBO member
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And the user selects the paperless prefereneces
    Then the preferences should be saved
    Then the user validates confirmation message on go green confirmation page

    Examples: 
      | memberId    |  | dob        |
      | 972430828-1 |  | 18/03/1942 |

  @goGreen
  Scenario Outline: Verify plan name on Go Green splash page for Texas ERS member
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And validate the plan name
      | PlanName | <planName> |

    Examples: 
      | memberId     |  | dob        | planName                                        |
      | 018873498-1  |  | 28/11/1951 | HealthSelectSM Medicare RX (PDP)                |
      | 000343946-1  |  | 15/09/1941 | UnitedHealthcare Group Medicare Advantage (HMO) |
      | 316454846-11 |  | 08/01/1945 | AARP MEDICARE SUPPLEMENT PLAN                   |

  @goGreen
  Scenario Outline: Verify go green splash error message on page
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And the user click the save preferences without agree terms and conditions
    Then the user should see the error message

    Examples: 
      | memberId    |  | dob        |
      | 000343946-1 |  | 15/09/1941 |
