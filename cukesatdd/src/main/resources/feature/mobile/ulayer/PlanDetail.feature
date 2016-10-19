@plandetail
Feature:To test plan drug details page on AARP site in mobile
Scenario Outline:Verify Plan Drug Details in AARP site for members in mobile
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to benefits and coverage details page on annual deductible stage
And the user navigates to benefits and coverage details page with the initial coverage stage
And the user navigates to benefits and coverage details page with the coverage gap stage
And the user navigates to benefits and coverage details page with the catastrophic coverage stage
Then the user validates plan and member details on benefits details page in AARP site 

Examples:
	| planType |
	| MAPD     |