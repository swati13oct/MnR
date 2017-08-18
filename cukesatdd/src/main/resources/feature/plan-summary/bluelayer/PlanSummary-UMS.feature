@plansummary
Feature:To test Plan Summary flow in UMS site
Scenario Outline:To verify different resources in plan summary page in UMS site
Given registered member to verify plan summary page in UMS site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to plan summary page in UMS site
Then the user validates different resources in UMS site

Examples:
 | plantype | memberType   |
#| MA       | Individual |
| MAPD     | Individual |
#| MAPD     | Group    |
#| PDP       | Group    |
#| MA       | Group    |
#| SSUP     | Group    |

@Q4
Scenario Outline:To validate the pharmacy saver widget in plan summary page in UMS site
Given registered member to login in UMS site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to plan summary page under my plans in UMS site
Then the user validates pharmacy saver widget in UMS site

Examples:
	| plantype | memberType   |
	| MAPD     | Individual   |
	| PDP      | Group        |
	| MAPD     | Group        |

@Q5
Scenario Outline: To validate Prescription drug cost summary widget on plan summary page for LIS 3
Given registered member to login in UMS site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to plan summary page under my plans in UMS site
Then user validate view details button is not displayed for  group LIS 3
Examples:
 | plantype | memberType   |
 | MAPD       | Group |
 
@PDPplancard
Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |        
Then the user navigates to pan details page
|Plan Name| <planName>|        
And the user navigated back using back to all plans
Examples:
                |zipCode|county                                                 |planType  |planName                                           |
                |90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |        