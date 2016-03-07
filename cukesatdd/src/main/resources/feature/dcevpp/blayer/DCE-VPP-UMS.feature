@dceVpp
Feature: To test DCE to VPP plan Summary flow  in UMS site
Scenario Outline: To Verify the drugs and plan summary for non AEP period 
Given the zipcode and county information DCE to Vpp Plan summary flow in UMS site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
When user search the drug using drug initials in UMS site
	| <drugInitials> |
And user access the drug list having 5 drugs in UMS site
And the user selects following drug in UMS site
	| <drugName> |
And user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects the low cost options in UMS site
	| <brand/generic> |
And user views all the drugs added in UMS site
And user performs the pharmacy search in UMS site
And user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And user views the list of pharmacies available in UMS site
And user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
And user views the plan results in UMS site
Then user views the plan summary for the following plan in UMS site
	| <planName> |

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                   |
	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  CVS PHARMACY  		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  COSTCO PHARMACY 676  		| AARP MedicareRx Preferred (PDP)    | 

 
Scenario Outline: To Verify the drugs and plan summary for AEP period 
Given the zipcode and county information DCE to Vpp Plan summary flow in UMS site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
	| Plan Year   | <planYear> |
When user search the drug using drug initials in UMS site
	| <drugInitials> |
And user access the drug list having 5 drugs in UMS site
And the user selects following drug in UMS site
	| <drugName> |
And user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects the low cost options in UMS site
	| <brand/generic> |
And user views all the drugs added in UMS site
And user performs the pharmacy search in UMS site
And user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And user views the list of pharmacies available in UMS site
And user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
And user views the plan results in UMS site
Then user views the plan summary for the following plan in UMS site
	| <planName> |

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                           | planYear |
	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  CVS PHARMACY  		        | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | 2015     |
	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  COSTCO PHARMACY 676 		    | AARP MedicareRx Preferred (PDP)    				   | 2015     | 

	
	