Feature: 1.13 Member Inbound and Outbound SSO functionality for M&R Member Portal

  @sso
  Scenario Outline: TID: <TID> -Group: <GroupName> -SSO Partner: <ssoPartner> - Verify North Carolina SSO functionality and check that security and password reset links are not displayed on profile page.
    Given the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button
      | CQ UserName | <userName> |
      | CQ Password | <passWord> |
    And the user enters details of member on the SSO test harness page and click submit
      | SSO Partner | <ssoPartner>  |
      | First Name  | <firstName>   |
      | Last Name   | <lastName>    |
      | DOB         | <dateOfBirth> |
      | UHCID       | <uhcID>       |
      | EAID        | <eaID>        |
      | EmpNumber   | <empNumber>   |
    And user click on SSO link generated on the page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link
    Then security and password reset link should not be visible

    Examples: 
      | TID   | GroupName | ssoPartner   | firstName | lastName  | dateOfBirth | uhcID     | eaID | empNumber | userName       | passWord   |
      | 15364 | NC        | benefitfocus | WIDAAD    | BOURGOYNE |    12111948 | 522290266 |      |           | sso_dummy_user | Password@1 |

  @sso
  Scenario Outline: TID: <TID> -Group: <GroupName> -SSO Partner: <ssoPartner> - Verify AT&T SSO functionality and check that security and password reset links are not displayed on profile page.
    Given the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button
      | CQ UserName | <userName> |
      | CQ Password | <passWord> |
    And the user enters details of member on the SSO test harness page and click submit
      | SSO Partner | <ssoPartner>  |
      | First Name  | <firstName>   |
      | Last Name   | <lastName>    |
      | DOB         | <dateOfBirth> |
      | UHCID       | <uhcID>       |
      | EAID        | <eaID>        |
      | EmpNumber   | <empNumber>   |
    And user click on SSO link generated on the page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link
    Then security and password reset link should not be visible

    Examples: 
      | TID   | GroupName | ssoPartner | firstName | lastName  | dateOfBirth | uhcID              | eaID | empNumber | userName       | passWord   |
      | 15362 | AT&T      | aonhewitt  | NAWAZISH  | LAMOUREUX |    05231937 | 542670610777869450 |      |           | sso_dummy_user | Password@1 |

  @sso
  Scenario Outline: TID: <TID> -Group: <GroupName> -SSO Partner: <ssoPartner> - Verify Verizon MA SSO functionality and check that security and password reset links are not displayed on profile page.
    Given the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button
      | CQ UserName | <userName> |
      | CQ Password | <passWord> |
    And the user enters details of member on the SSO test harness page and click submit
      | SSO Partner | <ssoPartner>  |
      | First Name  | <firstName>   |
      | Last Name   | <lastName>    |
      | DOB         | <dateOfBirth> |
      | UHCID       | <uhcID>       |
      | EAID        | <eaID>        |
      | EmpNumber   | <empNumber>   |
    And user click on SSO link generated on the page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link
    Then security and password reset link should not be visible

    Examples: 
      | TID   | GroupName  | ssoPartner | firstName | lastName | dateOfBirth | uhcID | eaID      | empNumber | userName       | passWord   |
      | 15363 | Verizon MA | conduent   | KARENE    | ABBAS    |    04021949 |       | 772911154 |    023978 | sso_dummy_user | Password@1 |

  @sso
  Scenario Outline: TID: <TID> -Group: <GroupName> -SSO Partner: <ssoPartner> - Verify Verizon MAPD SSO functionality and check that security and password reset links are not displayed on profile page.
    Given the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button
      | CQ UserName | <userName> |
      | CQ Password | <passWord> |
    And the user enters details of member on the SSO test harness page and click submit
      | SSO Partner | <ssoPartner>  |
      | First Name  | <firstName>   |
      | Last Name   | <lastName>    |
      | DOB         | <dateOfBirth> |
      | UHCID       | <uhcID>       |
      | EAID        | <eaID>        |
      | EmpNumber   | <empNumber>   |
    And user click on SSO link generated on the page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link
    Then security and password reset link should not be visible

    Examples: 
      | TID   | GroupName    | ssoPartner | firstName  | lastName | dateOfBirth | uhcID | eaID      | empNumber | userName       | passWord   |
      | 15388 | Verizon MAPD | conduent   | ABDUL-MUHS | BIEBERLY |    07031943 |       | 911172423 |    002230 | sso_dummy_user | Password@1 |

  @regressionMemberInboundSSO
  Scenario Outline: Verify that user is able to perfom Inbound SSO for <Scenario> from Ping Federate Test Harness Page
    Given User lands on the ping federate SSO test harness page
    And testharness page is displayed with all the fields
    And User enter details on ping federate test harness page
      | SAML_SUBJECT  | <samlsubject>   |
      | First Name    | <firstName>     |
      | Last Name     | <lastName>      |
      | DOB           | <dateOfBirth>   |
      | MBI           | <mbi>           |
      | APPLANDINGURL | <applandingurl> |
      | UHC_ID        | <uhcid>         |
    And user clicks on submit button on the Ping Federate Test Harness Page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link

    Examples: 
      | samlsubject   | firstName | lastName   | dateOfBirth | mbi         | applandingurl                                             | Scenario           | uhcid    |
      | bswift        | NARDA     | HAGERTY    |    09101939 | 6RE3H79NH60 | https://stage-medicare.uhc.com/sso/inbound/bswift         | CenterPoint Energy |          |
      | Bristol Myers | DIMITRIOS | FELLENBAUM |    08161935 | 5KP7H08MG55 | https://stage-medicare.uhc.com/sso/inbound/morneaushepell | Bristol Myers      |          |
      | canopyhealth  | NICOLETTE | WOLTZ      |    06291942 | 5AK3Q74MP80 | https://stage-medicare.uhc.com/sso/inbound/canopy         | Canopy Health      |          |
      | MCHCP         | MARGERY   | HOLWAY     |    09091955 |             | https://stage-medicare.uhc.com/sso/inbound/mchcp          | State of MO        | RC443160 |

  @regressionMemberOutboundSSO
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

  @regressionMemberOutboundSSO
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

  @regressionMemberOutboundSSO
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

  @regressionMemberOutboundSSO
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
