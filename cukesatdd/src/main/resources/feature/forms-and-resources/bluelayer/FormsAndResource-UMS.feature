@formsandresources
Feature:To test forms and resources in UMS site
Scenario Outline:To verify pdfs displayed in forms and resources in UMS site
Given registered member for forms and resources in UMS Site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> | 
When the user navigates to forms and resources in UMS site
Then the user validates pdfs in plan materials and forms and resources section in UMS site


Examples:

 | planType | memberType  |
#| MA   	|Individual |
#| MAPD     |Individual |
#| MAPD	    | Group    |
#| MA	    | Group    |
 | PDP      | Group    |
#| SSUP     | Group    |
 
Scenario Outline:To verify pdfs displayed in plan materials in UMS site
Given registered member for plan materials in forms and resources in UMS Site
| Plan Type   | <planType>   |
| Member Type | <memberType> | 
When the user navigates to plan materials in forms and resources page in UMS site
Then the user validates pdfs in plan materials section in UMS site

Examples:

	 | planType | memberType  |
	 | MA   	|Individual |
	 |  MA      | Group       |
	 |  PDP     | Group       |
	 |  SSRD    | Group       |
	 |  SSUP    | Group       |


