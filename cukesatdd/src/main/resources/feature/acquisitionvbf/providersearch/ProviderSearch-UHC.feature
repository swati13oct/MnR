@fixedTestCaseTest
@BlayerProviderSearch
Feature:1.15-VBF-Acq-To test Provider Search Flow  in UMS site
Scenario Outline: Verify Provider Search  in UMS site
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs plan search using following information in the UMS site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
When the user Click on Show Plans link
	| PlanType | <plantype> |
 When the user Click on Is my Provider covered link 
 |PlanName| <planname>|
 Then Verify X out of Y provider covered information is displayed on Plan Summary page 
 |PlanName| <planname>|
 Examples:
| zipcode | county             | plantype |   planname|                
| 90210   | Los Angeles County | MA 		|AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
