@payments
Feature: To test the payment flow on AARP site 
Scenario Outline: Verify recurring payment for a member in AARP site 
Given registered AMP with a planType member in AARP site 
	| <planType> |
When the user views payment history in AARP site
And the user setups automatic payment by entering the following bank account information in AARP site
        | Routing number             | <routingNo>         |
	| Confirm routing number     | <confirmRoutingNo>  |
	| Account number             | <accountNo>         |
	| Confirm account number     | <confirmAccountNo>  | 
	| Account holder first name  | <firstName>         |
	| Account holder middle name | <middleName>        |
	| Account holder last name   | <lastName>          |    	
And the user confirms to setup recurring payment in AARP site
Then the user validates the confirmation success page for recurring payment in AARP site
	
Examples:
        | planType | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName | middleName | lastName |
#      	| MA       | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    |
	| PDP      | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    |
#	| MAPD     | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    |


Scenario Outline: Verify the Automatic Payments Tool for Dashboard
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to Automatic Payments page


Examples:
	| planType |
	| MAPD     |
#	| MA       |
#	| PDP      |
#	| MS       |
#	| HIP      |