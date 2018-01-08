@fixedTestCase
Feature: To test Login on AARP site 
Scenario Outline: Verify login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
Then the user validates plan and member details after login in AARP site

Examples:
	| planType |
	| MAPD     |
	
@ULayerlogin
Scenario Outline: verify Quick links from footer after login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
	| Member type   | <memberType>  |
Then the user should be able to sign out and Sign In page is displayed.

Examples:
	| planType |  memberType  |
	| MAPD     | IndividualLogin |
#	|MedsuppShip|GroupShip |
	
	
@ULayerHAndW
Scenario Outline: verify Quick links from footer after login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
	| Member type   | <memberType>  |
Then click on View Health & Wellness button and My Health and Wellness page should be displayed
And verify Health & Wellness sub tabs and content
And click on Life style Tab and life style content should display 
And click on Learning Tab and learning content should display 
And click on Reward Tab and reward content should display
	
Examples:
	| planType |  memberType|
	|NOVU	   | Individual |
	