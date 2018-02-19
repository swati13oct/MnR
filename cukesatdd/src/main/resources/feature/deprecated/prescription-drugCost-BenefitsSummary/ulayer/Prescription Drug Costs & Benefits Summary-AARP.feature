@prescriptionDrugcostandSummary
Feature: To test Drug Costs & Benefits Summary on AARP site
Scenario Outline: Verify Drug Costs & Benefits Summary in AARP site
Given registered AMP with following details for Drug Costs & Benefits Summary flow
	| <plantype>  |
When the user clicks Prescription Drug Costs & Benefits Summary in my menu in AARP site
Then the user validates prescription drug cost and benefit summary page in AARP site
 
Examples:
		| plantype |
#		| MAPD     |
		| PDP      |
