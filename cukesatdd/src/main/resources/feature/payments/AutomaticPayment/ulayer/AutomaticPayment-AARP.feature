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

@US458336
Scenario Outline: Verify the Payment History for Dashboard Automatic Payment Tool 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
Then user lands on Review Automatic Payments Page and validates the payments page
And the user clicks on cancel button and validate payment history


Examples:
	| planType |
	| MAPD     |
#	| MA       |
#	| PDP      |
#	| MS       |
#	| HIP      |

@US458109
Scenario Outline: Verify the Payment History for Dashboard Automatic Payment Tool 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
Then user lands on Review Automatic Payments Page and validates the payments page

Examples:
	| planType |
	| MAPD     |
	
@US458369
Scenario Outline: Verify the Payment History for Dashboard Automatic Payment Tool 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
Then user lands on Review Automatic Payments Page and validates the payments page
And the user validate edit payment information on review automatic payment page

Examples:
	| planType |
	| MAPD     |

@US497802
Scenario Outline: Verify the Payment History page from Automatic Payment page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user clicks on cancel button in automatic payment page and validate payment history  

Examples:
	| planType |
	| MAPD     |
     
     