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

@drugtransistion
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user validates prescription drug transistion in AARP site

Examples:

| planType |
| PDP	   |

@privacypolicy
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view privacy policy in AARP site
Then the user validates privacy policy in AARP site

Examples:

| planType |
| PDP	   |

@appeals
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view appeals in AARP site
Then the user validates appeals content in AARP site

Examples:

| planType |
| MA	   |


@udrugtrasition
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user validates prescription drug transistion in AARP site
#Then the user validate download link in AARP site
#Then the user validate view link in AARP site
#Then the user validate backtoprevious link in AARP site

Examples:

| planType |
| MAPD	   |

@memberright
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view member right responsibilities in AARP site
Then the user validates member right responsibilities in AARP site

Examples:

| planType |
| MAPD	   |

@seasonalflu
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view seasonal flu shot information in AARP site
Then the user validates seasonal flu shot information in AARP site
#Then the user validate backtoprevious link in AARP site

Examples:

| planType |
| MA	   |

@termofuse
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view terms of use in AARP site
Then the user validates terms of use in AARP site
#Then the user validate backtoprevious link in AARP site
#sandy

Examples:

| planType |
| MA	   |

@medicaltherapy
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view medical therapy management program in AARP site
Then the user validate medical therapy management program in AARP site

Examples:

| planType |
| MAPD	   |

@pharmacymail
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view mymenu in AARP site
Then the user view preffered mail service pharmacy in AARP site
Then the user validate preffered mail service pharmacy in AARP site

Examples:

| planType |
| MAPD	   |

@disenrollment
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view disenrollment rights responsibilities in AARP site
Then the user validate disenrollment rights responsibilities in AARP site

Examples:

| planType |
| MAPD	   |

@medicationtherapy
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view medication therapy management in AARP site
Then the user validate medication therapy management in AARP site

Examples:

| planType |
| PDP	   |

@coverageappealspdp
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view coverage appeals and grievances in AARP site
Then the user validate coverage appeals and grievances in AARP site

Examples:

| planType |
| PDP	   |

@coverageappealsmapd
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view coverage appeals and grievances in AARP site
Then the user validate coverage appeals and grievances in AARP site

Examples:

| planType |
| MAPD	   |


@preferedmailbenefit
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view preferred mail service pharmacy benefit in AARP site
Then the user validate preferred mail service pharmacy benefit in AARP site

Examples:

| planType |
| PDP	   |

@lowertierdruglearnmore
Scenario Outline:To verify content story in forms and resource in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view benefit and coverage in AARP site
Then the user view lower tier drug and click on learnmore in AARP site
Then the user validate lower tier drug learnmore in AARP site

Examples:

| planType |
| PDP	   |
