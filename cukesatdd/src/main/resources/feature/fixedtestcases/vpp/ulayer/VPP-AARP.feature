@fixedTestCaseTest
@fixedTestCaseVPP
Feature: To test plan summary in vpp flow AARP site

@vppUlayer
Scenario Outline: Verify plan details in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in AARP site and validates
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90002   | Adams County | MAPD     	  |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	