@formsandresources
Feature:To test forms and resources in UMS site
#Scenario Outline:To verify pdfs displayed in forms and resources in UMS site
#Given registered member for forms and resources in UMS Site
#	| Plan Type   | <planType>   |
#	| Member Type | <memberType> | 
#When the user navigates to forms and resources in UMS site
#Then the user validates pdfs in plan materials and forms and resources section in UMS site

#Examples:

 #| planType | memberType  |
#| MA   	|Individual |
#| MAPD     |Individual |
#| MAPD	    | Group    |
#| MA	    | Group    |
#| PDP      | Group    |
#| SSUP     | Group    |

Scenario Outline: Verify benefits and coverage for MA (HMO) group member
Given registered member with following details for benefits and coverage flow
 | Plan Type      | MA  |
 | Member Type    | Group|

When the user navigates to benefits and Coverage
Then the user validates Plan Benefits and Coverage details
	 |Group ID|
	 | Member ID       | 
	 | Effective Date  |
	 |Medical Deductible|
	 |Medical Out-of-Pocket Max|
	 
Examples:
		|plantype    | memberType |
		|MA          | Group |	
		|MAPD        | Group |
			 
#Scenario Outline:To verify pdfs displayed in plan materials in UMS site
#Given registered member for plan materials in forms and resources in UMS Site
#| Plan Type   | <planType>   |
#| Member Type | <memberType> | 
#When the user navigates to plan materials in forms and resources page in UMS site
#Then the user validates pdfs in plan materials section in UMS site

#Examples:

#| planType | memberType  |
#| MA       |Individual |
#| MA      | Group       |
#| PDP     | Group       |
#| SSRD    | Group       |
#| SSUP    | Group       |

Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site
Then the user view benefits and coverage in UMS site
Then the user validates the content on benefits and coverage page

Examples:

| planType | memberType |
#| MA	   | Group |
#| MAPD	   | Group |
#| SSUP		| Group |
| SSRD		| Group |


Scenario Outline: Verify add plan tab on forms and resources page
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType>   |
	| Member Type		 |<memberType> |
	| Group Type     |<groupType>  |
When the user navigates to forms and resources in UMS site
Then validates that add plans tab is not available

Examples:
  | planType | memberType | groupType |
  | MAPD     | Group      | ALPEEHIP  |
  | MA			 | Group      | ALPEEHIP  |

@US463479
Scenario Outline:To verify pdfs displayed in forms and resources in UMS site
Given registered member for plan materials in forms and resources in UMS Site
| Plan Type   | <planType>   |
| Member Type | <memberType> | 
When the user view forms and resources in UMS site
Then I will be able access a PDF flyer in  English, Spanish or Chinese that explains passport benefits when a plan has this feature

Examples:

| planType | memberType  |
| MA       |Individual |

@prefmailorderlink
Scenario Outline:To verify preferred mail order benefit pdf link displayed on forms and resources in UMS Site
Given registered member for forms and resources in UMS Site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> | 
When the user navigates to forms and resources in UMS site
Then the user validates preferred mail order benefit pdfs in plan materials and formsandresources section in UMS site
Examples:
| planType | memberType  |
| MAPD     |Individual |


