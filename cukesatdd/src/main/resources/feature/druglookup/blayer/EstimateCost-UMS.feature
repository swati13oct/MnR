@druglookup
Feature: To test estimate drug cost flow in UMS site
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
And the user selects the low cost options in UMS site
		| <lowCostOpt> |
And the user selects the pharmacy type and distance in UMS site
		| Pharmacy Type | <pharmacyType> |
		| Distance      | <distance>     |
And the user selects a pharmacy from the given list in UMS site
 		| <pharmacyName> |
Then user will validate the view Drug cost page in UMS site
				
Examples:
		 | planType  |  memberType    | drugInitials | drugName     | drugDosage             | drugQuantity | drugFrequency  | packages       | lowCostOpt    | pharmacyType                | distance       | pharmacyName                     | planYear |
		| MAPD      | Individual   |   lipi       | Lipitor      | Lipitor TAB 10MG       | 30           | Every 1 month  | null           | Generic	       | Standard Network Pharmacy   | 15 miles       | CVS PHARMACY 00918	 | 2015     |
#		| MAPD      |  Group       |   lipi       | Lipitor      | Lipitor TAB 10MG       | 30           | Every 1 month  | null           | Generic	           | Standard Network Pharmacy   | 15 miles       |  	CVS PHARMACY 00918  | 2015     |
	   | PDP       |  Group       |   lipi       | Lipitor      | Lipitor TAB 10MG       | 30           | Every 1 month  | null           | Brand	           | Standard Network Pharmacy   | 15 miles       | AVALON CHEMISTS  			     | 2015     |


Scenario Outline: AL PEEHIP -DRUG COST ESTIMATOR: SELECT PHARMACY
Given I am a MA or MAPD member user on the AL PEEHIP site
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
When I view the Drug Cost Estimator Select a Pharmacy search page
		| <drugInitials> |
And It is on or after January 1, 2017
		| <drugName> |
Then I should not see the Preferred Mail Service Pharmacy radio button
		| Drug Dosage    | <drugDosage>    |
		| Drug Quantity  | <drugQuantity>  |
		| Drug Frequency | <drugFrequency> |
		| Packages       | <packages>      |
						
Examples:
		| planType  |  memberType    | drugInitials | drugName     | drugDosage             | drugQuantity | drugFrequency  | packages       | lowCostOpt    | pharmacyType                | distance       | pharmacyName                     | planYear |		
		| MAPD      |  Group       |   lipi       | Lipitor      | Lipitor TAB 10MG       | 30           | Every 1 month  | null           | Generic	           | Standard Network Pharmacy   | 15 miles       |  	CVS PHARMACY 00918  | 2015     |

Scenario Outline: AL PEEHIP DRUG COST ESTIMATOR DRUG COST DETAILS ways to save
Given I am a MA or MAPD member user on the AL PEEHIP site
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
When I view the Drug Cost Estimator Select a Pharmacy search page
		| <drugInitials> |
And It is on or after January 1, 2017
		| <drugName> |
Then the user adds the drug
		| Drug Dosage    | <drugDosage>    |
		| Drug Quantity  | <drugQuantity>  |
		| Drug Frequency | <drugFrequency> |
		| Packages       | <packages>      |
When user adds one more drug
		| <drugInitials1> |
And It is on or after January 1, 2017
		| <drugName1> |
Then user adds second drug
		| Drug Dosage    | <drugDosage1>    |
		| Drug Quantity  | <drugQuantity1>  |
		| Drug Frequency | <drugFrequency1> |
		| Packages       | <packages1>      |
Then validates the ways to save	
		|Pharamcy Name   |	<pharmacyName>  |							
Examples:
		| planType  |  memberType    | drugInitials | drugName     | drugDosage             | drugQuantity | drugFrequency  | packages       | lowCostOpt    | pharmacyType                | distance       | pharmacyName                     | planYear |	drugInitials1 | drugName1             | drugDosage1             | drugQuantity1 | drugFrequency1  | packages1 |	
		| MAPD      |  Group       |   lipi       | Lipitor      | Lipitor TAB 10MG       | 30           | Every 1 month  | null           | Generic	           | Standard Network Pharmacy   | 15 miles       |  	Ym Drugs Inc  | 2015            | simv         |simvastatin           |simvastatin TAB 20MG    | 30           |Every 1 month   | null                 |

