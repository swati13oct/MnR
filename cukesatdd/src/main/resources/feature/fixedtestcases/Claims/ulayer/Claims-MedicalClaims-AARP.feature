@fixedTestCaseTest
@claims
Feature:To test the medical claims summary and details flow in AARP site
@medClaimsUlayer
Scenario Outline:Verify the medical claim summary  and details for selected time period in AARP site
Given the user is on the AARPM site login page
When the registered AMP with following attributes in AARP site for medical claims
	| Plan Type   | <planType>   |
	| Claim Type  | <claimType>  |
When the user navigates to plan summary page in AARP site and validates
When the user navigates to claim summary page in AARP site
And user searches the claims for the following claim period in AARP site
	|Claim Period | <claimPeriod> |
Then user validates the medical claims displayed based on the selection in AARP site
	|Claim Period | <claimPeriod> |
And user views the claim details for the first medical claim in AARP site and validates
Examples:
	| planType | claimType | claimPeriod    |
	| MAPD       | Nice_med      | Last 24 Months |