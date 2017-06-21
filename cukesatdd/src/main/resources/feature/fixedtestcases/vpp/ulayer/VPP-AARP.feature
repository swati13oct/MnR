@fixedTestCaseTest
@fixedTestCaseVPP
Feature: To test plan summary in vpp flow AARP site

@vppUlayer
Scenario Outline: Verify plan details in AARP site
Given the user is on AARP medicare acquisition site landing page

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90002   | Adams County | MAPD     	  |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |