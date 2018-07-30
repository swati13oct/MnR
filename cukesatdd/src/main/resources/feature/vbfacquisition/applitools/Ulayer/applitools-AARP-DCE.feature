@applitoolsAARP_DCE
Feature:2.04-VBF-Acq-To test applitools for DCE flow on AARP site

Scenario Outline:To use applitools to take screenshots of the DCE pages
Given the user goes to aarp homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
Then the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot
	|Plan Type| <planType> |
	|Plan Name| <planName> |
	|Drug     | <drug>     |
Examples:
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 										  |  drug            | 
	| 90210     |  no       | no     		|   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | 
