@paymentUms
Feature: To test the payment flow on UMS site 
Scenario Outline: Verify one time payment for total ammount due in UMS site 
Given registered UMS with a planType member in UMS site
| Plan Type 	  | <planType> |
| Category	      | <category> |
When the user views payment history page in UMS site
And the user makes one time payment in UMS site
	| Amount to be paid	         | <Amount>		  |
    | Routing number             | <routingNo>        |
	| Confirm routing number     | <confirmRoutingNo> |
	| Account number             | <accountNo>        |
	| Confirm account number     | <confirmAccountNo> | 
	| Account holder first name  | <firstName>        |
	| Account holder middle name | <middleName>       |
	| Account holder last name   | <lastName>         |  
And the user confirms the payment in UMS site
Then the user validates the payment successful page in UMS page
	
Examples:
         |planType | category   | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName | middleName | lastName | Amount |
  #      | MA      | Individual | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00   |
         | MAPD    | Individual | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00   |
  #      | MAPD    | Group      | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00	 | 
  #      | PDP     | Group      | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00	 |
  #      | MA      | Group      | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00	 |
  #      | SSUP    | Group      | 123000000 |  123000000       |1234567890  | 1234567890       | first     | second     | third    | 2.00	 |