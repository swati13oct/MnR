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

Scenario Outline:To verify passport pdfs displayed in forms and resources in AARP site
Given registered member for forms and resources in AARP Site
	| Plan Type      |<planType> |

When the user view forms and resources in AARP site
Then I will be able access a PDF flyer in Englishthat explains passport benefits when a plan has this feature
And I will be able access a PDF flyer in Spanish or Chinese that explains passport benefits when a plan has this feature

Examples:

| planType |
| MAPD	   |