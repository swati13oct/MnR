@payment_history
Feature:To verify New Payment History page
Scenario Outline:To Verify Payment History section including the header and payment date range dropdown so that I can view and search for the history of my payments without having to call customer service.
Given I am an UHC Individual member on the Dashboard site
       | Plan Type   | <planType>   |
       | Member Type	  | <memberType> |
When the above plantype user logs in
Then navigate to the Payment History page
And I can view a Payment History header,text
And I can view a View Payments For dropdown menu and first selected option is Last 90 days
And I can view all the expected options in the dropdown
And  I can view a View Payments For Custom Search when I have selected Custom Search and options are coming.
| start date | <startDate> |
| end date | <endDate> |
And I can view a Payment table header
And I can view a Payment table columns  

Examples:

 | planType  | memberType  | startDate | endDate |
 | PDP   | Group  | 01/01/2016 | 12/30/2016 |
 | MA   | Group  | 01/01/2016 | 12/30/2016 |
 | MAPD   | Group  | 01/01/2016 | 12/30/2016 |
 
 