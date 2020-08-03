@footer @member_redesign_footer
Feature: 1.05.1 Member Footer validation - Member Auth

  @memAuth_footer01
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify footer section is in place
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to EOB page
    And the user validates the footer section in EOB page
    Then the user navigates to payment history page
    Then the user navigates to the footer section
    And the user validates the footer section in payments page
    #Then the user navigates to claims page
    #And the user validates the footer section in claims page
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

    Examples:
      | TID   | username  | password  | MemUserName         | planType | memberType        |
      | 15347 | qavgogine | qavgogine | q2_apr_aarp0250     | MAPD     | IndMAPDUHC_footer |
      | 15347 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020 | MEDICA   | Ind_footer        |
      | 15347 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022 | PCP      | Ind_footer        |

  @memAuth_footer02
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify footer section is in place for SHIP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to EOB page
    And the user validates the footer section in EOB page
    Then the user navigates to payment history page
    Then the user navigates to the footer section
    And the user validates the footer section in payments page
    #Then the user navigates to claims page
    #And the user validates the footer section in claims page
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
      | TID   | username  | password  | MemUserName        | planType | memberType |
      | 15347 | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | IND_footer |

  @memAuth_footer03
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Need Help section is in place
    # note: not going to validate pages from Rally, i.e. Dashboard (DCE), Find Care & Costs
    # note: if system is in future date, payment page may not show for user and this test will end up failing
    # note: this scenario covers multiple testcases: TID 15347,15348,15349,15350,15351
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to EOB page
    Then user validates Need Help section content for EOB page
    Then the user navigates to payment history page
    Then the user navigates to the footer section
    Then user validates Need Help section content for payment page
    #Then the user navigates to claims page
    #Then user validates Need Help section content for claims page
    Then the user navigates to profile and pref page
    Then user validates Need Help section content for account setting page
    Then the user navigates to Benefits page
    Then user validates Need Help section content for benefits page
    Then the user navigates to the Order Plan Materials page
    Then user validates Need Help section content for order plan materials page
    Then the user navigates to the Health and Wellness page
    Then user validates Need Help section content for health and wellness page
    Then the user navigates to the Pharmacies and Prescriptions page
    Then user validates Need Help section content for pharmacies and prescriptions page

    Examples:
      | TID   | username  | password  | MemUserName         | planType | memberType        |
      | 15347 | qavgogine | qavgogine | q2_apr_aarp0250     | MAPD     | IndMAPDUHC_footer |
      | 15347 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020 | MEDICA   | Ind_footer        |
      | 15347 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022 | PCP      | Ind_footer        |

  @memAuth_footer04
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Need Help section is in place for SHIP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to EOB page
    Then user validates Need Help section content for EOB page
    Then the user navigates to payment history page
    Then the user navigates to the footer section
    Then user validates Need Help section content for payment page
    #Then the user navigates to claims page
    #Then user validates Need Help section content for claims page
    Then the user navigates to profile and pref page
    Then user validates Need Help section content for account setting page
    Then the user navigates to Benefits page
    Then user validates Need Help section content for benefits page
    Then the user navigates to the Order Plan Materials page
    Then user validates Need Help section content for order plan materials page
    Then the user navigates to the Health and Wellness page
    Then user validates Need Help section content for health and wellness page
    #Then the user navigates to the Pharmacies and Prescriptions page
    #Then user validates Need Help section content for pharmacies and prescriptions page

    Examples:
      | TID   | username  | password  | MemUserName        | planType | memberType            |
      | 15347 | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | IND_footer            |
      #note: combo user with SHIP priority
      | xxxxx | qavgogine | qavgogine | q2_jun_uhc0009     | MAPD     | SHIP_FED_COMBO_footer |
