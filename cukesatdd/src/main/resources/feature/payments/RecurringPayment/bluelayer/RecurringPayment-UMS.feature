@payments
Feature: To test the payment flow on UMS site 
Scenario Outline: Verify recurring payment for a member in UMS site 
Given registered UMS with a planType member for recurring payment in UMS site
 | Plan Type 	  | <planType> |
 | Member Type	  | <memberType> |
When the user views payment history for recurring payment in UMS site
And the user setups automatic payment by entering the following bank account information in UMS site
    | Routing number             | <routingNo>         |
	| Confirm routing number     | <confirmRoutingNo>  |
	| Account number             | <accountNo>         |
	| Confirm account number     | <confirmAccountNo>  | 
	| Account holder first name  | <firstName>         |
	| Account holder middle name | <middleName>        |
	| Account holder last name   | <lastName>          |    
And the user confirms to setup recurring payment in UMS site
Then the user validates the confirmation success page for recurring payment in UMS site
	
Examples:
        | planType | memberType   | routingNo | confirmRoutingNo | accountNo   | confirmAccountNo | firstName | middleName | lastName |
#	    | MA       | Individual | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
	    | MAPD     | Individual | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
#       | MAPD     | Group      | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
#       | PDP      | Group      | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
#       | MA       | Group      | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
#       | SSUP     | Group      | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    |
