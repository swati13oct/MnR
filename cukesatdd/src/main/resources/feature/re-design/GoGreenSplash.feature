@goGreen
Feature: To test go green splash page

  Scenario Outline: Verify go green splash page and validate confirmation message
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And the user selects the paperless prefereneces
    Then the preferences should be saved
    Then the user validates confirmation message on go green confirmation page

    Examples: 
      | memberId    |  | dob        |
      |   969385135 |  | 12/06/1949 |
      |   904258676 |  | 14/08/1947 |
      |   003303086 |  | 26/09/1928 |
      |   008517902 |  | 28/02/1971 |
      |   000609631 |  | 18/11/1944 |
      |   968826992 |  | 22/01/1948 |
      |   851127195 |  | 21/08/1937 |
      |   008532606 |  | 04/10/1951 |
      |   018358177 |  | 20/11/1960 |

  #| 349898423-11 |  | 01/08/1945 |
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
      #| 349898423-11 |  | 01/08/1945 | AARP EXTENDED BASIC MEDICARE SUPPLEMENT PLAN    |

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
