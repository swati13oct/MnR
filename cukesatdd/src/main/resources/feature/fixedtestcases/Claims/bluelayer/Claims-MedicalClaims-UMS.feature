@fixedTestCaseTest
@claims
Feature:To test the medical claims summary and details flow in UMS site
@medClaimsBlayer
Scenario Outline:Verify the medical claim summary  and details for selected time period in UMS site
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMP with following details in UHC site	
	| Plan Type   | <planType>   |
	| Member Type | <memberType>  |
	| Claim Type  | <claimType>  |
When the user navigates to plan summary page in UMS site and validates
When the user navigates to claim summary page in UMS site
And user searches the claims for the following period in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the medical claims for the selected time period in UMS site
	| Claim Period | <claimPeriod> |
And user views medical claim details for individual claim in UMS site and validates them
Examples:
	| planType | memberType | claimType | claimPeriod    |
	| MA       | Individual | Nice_med      | Last 24 Months |