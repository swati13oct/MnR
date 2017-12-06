@fixedTestCaseTest
@loginAarp
Feature: To test Login on AARP site 
Scenario Outline: Verify login in AARP site 
Given the user is on the AARP site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
Then the user validates account home page

Examples:
	| planType |
	| MAPD     |