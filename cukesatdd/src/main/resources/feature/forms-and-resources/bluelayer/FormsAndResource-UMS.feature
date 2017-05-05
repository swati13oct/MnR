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

Examples:
| planType | memberType |
| MAPD	   | Individual |

@privacypolicy
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view privacy policy in UMS site
Then the user validates the content on privacy policy page

Examples:
| planType | memberType |
| MAPD	   | Individual |

@noaccordion
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site
Then the user validates the content on no accordion page

Examples:
| planType | memberType |
| MAPD	   | Individual |

@memberrightres
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view member right responsibilities in UMS site
Then the user validates the content on member right responsibilities page in UMS site
Then the user validate backtoprevious link in UMS site


Examples:
| planType | memberType |
| MAPD	   | Group |

@mapdappealsandgrievances
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view MAPD appeals and grievances in UMS site 
Then the user validates the content on MAPD appeals and grievances page in UMS site
Then the user validate backtoprevious link in UMS site


Examples:
| planType | memberType |
| MAPD	   | Individual |

@ssupappealsandgrievances
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view SSUP appeals and grievances in UMS site 
Then the user validates the content on SSUP appeals and grievances page in UMS site
Then the user validate backtoprevious link in UMS site


Examples:
| planType | memberType |
| SSUP	   | Group |


@medicaltherapyprog
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view medical therapy management program in UMS site
Then the user validates the content on medical therapy management program page in UMS site


Examples:
| planType | memberType |
| PDP	   | Group |

@seasonflushot
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view season flu shot information in UMS site
Then the user validates the content on season flu shot information page in UMS site

Examples:
| planType | memberType |
| MAPD	   | Individual |

@medicathreapymapd
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view medica therapy management in UMS site
Then the user validates the content on medica therapy management page in UMS site

Examples:
| planType | memberType |
| MAPD	   | Individual |

@prescriptiondrug
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view prescription drug transition in UMS site
Then the user validates the content on prescription drug transition page in UMS site

Examples:
| planType | memberType |
| MAPD	   | Individual |

@prescriptiondrug
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view preferred mail service pharmacy benefit in UMS site
Then the user validates the content on preferred mail service pharmacy benefit page in UMS site

Examples:
| planType | memberType |
| PDP	   | Group |

#Sprint 3

@drugtransition
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view prescription drug transition process in UMS site
Then the user validates the content on prescription drug transition process page in UMS site

Examples:
| planType | memberType |
| MAPD	   | Individual |


@disenrollment
Scenario Outline: Verify benefit summary content for group members in ums site
Given registered member for forms and resources in UMS Site
	| Plan Type      |<planType> |
	| Member Type		 |<memberType> |
When the user view forms and resources in UMS site 
Then the user view disenrollment rights and responsibilities in UMS site
Then the user validates the content on disenrollment rights and responsibilities page in UMS site

Examples:
| planType | memberType |
| PDP	     | Group |

