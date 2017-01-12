@claims
Feature:To test the medical claims summary and details flow in UMS site
Scenario Outline:Verify the medical claim summary  and details for selected time period in UMS site
Given the registered UHC with following attributes in UMS site for medical claims
	| Plan Type   | <planType>   |
	| Member Type | <memberType>  |
	| Claim Type  | <claimType>  |
When the user navigates to claim summary page in UMS site
And user searches the claims for the following period in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the medical claims for the selected time period in UMS site
When user views medical claim details for individual claim in UMS site
Then user validates the medical claim details for a claim in UMS site
Examples:
	| planType | memberType | claimType | claimPeriod    |
#	| MA       | Individual | Nice      | Last 24 Months | 
#	| MAPD     | Individual | Medical   | Last 90 Days   | 
#	| MAPD     | Group      | Nice      | Last 6 Months  |  
#	| MA       | Group      | Nice      | Last 24 Months | 

Scenario Outline:Verify the medical claim summary and details for selected time interval in UMS site
Given the registered UMS with following attributes in UMS site for medical claims
	| Plan Type   | <planType>   |
	| Member Type | <memerType>  |
	| Claim Type  | <claimType>  |
	| Plan Status | <planStatus> |
When the user navigates to claim summary page in UMS site
When user searches the medical claims for following time interval in UMS site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
Then user validates the medical claims displayed based on the selection in UMS site
When user views medical claim details for individual claim in UMS site
Then user validates the following medical claim details for a claim in UMS site
Examples:
	| planType | memberType | claimType | claimFromDate | claimToDate |
#	| MA       | Individual | Nice      | 02-13-2014    | 10-01-2015  |
#	| MAPD     | Individual | Medical   | 11-07-2016    | 11-07-2016  | 	
#	| MA       | Group      | Nice      | 01-06-2014    | 06-06-2015  |


Scenario Outline:Verify the medical claim summary  and details for selected time period for terminated members in UMS site
Given the registered terminated members with following attributes in UMS site for medical claims
	| Plan Type   | <planType>   |
	| Member Type | <memerType>   |
	| Claim Type  | <claimType>  |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in UMS site
And user searches the claims for the following period in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the medical claims displayed based on the selection in UMS site
When user views medical claim details for individual claim in UMS site
Then user validates the following medical claim details for a claim in UMS site
Examples:
	| planType | memberType  | claimType | claimPeriod    |
#	| MA       |  Individual | Nice      | Last 24 Months | 
#	| MAPD     |  Individual | Medical   | Last 90 Days   | 
#	| MAPD     |  Group      | Nice      | Last 24 Months | 
#	| MA       |  Group      | Nice      | Last 24 Months | 


Scenario Outline:Verify the medical claim summary and details for selected time interval for terminated members in UMS site
Given the registered terminated members with following attributes in UMS site for medical claims
	| Plan Type   | <planType>   |
	| Member Type | <memerType>   |
	| Claim Type  | <claimType>  |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in UMS site
When user searches the medical claims for following time interval in UMS site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
Then user validates the medical claims displayed based on the selection in UMS site
When user views medical claim details for individual claim in UMS site
Then user validates the following medical claim details for a claim in UMS site

Examples:
	| planType | memberType | claimType | claimFromDate | claimToDate |
#	| MA       | Individual | Nice      | 02-13-2014    | 10-01-2015  |
#	| MAPD     | Individual | Medical   | 11-07-2016    | 11-07-2016  | 
#	| MA       | Group      | Nice      | 01-06-2014    | 06-06-2015  |





Scenario Outline:Verify the medical claim summary  and details for selected time period in UMS site
Given the registered UHC with following attributes in UMS site for medical claims
	| Plan Type   | <planType>   |
	| Member Type | <memberType>  |
When the user navigates to claim summary page in UMS site
Examples:
	| planType | memberType | 
#	| MA       | Individual |  
	| MAPD     | Individual |  
#	| MAPD     | Group      |   
#	| MA       | Group      | 


@albama
Scenario Outline:Verify add a plan link is not displayed for albama members on claim summary page
Given registered member to login in UMS site
| Plan Type   | <planType>   |
| Member Type | <memberType>  |
When the user navigates to claim summary page in UMS site
Then user validate add a plan link is not displayed for albama members
Examples:
| planType | memberType | 
| MAPD       | Group | 
| MA         | Group |