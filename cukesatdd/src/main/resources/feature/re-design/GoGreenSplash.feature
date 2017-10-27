@velocityDashers
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
      | 003072377-1  |  | 07/10/1930 |
      | 374578451-11 |  | 03/01/1949 |

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
      | memberId     |  | dob        | planName                                             |
      | 018840597-1  |  | 02/24/1937 | HealthSelectSM Medicare RX (PDP)                     |
      | 003072377-1  |  | 07/10/1930 | AARP MedicareComplete SecureHorizons Essential (HMO) |
      | 374578451-11 |  | 03/01/1949 | AARP MEDICARE SUPPLEMENT PLAN                        |

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
      | 003072377-1 |  | 07/10/1930 |
