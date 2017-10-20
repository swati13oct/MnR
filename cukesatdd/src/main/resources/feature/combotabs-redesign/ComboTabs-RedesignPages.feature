
@ComboTabsRedesignPages
Feature: Test Combo Member Plan Tabs for Redesign Pages

@TerminatedPlanTabsDisplay
Scenario Outline: Verify Terminated Plan Tabs are displayed in Claims, EOB, Contact Us and Forms & Resources Redesign pages
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |

When the user navigates to mentioned page in Redesign site 
| Page Name | <pagename> |
Then the user validates Terminated Plan Tabs in the Redesign Page
| Page Name | <pagename> |

Examples:
 |  planType | memberType | pagename  | 
 | AARP | TerminatedPlan  | Claims 		|  
 | AARP | TerminatedPlan  | EOB 			| 
 | AARP |  TerminatedPlan | ContactUs | 
# | AARP | TerminatedPlan  | FormsResources |
    
@TerminatedPlanTabsNotDisplayed
Scenario Outline: Verify Terminated Plan Tabs are NOT Displayed in Profile and Go Green Preferences Redesign pages
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |

When the user navigates to mentioned page in Redesign site 
| Page Name | <pagename> |
Then the user validates Terminated Plans Tab are Not Displayed in the Redesign Page
| Page Name | <pagename> |

Examples:
 |  planType | memberType | pagename  | 
 | AARP | TerminatedPlan | Profile 		|  
 | AARP | TerminatedPlan | GoGreenPreferences |
