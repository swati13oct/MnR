@login
Feature:To test Login on AARP site in mobile
Scenario Outline:Verify login in AARP site for MA or MAPD members in mobile
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
Then the user validates plan and member details on benefits summary page in AARP site

Examples:
	| planType |
	| MAPD     |