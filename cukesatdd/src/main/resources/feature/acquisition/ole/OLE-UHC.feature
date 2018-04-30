@fastandfurious @OLE
@OLE_UHC
Feature: To test OLE common tool flow flow UMS site

@OLE_VPP_UHC
Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary 
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
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
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Los Angeles County | MA     	|  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 90210		| Los Angeles County | PDP  		| AARP MedicareRx Walgreens (PDP) 	|
	| 35045		|	Chilton County		 | SNP			| UnitedHealthcare Dual Complete (HMO SNP)	|

@OLE_PlanDetails_UHC
Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Details
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in UMS site vpp
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
Then the user validates the Plan details on OLE

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Los Angeles County | MA     	|  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 90210		| Los Angeles County | PDP  		| AARP MedicareRx Walgreens (PDP) 	|
	| 35045		|	Chilton County		 | SNP			| UnitedHealthcare Dual Complete (HMO SNP)	|
	
	@OLE_PlanCompare_UHC
Scenario Outline: OLE Landing from UHC Acuisition site VPP Plan Compare
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user selects plans to add to plan compare and navigates to Plan compare page in UHC site
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
	| Plan Name | <planName> |
Then the user validates the Plan details on OLE 

Examples:
	| zipcode | county             | plantype |  planName                                      |
	| 90210   | Los Angeles County | MA     	|  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 90210		| Los Angeles County | PDP  		| AARP MedicareRx Walgreens (PDP) 	|
	