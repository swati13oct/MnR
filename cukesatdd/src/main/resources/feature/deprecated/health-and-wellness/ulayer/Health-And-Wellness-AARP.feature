@H&W
Feature:To test health and wellness in AARP site
Scenario Outline:To verify health and wellness widgets in AARP site
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details for health and wellness flow in AARP site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
And the user navigates to health and wellness page in AARP site
Then the user validates health and wellness page in AARP site

Examples:
	| planType | memberType |
	| MA       | novu       |
	| MAPD     | non-novu   |
