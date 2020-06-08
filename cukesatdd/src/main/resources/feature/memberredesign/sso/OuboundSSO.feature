Feature: 1.13 Member Outbound SSO functionality for M&R Member Portal

  @regressionMember
  Scenario Outline: Verify that member of <Test Scenario> is able to perfom Outbound SSO - University of Kentucky - Express Scripts SSO
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And user scrolls down to Express Scripts link to perform outbound SSO
    Then user clicks on Express Scripts link and lands on Express Scripts SSO page in new window

    Examples: 
      | TID   | planType | memberType              | copayCategory | Test Scenario          |
      | XXXXX | MAPD     | universityofkentuckySSO | NON LIS       | University Of Kentucky |

  @regressionMember
  Scenario Outline: Verify that user is able to perfom Outbound SSO - MyHCE_<Test Scenario>
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And user directly access the SSO link for myhce
    And user enters zip code on myhce page and clicks on continue button
      | Zip Code | <zipCode> |
    Then user lands on hceestimator landing page

    Examples: 
      | TID   | planType | memberType | copayCategory | zipCode | Test Scenario         |
      | XXXXX | MAPD     | myhce      | NON LIS       |   30736 | TC_SHBP_Georgia_myHCE |

  @regressionMember
  Scenario Outline: Verify that user is able to perfom Outbound SSO - OptumRx from Benefits and Coverage Page from <optumrxssolink>
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And user scrolls down to OptumRx SSO link to perform outbound OptumRx SSO
      | OptumRx SSO Link | <optumrxssolink> |
    And user clicks on OptumRx SSO link and lands on OptumRx SSO Page in new window
      | OptumRx SSO Link | <optumrxssolink> |

    Examples: 
      | TID   | planType | memberType | copayCategory | Test Scenario   | optumrxssolink                                                  |
      | TC001 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM |
      | TC002 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | LookUpDrugsButton                                               |
      | TC003 | MAPD     | optumrx    | NON LIS       | TC_OptumxRX_SSO | viewDetailsAtOptumrxLink                                        |

  @regressionMember
  Scenario Outline: Verify that user is able to perfom Outbound SSO - OptumRx from Pharmacies and Prescriptions Page from link <optumrxssolink>
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType | <planType> |
    And user scrolls down to OptumRx SSO link on Pharmacies and Prescriptions Page to perform outbound OptumRx SSO
      | OptumRx SSO Link | <optumrxssolink> |
    And user clicks on OptumRx SSO link on Pharmacies and Prescriptions Page and lands on OptumRx SSO Page in new window
      | OptumRx SSO Link | <optumrxssolink> |

    Examples: 
      | TID   | planType                | memberType | copayCategory | Test Scenario   | optumrxssolink           |
      | TC004 | GroupMAPDWithoutPayment | optumrx    | NON LIS       | TC_OptumxRX_SSO | LookUpDrugsButton        |
      | TC005 | GroupMAPDWithoutPayment | optumrx    | NON LIS       | TC_OptumxRX_SSO | orderPrescriptionsButton |
      | TC006 | GroupMAPDWithoutPayment | optumrx    | NON LIS       | TC_OptumxRX_SSO | checkDelieryStatusButton |
      | TC007 | GroupMAPDWithoutPayment | optumrx    | NON LIS       | TC_OptumxRX_SSO | drugCostSummaryButton    |
