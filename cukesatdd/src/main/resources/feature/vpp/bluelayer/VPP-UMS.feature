@vppTest
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
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)       |
	| 90210   | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO)       |
	| 30002   | DeKalb County      | MAPD     | Care Improvement Plus Medicare Advantage (Regional PPO) |
	| 60004   | Cook County        | MAPD     | AARP MedicareComplete Plan 1 (HMO)                      |
	| 80002   | Jefferson County   | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)    |
	| 80002   | Jefferson County   | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)         |
	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                         |
	| 78006   | Comal County       | SNP      | Care Improvement Plus Gold Rx (Regional PPO SNP)        |
	
Scenario Outline: Verify plan details in UMS site
Given the user is on the UMS site landing page
When user performs plan search using following information in UMS site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then the user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then user validates the available plans for selected plan types in UMS site
And user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
When user view plan details of the above selected plan in UMS site
Then user validates the details of the selected plan in UMS site

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80002   | Jefferson County   | MA	  |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
#	| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |
#	| 78006   | Bexar County       | SNP      |  UnitedHealthcare Dual Complete (HMO SNP)             |
