@fixedTestCaseTest
@AcqProviderSearchUlayer
Feature:1.17-VBF-Acq-To test Provider Search Flow  in AARP site
Scenario Outline: Verify Provider Search  in AARP site
Given the user is on AARP medicare acquisition site landing page for provider search
When I access the vpp page for provider search using below zipcode on aarp site
	| Zip Code    | <zipcode>  |
	| County Name | <county>  |
When I click on view plans link on vpp page for provider search
	| Plan Type | <plantype> |
When the user Click on Is my Provider covered link Ulayer
|PlanName| <planname>|
Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
|PlanName| <planname>|
Examples:
| zipcode | county             | plantype |   planname|                
| 90210   | None | MA 		|AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
