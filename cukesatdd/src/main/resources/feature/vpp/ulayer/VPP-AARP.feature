@vppaarp
Feature: To test plan summary in AARP site
##Scenario Outline: Verify plan summary in AARP site
##Given the user is on the AARP medicare site landing page
##When the user performs plan search using following information in AARP site
##| Zip Code    | <zipcode> |
##| County Name | <county>  |
##Then user validates plan count for all plan types on plan summary page in AARP site
##When the user views plans of the below plan type in AARP site
##| Plan Type | <plantype> |
##Then the user validates the available plans for selected plan types in AARP site
##And the user validates the plan summary for the below plan in AARP site
##| Plan Name | <planName> |
##Examples:
#| zipcode | county             | plantype | planName                                             |
#| 90210   | Los Angeles County | MA    | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#| 80002   | Jefferson County   | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) |
#| 80001   | Jefferson County   | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                      |
#| 78006   | Bexar County       | PDP      | AARP MedicareRx Saver Plus (PDP)                     |

##Scenario Outline: Verify plan details in AARP site
##Given the user is on the AARP medicare site landing page
##When the user performs plan search using following information in AARP site
##| Zip Code    | <zipcode> |
##| County Name | <county>  |
##Then user validates plan count for all plan types on plan summary page in AARP site
##When the user views plans of the below plan type in AARP site
##| Plan Type | <plantype> |
##Then the user validates the available plans for selected plan types in AARP site
##And the user validates the plan summary for the below plan in AARP site
##| Plan Name | <planName> |
##When the user view plan details of the above selected plan in AARP site
##Then the user validates the details of the selected plan in AARP site
##Examples:
##| zipcode | county             | plantype |  planName                                             |
##| 80002   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
##| 80002   | Jefferson County   | MA       |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
##| 90210   |                    | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
##| 80001   |                    | PDP      |  AARP MedicareRx Preferred (PDP)                      |
##| 78006   | Comal County       | PDP      |  AARP MedicareRx Saver Plus (PDP)                     |


##Scenario Outline: Verify plan summary after updating provider info in AARP site
#Given the user is on the AARP medicare site landing page
#When the user performs plan search using following information in AARP site
#| Zip Code    | <zipcode> |
#| County Name | <county>  |
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in AARP site
#| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in AARP site
#| Plan Name | <planName> |
#And the user clicks on Enter Provider information link in AARP site
#| <physicianSearch>	|
#| <physicianName>	|
#Then the user validates the plan summary after provider information is added in AARP site
#Examples:
#| zipcode | county             | plantype | planName                                             | physicianSearch		| physicianName		|
#| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | All Primary Care Physicians  | Linda S Blust, MD	|

	
#Scenario Outline: Verify plan details in AARP site for AEP only
#Given the user is on the AARP medicare site landing page
#When the user performs plan search using following information in AARP site during AEP period
#	| Zip Code    | <zipcode> |
#	| County Name | <county>  |
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in AARP site during AEP
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in AARP site during AEP
#	| Plan Name | <planName> |
#When the user view plan details of the above selected plan in AARP site during AEP 
#Then the user validates the details of the selected plan in AARP site
#When user comes backs to plan summary page and view current year plan
#And the user validates the plan summary for the below plan in AARP site during AEP
#	| Plan Name | <planName> |
#When the user view plan details of the above selected plan in AARP site during AEP 
#Then the user validates the details of the selected plan in AARP site
#Examples:
#	| zipcode | county             | plantype |  planName                                             |  		 
   #| 90210   | Los Angeles County | MA       |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	#| 80210   | Denver County      | MA       |  AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	

#Scenario Outline: Verify plan summary in AARP site
#Given the user is on the AARP medicare site landing page
#When the user performs plan search using following information in AARP site
#	| Zip Code    | <zipcode> |
#	| County Name | <county>  |
#Then user validates plan count for all plan types on plan summary page in AARP site
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in AARP site
#	| Plan Name | <planName> |
#When the user view plan details of the above selected plan in AARP site
#Then the user validates the details of the selected plan in AARP site
#And the user validate pdf links
#Examples:
#	| zipcode | county             | plantype | planName                                             |
#	| 80210   | Denver County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
#	| 01002   | Hampshire County   | MA       |  AARP MedicareComplete Choice (Regional PPO)    |
#	| 11001   | Queens County     | MAPD    |  AARP MedicareComplete Plan 2 (HMO)    |
#	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                   |      

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
When the user view plan details of the above selected plan in AARP site
#Then the user validates the details of the selected plan in AARP site
And the user validate pdf links
Examples:
	| zipcode | county             | plantype | planName                                             |
	#| 80210   | Denver County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
	| 01002   | Hampshire County   | MA       |  AARP MedicareComplete Choice (Regional PPO)    |
	| 11001   | Queens County     | MAPD    |  AARP MedicareComplete Plan 2 (HMO)    |
	| 78006   | Comal County       | PDP      | AARP MedicareRx Preferred (PDP)                   |      


Examples:
	| zipcode | county             | plantype | planName                                             | physicianSearch		| physicianName		|
	| 80002   | Adams County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | All Primary Care Physicians  | Linda S Blust, MD	|
Scenario Outline: Plan Compare Launch on VPP Pages
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
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

