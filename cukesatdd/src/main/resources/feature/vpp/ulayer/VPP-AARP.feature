@vpp
Feature: To test plan summary in AARP site
Scenario Outline: Verify plan summary in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in AARP site
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in AARP site
And the user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype | planName                                             |
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	| 80002   | Jefferson County   | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) |
	| 80001   | Jefferson County   | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                      |
	| 78006   | Bexar County       | PDP      | AARP MedicareRx Saver Plus (PDP)                     |
	
Scenario Outline: Verify plan details in AARP site
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then the user validates plan count for all plan types on plan summary page in AARP site
When user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then user validates the available plans for selected plan types in AARP site
And user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |
When user view plan details of the above selected plan in AARP site
Then user validates the details of the selected plan in AARP site
Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80002   | Jefferson County   | MA       |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
#	| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
#	| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |