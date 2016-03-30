@drxDrugSearch
Feature: To test DRX flow for Generic Portlet
Scenario Outline: To Verify the  drug search results in DRX flow for Generic Portlet
Given the user is on the Generic Portlet home page
When the user enters the plan info on the Generic Portlet home page
	| Zip Code              | <zipcode> 		    |
	| County                | <county>   		    |
	| Effective  Date       | <effectiveDate>       |
	| Plan Category         | <planCategory>        |
	| Plan Name             | <planName>            |
	| Transferred Drug Cost | <transferredDrugCost> |
	| Transferred Troop     | <transferredTroop>    |

And the user searches the drug using drug initials in Generic Portlet
	| <drugInitials> |
Then the user validates the drug results displayed in Generic Portlet

Examples:
		| zipcode | county 				| effectiveDate | planCategory | planName                                         | transferredDrugCost | transferredTroop| drugInitials |
		#| 90210   | Los Angeles County  | 04/01/2016    | MAPD         |AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 0.00                | 0.00            | lipi         |
		| 80002   | Adams County        | 04/01/2016    | MAPD         |AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 0.00                | 0.00            | lipi         |
	

	
	
