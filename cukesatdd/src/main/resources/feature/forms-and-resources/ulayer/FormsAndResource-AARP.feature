@formsandresourcesAARP
Feature:To test forms and resources in AARP site
##Scenario Outline:To verify pdfs displayed in forms and resources for MA member in AARP site
##Given registered member for forms and resources in AARP Site
##	| <planType> |
##When the user view forms and resources in AARP site
##Then the user validates the plan materials under plan document section


##Examples:

##| planType |
#| MA	   |
#| MAPD	   |
#| PDP      |
#| MS       |
#| HIP      |


Scenario Outline:To verify pdfs displayed in forms and resources for MA member in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user validates next year ANOC and Annual directory section


Examples:

| planType |
#| MA	   |
#| MAPD	   |
#| PDP      |
#| MS       |
#| HIP      |




Scenario Outline:To verify pdfs displayed in forms and resources for MA member in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user validates the plan materials under plan document section
And the user click on pdf links 

Examples:

| planType |
#| MA	   |
| MAPD	   |
#| PDP      |
#| MS       |
#| HIP      |
