@vpp
Feature: To test plan summary in UMS site
Scenario Outline: Verify plan summary in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype | planName                                                |
#	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       |
#	| 90210   | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO)       |
#	| 30002   | DeKalb County      | MAPD     | Care Improvement Plus Medicare Advantage (Regional PPO) |
#	| 60004   | Cook County        | MAPD     | AARP MedicareComplete Plan 1 (HMO)                      |
#	| 80002   | Jefferson County   | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)    |
#	| 80002   | Jefferson County   | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)         |
#	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                         |
#	| 78006   | Comal County       | SNP      | Care Improvement Plus Gold Rx (Regional PPO SNP)        |

Scenario Outline: Verify plan details in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
Then the user validates the details of the selected plan in UMS site

Examples:
	| zipcode | county             | plantype |  planName                                             |
#	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 80002   | Jefferson County   | MA	  |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
#	| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |
#	| 78006   | Bexar County       | SNP      |  UnitedHealthcare Dual Complete (HMO SNP)             |
#	| 01002   | Hampshire County   | MA       |  AARP MedicareComplete Choice (Regional PPO)    |
#	| 01008   | Hampden County   | MA       |  AARP MedicareComplete Plan 2 (HMO)    |
	


Scenario Outline: Verify plan summary after entering drug information in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
And the user access the enter drug information link for above selected plan section in UMS site
And the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
When the user applies changes after selecting drug and pharmacy in UMS site
Then the user validates the plan summary for the above plan name in UMS site


Examples:
	| zipcode | county             | plantype | planName                                                | drugInitials	| drugName      |  drugDosage	        | packages	| quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 | distance   |  pharmacyName          |
#	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       | lipi		|  Lipitor      |  Lipitor TAB 20MG	| null		| 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy	 | 25 miles   | COSTCO PHARMACY 676    |
#	| 90210   | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO)       |
#	| 30002   | DeKalb County      | MAPD     | Care Improvement Plus Medicare Advantage (Regional PPO) |
#	| 60004   | Cook County        | MAPD     | AARP MedicareComplete Plan 1 (HMO)                      |
#	| 80002   | Jefferson County   | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)    |
#	| 80002   | Jefferson County   | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)         |
#	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                         |
#	| 78006   | Comal County       | SNP      | Care Improvement Plus Gold Rx (Regional PPO SNP)        |

	
Scenario Outline: Verify plan details after entering drug information in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
Then the user validates the details of the selected plan in UMS site
And the user access the enter drug information link in plan details page for above selected plan section in UMS site
And the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
When the user applies changes after selecting drug and pharmacy for plan details in UMS site
Then the user validates the plan details for the above plan name in UMS site

Examples:
	| zipcode | county             | plantype | planName                                                | drugInitials	| drugName      |  drugDosage	        | packages	| quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 | distance   |  pharmacyName          |
#	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       | lipi		|  Lipitor      |  Lipitor TAB 20MG	| null		| 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy	 | 25 miles   | COSTCO PHARMACY 676    |
#	| 80002   | Jefferson County   | MA	  |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
#	| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |
#	| 78006   | Bexar County       | SNP      |  UnitedHealthcare Dual Complete (HMO SNP)             |





Scenario Outline: Verify plan details in UMS site for AEP only
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site during AEP period
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site during AEP
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site during AEP
	| Plan Name | <planName> |
When the user views plan details of the above selected plan in UMS site during AEP 
Then the user validates the details of the selected plan in UMS site
When user comes back to UMS plan summary page and view current year plan
And the user validates the plan summary for the below plan in UMS site during AEP
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site during AEP 
Then the user validates the details of the selected plan in UMS site

Examples:
	| zipcode | county             | plantype |  planName                                             |  		 
#	| 78006   | Comal County | MA       |  AARP MedicareComplete SecureHorizons Essential (HMO)   |
#	| 01008   | Hampden County   | MA       |  AARP MedicareComplete Plan 2 (HMO)    |


Scenario Outline: Verify plan details in UMS site

@Q3
Scenario Outline: Verify the pharmacies after selecting a plan UMS site

Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |

Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
Then the user validates the details of the selected plan in UMS site
And the user validate pdf links on UMS site

Examples:
	| zipcode | county             | plantype |  planName                                             |
#	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80002   | Jefferson County   | MA	  |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
#	| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |
#	| 78006   | Bexar County       | SNP      |  UnitedHealthcare Dual Complete (HMO SNP)             |
#	| 01002   | Hampshire County   | MA       |  AARP MedicareComplete Choice (Regional PPO)    |
	| 01008   | Hampden County   | MA       |  AARP MedicareComplete Plan 2 (HMO)    |
	| 11001   | Queens County     | MAPD    |  AARP MedicareComplete Plan 2 (HMO)    |
	| 01008   | Hampden County   | PDP       |  AARP MedicareRx Preferred (PDP)    			|

Scenario Outline: Plan Compare Launch on VPP Pages
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then the user navigates to the following plan type
	| Plan Type | <plantype> |
Then user should see the inactive/grey plan compare button
And the user should see blank compare check box
When user click any of the check boxes or compare content
Then check in checkbox should appear and disappear
Examples:
	| zipcode | county             | plantype | planName                                             |
	| 78006   | Bexar County       | PDP      | AARP MedicareRx Saver Plus (PDP)                     |


And the user selects the plan in UMS site
	| Plan Type | <plantype> |
And the user selects the enter drug information link for the selected plan in UMS site
    | Plan Name | <planName> |
And the user search for the drug in UMS site
	| <drugInitials> |
And the user selects the drug from the dropdown in UMS site
	| <drugName> |
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for the selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
When the user search for pharmacies in UMS site
And the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site

Examples:
	| zipcode | county             | plantype | planName 					    |drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 		     | distance   | 
	| 90210   | Los Angeles County | PDP      |AARP MedicareRx Preferred (PDP)  |lipi	      |   Lipitor     |  Lipitor TAB 10MG   | null                                              | 30       | Every 1 month  | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy        | 15 miles   |
	
@Q3	
Scenario Outline: Verify Marketing Bullets for symphonix and walgreen plans in UMS site for AEP only
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site during AEP period
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site during AEP
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site during AEP
	| Plan Name | <planName> |
When the user views plan details of the above selected plan in UMS site during AEP 
Then the user validates the details of the selected plan in UMS site
Examples:
| zipcode | county             | plantype |  planName                                             |  		 
| 60646   | Cook County | PDP       |  AARP MedicareRx Walgreens (PDP)  |
| 60646   | Cook County | PDP       |  Symphonix Value Rx (PDP)  |
		 

