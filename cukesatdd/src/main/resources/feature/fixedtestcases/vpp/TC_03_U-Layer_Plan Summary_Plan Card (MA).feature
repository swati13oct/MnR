@fixedTestCaseTest
@TC_03_U-Layer_PlanSummary_PlanCard(MA)
Feature:To test PlanSummary PlanCard  in AARP site
Scenario Outline: Verify PlanSummary PlanCard  in AARP site
Given the user is on AARP Ulayer medicare acquisition site landing pages
When the user performs plan search using following information in the Ulayer AARP sites
        | Zip Code    | <zipcode> |
        | County Name | <county>  |
When the user Click on Show Plans link Ulayers
	| PlanType | <plantype> |
	
Then the user validates the Plancard

Examples:
| zipcode | county             | plantype|       
| 90210   | Los Angeles County | MA      | 