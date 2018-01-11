@TeamPredators
@uLayerSHIPplans
Feature: Test SHIP member ulayer All Pages

@SingleTabsforSHIP
Scenario Outline: Verify single tabs for all SHIP plans in Claims, EOB, Payment, My Profile and Contact Us  page
Given registered AMP member with SHIP combo plans
When the user navigates to mentioned page in AARP site 
| Page Name | <pagename> |
Then the user validates single tab for all SHIP plans
| SHIP Page | <shippagename> |

Examples:
    | pagename  | shippagename  |
    | Claims 		| Claims 		| 
    | EOB 			| EOB 			|
    | Payment 	| Payment 	|
    | Profile 	| Profile 	|
    | ContactUs | ContactUs |
    
   