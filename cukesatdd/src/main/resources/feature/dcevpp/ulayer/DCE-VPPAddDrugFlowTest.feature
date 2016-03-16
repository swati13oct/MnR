@dceVppAddDrugTest
Feature: To test DCE to VPP Add Drug flow in AARP site
Scenario Outline: VPP Add Drug flow Test 
Given the user is on the AARP medicare site home page
When the user performs drug search using the following details in AARP site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When user search the drug using drug initials in AARP site
	| <drugInitials> |
Then user validates the drug list that has above mentioned drug initials in AARP site
When user selects following drug in AARP site
	| <drugName> |
Then user validates the available drug information in AARP site
When user selects the following dosage information in AARP site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And user selects low cost options for above selected drug in AARP site
	| <brand/generic> |

Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | brand/generic                            | pharmacyType	 	 		 | distance   |  pharmacyName          | plantype | planName 					                         |
	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#	| 80002   | Adams County       | rest	      |  Restasis     |  Restasis EMU 0.05% | Plastic Container of 1.0(sold in a package of 60) | 2        | Every 3 months | Lipitor TAB 10MG                         | Standard Network Pharmacy   | 15 miles   |  COSTCO PHARMACY 676   |          | AARP MedicareRx Preferred (PDP)                    |


Scenario Outline: To test DCE to VPP Add Drug flow from enter zipcode widget in AARP site
Given user is on the AARP medicare site home page
When user performs drug search using the following details in AARP site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |	
	| Plan Type   | <plantype> |
When user search the drug using drug initials in AARP site
	| <drugInitials> |
Then user validates the drug list that has above mentioned drug initials in AARP site
When user selects following drug in AARP site
	| <drugName> |
Then user validates the available drug information in AARP site
When user selects the following dosage information in AARP site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And user selects low cost options for above selected drug in AARP site
	| <brand/generic> |

Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | brand/generic                            | pharmacyType	 	 		 | distance   |  pharmacyName          | plantype | planName 					                       |
#	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | PDP      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#	| 80002   | Adams County       | rest	      |  Restasis     |  Restasis EMU 0.05% | Plastic Container of 1.0(sold in a package of 60) | 2        | Every 3 months | Lipitor TAB 10MG                         | Standard Network Pharmacy   | 15 miles   |  COSTCO PHARMACY 676   |          | AARP MedicareRx Preferred (PDP)                    |

Scenario Outline: To Verify the drugs and plan summary for non AEP period 
Given the user is on the AARP medicare site landing page
When the user performs drug search using the following information in AARP site
       | Zip Code    | <zipcode>  |
       | County      | <county>   |
When the user search the drug using drug initials in AARP site
       | <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in AARP site
When the user selects following drug in AARP site
       | <drugName> |
Then the user validates the available drug information in AARP site
When the user selects the following dosage information in AARP site
       | Drug Dosage    | <drugDosage>    |
       | Quantity       | <quantity>      |
       | Drug Frequency | <drugFrequency> |
       | Packages       | <packages>      |
And the user selects low cost options for above selected drug in AARP site
       | <brand/generic> |
And the user wants to add another drug 

Examples:
       | zipcode | county             | drugInitials | drugName      |  drugDosage         | packages         | quantity | drugFrequency  | brand/generic                            | pharmacyType                         | distance   |  pharmacyName          | plantype | planName                                                      |
#       | 90210   | Los Angeles County | lipi          |  Lipitor      |  Lipitor TAB 20MG   | null             | 40       | Every 3 months | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |

