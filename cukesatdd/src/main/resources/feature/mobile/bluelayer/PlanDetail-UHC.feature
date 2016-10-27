@bplandetail
Feature:To test plan drug details page on UHCM site in mobile
Scenario Outline:Verify Plan Drug Details in UHCM site for members in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
And the user navigates to benefits and coverage details of Annual Deductible UHC page
And the user navigates to benefits and coverage details of UHC page with the initial coverage stage
And the user navigates to benefits and coverage details of UHC page with the coverage gap stage
And the user navigates to benefits and coverage details of UHC page with the catastrophic coverage stage
Then the user validates plan and member details on benefits details page in UHCM site 

Examples:
	| planType |
	| MAPD     |