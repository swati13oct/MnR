@paymentHistory

Feature: To verify New Payment History page
Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an UHC member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
Then navigate to the new Payment History page and validate Non setup automatic payment

Examples:
         | planType | membertype |
         | MAPD     | Individual |
       # | MA       | Group      | 
       # | MA       | Individual |

Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an UHC member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
Then navigate to the new Payment History page and validate setup automatic payment

Examples:
         | planType | membertype  |
         | MA       | Individual |       
       


        
        
 