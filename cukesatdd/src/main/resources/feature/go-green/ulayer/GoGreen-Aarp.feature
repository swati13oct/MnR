@goGreenTest
Feature: To test go green on AARP site 
Scenario Outline: Verify go green in AARP site for federal plan type member  
Given registered member for go green in AARP site
    | <planType> |
When the user clicks on go green icon in AARP site
And the user updates delivery preference with the following details in AARP site
    | Document Name	   | <documentname>        |
    | Delivery Preferences | <deliverypreferences> |
Then the user validates the updated delivery preferences in AARP site
Examples:
	| planType | documentname                                    | deliverypreferences |
	| PDP      | Annual Notice Of Changes Documents              | Online              |
#	| MAPD     | Prescription Drug Explanation of Benefits (EOB) | U.S.Mail            |
#	| MA       | Claims                                          | Online              |
#       | MS       | Claims                                          | Online              |
#       | HIP      | Claims                                          | Online              | 