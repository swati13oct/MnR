@druglookupUms
Feature: 1.26-DCE (Member) To test drug search on UMS site

Scenario Outline: Verify drug cost information in UMS site
Given registered UHC member with following details for estimate drug cost
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
When the user navigates to estimate costs
When the user searches the drug with drug initials in UMS site
		| <drugInitials> |
And the user selects a drug and views the available dosages in UMS site
		| <drugName> |
And the user selects the following drug dosage information in UMS site
		| Drug Dosage    | <drugDosage>    |
		| Drug Quantity  | <drugQuantity>  |
		| Drug Frequency | <drugFrequency> |
		| Packages       | <packages>      |
#And the user selects the low cost options in UMS site
#		| <lowCostOpt> |
And the user selects the pharmacy type and the distance in UMS site	
		| Pharmacy Type | <pharmacyType> |
		| Distance      | <distance>     |
And the user selects a pharmacy from the given list in UMS site
 		| Zipcode     | <zipcode> |
Then user will validate the view Drug cost page in UMS site
		| Drug Dosage    | <drugDosage>    |
Examples:
		| planType  |  memberType    | drugInitials | drugName     | drugDosage             | drugQuantity | drugFrequency  | packages                          | lowCostOpt    | pharmacyType                | distance       | zipcode                     | planYear |
		| MAPD      | COSMOS_dce      |   lipi       | Lipistart      | Lipistart POW       | 1          | Every 1 month  | 400.0GM Can(sold in a package of 1) | Generic	     | Standard Network Pharmacy   | 15 miles       | 90210 		           | 2016     |
