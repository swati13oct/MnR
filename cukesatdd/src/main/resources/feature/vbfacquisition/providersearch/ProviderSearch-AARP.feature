@fixedTestCaseTest
@AcqProviderSearchUlayer
Feature:1.17-VBF-Acq-To test Provider Search Flow  in AARP site
Scenario Outline: Verify Provider Search  in AARP site
Given the user is on AARP medicare acquisition site landing page
When I access the vpp page using below zipcode on aarp site
	| Zip Code    | <zipcode>  |
When I click on view plans link on vpp page
	| Plan Type | <plantype> |
When the user Click on Is my Provider covered link Ulayer
|PlanName| <planname>|
Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
|PlanName| <planname>|
Examples:
| zipcode |  plantype| planname |               
#| 80001 | MA      | AARP MedicareComplete SecureHorizons Essential (HMO) |
| 90210  |  MA      | AARP MedicareComplete SecureHorizons Essential (HMO) |


	



