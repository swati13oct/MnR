@fixedTestCaseTest
@AcqProviderSearchUlayer
Feature:1.16-VBF-Acq-To test Provider Search Flow  in AARP site
Scenario Outline: Verify Provider Search  in AARP site
Given the user is on AARP medicare acquisition site landing page
When fetch the data attributes in row form
When the user performs plan search using following information in the Ulayer AARP site
        | Zip Code    | <zipcode> |
        | County Name | <county>  |
When the user Click on Show Plans link Ulayer
	| PlanType | <plantype> |
When the user Click on Is my Provider covered link Ulayer
|PlanName| <planname>|
Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
|PlanName| <planname>|
Examples:
| zipcode | county             | plantype| planname |               
| 90210   | Los Angeles County | MA      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)|



	



