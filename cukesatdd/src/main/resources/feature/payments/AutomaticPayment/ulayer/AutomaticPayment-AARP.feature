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
     
@US497804
Scenario Outline: Verify the Payment History page from Automatic Payment page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user clicks on Continue button in automatic payment page without clicking checkbox 

Examples:
	| planType |
	| MAPD     |


@US458717
Scenario Outline: Verify the Payment History page from Automatic Payment page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
And the user lands on Review Automatic Payments Page and clicks on Submit button
Then the user presses Back To Payment History button on Automatic Payment Submitted page and validates it


Examples:
	| planType |
	| MAPD     |

@US458747
Scenario Outline: Verify the PDF link on Automatic Payment Submitted page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to TestHarness Page
And the user navigates to PaymentOverview Page
And the user navigates to Automatic Payments page from Payments Overview Page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
And the user lands on Review Automatic Payments Page and clicks on Submit button
Then the user lands on Automatic Payment Submitted Page and validates PDF link

Examples:
	| planType |
	| MA     |

#US458581, US458605 also covered
@US628468
Scenario Outline: Verify the Payment Type and Timestamp
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to TestHarness Page
And the user navigates to PaymentOverview Page
And the user navigates to Automatic Payments page from Payments Overview Page
And the user enters details and click on continue button on Automatic Payments Page for Dashboard
And the user lands on Review Automatic Payments Page and clicks on Submit button
Then the user lands on Automatic Payment Submitted Page and validates Timestamp, Payment Type and Payment Amount

Examples:
	| planType |
	| MA     |

