@fixedTestCaseTest
@fixedTestCaseVPP
Feature:[7/11/17 Known Issue] To test plan summary in vpp flow UMS site
@vppBlayer
Scenario Outline: Verify plan details in UMS site 
Given the user is on the uhcmedicaresolutions site landing page

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |