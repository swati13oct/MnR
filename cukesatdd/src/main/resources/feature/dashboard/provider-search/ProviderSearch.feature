Feature:To test provider search (Rally) functionality
@Sanity_ProviderSearch 
Scenario Outline: To validate that provider search is opening up correctly
Given I am a authenticated member on the member redesign site
	| Member Type    |<memberType>|
When the above plantype user logs in UMS Site Desktop
And the member navigates to Provider Search page
Then the member should be able to access provider page
Examples:
| memberType        	|
| UhcMapdInd    |
| AARPMapdInd   |
| GroupRetireeMapd     |
	