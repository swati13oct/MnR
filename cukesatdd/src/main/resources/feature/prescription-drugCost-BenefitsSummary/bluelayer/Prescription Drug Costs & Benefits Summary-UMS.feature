@prescriptionDrugcostandSummary
Feature: To test Drug Costs & Benefits Summary on UMS site
Scenario Outline: Verify Drug Costs & Benefits Summary in UMS site
Given registered UHC with following details for Drug Costs & Benefits Summary flow
 | Plan Type    | <plantype>  |
 | Category     | <category>|
When the user navigates to Prescription Drug Costs & Benefits Summary in my menu in UMS site
Then the user validates prescription drug cost and benefit summary page in UMS site
Examples:
		| plantype | category |
	#	| MAPD     |Individual|
	#	| MAPD     | Group    |
		| PDP      | Group    |
		