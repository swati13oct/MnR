@fixedTestCaseTest
@loginAarp
Feature: To test Login on AARP site 
Scenario Outline: Verify login in AARP site 
Given the user is on the login page for ulayer
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
Then the user validates account home page for aarp

Examples:
	| planType |
	| MAPD     |