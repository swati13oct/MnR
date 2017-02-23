@planSummaryPage
Feature: To vefify mobile responsive 
 
Scenario Outline: To validate plan highlights and provider searh link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
And the user validates plan highlight and provider search	
Examples:
		|zipCode|county            |planType|
		|90210  |Los Angeles County|MA      |		

Scenario Outline: To validate plan details link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |

@portfolio
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
#Then user validates plan count for all plan types on plan summary page in AARP site
Then user validates county name on plan summary page
Examples:
|zipCode|county     |
|78006 |Bexar County|			