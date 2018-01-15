Feature:To test sign functionality
@Sanity_DirectLogin 
Scenario Outline: To validate that member is successfully getting logged in to Rally Dashboard
Given I am a authenticated member on the member redesign site
	| Member Type    |<memberType>|
When the above plantype user logs in UMS Site Desktop
Then User should be able to validate Dashboard elements
And User should be ale to navigate to secondary page

Examples:
| memberType        |
| UhcMapdInd     |
| AARPMapdInd     |
| GroupRetireeMapd     |
| Ship     |
| PCP     |
| Medica     |

