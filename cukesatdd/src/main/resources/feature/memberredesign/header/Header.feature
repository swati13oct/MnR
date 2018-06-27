@theIncredibles
@member_redesign
Feature:I1.3Header/Navigation for Member Site Redesign

@member_redesign_header @IncrediblesHeader @regression_06_06_18
Scenario Outline:Verify HSID login functionality and header
  Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
#When the above plantype user logs in UMS Site Desktop Header
And I view the global navigation Header
Then I should be able to see and use the Home tab Header
Then I should be able to see and use the Find Care & Costs tab Header
Then I should be able to see and use the Claims tab Header
And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
And then click the Claims Summary tab and I should be directed to the Claims Summary Page Header
And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
Then I should be able to see and use the Coverage & Benefits tab Header
And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header
And then click the Benefits Summary tab and I should be directed to the Benefits Summary Page Header
And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header
And then click the Order Materials tab and I should be directed to the Order Materials Page Header
Then I should be able to see and use the Premium Payments tab Header
Then I should be able to see the help button Header
Then I should be able to see and use the Account/Profile dropdown and logout

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |
 

 @premiumpaymentsheader @regression_06_06_18
Scenario Outline:To check the Premium Payments Tab in the header
 Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should be able to see and use the Premium Payments tab Header


Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |
 #| MAPD    |GroupLessSubsidy |
 
 
 @premiumpaymentsheader_100%subisdy
 Scenario Outline:To check that the Premium Payments Tab is not displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should not be able to see the Premium Payments tab Header

Examples:
 | planType|  memberType  | 
 | MAPD    |  UHCGroup  	  |
 
 
 @findcarecostsheader @regression_06_06_18
 Scenario Outline:To check that the Find Care and Costs Tab is displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should be able to see and use the Find Care & Costs tab Header

Examples:
 | planType|  memberType  	| 
| MAPD    |  UHCGroup  	  |
 #| MAPD    | IndividualDCEmember |
 #| PCP     | OrderMaterials |
 #| Medica  | OrderMaterials |
 
 
 @no_findcareheader @regression_06_06_18
Scenario Outline:To check that the Find Care and Costs Tab is displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
#And I view the global navigation Header
Then I should not be able to see the Find Care & Costs tab Header

Examples:
 | planType|  memberType  	| 
| SHIP    |    	Individual  |
#| SSUP    |   UHCGroup 	  |
 

 @Terminated_view @regression_06_06_18
 Scenario Outline:To check that the Find Care and Costs Tab is displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
Then I should be able to see and use the Home tab on Dashboard

Examples:
 | planType|  memberType  	| 
| MAPD    |  AARPTerminatedmember 	  |
|MA		| UHCTerminatedmember|

 
 