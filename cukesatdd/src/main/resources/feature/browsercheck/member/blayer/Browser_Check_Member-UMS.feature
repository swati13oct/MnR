@memberBrowserCheck
Feature: To test Browser check on member UMS site
Scenario: To Verify the Pages of template in the browser for member site
Given the user is on the UMS Member site landing page
When the user is on the UMS Member home page
Then the user validates unsupported error message on the browser


Scenario Outline: To Verify the Pages of template in the browser for Uhcm member site
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
Then the user validates unsupported error message after login in UHC medicare site

	Examples:
	| planType |
	| MAPD     |
#	| MA       |