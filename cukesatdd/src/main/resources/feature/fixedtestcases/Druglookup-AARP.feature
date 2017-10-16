@druglookup
Feature: 1.25-DCE (Member) To test drug search on AARP site
@dceUlayer
Scenario Outline: Verify drug search in AARP site for a member
Given registered AMP user with following attributes for drug search
      | <planType> |   
      | <category> |           		
When the user navigates to drug search in AARP site	
#And the user selects the plan and clicks on continue
#	 |Plan Name | <planName> |
And the user search the drug with drugInitials in AARP site
      | <drugInitials> |
And the user selects drugName in the drug list in AARP site
      | <drugName> | 
And the user selects the following dosage information in AARP site
	  | Drug Dosage    | <drugDosage>    |
	  | Drug Quantity  | <drugQuantity>  |
	  | Drug Frequency | <drugFrequency> |
	  | Packages       | <packages>      |
	  |  Drug Type     |<drugType>|
And the user search for pharmacies using the following information in AARP site
	  | Pharmacy Type | <pharmacyType> |
	  | Distance      | <distance>     |
And the user selects a pharmacy from the list of pharmacies in AARP site
      | <pharmacyName> |
Then the user validates drug cost page in AARP site
		| Drug Dosage    | <drugDosage>    |
		
Examples:
		| planType | category    	| 			planName				|drugInitials | drugName     | drugDosage          | drugQuantity | drugFrequency  | packages       | drugType    | pharmacyType                | distance | pharmacyName        |
		| MAPD     | COSMOS_dce1	| AARP MedicareComplete Plan 1 (HMO)| lipi        | Lipitor      | Lipitor TAB 10MG    | 30           | Every 1 month  | null           | Brand            | Standard Network Pharmacy   | 15 miles | Brockie Pharmatech   |

@dcePlans	    
Scenario Outline: Verify DCE plans are showing AARP plans and not UHC plans
Given registered AMP user with following attributes for drug search
      | <planType> |   
      | <category> |           		
When the user navigates to drug search in AARP site
Then the user checks and verifies that the plans shown are AARP plans

Examples:
	|planType | category |
	|MAPD 	| COSMOS_dce2 |
