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
     