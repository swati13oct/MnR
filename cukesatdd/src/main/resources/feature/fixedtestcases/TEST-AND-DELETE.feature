@fixedTestCase
Feature: To test plan summary in AARP site
Scenario Outline: Verify plan summary in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
When the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in the AARP site
And the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
Examples:
	| zipcode | county             | plantype | planName                                             |
	| 00110   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |