@payment_history_mobile
Feature:To verify New Payment History page in mobile site
Scenario Outline:To Verify Payment History section including the header and payment date range dropdown so that I can view and search for the history of my payments without having to call customer service.
Given I am an AARP Individual member on the Dashboard site
       | Plan Type   | <planType>   |
When the above plantype user logs in mobile site
Then I navigate to the Payment History page in AARP site
And I can view a Payment History header_text in AARP site
And I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP site
And I can view all the expected options in the dropdown in AARP site
And I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP site
        | Start Date   | <startDate>  |
        | End Date     | <endDate>    |     
And I can view a Payment table columns in AARP site

Examples:

 | planType  |  startDate  |  endDate   |
 | PDP   	 |  10/01/2016 | 12/31/2016 |
#| MAPD      |  01/01/2016 | 12/30/2016 |
#| MA        |  01/01/2016 | 12/30/2016 |

	