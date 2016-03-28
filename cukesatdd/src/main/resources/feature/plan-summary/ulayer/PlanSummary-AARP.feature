@plansummary
Feature:To test Plan Sumamry flow in AARP site
Scenario Outline:To verify plan summary page in AARP site
Given registered member to verify plan summary page in AARP site
	| <plantype> |
When the user navigates to plan summary page in AARP site
Then the user the validates plan summary page in AARP site

Examples:
	| plantype |
#	| MA       |
#	| MAPD     |
	| PDP      |
#	| MS       |
#	| HIP	   |
#	| RIDER    |