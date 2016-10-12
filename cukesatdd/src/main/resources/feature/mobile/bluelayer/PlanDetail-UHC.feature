@plandetails
Feature:To test Login on UHCM site in mobile
Scenario Outline:Verify login in UHCM site for MA or MAPD members in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
And the user navigates to benefits and coverage details page
Then the user validates plan and member details on benefits details page in UHCM site	

Examples:
	| planType |
	| MAPD     |