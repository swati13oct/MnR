@payments
Feature: To test the payment flow on AARP site 

Scenario Outline: Verify the Review Automatic Payment Tool for Dashboard
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user enters details and click on continue button on One Time Payments Page for  Dashboard
Then user lands on Review Automatic Payments Page and validates the payments page


Examples:
	| planType |
	| MAPD     |
#	| MA       |
#	| PDP      |
#	| MS       |
#	| HIP      |
     
     