@fastandfurious @OLE
@OLE_Ulayer
Feature:1.12-VBF-ACQ-To test OLE common tool flow in AARP site

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
Then the user validates TFN in Welcome OLE Right Rail
Then the user validates Learn more modal for Welcome OLE
Then the user validates Leave OLE modal for Welcome OLE
Then the user validates cancellation modal for Welcome OLE
Then the user validates and selects the Disclaimer Checkbox
Then the user navigates to Medicare Information Page
Then the user validates Medicare Information Page required fields
Then the user enters following required Medicare Information
	| First Name | <firstname> |
	| Last Name | <lastname> |
	| Medicare Number | <medicarenumber> |
	| SSN Flag | <ssnflag> |
	| PartA Date | <partadate> |
	| PartB Date | <partbdate> |
	| Card Type | <cardtype> |
Then the user validates TFN in Medicare Info OLE Right Rail
Then the user validates the Plan details in Medicare Info OLE Right Rail 
Then the user validates Learn more modal for Medicare Information Page
Then the user validates Leave OLE modal for Medicare Information Page
Then the user validates cancellation modal for Medicare Information Page
#Then the user navigates to Preliminary Questions Page
#Then the user validates TFN in Right Rail on Preliminary Questions Page
#Then the user fills following information in Preliminary Questions page

#| MedicaidNumber | <medicaidnumber> |	
Examples:
| zipcode | county             | plantype | planName                                       | cardtype   | firstname  | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber |
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | HICN		|  John		 |	Doe			|	123456789a		 | false		 | 01012010	 | 01012010	 | 123456789123121 |

@OLE_PlanDetails_Aarp
Scenario Outline: OLE Landing from VPP Plan Details
Given the user is on AARP medicare site landing page OLE
When user performs plan search using following information in AARP site OLE
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
And the user views plans of the below plan type in AARP site OLE
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in AARP site and validates
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
Then the user validates the Plan details on OLE 

Examples:
	| zipcode | county             | plantype |  planName                                             |
#	| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	
@OLE_PlanCompare_Aarp
Scenario Outline: OLE Landing from VPP Plan Compare
Given the user is on AARP medicare site landing page OLE
When user performs plan search using following information in AARP site OLE
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
And the user views plans of the below plan type in AARP site OLE
	| Plan Type | <plantype> |
Then the user selects plans to add to plan compare and navigates to Plan compare page
	| Plan Name | <planName> |
Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
	| Plan Name | <planName> |
Then the user validates the Plan details on OLE 

Examples:
	| zipcode | county             | plantype |  planName                                      |
#	| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	
