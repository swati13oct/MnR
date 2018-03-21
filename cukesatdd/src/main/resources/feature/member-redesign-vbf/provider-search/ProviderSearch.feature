@smokeTest
Feature: 1.14-VBF-MemRedesign-To test provider search (Rally) functionality
@smokeTest_ProviderSearch @rallyDashboard @testharness
Scenario Outline: To validate that provider search is opening up correctly
Given I am a authenticated member on the member redesign site for Provider Search
	| Member Type    |<memberType>|
When the above plantype user logs in member area to validate provider search
And the member navigates to Provider Search page
Then the member should be able to access provider page
Examples:
| memberType        	|
| UhcMapdInd    |
#| AARPMapdInd   |
#| GroupRetireeMapd     |
	