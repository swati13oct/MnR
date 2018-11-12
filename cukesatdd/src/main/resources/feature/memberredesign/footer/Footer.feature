@member_redesign_footer @regression_06_06_18
Feature: Footer validation



  @IncrediblesFooter
  Scenario Outline: Verify footer section is in place
  # note: not going to validate pages from Rally, i.e. Dashboard (DCE), Find Care & Costs
  # note: if system is in future date, payment page may not show for user and this test will end up failing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    Then the user navigates to the footer section
    And the user validates the footer section in payments page
    Then the user navigates to claims page
    And the user validates the footer section in claims page
    Then the user navigates to EOB page to validate footer
    And the user validates the footer section in EOB page
    Then the user navigates to profile and pref page
    And the user validates the footer section in pref page
    Then the user navigates to Contact us page
    And the user validates the footer section in contact us page
    Then the user navigates to Benefits page
    And the user validates the footer section in Benefits page

    Examples: 
      | planType | memberType           |
      | MAPD     | withRider |
