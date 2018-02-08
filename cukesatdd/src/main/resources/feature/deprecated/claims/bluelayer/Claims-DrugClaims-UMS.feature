@claims
Feature:To test the drug claims summary and details flow in UMS site
Scenario Outline:Verify the drug claim summary and details for selected time period
Given the registered UMS with following attributes in UMS site for drug claims
	| Plan Type    | <planType>    |
	| Member Type  | <memberType>  |
	| Claim System | <claimSystem> |
When the user navigates to claim summary page in UMS site for drug claims
And the user search drug claims for the following claim period in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the drug claims for the selected time period in UMS site
When user views drug claim details for individual claim in UMS site
Then user validates the drug claim details for a claim in UMS site
Examples:
	| planType | memberType | claimPeriod    |claimSystem|
#	| MAPD     | Individual | Last 90 days   | Drug      |
#	| PDP      | Individual	| Last 24 Months |           |
#	| MAPD     | Group      | Last 90 days   |           |
#	| PDP      | Group      | Last 90 days   |	         |
  

Scenario Outline:Verify the drug claim summary and details for selected time interval
Given the registered UMS with following attributes in UMS site for drug claims
	| Plan Type       | <planType>     |
	| Member Type  | <memberType>  |
When the user navigates to claim summary page in UMS site for drug claims
When user searches the drug claims for following time interval in UMS site
	| Claims To Date   | <claimToDate>   |
	| Claims From Date | <claimFromDate>  |
Then user validates the drug claims displayed based on the selection in UMS site
When user views drug claim details for individual claim in UMS site
Then user validates the following drug claim details for a claim in UMS site
	
Examples:
	| planType | memberType   | claimFromDate | claimToDate |
#	| MAPD     | Individual	  | 07-11-2016    | 07-11-2016  |
#	| MAPD     | Group        | 01-01-2015    | 12-01-2015  |
#	| PDP      |	          | 01-01-2015    | 12-01-2015  |
#	| PDP      | Group        | 01-01-2015    | 12-01-2015  |


Scenario Outline:Verify the drug claim summary and details for selected time period for terminated members
Given the registered terminated member with following attributes in UMS site for drug claims
	| Plan Type       | <planType>     |
	| Member Type  | <memberType>  |
	| Plan Status     | Term less than 12 months |
When the user navigates to claim summary page for terminated members in UMS site for drug claims
And the user search drug claims for the following claim period for terminated members in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the drug claims displayed based on the selection in UMS site
When user views drug claim details for individual claim in UMS site
Then user validates the drug claim details for a claim in UMS site

Examples:
	| planType | memberType | claimPeriod    |
#	| MAPD     |	      | Last 24 Months |
#	| PDP      |	      |	Last 24 Months |
#	| MAPD     | Group    | Last 90 days   |
#	| PDP      | Group    |	Last 90 days   |	
  

Scenario Outline:Verify the drug claim summary and details for selected time interval for terminated members
Given the registered terminated member with following attributes in UMS site for drug claims
	| Plan Type       | <planType>     |
	| Member Type  | <memberType>  |
	| Plan Status     | Term less than 12 months |
When the user navigates to claim summary page for terminated members in UMS site for drug claims
When user searches the drug claims for following time interval for terminated members in UMS site
	| Claims To Date   | <claimToDate>   |
	| Claims From Date | <claimFromDate>  |
Then user validates the drug claims displayed based on the selection in UMS site
When user views drug claim details for individual claim in UMS site
Then user validates the following drug claim details for a claim in UMS site
	
Examples:
	| planType | memberType   | claimFromDate | claimToDate |
#	| MAPD     |	        | 01-01-2015    | 12-01-2015  |
#	| MAPD     | Group      | 01-01-2015    | 12-01-2015  |
#	| PDP      |	        | 01-01-2015    | 12-01-2015  |
#	| PDP      | Group      | 01-01-2015    | 12-01-2015  |


Scenario Outline: To display the link to the My Drug Costs and Benefits page for Non-LIS and LIS 1, 2 & 4 members 
Given the registered UMS with following attributes in UMS site for drug claims
| Plan Type    | <planType>    |
| Member Type  | <memberType>  |
When I want to display the link to the My Drug Costs and Benefits page
Then We should be able to reach My Drug Costs and Benefits page

Examples:
	| planType | memberType | 
	| PDP      | Group      | 
	| MAPD     | Group      |





@claimfnf
Scenario Outline:Verify the drug claim summary and details for selected time period
Given the registered UMS with following attributes in UMS site for drug claims
	| Plan Type    | <planType>    |
	| Member Type  | <memberType>  |
When the user navigates to claim summary page in UMS site for drug claims
Examples:
	| planType | memberType | 
#	| MA       | Individual |  
#	| MAPD     | Individual |  
	| MAPD     | Group      |   
#	| MA       | Group      | 

