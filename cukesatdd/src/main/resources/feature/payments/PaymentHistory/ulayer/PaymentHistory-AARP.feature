@payment_history
Feature:To verify New Payment History page
Scenario Outline:To verify New Payment History page
Given I am an AARP Individual member on the Dashboard site
    | Plan Type   | <planType>   |
When the above plantype user logs in
Then I navigate to the new Payment History page 

Examples:

 | planType |
 | PDP   	|
 | MAPD     |