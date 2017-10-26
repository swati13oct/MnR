@goGreen
Feature: To test go green splash save preferences
	
  Scenario Outline: Verify go green splash page
  Given I am a Federal member on the member redesign registration page
  | MemberId | <memberId> |
  | DOB      | <dob>      |
  When the user navigates to go green splash page
  And the user selects the paperless prefereneces
  Then the preferences should be saved
  Then the user validates confirmation message on go green confirmation page
  
  Examples:
  | memberId    |  | dob        |
  | 003072377-1 |  | 07/10/1930 |
  | 374578451-11 |  | 03/01/1949 |
  
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
  
  Scenario Outline: Verify go green splash page
    Given I am a Federal member on the member redesign registration page
      | MemberId | <memberId> |
      | DOB      | <dob>      |
    When the user navigates to go green splash page
    And the user click the save preferences without agree terms and conditions
    Then the user should see the error message

    Examples: 
      | memberId    |  | dob        |
      | 003072377-1 |  | 07/10/1930 |
