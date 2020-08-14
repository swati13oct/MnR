Feature: 1.13 Member Inbound SSO functionality tested from TestHarness page for M&R Member Portal

  #This scenario below cannot be tested as test harness page is no longer working
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

  #This scenario below cannot be tested as test harness page is no longer working
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

  #This scenario below cannot be tested as test harness page is no longer working
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

  #This scenario below cannot be tested as test harness page is no longer working
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

  @regressionMember
  Scenario Outline: Verify that user is able to perfom Inbound SSO for <Scenario> from Ping Federate Test Harness Page
    Given User lands on the ping federate SSO test harness page
    And testharness page is displayed with all the fields
    And User enter details on ping federate test harness page
      | SAML_SUBJECT  | <samlsubject>   |
      | First Name    | <firstName>     |
      | Last Name     | <lastName>      |
      | DOB           | <dateOfBirth>   |
      | MBI           | <mbi>           |
      | APPLANDINGURLSTAGE | <applandingurlStage> |
      | APPLANDINGURLTEAHH | <applandingurlteamh> |
      | APPLANDINGURLOFFLINESTAGE | <applandingurlofflinestage> |
      | UHC_ID        | <uhcid>         |
    And user clicks on submit button on the Ping Federate Test Harness Page
    Then user should be navigated to home page of rally dashboard
    And user clicks on account setting link

    Examples: 
      | samlsubject   | firstName | lastName   | dateOfBirth | mbi         | applandingurlStage                                             | Scenario           | uhcid    | applandingurlteamh                                                                   | applandingurlofflinestage                                         |
      | bswift        | NARDA     | HAGERTY    |    09101939 | 6RE3H79NH60 | https://stage-medicare.uhc.com/sso/inbound/bswift         | CenterPoint Energy |          | https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/sso/inbound/bswift         | https://offline-stage-medicare.uhc.com/sso/inbound/bswift         |
      | Bristol Myers | DIMITRIOS | FELLENBAUM |    08161935 | 5KP7H08MG55 | https://stage-medicare.uhc.com/sso/inbound/morneaushepell | Bristol Myers      |          | https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/sso/inbound/morneaushepell | https://offline-stage-medicare.uhc.com/sso/inbound/morneaushepell |
      | canopyhealth  | MARYBETH  | NEUBURGER  |    05281938 | 2EE1V96VD04 | https://stage-medicare.uhc.com/sso/inbound/canopy         | Canopy Health      |          | https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/sso/inbound/canopy         | https://offline-stage-medicare.uhc.com/sso/inbound/canopy         |
      | MCHCP         | MARGERY   | HOLWAY     |    09091955 |             | https://stage-medicare.uhc.com/sso/inbound/mchcp          | State of MO        | RC443160 | https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/sso/inbound/mchcp          | https://offline-stage-medicare.uhc.com/sso/inbound/mchcp          |
