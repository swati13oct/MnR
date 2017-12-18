@US446565_mobile
Feature:Validate that an authenticated PDP Group member on the Dashboard site can view
Scenario Outline:To verify New Payment History page
Given I am a UHC Blayer Group PDP member on the Dashboard site
    | Plan Type   | <planType>   |
When I navigate to the Payment History page
Then I can view a Premium Payments Overview section and header
Examples:

 | planType |
 | PDP   	|