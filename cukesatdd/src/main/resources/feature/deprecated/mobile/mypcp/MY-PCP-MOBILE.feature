@mypcpmobile
Feature: Test case for My PCP Mobile site
Scenario Outline:To Verify the  My PCP Mobile site AboutUs contact us and Sign in page navigation
Given the user is on the My PCP mobile site landing page
#Given the user is on registration page of My PCP mobile site1
#Given the user clicks on back button from  My PCP mobile site registration page
#Given the user is on password assistance page of My PCP mobile site1

When the user logs in with a registered UMS with following details in PCP site
	| Plan Type   | <planType>  |
Then the user validates plan and member details on benefits summary page in PCP site 

Examples:
	| planType |
	| MAPD     |
	





