@vppDce
Feature: To test DCE-ways to save flow in UMS site
Scenario Outline: To Verify Estimated Annual Drug costs in DCE-ways to save flow for non AEP period
Given the zipcode county name for drug search for WTS in the UMS site
	| Zip Code    | <zipCode>  |
	| County      | <county>   |
When the user search the drug with drug initials for WTS in the UMS site
	| <drugInitials> |
And a drug list appears with 5 drugs for WTS in the UMS site
And the user selects drug name in the drug list for WTS in the UMS site
	| <drugName> |
And the user selects the following dosage information for WTS in the UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects low cost options information for WTS in the UMS site
	| <brand/generic> |
And the user views all the added drugs for WTS in the UMS site
And the user performs pharmacy search for WTS  in the UMS site
And the user selects the pharmacy type and distance for WTS in the UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And the user views list of pharmacies available for WTS in the UMS site
And the user selects from the list of pharmacies for WTS in the UMS site
	| <pharmacyName> |
And the user views the plan results for WTS in the UMS site
Then user views the plan details for the following plan for WTS in UMS site
	| <planName> |
And the user access the ways to save section in WTS in UMS site
And the user selects reduce costs on the selected drug in WTS in UMS site
And the user switches to generic drug in WTS in UMS site
And the user performs apply changes in WTS in UMS site

Examples:
		| zipCode     |  county        | drugInitials | drugName     | drugDosage        | drugQuantity | drugFrequency  | packages       | brand/generic | pharmacyType                | distance | pharmacyName        | planName                                                  | 
		| 80002       | Adams County       | lipi         | Lipitor      | Lipitor TAB 10MG  | 30           | Every 1 month  | null           | BRAND         | Standard Network Pharmacy | 15 miles	   | COSTCO PHARMACY 676 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |  
		| 80002       | Adams County       | lipi         | Lipitor      | Lipitor TAB 10MG  | 30           | Every 1 month  | null           | BRAND         | Standard Network Pharmacy | 15 miles	   | COSTCO PHARMACY 676 | AARP MedicareRx Preferred (PDP)                   |
		
Scenario Outline: To Verify Estimated Annual Drug costs in DCE-ways to save flow for AEP period
Given the zipcode county name for drug search for WTS in the UMS site
	| Zip Code    | <zipCode>  |
	| County      | <county>   |
	| Plan Year   | <planYear> |
When the user search the drug with drug initials for WTS in the UMS site
	| <drugInitials> |
And a drug list appears with 5 drugs for WTS in the UMS site
And the user selects drug name in the drug list for WTS in the UMS site
	| <drugName> |
And the user selects the following dosage information for WTS in the UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects low cost options information for WTS in the UMS site
	| <brand/generic> |
And the user views all the added drugs for WTS in the UMS site
And the user performs pharmacy search for WTS  in the UMS site
And the user selects the pharmacy type and distance for WTS in the UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And the user views list of pharmacies available for WTS in the UMS site
And the user selects from the list of pharmacies for WTS in the UMS site
	| <pharmacyName> |
And the user views the plan results for WTS in the UMS site
Then user views the plan details for the following plan for WTS in UMS site
	| <planName> |
And the user access the ways to save section in WTS
And the user selects reduce costs on the selected drug in WTS
And the user switches to generic drug in WTS
And the user performs apply changes in WTS

Examples:
		| zipCode     |  county        | drugInitials | drugName     | drugDosage        | drugQuantity | drugFrequency  | packages       | brand/generic | pharmacyType                | distance | pharmacyName        | planName                                                     | planYear|
		| 80002       | Adams County   | lipi         | Lipitor      | Lipitor TAB 10MG  | 30           | Every 1 month  | null           | BRAND         | Standard Network Pharmacy   | 15 miles	      | COSTCO PHARMACY 676     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2015|
		| 80002       | Adams County   | lipi         | Lipitor      | Lipitor TAB 10MG  | 30           | Every 1 month  | null           | BRAND         | Standard Network Pharmacy   | 15 miles	      | COSTCO PHARMACY 676     | AARP MedicareRx Preferred (PDP)                   | 2015|
		
