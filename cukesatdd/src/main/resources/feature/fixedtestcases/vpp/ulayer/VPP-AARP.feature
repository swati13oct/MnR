@fixedTestCaseTest
@vppUlayer
Feature: To test plan summary in vpp flow AARP site
Scenario Outline: Verify plan summary in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
And the user validates the available plans for selected plan types in the AARP site
Then the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
Examples:
| zipcode | county             | plantype | planName                                         |
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |

@vppPlanDetailsAarp
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
	
@defect3281
Scenario Outline: To check all 3 MA plans and go to estimate drug costs page and return to vpp to verify they're still selected
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	|Zip Code| <zipcode> |
And I select all 3 plans to compare in MA and click on compare plan link
Then I click back to all plans button and verify that all 3 plans are still selected

Examples:
|zipcode|
|80007 | 