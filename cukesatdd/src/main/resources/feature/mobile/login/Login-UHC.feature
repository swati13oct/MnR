@blogin
Feature:To test Login on UHCM site in mobile
Scenario Outline:Verify login in UHCM site for MA or MAPD members in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates plan and member details on benefits summary page in UHC site 

Examples:
	| planType |
	| MAPD     |