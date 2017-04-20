@payments
Feature: To test the payment flow on AARP site 
Scenario Outline: Verify one time payment for total ammount due in AARP site 
Given registered AARP with a planType member for AARP site
 | <planType> |
When the user views payment history
And the user makes one time payment in AARP site
	| Amount to be paid	     | <Amount>		  |
	| Routing number             | <routingNo>        |
	| Confirm routing number     | <confirmRoutingNo> |
	| Account number             | <accountNo>        |
	| Confirm account number     | <confirmAccountNo> | 
	| Account holder first name  | <firstName>        |
	| Account holder middle name | <middleName>       |
	| Account holder last name   | <lastName>         |  
And the user confirms the payment in AARP site
Then the user validates the payment successful page
	
Examples:
        |planType | routingNo | confirmRoutingNo | accountNo   | confirmAccountNo | firstName | middleName | lastName | Amount |
#        |  MA     | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
#        |  MAPD   | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
        |  PDP    | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
#        |  MS     | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
#        |  HIP    | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
#	|  RIDER  | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |


Scenario Outline: Verify the One Time Payments Tool for Dashboard
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to One Time Payments page


Examples:
	| planType |
	| MAPD     |
#	| MA       |
#	| PDP      |
#	| MS       |
#	| HIP      |


Scenario Outline: Verify the Payment amount and Routing Number on One Time Payments Tool for Dashboard
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to One Time Payments page
And the user enters details and click on continue button on One Time Payments Page for  Dashboard
Then user lands on Review One time Payments Page and validates the amount and routing number values


Examples:
	| planType |
	| MAPD     |
#	| MA       |
#	| PDP      |
#	| MS       |
#	| HIP      |

@US455296
Scenario Outline: Verify the edit payment information on One Time Payments Tool for Dashboard
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to One Time Payments page
And the user enters details and click on continue button on One Time Payments Page for Dashboard
Then user lands on Review One time Payments Page and validates the one time payment page
And the user clicks on edit payment information button on Review Payments Page


Examples:
	| planType |
	| MAPD     |

   

@US454601
Scenario Outline: Verify that payment history page is navigated when cancel button is clicked in Review One Time Payment Page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to One Time Payments page
And the user enters details and click on continue button on One Time Payments Page for Dashboard
And the user clicks on cancel button on Review Payments Page and validates payments history page


Examples:
	| planType |
	| MAPD     |
       
     