#@thePredators
@ComboTabsRedesignPages
Feature:P1.1 Test Combo Member Plan Tabs for Redesign Pages
 
@TerminatedPlanTabsDisplay
Scenario Outline: Verify Terminated Plan Tabs are displayed in Claims, EOB, Contact Us and Forms & Resources Redesign pages
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |

When the user navigates to mentioned page in Redesign site 
| Page Name | <pagename> |
Then the user validates Terminated Plan Tabs in the following Redesign Page
| Page Name | <pagename> |

Examples:
 |  planType | memberType | pagename  | 
 | AARP | TerminatedPlan  | Claims,EOB,ContactUs 		|  
# | AARP | TerminatedPlan  | EOB 			| 
# | AARP |  TerminatedPlan | ContactUs | 
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
 
@SingleTabsforSHIP
Scenario Outline: Verify single tabs for all SHIP plans in Claims, EOB, Payment, My Profile and Contact Us  page
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
	When the user navigates to mentioned page in AARP site 
| Page Name | <pagename> |
Then the user validates single tab for all SHIP plans
| Page Name | <pagename> |

Examples:
   | planType    | memberType | pagename  | 
   | SHIP        | MedSuppwithRider |  Claims,EOB,Payment,Profile,ContactUs 		| 
#    | EOB 			| 
#    | Payment 	| 
#    | Profile 	| 
#    | ContactUs | 

    @ValidateSHIPsingleTab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
	When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates Single Tab for all SHIP Plans

Examples:   
            | planType    | memberType |
            | SHIP        | MedSuppwithRider |
#            | SHIP				| HIPwithRider	|

@ValidatePHIPtab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
	When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates Separate PHIP tab

Examples:   
            | planType    | memberType |
            | SHIP        | PHIP |

@ValidateComboTabsAARPPlans
Scenario Outline: Verify Separate tabs for All AARP Plans in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | MA        | MAwithHIP | MA,HIP |
            | MAPD			| MAPDwithHIP | MA,HIP |
            | PDP				| PDPwithMedHIP | PDP,HIP |
            | MA        | MAwithMedSupp | MA,MedSupp |
            | MAPD			| MAPDwithMedSUpp | MA,MedSupp |
            | PDP				| PDPwithMedSupp | PDP,MedSupp |

@ValidateComboTabsUHCPlans
Scenario Outline: Verify Separate tabs for All UHC Plans in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | PDPwithSSUP | Group | PDP,SSUP |
    

@ValidateGoGreenPageSHIPsingleTab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
And user navigates to Redesign Go Green Page from My Profile Page
Then the user Validates Single Tab for all SHIP Plans

Examples:   
            | planType    | memberType |
            | SHIP        | MedSuppwithRider |
            | SHIP				| HIPwithRider	|

@ValidateGoGreenPagePHIPtab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
And user navigates to Redesign Go Green Page from My Profile Page
Then the user Validates Separate PHIP tab

Examples:   
            | planType    | memberType |
            | SHIP        | PHIP |

@ValidateGoGreenPageComboTabsAARPPlans
Scenario Outline: Verify Separate tabs for All AARP Plans in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
And user navigates to Redesign Go Green Page from My Profile Page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | MA        | MAwithHIP | MA,HIP |
            | MAPD			| MAPDwithHIP | MA,HIP |
            | PDP				| PDPwithMedHIP | PDP,HIP |
            | MA        | MAwithMedSupp | MA,MedSupp |
            | MAPD			| MAPDwithMedSUpp | MA,MedSupp |
            | PDP				| PDPwithMedSupp | PDP,MedSupp |

@ValidateGoGreenPageComboTabsUHCPlans
Scenario Outline: Verify Separate tabs for All UHC Plans in My Profile and Preferences in Member Redesign site
Given registered Combo Plans member with following attribute
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
And user navigates to Redesign Go Green Page from My Profile Page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | PDPwithSSUP | Group | PDP,SSUP |

    