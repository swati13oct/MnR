@pharmacy
Feature:To test pharmacy locator page for AL PEEHIP
Scenario Outline:Verify login in UHCM site for MA or MAPD members in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  | 
And user Clicks on Menu tab and click Pharmacy locator
Then user clicks on pharmacy locator link and validates the scenarios
Examples:
	| planType |
	| MAPD     |