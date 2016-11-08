@prescriptionDrugcostandSummary
Feature: To test Drug Costs & Benefits Summary on UMS site
Scenario Outline: Verify Drug Costs & Benefits Summary in UMS site
Given registered UHC with following details for Drug Costs & Benefits Summary flow
 | Plan Type    | <plantype>  |
 | Member Type  | <memberType>|
When the user navigates to Prescription Drug Costs & Benefits Summary in my menu in UMS site
Then the user validates prescription drug cost and benefit summary page in UMS site
Examples:
		| plantype | memberType |
	#	| MAPD     | Individual |
	#	| MAPD     | Group      |
		| PDP      | Group      |

Scenario Outline: Verify Current Year plan summary page 
Given  I am a registered member logged into BLAYER
 | Plan Type    | <plantype>  |
 | Member Type  | <memberType>|
When I access the My Drug Costs and Benefits page
And I will see the Troop meter
Then  I will see the Current Year Plan Summary page

Examples:
		| plantype | memberType |
		| MAPD     | Individual |
	#	| MAPD     | Group      |
		