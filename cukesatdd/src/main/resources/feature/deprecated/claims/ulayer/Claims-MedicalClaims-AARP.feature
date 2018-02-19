@claims
Feature:To test the medical claims summary and details flow in AARP site
Scenario Outline:Verify the medical claim summary  and details for selected time period in AARP site
Given the registered AMP with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Claim Type  | <claimType>  |
When the user navigates to claim summary page in AARP site
And user searches the claims for the following claim period in AARP site
	| <claimPeriod> |
Then user validates the medical claims displayed based on the selection in AARP site
And user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType | claimType | claimPeriod    |
#	| MA       | Nice      | Last 6 Months | 
#	| MAPD     | Nice      | Last 24 Months | 
#	| MAPD     | Nice      | Last 24 Months | 

Scenario Outline:Verify the medical claim summary and details for selected time interval in AARP site
Given the registered AMP with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Claim Type  | <claimType>  |
When the user navigates to claim summary page in AARP site
When user searches the medical claims for following time interval in AARP site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
Then user validates the medical claims displayed based on the selection in AARP site
And user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType | claimType | claimFromDate | claimToDate |
	| MA       | Nice      | 08-28-2015    | 12-28-2015  |
#	| MAPD     | Nice      | 02-13-2014    | 10-01-2015  | 
#	| MA       | Nice      | 01-06-2014    | 06-06-2015  |


Scenario Outline:Verify the terminated member medical claim summary and details for selected time period in AARP site
Given the registered terminated plan member with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Claim Type  | <claimType>  |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in AARP site
And user searches the claims for the following period in AARP site
	| Claim Period | <claimPeriod> |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site
Examples:
	| planType | claimType | claimPeriod    |
#	| MA       | Nice      | Last 24 Months | 
#	| MAPD     | Nice      | Last 24 Months | 
#	| MAPD     | Nice      | Last 24 Months | 


Scenario Outline:Verify the medical claim summary and details for selected time interval for terminated member in AARP site
Given the registered terminated plan member with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Claim Type  | <claimType>  |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in AARP site
When user searches the medical claims for following time interval in AARP site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType | claimType | claimFromDate | claimToDate |
#	| MA       | Nice      | 02-13-2014    | 10-01-2015  |
#	| MAPD     | Nice      | 02-13-2014    | 10-01-2015  | 
#	| MA       | Nice      | 01-06-2014    | 06-06-2015  |

Scenario Outline:Verify the medical claim summary and details for selected time period in AARP site
Given the registered AMP with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
When the user navigates to claim summary page in AARP site
When user searches the claims for the following period in AARP site
	| Claim Period  | <claimPeriod> |
	| Provider Name | <ProviderName> |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site


Examples:
	| planType | claimPeriod    | ProviderName  | 
#	| HIP      | Last 24 Months | All Providers |
#	| MS       | Last 24 Months | All Providers |

Scenario Outline:Verify the medical claim summary and details for selected time interval in AARP site
Given the registered AMP with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
When the user navigates to claim summary page in AARP site
When user searches the medical claims for following time interval in AARP site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
	| Provider Name    | <ProviderName> |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType  | claimFromDate | claimToDate | ProviderName  |
#	| HIP       | 07-24-2013    | 07-24-2015  | All Providers |
#	| MS        | 07-24-2013    | 07-24-2015  | All Providers |

Scenario Outline:Verify the medical claim summary and details for selected time period in AARP site
Given the registered terminated plan member with following attributes in AARP site for medical claims
	| Plan Type   | <planType>               |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in AARP site
When user searches the claims for the following period in AARP site
	| Claim Period  | <claimPeriod> |
	| Provider Name | <ProviderName> |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType | claimPeriod    | ProviderName  | 
#	| HIP      | Last 24 Months | All Providers |

Scenario Outline:Verify the medical claim summary and details for selected time interval in AARP site
Given the registered terminated plan member with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Plan Status | Term less than 12 months |
When the user navigates to claim summary page for terminated members in AARP site
When user searches the medical claims for following time interval in AARP site
	| Claims From Date | <claimFromDate> |
	| Claims To Date   | <claimToDate>   |
	| Provider Name    | <ProviderName> |
Then user validates the medical claims displayed based on the selection in AARP site
When user views the claim details for the first medical claim in AARP site
Then user validates the following claim details in AARP site

Examples:
	| planType  | claimFromDate | claimToDate | ProviderName  |
#	| HIP       | 07-24-2013    | 07-24-2015  | All Providers |