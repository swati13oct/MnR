@fastandfurious @OLE
@OLE_Ulayer
Feature: To test OLE common tool flow in AARP site
@BuildAcceptanceTest
Scenario Outline: Build Validation Test for OLE Flow 
Given the user lands on OLE Welcome Page wity following Plan Details
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
		| Plan Type | <plantype> |
		| Plan Name | <planName> |
	| Premium	 		| <premium>	|
Then the user validates Learn more modal for OLE
Then the user validates cancellation modal for OLE
Then the user validates Leave OLE modal for OLE
Then the user validates and selects the Disclaimer Checkbox
Then the user navigates to Medicare Information Page
Then the user validates Medicare Information Page required fields
Then the user navigates to Preliminary Questions Page
Then the user navigates to Personal Information Page
	
Examples:
| zipcode | county             | plantype | planName                                         | premium	|
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |	$0.00	|


@OLE_VPP_AARP
Scenario Outline: OLE Landing from VPP Plan Summary
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
And the user validates the available plans for selected plan types in the AARP site
Then the user clicks on Enroll Now for AARP site to start the OLE flow
	| Plan Name | <planName> |
Then the user validates the Plan details on OLE 
Then the user validates TFN in Right Rail
Then the user validates Learn more modal for OLE
Then the user validates Leave OLE modal for OLE
Then the user validates cancellation modal for OLE
Then the user validates and selects the Disclaimer Checkbox
Then the user navigates to Medicare Information Page
Then the user validates Medicare Information Page required fields
Then the user navigates to Preliminary Questions Page

	
Examples:
| zipcode | county             | plantype | planName                                         |
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
| 90210		| Los Angeles County | PDP  | AARP MedicareRx Walgreens (PDP) 	|

@OLE_PlanDetails_Aarp
Scenario Outline: OLE Landing from VPP Plan Details
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in AARP site and validates
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
Then the user validates the Plan details on OLE 

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	| 90210		| Los Angeles County | PDP  | AARP MedicareRx Walgreens (PDP) 	|
	
	@OLE_PlanCompare_Aarp
Scenario Outline: OLE Landing from VPP Plan Compare
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user selects plans to add to plan compare and navigates to Plan compare page
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
	| Plan Name | <planName> |
Then the user validates the Plan details on OLE 

Examples:
	| zipcode | county             | plantype |  planName                                      |
	| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	| 90210		| Los Angeles County | PDP  | AARP MedicareRx Walgreens (PDP) 	|
	
