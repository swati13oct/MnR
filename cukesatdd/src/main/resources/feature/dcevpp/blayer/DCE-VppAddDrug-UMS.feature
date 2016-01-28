@dceVppAddDrugUMSTest
Feature: To test DCE Add Drug Flow to VPP plan Summary flow  in UMS site
Scenario Outline: DCE Add Drug Flow Test
Given zipcode and county information DCE to Vpp Plan summary flow in UMS site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
When user wants to search the drug using drug initials in UMS site
	| <drugInitials> |
And user wants to access the drug list having 5 drugs in UMS site
And the user wants to selects following drug in UMS site
	| <drugName> |
And user wants to selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user wants to selects the low cost options in UMS site
	| <brand/generic> |

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                   |
	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  CVS PHARMACY  		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#   | 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  COSTCO PHARMACY 676  		| AARP MedicareRx Preferred (PDP)    | 

 
Scenario Outline: DCE Add Drug Flow Test from enter zip code widget
When user doing drug search using the following details in ums site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |	
	| Plan Type   | <plantype> |
When user wants to search the drug using drug initials in UMS site
	| <drugInitials> |
And user wants to access the drug list having 5 drugs in UMS site
And the user wants to selects following drug in UMS site
	| <drugName> |
And user wants to selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user wants to selects the low cost options in UMS site
	| <brand/generic> |

Examples:
	| Zipcode | plantype | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic            | pharmacyType	 	 		 | distance        | pharmacyName        		| planName 					                   |
#	| 90210   |  PDP	 | Los Angeles County  | lipi	     |  Lipitor      |  Lipitor TAB 10MG  |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  CVS PHARMACY  		    | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#   | 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 | 15 miles	       |  COSTCO PHARMACY 676  		| AARP MedicareRx Preferred (PDP)    | 
 