@plansummary
Feature:To test Plan Summary flow in UMS site
Scenario Outline:To verify different resources in plan summary page in UMS site
Given registered member to verify plan summary page in UMS site
	| <plantype> |
    | <category> |
When the user navigates to plan summary page in UMS site
Then the user validates different resources in UMS site

Examples:
 | plantype | category   |
#| MA       | Individual |
#| MAPD     | Individual |
#| MAPD     | Group    |
| PDP       | Group    |
#| MA       | Group    |
#| SSUP     | Group    |
