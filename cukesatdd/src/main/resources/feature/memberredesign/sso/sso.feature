@sso
Feature: 1.13 Member SSO functionality for SSO groups

  @sso1 @US1048825 @regression @regression_sso    @regressionMember
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
      | TID   | GroupName | ssoPartner   | firstName | lastName | dateOfBirth | uhcID     | eaID      | empNumber | userName       | passWord   |
      | 15364 | NC        | benefitfocus | EFBBF     | EEEDFAB  |    01251950 | BAB27F10F | BAB27F10F |           | sso_dummy_user | Password@1 |

  @sso2 @US1048825 @regression @regression_sso    @regressionMember
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
     | TID   | GroupName | ssoPartner | firstName | lastName  | dateOfBirth | uhcID              | eaID               | empNumber | userName       | passWord   |
     | 15362 | AT&T      | aonhewitt  | FBDDE     | EABEAFBCB |    05171937 | 04E60BC3ED108800AC | 04E60BC3ED108800AC |           | sso_dummy_user | Password@1 |

  @sso3 @US1048825 @regression @regression_sso @regressionMember
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
     | TID   | GroupName  | ssoPartner | firstName | lastName | dateOfBirth | uhcID | eaID       | empNumber | userName       | passWord   |
     | 15363 | Verizon MA | conduent   | DABDCAE   | FCADBDD  |    11101946 |       | 63E8B0353B |    023978 | sso_dummy_user | Password@1 |

  @sso4 @US1048825 @regression @regression_sso @regressionMember
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
      | TID   | GroupName    | ssoPartner | firstName | lastName | dateOfBirth | uhcID | eaID      | empNumber | userName       | passWord   |
      | 15388 | Verizon MAPD | conduent   | DAFB      | DCFDECCD |    06191926 |       | C6AC8162F |    002203 | sso_dummy_user | Password@1 |
      
    @Ssobswift @US1769264 @CodeTransformers
    Scenario Outline: Verify As CenterPoint Energy MAPD Group Member is allowed to land on the dashboard for the medicare.uhc.com site.  
      Given CE MAPD group member lands on the SSO test harness page 
      And testharness page is displayed with all the fields
      And on testharness I enter the member details and click continue
      | SSO Partner | <ssoPartner>  |
      | First Name  | <firstName>   |
      | Last Name   | <lastName>    |
      | DOB         | <dateOfBirth> |
      | MBI         | <uhcID>       |
      |Target URL   | <url>         |
     And user is navigated to the Dashboard       
     Examples: 
       | ssoPartner    | firstName | lastName | dateOfBirth |   uhcID         |url                                            |  userName       | passWord   |
       | bswift       | EBERA     | WOLFMANA |    10241939  |   2Y55K31PM63 |https://stage-medicare.uhc.com/sso/inbound/bswift| sso_dummy_user  | Password@1 |
        
