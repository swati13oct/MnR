@fixedTestCaseTest
@TC_06_Plan_Details_page_Plan_Costs_section
Feature:To test Plan Costs  in AARP site
Scenario Outline: Verify PlanCosts  in AARP site
Given the user is on AARP Ulayer medicare acquisition site landing pages
When the user performs plan search using following information in the Ulayer AARP sites
        | Zip Code    | <zipcode> |
        | County Name | <county>  |
When the user Click on Show Plans link Ulayers
	| PlanType | <plantype> |
	
Then the user Click on viewPlanandCoverageDetails in Ulayer

Then the user validates 4 tabs in Ulayer
Then the user validates all fields in planCosts

Examples:
| zipcode | county             | plantype|       
| 90210   | Los Angeles County | MA      | 