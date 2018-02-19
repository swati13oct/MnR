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
 
 
@PaymentMethodTest
Scenario Outline: To verify Premium Payments Overview section with the Payment Method 
Given I am an AARP Individual member on the Dashboard site
   | Plan Type   | <planType>   |
When the above plantype user logs in
And I navigate to the new Dashboard Payment History page
Then I can view a Premium Payments Overview section with the Payment Method I have selected displayed on desktop

Examples:

 | planType |
 | MAPD     |