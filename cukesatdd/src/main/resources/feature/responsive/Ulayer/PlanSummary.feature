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
And the user click compare plans in AARP site
#And the user click plan view details link on compare in AARP site
#And the user remove plan link on compare page in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		

@medicalbenefits
Scenario Outline: To validate medical benefits in compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user selects desired plan to compare
      |Plan 1|<planName1>|
      |Plan 2|<planName2>|
Then the user validates medical benefits
      |MP Plan1|<mpPlan1>|
      |MP Plan2|<mpPlan2>|
      |Oop Plan1|<oopPlan1>|
      |Oop Plan2|<oopPlan2>|      
Examples:
		|zipCode|county            |planType|planName1 											|planName2                                             |mpPlan1|mpPlan2|oopPlan1|oopPlan2|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |AARP MedicareComplete SecureHorizons Plan 2 (HMO)     |$0.00  |$0.00  |$4,600.00|$2,000.00|		