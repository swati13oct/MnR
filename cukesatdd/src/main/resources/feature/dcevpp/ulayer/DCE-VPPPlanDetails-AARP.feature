@dceVppDetails
Feature: To test DCE to VPP plan Summary flow  in AARP site
Scenario Outline: To Verify the drugs and plan summary for non AEP period 
Given the zipcode county name for drug search in the AARP site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
When the user search the drug with drug initials in the AARP site
	| <drugInitials> |
And a drug list appears with 5 drugs in the AARP site
And the user selects drug name in the drug list in the AARP site
	| <drugName> |
And the user selects the following dosage information in the AARP site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects low cost options information in the AARP site
	| <brand/generic> |
And the user views all the added drugs in the AARP site
And the user performs pharmacy search in the AARP site
And the user selects the pharmacy type and distance in the AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And the user views list of pharmacies available in the AARP site
And the user selects from the list of pharmacies in the AARP site
	| <pharmacyName> |
And the user views the plan results in the AARP site
Then user views the plan details for the following plan in AARP site
	| <planName> |


Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                   |
	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  CVS PHARMACY  		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  COSTCO PHARMACY 676  		| AARP MedicareRx Preferred (PDP)    | 

 
Scenario Outline: To Verify the drugs and plan summary for AEP period 
Scenario Outline: To Verify the drugs and plan summary for non AEP period 
Given the zipcode county name for drug search in the AARP site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
	| Plan Year   |<planYear>   |
When the user search the drug with drug initials in the AARP site
	| <drugInitials> |
And a drug list appears with 5 drugs in the AARP site
And the user selects drug name in the drug list in the AARP site
	| <drugName> |
And the user selects the following dosage information in the AARP site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects low cost options information in the AARP site
	| <brand/generic> |
And the user views all the added drugs in the AARP site
And the user performs pharmacy search in the AARP site
And the user selects the pharmacy type and distance in the AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And the user views list of pharmacies available in the AARP site
And the user selects from the list of pharmacies in the AARP site
	| <pharmacyName> |
And the user views the plan results in the AARP site
Then user views the plan details for the following plan in AARP site
	| <planName> |

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                           | planYear| 
	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 		  | 15 miles	           |  CVS PHARMACY  		        | AARP MedicareComplete SecureHorizons Plan 2 (HMO)            | 2015     |
	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 		 | 15 miles	           |  COSTCO PHARMACY 676  		    | AARP MedicareRx Preferred (PDP)                          | 2015     | 

	
	