@TeamPredators
@GoGreenPage
Feature: To test for Functionality and UI for Go Green Page in Redesign site

@ValidateGoGreenPageSHIPsingleTab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
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
Given registered AMP member with following attributes
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
Given registered AMP member with following attributes
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
Given registered UHC member with following attributes
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
And user navigates to Redesign Go Green Page from My Profile Page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | PDPwithSSUP | Group | PDP,SSUP |

