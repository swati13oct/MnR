@claims
Feature:To test the drug claims summary and details flow in UMS site
@drugClaimsBlayer
Scenario Outline:Verify the drug claim summary and details for selected time period
Given the user is on the UHC site login page
When the user logs in to UMS site with following details in UHC site
	| Plan Type    | <planType>    |
	| Member Type  | <memberType>  |
	| Claim System | <claimSystem> |
When the user navigates to plan summary page and validates
When the user navigates to claim summary page in UMS site for drug claims
And the user search drug claims for the following claim period in UMS site
	| Claim Period | <claimPeriod> |
Then user validates the drug claims for the selected time period in UMS site
Examples:
	| planType | memberType |claimSystem| claimPeriod    |
	| MAPD     | Individual | Drug      |Last 24 Months   | 