@druglookup
Feature: To test drug search on AARP site
Scenario Outline: Verify drug search in AARP site for a member
Given registered AMP with following attributes for drug search
      | <planType> |              		
When the navigates to drug search in AARP site	
And the user selects plan year and plan name
	  | Plan Year | <planYear> |
	  | Plane Name | <planName> |
And the user search the drug with drugInitials in AARP site
      | <drugInitials> |
And the user selects drugName in the drug list in AARP site
      | <drugName> | 
And the user selects the following dosage information in AARP site
	  | Drug Dosage    | <drugDosage>    |
	  | Drug Quantity  | <drugQuantity>  |
	  | Drug Frequency | <drugFrequency> |
	  | Packages       | <packages>      |
And the user selects the following branded or generic drug in AARP site
      |<brand/generic>|
And the user search for pharmacies using the following information in AARP site
	  | Pharmacy Type | <pharmacyType> |
	  | Distance      | <distance>     |
And the user selects a pharmacy from the list of pharmacies in AARP site
      | <pharmacyName> |
Then the user validates drug cost page in AARP site
		
		
Examples:
		| planType | planYear | planName 								| drugInitials | drugName     | drugDosage          | drugQuantity | drugFrequency  | packages       | brand/generic    | pharmacyType                | distance | pharmacyName        |
		| PDP      | 2017 	  | AARP MedicareRx Saver Plus (PDP)		|  lipi       | Lipitor       | Lipitor TAB 10MG	| 30           | Every 1 month  | null           | Brand	        | Standard Network Pharmacy   | 15 miles | Pebblebrook Pharmacy 	     |
		| MAPD     | 2017	  | AARP MedicareComplete Plan 2 (HMO)	 	|  lipi        | Lipitor      | Lipitor TAB 10MG    | 30           | Every 1 month  | null           | Brand            | Standard Network Pharmacy   | 15 miles | Mickey M.Y. Tseng M.D. M.P.H Inc    |

@druglookup_pharmacysaver
Scenario Outline: As a MAPD Ulayer Member using the DCE tool on 10/1/2017, I should not see Pharmacy Saver pharmacies, including the below pharmacy saver related information for 2018 plan year
Given registered AMP with following attributes for drug search
      | <planType> |            		
When the navigates to drug search in AARP site
And the user selects plan year and plan name
	  | Plan Year | 2017 |
	  | Plane Name | AARP MedicareComplete (HMO) |
And I navigate to Pharmacy tab
Then I should see the Pharmacy Saver Plans Radio Button
And I should see the Pharmacy Saver Pharmacy type savings message
And I should see the Pharmacy Saver plans disclaimer within the Disclaimer section
And the user navigates back to drug search page
And the user selects plan year and plan name
	  | Plan Year | 2018 |
	  | Plane Name | AARP MedicareComplete Plan 1 (HMO) |
Then I should not see the Pharmacy Saver Plans Radio Button
And I should not see the Pharmacy Saver Pharmacy type savings message
And I should not see the Pharmacy Saver plans disclaimer within the Disclaimer section

Examples:
 | planType |
 | MAPDSaver|

