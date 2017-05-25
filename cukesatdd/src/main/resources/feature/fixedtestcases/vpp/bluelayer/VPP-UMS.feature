@fixedTestCaseTest
@fixedTestCaseVPP
Feature: To test plan summary in UMS site

@vppBlayer
Scenario Outline: Verify plan details in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in UMS site and validates
	| Plan Name | <planName> |

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	
@fixedTestCaseNonAEP
Scenario Outline: Verify plan summary in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the UMS site
When user views plans of the below plan type in the UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the UMS site
And the user validates the plan summary for the below plan in the UMS site
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype | planName                                                |
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       |
	| 90210   | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO)       |
	| 30002   | DeKalb County      | MAPD     | Care Improvement Plus Medicare Advantage (Regional PPO) |
	| 60004   | Cook County        | MAPD     | AARP MedicareComplete Plan 1 (HMO)                      |
	| 80002   | Jefferson County   | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)         |
	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                         |
	| 78006   | Comal County       | SNP      | Care Improvement Plus Gold Rx (Regional PPO SNP)        |


@fixedTestCaseNonAEP
Scenario Outline: Verify plan details in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the UMS site
When user views plans of the below plan type in the UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the UMS site
And the user validates the plan summary for the below plan in the UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in the UMS site
Then the user validates the details of the selected plan in the UMS site

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 90210   | Los Angeles County | MA       |  AARP MedicareComplete SecureHorizons Plan 3 (HMO)    |
	| 78006   | Comal County       | PDP      |  AARP MedicareRx Preferred (PDP)	                  |


@fixedTestCaseNonAEP
Scenario Outline: Verify plan summary after entering drug information in the UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the UMS site
When user views plans of the below plan type in the UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the UMS site
And the user validates the plan summary for the below plan in the UMS site
	| Plan Name | <planName> |
And the user access the enter drug information link for above selected plan section in the UMS site
And the user search the drug using drug initials in the UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in the UMS site
When the user selects following drug in the UMS site
	| <drugName> |
Then the user validates the available drug information in the UMS site
When the user selects the following dosage information in the UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in the UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in the UMS site
When the user search for pharmacies in dce flow in the UMS site
Then the user validates the available pharmacies in the selected zipcode in the UMS site
When the user selects the pharmacy type and distance in the UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in the UMS site
When the user selects a pharmacy from the list of pharmacies in the UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in the UMS site
When the user applies changes after selecting drug and pharmacy in the UMS site
Then the user validates the plan summary for the above plan name in the UMS site


Examples:
	| zipcode | county             | plantype | planName                                                | drugInitials	| drugName      |  drugDosage	        | packages	| quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 | distance   |  pharmacyName   |
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       | lipi		|  Lipitor      |  Lipitor TAB 20MG	| null		| 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy	 | 15 miles   | Costco Pharmacy	|

@fixedTestCaseNonAEP	
Scenario Outline: Verify plan details after entering drug information in UMS site
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the UMS site
When user views plans of the below plan type in the UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the UMS site
And the user validates the plan summary for the below plan in the UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in the UMS site
Then the user validates the details of the selected plan in the UMS site
And the user access the enter drug information link in plan details page for above selected plan section in the UMS site
And the user search the drug using drug initials in the UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in the UMS site
When the user selects following drug in the UMS site
	| <drugName> |
Then the user validates the available drug information in the UMS site
When the user selects the following dosage information in the UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in the UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in the UMS site
When the user search for pharmacies in dce flow in the UMS site
Then the user validates the available pharmacies in the selected zipcode in the UMS site
When the user selects the pharmacy type and distance in the UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in the UMS site
When the user selects a pharmacy from the list of pharmacies in the UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in the UMS site
When the user applies changes after selecting drug and pharmacy for plan details in the UMS site
Then the user validates the plan details for the above plan name in the UMS site

Examples:
	| zipcode | county             | plantype | planName                                                | drugInitials	| drugName      |  drugDosage	        | packages	| quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 | distance   |  pharmacyName   |
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       | lipi		|  Lipitor      |  Lipitor TAB 20MG	| null		| 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Standard Network Pharmacy	 | 15 miles   | Costco Pharmacy	|

@fixedTestCaseAEP
Scenario Outline: Verify plan details for current year and next year plans in UMS site during AEP only
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site during AEP period
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the UMS site
When the user views plans of the below plan type in the UMS site during AEP
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the UMS site
And the user validates the plan summary for the below plan in the UMS site during AEP
	| Plan Name | <planName> |
When the user views plan details of the above selected plan in the UMS site during AEP
Then the user validates the details of the selected plan in the UMS site
When user comes back to the UMS plan summary page and view current year plan
And the user validates the plan summary for the below plan in the UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in the UMS site
Then the user validates the details of the selected plan in the UMS site

Examples:
	| zipcode | county		| plantype |  planName							|  		 
	| 78006   | Comal County	| MA       |  AARP MedicareComplete SecureHorizons Essential (HMO)	|


Scenario Outline: Plan Compare Launch on VPP Pages
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in the UMS site
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
#	| 78006   | Bexar County       | PDP      | AARP MedicareRx Saver Plus (PDP)                     |