@pharmacyLocator
Feature:To validate Pharmacy Locator Tool - Mobile
	
Scenario Outline:Verify the pharmacy locator tool in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user navigates to Pharmacy Locator Landing Page page and Click on "List View"
And the user validates the red markers will display for Pharmacy Saver
And the user validates the blue markers will display for Standard Network Pharmacy
And the user validate the first pharmacy results

Examples:
	| planType |
	| PDP     |
	

Scenario Outline:Verify the pharmacy locator tool in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user navigates to Pharmacy Locator Landing Page page and Click on "List View"
And the user validates the red balloon markers will display for Preferred Pharmacy
And the user validates the blue markers will display for Standard Network Pharmacy
And the user validate the first pharmacy results

Examples:
	| planType |
	| PDP     |	
	
	
Scenario Outline:Verify the pharmacy locator filter in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user navigates to Pharmacy Locator Landing Page page and Click on "List View"
And the user clicks on filter button on the page
And validates the two tool tips

Examples:
	| planType |
	| PDP     |	

	