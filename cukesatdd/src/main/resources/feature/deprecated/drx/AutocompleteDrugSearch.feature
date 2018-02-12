@drxDrugSearch
Feature: To test DRX flow for Generic Portlet
Scenario Outline: To Verify the  auto drug list displaued in DRX flow for Generic Portlet
Given the user is on the Generic Portlet home page
When the user enters the plan info for autocomplete flow on the Generic Portlet home page
	| Zip Code              | <zipcode> 		    |
	| County                | <county>   		    |
	| Effective  Date       | <effectiveDate>       |
	| Plan Category         | <planCategory>        |
	| Plan Name             | <planName>            |
	| Transferred Drug Cost | <transferredDrugCost> |
	| Transferred Troop     | <transferredTroop>    |

And the user searches the drug using drug initials for autocomplete flow in Generic Portlet
	| <drugInitials> |
Then the user validates the drug results displayed in Generic Portlet
And the user selects following drug in Generic Portlet
	| <drugName> |
Then the user validates the available drug information in Generic Portlet

Examples:
		| zipcode | county 				| effectiveDate | planCategory | planName                                         | transferredDrugCost | transferredTroop| drugInitials | drugName|
		#| 90210   | Los Angeles County  | 04/01/2016    | MAPD         |AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 0.00                | 0.00            | lipi        | Lipitor |
		| 80002   | Adams County        | 04/01/2016    | MAPD         |AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 0.00                | 0.00            | lipi         | Lipitor |
	

	
	
