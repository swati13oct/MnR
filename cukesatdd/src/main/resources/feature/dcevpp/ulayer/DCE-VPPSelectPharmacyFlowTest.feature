@dceVppSelectPharmacyTestAARP
Feature: To test DCE to VPP Select Pharmacy flow in AARP site
Scenario Outline: DCE Select Pharmacy flow Test 
Given user is on the AARP medicare home page
When the user wants to performs drug search using the following details in AARP site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When user wants to search the drug using drug initials in AARP site
	| <drugInitials> |
Then user wants to validates the drug list that has above mentioned drug initials in AARP site
When user wants to selects following drug in AARP site
	| <drugName> |
Then user wants to validates the available drug information in AARP site
When user wants to selects the following dosage information in AARP site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And user wants to selects low cost options for above selected drug in AARP site
	| <brand/generic> |
Then user wants to validates all the drugs added in dce flow in AARP site
When user wants to search for pharmacies in dce flow in AARP site
Then user wants to validates the available pharmacies in the selected zipcode in AARP site
When user wants to selects the pharmacy type and distance in AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then user wants to validates the available pharmacies based on selection made above in AARP site
When user wants to selects a pharmacy from the list of pharmacies in AARP site
	| <pharmacyName> |
Then user wants to validates the selected drug and selected pharmacy on manage drug list page in AARP site
	
Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | brand/generic                            | pharmacyType	 	 		 | distance   |  pharmacyName          | plantype | planName 					                         |
	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#	| 80002   | Adams County       | rest	      |  Restasis     |  Restasis EMU 0.05% | Plastic Container of 1.0(sold in a package of 60) | 2        | Every 3 months | Lipitor TAB 10MG                         | Standard Network Pharmacy   | 15 miles   |  COSTCO PHARMACY 676   |          | AARP MedicareRx Preferred (PDP)                    |
