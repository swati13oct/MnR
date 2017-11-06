@fixedTestCaseTest
@BlayerRightRail
Feature: test Plan Details RightRail Flow  in UMSsite
Scenario Outline: Verify RightRail in UMS site
Given the user is on the UMS Blayer medicare acquisition site landing page
When the user performs plan search using the following information in the Blayer UMS site
        | Zip Code    | <zipcode> |
        | County Name | <county>  |
When the user Click on Show Plans link the Blayer
	| PlanType | <plantype> |
	
When the user Click on viewPlanandCoverageDetails
Then the user validates all fields in medical Benifits and Programs
Then the user validates the right rail widgets
Then the user validates 4 tabs
|<Tabs>|



Examples:
| zipcode | county             | plantype| Tabs|            
| 90210   | Los Angeles County | MA      | Medical Benefits and Programs|