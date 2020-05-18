Feature: 1.13 Member Outbound SSO functionality for M&R Member Portal

  @regressionMemberPROD
  Scenario Outline: Verify that user - <member> is able to perfom Outbound SSO - University of Kentucky - Express Scripts SSO
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And user scrolls down to Express Scripts link to perform outbound SSO
    Then user clicks on Express Scripts link and lands on Express Scripts SSO page in new window

    Examples: 
      | TID   | planType | memberType              | copayCategory | Test Scenario                                       | username | password | member      |
      | XXXXX | MAPD     | universityofkentuckySSO | NON LIS       | TC_Check SSO_University Of Kentucky_Express Scripts | jkuma14  | Brock@02 | Kywoman1953 |

  @regressionMemberPROD
  Scenario Outline: Verify that user is able to perfom Outbound SSO - MyHCE_<Test Scenario>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And user directly access the SSO link for myhce
    And user enters zip code on myhce page and clicks on continue button
      | Zip Code | <zipCode> |
    Then user lands on hceestimator landing page

    Examples: 
      | TID   | planType | memberType | copayCategory | zipCode | Test Scenario             | username | password | member                    |
      | XXXXX | MAPD     | myhce      | NON LIS       |   30527 | TC_SSO_SHBP_Georgia_myHCE | jkuma14  | Brock@02 | Andersonga1@Bellsouth.Net |

  @regressionMemberPROD
  Scenario Outline: Verify that user is able to perfom Outbound SSO - OptumRx from Benefits and Coverage Page from <optumrxssolink>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And user scrolls down to OptumRx SSO link to perform outbound OptumRx SSO
      | OptumRx SSO Link | <optumrxssolink> |
    And user clicks on OptumRx SSO link and lands on OptumRx SSO Page in new window
      | OptumRx SSO Link | <optumrxssolink> |

    Examples: 
      | TID   | planType | memberType | copayCategory | Test Scenario   | optumrxssolink                                                  | username | password | member                    |
      | TC001 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM | jkuma14  | Brock@02 | Andersonga1@Bellsouth.Net |
      | TC002 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | LookUpDrugsButton                                               | jkuma14  | Brock@02 | Andersonga1@Bellsouth.Net |
      | TC003 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | viewDetailsAtOptumrxLink                                        | jkuma14  | Brock@02 | Andersonga1@Bellsouth.Net |

  @regressionMemberPROD1
  Scenario Outline: Verify that user is able to perfom Outbound SSO - OptumRx from Pharmacies and Prescriptions Page from link <optumrxssolink>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    And user scrolls down to OptumRx SSO link on Pharmacies and Prescriptions Page to perform outbound OptumRx SSO
      | OptumRx SSO Link | <optumrxssolink> |
    And user clicks on OptumRx SSO link on Pharmacies and Prescriptions Page and lands on OptumRx SSO Page in new window
      | OptumRx SSO Link | <optumrxssolink> |

    Examples: 
      | TID   | planType | memberType | copayCategory | Test Scenario   | optumrxssolink           | expectLink |
      | TC004 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | LookUpDrugsButton        | yes        |
      | TC005 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | orderPrescriptionsButton | yes        |
      | TC006 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | checkDelieryStatusButton | yes        |
      | TC007 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | drugCostSummaryButton    | yes        |
