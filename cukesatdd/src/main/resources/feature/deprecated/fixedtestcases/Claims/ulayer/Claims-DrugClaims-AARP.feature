@fixedTestCaseTest_work_in_progress
@claims
Feature:1.03-To test the drug claims summary and details flow in AARP site
@drugClaimsUlayer
Scenario Outline:Verify the drug claim summary and details for selected time period
Given the user is on the AARP login page
When the registered AMP with following attributes in AARP site for drug claims
	| Plan Type | <planType> |
	| Category  | <category> |
When the user navigates to plan summary page and validates claims info
When the user navigates to claim summary page in AARP site for drug claims
And the user search drug claims for the following claim period in AARP site
	|Claim Period | <claimPeriod> |
Then user validates the drug claims displayed based on the selection in AARP site
Examples:
	| planType | category | claimPeriod    |
	| PDP     | drug   | Last 24 Months   |