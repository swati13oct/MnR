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
	| MAPD     |
#	| PDP      |
#	| MS       |
#	| HIP	   |
#	| RIDER    |

@Q4
Scenario Outline:To validate the pharmacy saver widget in plan summary page in AARP site
Given registered member to login in AARP site
	|  <plantype>  |
When the user navigates to plan summary page under my plans in AARP site
Then the user validates pharmacy saver widget in AARP site

Examples:
	| plantype |
	| MAPD     |