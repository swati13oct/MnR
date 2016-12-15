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

When the above plantype user logs in
Then I navigate to the new Payment History page
Then validate Payment Method value

Examples:

| plantype   | memberType   |
|  MAPD | Individual |
 
 
 
