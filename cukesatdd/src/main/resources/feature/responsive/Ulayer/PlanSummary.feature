@planSummaryPage
Feature: To vefify Add to Compare Checboxes

Scenario Outline: To validate Add to Compare Checboxes
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		
		
@planSummaryPage1		
Scenario Outline: To validate Add to Compare Checboxes
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|85001  |Maricopa County   |MA      |AARP MedicareComplete Plan 1 (HMO)  								|	