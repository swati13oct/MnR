@mobilebrowsercheck
Feature:To test Browser check on UHCM member mobile site
Scenario:To Verify the Pages of templates in the mobile blue layer browser
Given the user is on the mobile UHCM site landing page
When the user is on the mobile UHCM home page
Then the user validates error message on the browser for mobile UHCM site



Scenario Outline:To Verify the Pages of templates in the mobile browser after login in blue layer
Given the user is on the mobile UHCM site landing page
When the user logs in with a registered UMP with following details in mobile UHCM site
	| Plan Type   | <planType>  |
Then the user validates error message on the browser for mobile UHCM site after login

Examples:
	| planType | 
	| MAPD     |


