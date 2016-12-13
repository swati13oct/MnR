@mobile
Feature:To test Browser check on AARP member mobile site
Scenario:To Verify the Pages of templates in the mobile browser
Given the user is on the mobile AARP site landing page
When the user is on the mobile AARP home page
Then the user validates error message on the browser for mobile AARP site


Scenario Outline:To Verify the Pages of templates in the mobile browser after login
Given the user is on the mobile AARP site landing page
When the user logs in with a registered AMP with following details in mobile AARP site
	| Plan Type   | <planType>  |
Then the user validates error message on the browser for mobile AARP site after login

Examples:
	| planType | 
	| MAPD     |




