@dceVppTestUhc1
Feature: To test DCE to VPP plan Summary flow Edit Flow in UMS site
Scenario Outline: To Verify the drugs and plan summary Edit Flow for non AEP period 
Given the zipcode and county information for DCE to Vpp Plan summary flow in UMS site
	| Zip Code    | <Zipcode>  |
	| County      | <county>   |
When user search the drug using the drug initials in UMS site
	| <drugInitials> |
And user access the drug list with having 5 drugs in UMS site
And the user selects the following drug in UMS site
	| <drugName> |
And user selects the following dosage info in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Drug Quantity  | <drugQuantity>  |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |	
And the user selects low cost options in UMS site
	| <brand/generic> |
And user views all the drugs got added in UMS site
And user perform the pharmacy search in UMS site
And user selects pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And user views list of pharmacies available in UMS site
And user selects the pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
And user view the plan results in UMS site
And user view the plan summary for the following plan in UMS site
	| <planName> |
And the user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |	
When the user click the Edit Drug List link in plan summary page of UMS site
Then user validated estimated drug cost and tooltip in UMS site	

Examples:
	| Zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic    | pharmacyType	 	 		 | distance  | pharmacyName   | planName 					                      | plantype |
	| 90210   |  Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 10MG |    30        | Every 1 month | null     | Lipitor TAB 10MG | Standard Network Pharmacy 	 | 15 miles	 | CVS PHARMACY 09652  | AARP MedicareComplete SecureHorizons Plan 2 (HMO) | MAPD     |
