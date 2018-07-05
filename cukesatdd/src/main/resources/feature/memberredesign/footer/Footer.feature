@codeMonkeys @regression_06_06_18
Feature: C1.1 To test plan benefits and Coverage on UMS site

@member_redesign_footer @IncrediblesFooter @regression_06_06_18
   Scenario Outline: Verify Need Help section
   Given the user login in member site
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
 | planType  | memberType  |
 | MAPD     | IndividualDCEmembers |
