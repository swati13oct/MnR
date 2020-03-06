@footer @member_redesign_footer @regressionMember
Feature: 1.05 Member Footer validation

  @footer01 @thePredators
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify footer section is in place
    # note: not going to validate pages from Rally, i.e. Dashboard (DCE), Find Care & Costs
    # note: if system is in future date, payment page may not show for user and this test will end up failing
    # note: this scenario covers multiple testcases: TID 15347,15348,15349,15350,15351
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
    Then the user navigates to the Order Plan Materials page
    And the user validates the footer section in Order Plan Materials page
    Then the user navigates to the Health and Wellness page
    And the user validates the footer section in Health and Wellness page
    Then the user navigates to the Pharmacies and Prescriptions page
    And the user validates the footer section in Pharmacies and Prescriptions page

    @devRegression
    Examples: 
     | TID   | planType | memberType                 |
     | 15347 | MAPD     | IndMAPDUHC_footer          |
    #| 15347 | MAPD     | CALPERSGroup_ContactUs     |
      
      
  @footer02 @thePredators @shipFooter
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify footer section is in place for SHIP member
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
    Then the user navigates to profile and pref page for Ship member
    And the user validates the footer section in pref page
    Then the user navigates to Contact us page
    And the user validates the footer section in contact us page
    Then the user navigates to Benefits page
    And the user validates the footer section in Benefits page
    Then the user navigates to the Order Plan Materials page
    And the user validates the footer section in Order Plan Materials page
    Then the user navigates to the Health and Wellness page
    And the user validates the footer section in Health and Wellness page
    Then the user navigates to the Pharmacies and Prescriptions page
    And the user validates the footer section in Pharmacies and Prescriptions page

    Examples: 
      | TID   | planType | memberType    |
      | 15347 | SHIP     | IND_footer    |