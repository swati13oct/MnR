@OLE_UHC @JuneRelease2018
Feature: To test OLE common tool flow flow UMS site
@planDetailsUMS
@vppBlayerSmoke
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
	
