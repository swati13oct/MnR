@memberUlayerBrowserCheck
Feature: To test Browser check on member Aarp site
Scenario: To Verify the Pages of template in the browser for member Aarp site
Given the user is on the AARP Member site landing page
When the user is on the ulayer member home page
Then the user validates error message on the browser of AARP member site


Scenario Outline:To Verify the Pages of template in the browser
Given the user is on the AARP Member site landing page
When the user logs in with a registered AMP with following details in member AARP medicare plans site
	| Plan Type   | <planType>  |
Then the user validates unsupported error message after login in member AARP medicare plans site
 
	Examples:
	| planType |
	| PDP      |
#	| MA       |