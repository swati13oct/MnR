@theSpartans
Feature:To verify New Payment History page
Scenario Outline:To Verify Payment History section including the header and payment date range dropdown so that I can view and search for the history of my payments without having to call customer service.
Given I am an UHC Individual member on the Dashboard site
       | Plan Type   | <planType>   |
       | Member Type	  | <memberType> |
When the above plantype user logs in UMS Site
Then navigate to the Payment History page in UMS Site
And I can view a Payment History header,text in UMS Site
And I can view a View Payments For dropdown menu and first selected option is Last 90 days in UMS Site
And I can view all the expected options in the dropdown of View Payments in UMS Site
And  I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in UMS Site
| start date | <startDate> |
| end date | <endDate> |
And I can view a Payment table header in UMS Site
And I can view a Payment table columns in UMS Site
And I can view Making your payments header and text in UMS Site
And I can view LEARN MORE ABOUT WAYS TO PAY text that can expand in UMS Site

Examples:

 | planType  | memberType  | startDate | endDate |
 | PDP   | Group  | 01/01/2016 | 12/30/2016 |
 #| MAPD  |  Group | 01/01/2016 | 12/30/2016 |
#| MA    | Group  | 01/01/2016 | 12/30/2016 |
 | SSUP   | Group  | 12/01/2016 | 12/30/2016 |
 
Scenario Outline:To verify New Payment History page
Given I am an UHC Individual member on the Dashboard site
    | Plan Type      | <planType>  |
 	| Member Type     | <memberType>|
 
When the above plantype user logs in
Then I navigate to new Payment History page 
Then I can view the total amount due credit balance

Examples:

 | planType | | memberType |
 | SSUP | | Group |
 | MA | | Group |
 | MAPD | | Group |
 | PDP | | Group |
 | MA | | Individual |
 | MAPD | | Individual |

Scenario Outline:To verify New Payment History page
Given I am an Uhc Individual member on the Dashboard site
    | Plan Type | <plantype> |
	| Member Type  | <memberType> |
When the above plantype user logs in
Then I navigate to the new Payment History page 
Then validate Payment Method value
Examples:

 | plantype   | memberType   |
  |  SSUP | Group |
  |  MA | Group |
   |  MAPD | Group |
   |  MA     | Individual |
   |  MAPD | Individual |
 
 
Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an UHC member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile in UHC Site
When navigate to the new Payment History page in mobile site 
Then validate Non setup automatic payment

Examples:
         | planType | membertype |
         | MA       | Group      |
       # | MA       | Group      | 
       # | MA       | Individual |

Scenario Outline: To verify New Payment History page and validate for member who setup automatic payment
Given I am an UHC member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile in UHC Site
When navigate to the new Payment History page in mobile site 
Then validate setup automatic payment

Examples:
         | planType | membertype  |
         | MA       | Group       |       
      
Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an UHC member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When plantype user logs in mobile in UHC Site
When navigate to the new Payment History page in mobile site
Then validate Credit Balance when the balance is greater than zero


Examples:
         | planType | membertype  |
         | MA       | Group       |  

 
 
 
 
 
 
 