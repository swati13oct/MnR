@applitoolsAARP_VPP
Feature:2.04-VBF-Acq-To test applitools for DCE flow on AARP site

Scenario Outline:To use applitools to take screenshots of the vpp pages
Given the user goes to aarp homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
And the user goes to the view plan details page for MAPD plan and takes screenshots
	|Plan Type| <planType> |
	|Plan Name| <planName> |
When the user clicks on PDP plans and takes screenshot
And the user goes to the view plan details page for PDP plan and takes screenshots
	|Plan Type2| <planType2> |
	|Plan Name2| <planName2> |

Examples:
	| zipcode 	| screenshot1 |screenshot2 | planType | planName 										  |  planType2 | planName2 						  | 
	| 90210     |   yes       | yes        |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)|  PDP 	   | AARP MedicareRx Walgreens (PDP)      |
