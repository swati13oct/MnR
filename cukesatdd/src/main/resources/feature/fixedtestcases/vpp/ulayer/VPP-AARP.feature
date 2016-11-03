@fixedTestCase
Feature: To test plan summary in AARP site

@fixedTestCaseNonAEP
Scenario Outline: Verify plan summary in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype | planName                                             |
	| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |

@fixedTestCaseNonAEP
Scenario Outline: Verify plan details in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
When the user view the plan details of above selected plan in the AARP site
Then the user validates the details of the selected plan in the AARP site
Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |

@fixedTestCaseAEP	
Scenario Outline: Verify plan details in AARP site for AEP only
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site during AEP period
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site during AEP
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site during AEP
	| Plan Name | <planName> |
When the user view the plan details of above selected plan in the AARP site during AEP 
Then the user validates the details of the selected plan in the AARP site
When user comes backs to plan summary page and view current year plan
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
When the user view the plan details of above selected plan in the AARP site
Then the user validates the details of the selected plan in the AARP site
Examples:
	| zipcode | county             | plantype |  planName                                             |  		 
	| 80210   | Denver County      | MA       |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	
		
@fixedTestCaseAEP	
Scenario Outline: Verify Enroll now link on plan summary page in AARP site for AEP only from 15th October till 30th November
Given the user is on AARP medicare acquisition site landing page 
When the user performs plan search using following information in aquisition AARP site during AEP period
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user select MA/MAPD/PDP plans on plan summary page using following information during AEP period
	| Plan Type | <plantype> |
	| Plan Name | <planName> |
And user verify enroll now link for next year MA/MAPD/PDP plans during AEP period

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 80210   | Denver County      | MA       |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |

	
@fixedTestCaseNonAEP
Scenario Outline: Verify plan summary after entering drug information in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
And the user selects the enter drug information link for the selected plan in the AARP site
And the user search the drug using drug initials in the AARP site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in the AARP site
And the user selects following drug in the AARP site
	| <drugName> |
Then the user validates the available drug information in the AARP site
And the user selects the following dosage information in the AARP site
	| Drug Dosage   | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in the AARP site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in the AARP site
When the user search for pharmacies in dce flow in the AARP site
Then the user validates the available pharmacies in the selected zipcode in the AARP site
And the user selects the pharmacy type and distance in the AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in the AARP site
When the user selects a pharmacy from the list of pharmacies in the AARP site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in the AARP site
When the user applies changes after selecting drug and pharmacy in the AARP site
Then the user validates the plan summary page with updated drug information in the AARP site

Examples:
	| zipcode | county             | plantype  | planName 					        | drugInitials  | drugName      |  drugDosage	        | quantity      | drugFrequency  |  packages    | genericAvailable | brand/generic                              | pharmacyType	 	 		| distance      |  pharmacyName			|
	| 90210   | Los Angeles County | MAPD      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | lipi		|  Lipitor      |  Lipitor TAB 20MG     |   40		| Every 3 months |   null	|   	yes	   | Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	|  Horton And Converse Pharmacy	|



@fixedTestCaseNonAEP
Scenario Outline: Verify plan details after entering drug information in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
When the user view the plan details of above selected plan in the AARP site
Then the user validates the details of the selected plan in the AARP site
And the user access the enter drug information link in the plan details page for above selected plan section in the AARP site
And the user search the drug using drug initials in the AARP site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in the AARP site
And the user selects following drug in the AARP site
	| <drugName> |
Then the user validates the available drug information in the AARP site
And the user selects the following dosage information in the AARP site
	| Drug Dosage   | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in the AARP site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in the AARP site
When the user search for pharmacies in dce flow in the AARP site
Then the user validates the available pharmacies in the selected zipcode in the AARP site
And the user selects the pharmacy type and distance in the AARP site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in the AARP site
When the user selects a pharmacy from the list of pharmacies in the AARP site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in the AARP site
When the user applies changes after selecting drug and pharmacy for plan details in the AARP site
Then the user validates the plan details for above plan name in the AARP site

Examples:
	| zipcode | county             | plantype  | planName 					        | drugInitials  | drugName      |  drugDosage	        | quantity      | drugFrequency  |  packages    | genericAvailable | brand/generic                              | pharmacyType	 	 		| distance      |  pharmacyName			|
	| 90210   | Los Angeles County | MAPD      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | lipi		|  Lipitor      |  Lipitor TAB 20MG     |   40		| Every 3 months |   null	|   	yes	   | Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	|  Horton And Converse Pharmacy	|


Scenario Outline: Plan Compare Launch on VPP Pages
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then the user navigates to the following plan typein the AARP site
	| Plan Type | <plantype> |
Then user should see the inactive/grey plan compare button in the AARP site
And the user should see blank compare check box in the AARP site
When user click any of the check boxes or compare content in the AARP site
Then check in checkbox should appear and disappear in the AARP site
Examples:
	| zipcode | county             | plantype | planName                                             |
##	| 78006   | Bexar County       | PDP      | AARP MedicareRx Saver Plus (PDP)                     |	 