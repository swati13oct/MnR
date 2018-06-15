Feature: To test SSO functionality for SSO groups

  @US1048825 @regression @regression_sso 
  Scenario Outline: Verify North Carolina SSO functionality and check that security and password reset links are not displayed on profile page.
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
      | GroupName | ssoPartner   | firstName | lastName  | dateOfBirth | uhcID     |eaID     | empNumber | userName      | passWord  |
      | NC        | benefitfocus | EFBBF     | EEEDFAB	 |    01251950 | BAB27F10F |BAB27F10F|           | jkuma14| Lesnar51 |

  @US1048825 @regression @regression_sso     
Scenario Outline: Verify AT&T SSO functionality and check that security and password reset links are not displayed on profile page.
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
      | GroupName | ssoPartner   | firstName | lastName  | dateOfBirth | uhcID     |eaID     | empNumber | userName      | passWord  |
      | AT&T      | aonhewitt 	 | FBDDE     | EABEAFBCB |    05171937 | 2906710B4 |2906710B4|           | jkuma14				| Lesnar51|


  @US1048825 @regression @regression_sso   
Scenario Outline: Verify Verizon MA SSO functionality and check that security and password reset links are not displayed on profile page.
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
      | GroupName  | ssoPartner   | firstName | lastName  | dateOfBirth | uhcID     |eaID      | empNumber | userName      | passWord  |
      | Verizon MA | conduent     | DABDCAE   | FCADBDD   |    11101946 |           |63E8B0353B|   023978  | jkuma14				| Lesnar51|

  
     @US1048825 @regression @regression_sso 
 Scenario Outline: Verify Verizon MAPD SSO functionality and check that security and password reset links are not displayed on profile page.
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
      | GroupName   | ssoPartner   | firstName | lastName  | dateOfBirth | uhcID     |eaID      | empNumber | userName      | passWord  |
      | Verizon MAPD| conduent     | BBBCCB    | DACECC    |  02111944   |           |F0203F253 |   002203  | jkuma14				| Lesnar51|
