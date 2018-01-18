@fixedTestCaseTest
@loginUhc
@loginUHCSmoke
Feature: To test Login on UHC site 
Scenario Outline: Verify login in UHC site 
Given the user is on the UHC site login page
When the user logs in with a registered UMP with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates account home page for uhc

Examples:
	| planType |
	| MAPD     |