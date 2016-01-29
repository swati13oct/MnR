@dceVppTestAARP
Feature: To test DCE to VPP plan Summary flow  in AARP site
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
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in AARP site
When the user search for pharmacies in dce flow in AARP site
Then the user validates the available pharmacies in the selected zipcode in AARP site
When the user selects the pharmacy type and distance in AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in AARP site
When the user selects a pharmacy from the list of pharmacies in AARP site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
When the user views plan results after selecting drug and pharmacy in AARP site
Then user validates plan count for all plan types on plan summary page in AARP site
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in AARP site
And the user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |

Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 		 | distance   |  pharmacyName          | plantype | planName 					                         |
	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |

Scenario Outline: To Verify the drugs and plan summary for AEP period 
Given the zipcode and county information DCE to Vpp Plan summary flow in AARP site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
	| Plan Year   | <planYear> |
When user search the drug using drug initials in AARP site
	| <drugInitials> |
And user access the drug list having 5 drugs in AARP site
And the user selects following drug in AARP site
	| <drugName> |
And user selects the following dosage information in AARP site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects the low cost options in AARP site
	| <brand/generic> |
And user views all the drugs added in AARP site
And user performs the pharmacy search in AARP site
And user selects the pharmacy type and distance in AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And user views the list of pharmacies available in AARP site
And user selects a pharmacy from the list of pharmacies in AARP site
	| <pharmacyName> |
And user views the plan results in AARP site
Then user views the plan summary for the following plan in AARP site
	| <planName> |

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic            | pharmacyType	 	 		 	 | distance   | pharmacyName        		| planName 					                           | planYear |
#	| 90210   |  Los Angeles County| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 			| 15 miles	       		|  CVS PHARMACY  				| AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | 2015     |
#	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 			| 15 miles	       		|  COSTCO PHARMACY 676 			| AARP MedicareRx Preferred (PDP)    | 2015     |


Scenario Outline: To Verify the drugs and plan details for non AEP period 
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
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in AARP site
When the user search for pharmacies in dce flow in AARP site
Then the user validates the available pharmacies in the selected zipcode in AARP site
When the user selects the pharmacy type and distance in AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in AARP site
When the user selects a pharmacy from the list of pharmacies in AARP site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
When the user views plan results after selecting drug and pharmacy in AARP site
Then user validates plan count for all plan types on plan summary page in AARP site
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in AARP site
And the user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in AARP site
Then the user validates the details of the selected plan in AARP site

Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic    | pharmacyType	 	 		| distance   |  pharmacyName                   | plantype | planName 					    |
	| 80002   | Adams County       | rest	      |  Restasis     |  Restasis EMU 0.05% | Plastic Container of 1.0(sold in a package of 60) | 2        | Every 3 months | no               | null             | Cost Savings Pharmacies     | 15 miles   |  SAMS PHARMACY 10-6630 106630   | PDP      | AARP MedicareRx Preferred (PDP) | 

	 
Scenario Outline: To Verify the manage drug page and verify tooltips for AARP Site 
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
Then the user validates all the drugs added in dce flow in AARP site
When the user search for pharmacies in dce flow in AARP site
Then the user validates the available pharmacies in the selected zipcode in AARP site
When the user selects the pharmacy type and distance in AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in AARP site
When the user selects a pharmacy from the list of pharmacies in AARP site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
When the user views plan results after selecting drug and pharmacy in AARP site
Then user validates plan count for all plan types on plan summary page in AARP site
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in AARP site
And the user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |
When the user click the Edit Drug List link in plan summary page of AARP site
Then user validated estimated drug cost and tooltip in AARP site

Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages | quantity | drugFrequency  | brand/generic                            | pharmacyType	 	 		 | distance   |  pharmacyName          | plantype | planName 					                         |
	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null     | 40       | Every 3 months | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy   | 25 miles   |  CVS PHARMACY 09652    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
	 