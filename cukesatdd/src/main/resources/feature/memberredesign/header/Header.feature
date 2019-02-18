@header @theIncredibles @member_redesign
Feature:I1.3Header/Navigation for Member Site Redesign
# note: if system is in future date, some testcases may fail due to expected tab(s) not showing up on page depending on user's data setup

@header1 @member_redesign_header @IncrediblesHeader @regressionMember
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify HSID login functionality and header
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
 | TID   | planType  | memberType       |
 | 15164 | MAPD      | IndividualMember |
 

@header2 @premiumpaymentsheader @regressionMember 
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check the Premium Payments Tab in the header
 Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should be able to see and use the Premium Payments tab Header


Examples:
 | TID   | planType | memberType       |
 | 15168 | MAPD     | IndividualMember |
 | 15252 | MAPD     | GroupLessSubsidy |
 
 
@header3 @premiumpaymentsheader_100%subisdy @regressionMember
 Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Premium Payments Tab is not displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should not be able to see the Premium Payments tab Header

Examples:
 | TID   | planType|  memberType | 
 | 15253 | MAPD    |  UHCGroup   |
 
 
@header4 @findcarecostsheader @regressionMember
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
And I view the global navigation Header
Then I should be able to see and use the Find Care & Costs tab Header

Examples:
 | TID   | planType| memberType  	  | 
 | 15171 | MAPD    | UHCGroup  	      |
 | 15171 | MAPD    | IndividualMember |
 | 15171 | MAPD    | PCP              |
 | 15171 | MAPD    | Medica           |
 
 
@header5 @no_findcareheader @regressionMember  
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
#And I view the global navigation Header
Then I should not be able to see the Find Care & Costs tab Header

Examples:
 | TID   | planType |  memberType  	      | 
 | 15251 | SHIP     |   Individual_header |
 | 15251 | SSUP     |   UHCGroup_header   |
 

@header6 @Terminated_view @regressionMember
 Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header for terminated user
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type   | <memberType> |
Then I should be able to see and use the Home tab on Dashboard

Examples:
 | TID   | planType| memberType  	      | 
 | 15162 | MAPD    | AARPTerminatedmember |
 | 15162 | MA	   | UHCTerminatedmember  |
