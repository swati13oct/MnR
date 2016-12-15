@paymenthistory

Feature: To verify New Payment History page
Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an AARP member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
Then navigate to the new Payment History page and validate Non setup automatic payment

Examples:
         | planType | membertype |
         | MA       | Group      |
       # | MA       | Group      | 
       # | MA       | Individual |


Scenario Outline: To verify New Payment History page and validate for member who setup automatic payment
Given I am an AARP member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
Then navigate to the new Payment History page and validate setup automatic payment

Examples:
         | planType | membertype  |
         | MA       | Group       |       
 
Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an AARP member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
Then navigate to the new Payment History page and validate Credit Balance when the balance is greater than zero

Examples:
         | planType | membertype  |
         | MA       | Group       | 

Scenario Outline: To verify New Payment History page and validate for Dtm values for makeonepayment and setup automatic payments
Given I am an AARP member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile
When navigate to the new Payment History page
Then navigate to the new Payment History page and validate DTM values for Make A One Time Payment
Then navigate to the new Payment History page and validate DTM values for Set Up Automatic Payments

Examples:
         | planType | membertype  |
         | MA       | Group       | 
        
        
 