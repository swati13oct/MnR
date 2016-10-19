@test-only
Feature: Verify and View all of my MAPD information on the My Claims Page 
Scenario Outline: Verify My Claims Page 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the My Claims page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Examples:
	| planType | memberType |
	| MAPD     | Individual |
