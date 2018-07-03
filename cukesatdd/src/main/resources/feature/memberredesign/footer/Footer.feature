@member_redesign_footer @regression_06_06_18
Feature: C1.1 To test footer on UMS site

  @IncrediblesFooter
  Scenario Outline: Verify footer section is in place
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    Then the user navigates to the footer section
    And the user validates the footer section
    Then the user navigates to payment history
    Then the user navigates to the footer section
    And the user validates the footer section
    Then the user navigates to claims page
    And the user validates the footer section
    Then the user navigates to EOB page
    And the user validates the footer section
    Then the user navigates to Pharmacy locator page
    And the user validates the footer section
    Then the user navigates to DCE home page
    And the user validates the footer section
    Then the user navigates to profile page
    And the user validates the footer section
    Then the user navigates to Preferances page
    And the user validates the footer section
    Then the user navigates to Contact us page
    And the user validates the footer section
    Then the user navigates to Benefits page
    And the user validates the footer section

    Examples: 
      | planType | memberType           |
      | MAPD     | IndividualDCEmembers |
