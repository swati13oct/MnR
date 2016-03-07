@claims
Feature:To test the drug claims summary and details flow in AARP site
Scenario Outline:Verify the drug claim summary and details for selected time period
Given the registered AMP with following attributes in AARP site for drug claims
	| Plan Type | <planType> |
	| Category  | <category> |
When the user navigates to claim summary page in AARP site for drug claims
And the user search drug claims for the following claim period in AARP site
	| <claimPeriod> |
Then user validates the drug claims displayed based on the selection in AARP site
When user views drug claim details for individual claim in AARP site
Then user validates the following drug claim details for a claim in AARP site

Examples:
	| planType | category | claimPeriod    |
#	| PDP      |	      | Last 6 Months  |
#	| MAPD     | COSMOS   | Last 90 days   |
#	| MAPD     | NICE     | Last 90 days   |


Scenario Outline:Verify the drug claim summary and details for selected time interval
Given the registered AMP with following attributes in AARP site for drug claims
	| Plan Type | <planType> |
	| Category  | <category> |
When the user navigates to claim summary page in AARP site for drug claims
And user searches the drug claims for following time interval in AARP site
	| Claims To Date   | <claimToDate>   |
	| Claims From Date | <claimFromDate>  |
Then user validates the drug claims displayed based on the selection in AARP site
When user views drug claim details for individual claim in AARP site
Then user validates the following drug claim details for a claim in AARP site

Examples:
	| planType | category | claimFromDate | claimToDate |
	| PDP      |	      | 09-01-2015    | 12-11-2015  |
#	| MAPD     | COSMOS   | 09-01-2015    | 12-11-2015  |



Scenario Outline:Verify the drug claim summary for terminated members and details for selected time period
Given the registered terminated plan member with following attributes in AARP site for drug claims
	| Plan Type       | <planType>     |
	| Plan Status     | Term less than 12 months |
When the user navigates to claim summary page for terminated members in AARP site for drug claims
And the user search drug claims for the following claim period for terminated members in AARP site
	| Claim Period | <claimPeriod> |
Then user validates the drug claims displayed based on the selection in AARP site
When user views drug claim details for individual claim in AARP site
Then user validates the following drug claim details for a claim in AARP site

Examples:
	| planType | claimPeriod    |
#	| PDP      | Last 24 Months |
#	| MAPD     | Last 90 days   |	
  

Scenario Outline:Verify the drug claim summary for terminated members and details for selected time interval
Given the registered AMP with following attributes in AARP site for drug claims
	| Plan Type       | <planType>     |
	| Plan Status     | Term less than 12 months |
When the user navigates to drug claim summary page for terminated members in AARP site for drug claims
And user searches the drug claims for following time interval for terminated members in AARP site
	| Claims To Date   | <claimToDate>   |
	| Claims From Date | <claimFromDate>  |
Then user validates the drug claims displayed based on the selection in AARP site
When user views drug claim details for individual claim in AARP site
Then user validates the following drug claim details for a claim in AARP site

	
Examples:
	| planType | claimFromDate | claimToDate |
#	| PDP      | 01-01-2015    | 12-01-2015  |
#	| MAPD     | 01-01-2014    | 06-06-2015  |