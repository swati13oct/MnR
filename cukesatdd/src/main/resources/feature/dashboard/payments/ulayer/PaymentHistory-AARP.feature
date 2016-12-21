@payment_history
Feature:To verify New Payment History page
Scenario Outline:To Verify Payment History section including the header and payment date range dropdown so that I can view and search for the history of my payments without having to call customer service.
Given I am an AARP Individual member on the Dashboard site
       | Plan Type   | <planType>   |
When the above plantype user logs in AARP Site
Then I navigate to the Payment History page in AARP Site
And I can view a Payment History header_text in AARP Site
And I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP Site
And I can view all the expected options in the dropdown of view payment dropdown menu in AARP Site
And I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP Site
        | Start Date   | <startDate>  |
        | End Date     | <endDate>    |     
And I can view a Payment table header in AARP Site
And I can view a Payment table columns in AARP Site

Examples:

 | planType  |  startDate  |  endDate   |
 | PDP   	 |  01/01/2016 | 12/30/2016 |
#| MAPD      |  01/01/2016 | 12/30/2016 |
#| MA        |  01/01/2016 | 12/30/2016 |
 
 
Scenario Outline:To verify New Payment History page
Given I am an AARP Individual member on the Dashboard site

    | Plan Type | <plantype> |
	| Member Type  | <memberType> |

When the above plantype user logs in AARP Site
Then I navigate to the new Payment History page
Then validate Payment Method value

Examples:

| plantype   | memberType   |
|  MAPD | Individual |
|  MA | Individual |
|  PDP | Individual |


 
@SetUpAutomaticPaymentButtonTest
Scenario Outline: To verify Premium Payments Overview section and Set Up Automatic Payments button
Given I am an AARP  Individual member on the Dashboard site who has NOT previously setup automatic payments
  | Plan Type | <plantype> |
	| Member Type  | <memberType> |
When the above plantype user logs in AARP Site
And I navigate to the Payment History page
Then I can view a button Make a One-Time Payment
And a button Set Up Automatic Payments

Examples:

| plantype   | memberType   |
#|  MAPD | Individual |
#|  MA | Individual |
|  PDP | Individual |




 
 @EditAutomaticPaymentButtonTest 
Scenario Outline: To verify Premium Payments Overview section and Set Up Automatic Payments button
Given I am an AARP  Individual member on the Dashboard site who has NOT previously setup automatic payments
   | Plan Type | <plantype> |
	| Member Type  | <memberType> |
When the above plantype user logs in AARP Site
And I navigate to the Payment History page
Then I can view a button Make a One-Time Payment
And a button Edit Automatic Payments

Examples:

| plantype   | memberType   |
|  MAPD | Individual |
|  MA | Individual |
|  PDP | Individual |

Scenario Outline: To verify New Payment History page and validate for Dtm values for makeonepayment and setup automatic payments
Given I am an AARP Individual member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in AARP Site
Then I navigate to the Payment History page in AARP Site
Then navigate to the new Payment History page and validate DTM values for Make A One Time Payment
Then navigate to the new Payment History page and validate DTM values for Set Up Automatic Payments

Examples:
         | planType | membertype  |
         | MAPD     | Individual  | 
        

Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site
When navigate to the new Payment History page
Then validate Non setup automatic payment

Examples:
         | planType | membertype |  
         | MA       | Group      | 
       # | MA       | Group      | 
       # | MA       | Individual |


Scenario Outline: To verify New Payment History page and validate for member who setup automatic payment
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site
When navigate to the new Payment History page in mobile site
Then validate setup automatic payment

Examples:
         | planType | membertype  |
         | MA       | Group       |       
 
Scenario Outline: To verify New Payment History page and validate Credit Balance when the balance is greater than zero
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site 
When navigate to the new Payment History page in mobile site
Then validate Credit Balance when the balance is greater than zero

Examples:
         | planType | membertype  |
         | MA       | Group       | 

Scenario Outline: To verify New Payment History page and validate for Dtm values for makeonepayment and setup automatic payments
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site  
When navigate to the new Payment History page in mobile site
Then validate DTM values for Make A One Time Payment
Then validate DTM values for Set Up Automatic Payments

Examples:
         | planType | membertype  |
         | MA       | Group       | 

 
 
 
