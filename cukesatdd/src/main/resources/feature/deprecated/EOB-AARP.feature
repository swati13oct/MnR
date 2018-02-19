@unimplemented
Feature:To test EOB in AARP site
Scenario:To verify Medical EOB in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user clicks my menu
And the user selects My Medical Explanation of Benefits (EOB) in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| MA       |
		| MAPD     |

Scenario:To verify Prescription Drug EOB in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user clicks my menu
And the user selects My Prescription Drug Explanation of Benefits (EOB) in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| PDP       |
		| MAPD     |



Scenario:To verify EOB in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user clicks my menu
And the user selects My Explanation of Benefits (EOB) in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| MS       |
		| HIP     |



Scenario:To verify Medical EOB for forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user user views forms and resources
And the user selects search Medical(EOB) history in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| MA       |
		| MAPD     |


Scenario:To verify Prescription Drug EOB for forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user user views forms and resources
And the user selects search Prescription Drug EOB) history in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| PDP       |
		| MAPD     |


Scenario:To verify EOB for forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
When the user user views forms and resources
And the user selects search My Explanation of Benefits (EOB) history in plan resources in AARP site
And the user selects date range for eob in AARP site
And the user search EOB history
Then the user validates EOB
Examples:
		| plantype |
		| MS       |
		| HIP     |