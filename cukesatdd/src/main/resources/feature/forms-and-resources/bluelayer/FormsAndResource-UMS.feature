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

@pharmacybenefit
Scenario Outline: Verify forms and resource content for members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user navigates to my personal health record in UMS site
Then the user view prefered mail service pharmacy benefit in UMS site
#Then the user validates the content on prefered mail service pharmacy benefit page

Examples:
| planType | memberType |
| MAPD	   | Individual |


@appoint
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user navigates to forms and resources in UMS site
Then the user view how to appoint a representive in UMS site
#Then the user validates the content on appoint a representative page
