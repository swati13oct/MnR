@fixedTestCaseTest
@applitools
Feature:2.04-VBF-Acq-To test applitools in AARP site
@applitools_aarp
Scenario Outline:To verify pages load correctly on AARP site
Given user is on acquisition home page applitool
#When the user accesses the vpp page using below zipcode on aarp site applitools
#	|Zip Code | <zipcode>|
#And the user accesses the DCE tool from vpp page on aarp site applitools
#	|Plan Type | <plantype> |
#And the user has added a drug to the drug list applitools
#	|Drug | <drug>|
#And the user navigates to step2 page applitools
#And the user selects the first pharmacy applitools
#Then the user navigates to step3 page and validates applitools
#	|Drug|<drug>|
Examples:
|zipcode|plantype    |drug            |
|90210  |  MA	     |Lipitor TAB 10MG|

@agentAppointment_applitools
Scenario Outline: Verify request an appointment with an agent flow in AARP site
Given user is on acquisition home page applitool
When the user navigates to request more help and information in AARP site applitools
Then the user navigates to request appointment with an agent in AARP site and validates page is loaded applitools
	|Place Holder| <placeHolder>|
Examples:
	| placeHolder | 
	| none       |
	
	
@mobileTest
Scenario Outline: Verify request an appointment with an agent flow in AARP site
Given user is on acquisition home page applitool
Examples:
	| placeHolder | 
	| none       |
	
@languageTest
Scenario Outline:To verify pages load correctly on AARP site
Given user is on acquisition home page applitool
When the user accesses the vpp page using below zipcode on aarp site applitools
	|Zip Code | <zipcode>|
And the user views the plans of the below plan type in AARP site applitools
 	|Plan Type | <plantype> |
Then the user view plan details of the above selected plan in AARP site applitools
	| Plan Name | <planName> |
Examples:
	|zipcode | plantype | planName |
	|90210 | MA |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	
@appAcqPagesTest
Scenario Outline:To directly hit acquisition pages urls and take screenshots
Given the user goes to aarp homepage and takes full screenshot
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans
	|Zipcode| <zipcode>|
And the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot
	|Plan Type| <planType> |
	|Plan Name| <planName> |
	|Drug     | <drug>     |
And the user goes to the view plan details page for MAPD plan and takes screenshots
	|Plan Type| <planType> |
	|Plan Name| <planName> |
When the user clicks on PDP plans and takes screenshot
And the user goes to the view plan details page for PDP plan and takes screenshots
	|Plan Type2| <planType2> |
	|Plan Name2| <planName2> |
And the user clicks on Request More Help and Info link in Our plans and takes screenshots
And the user clicks on Request Agent appointment link and takes screenshots
And the user clicks on Find Uhc in your community link and takes screenshots
And the user clicks on Request PDP Info and enrollment link and takes screenshots

Examples:
	| zipcode 	| planType | planName 										  |  drug            |planType2 | planName2 						  | 
	| 90210     | MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | PDP 	   | AARP MedicareRx Walgreens (PDP)  |