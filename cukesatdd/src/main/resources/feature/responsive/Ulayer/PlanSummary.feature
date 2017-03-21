@US557073
Feature: To vefify vpp compare page
Scenario Outline: To validate remove plan in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user verify disclaimer text for MA/MAPD plan for plan compare page in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |



@US519614		
Scenario Outline: To validate plan view details in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user click plan view details link on compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		
		

@US519611
Scenario Outline: To validate remove plan in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user remove plan link on compare page in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
		
@US540565		
Scenario Outline: To validate footnote section in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user verify footnote section on compare page

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |	


@US519614
Scenario Outline: To validate plan view details in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user click plan view details link on compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
    |90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |






		



