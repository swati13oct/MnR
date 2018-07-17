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
	
@applitoolsAcqAARP
Scenario Outline:To directly hit acquisition pages urls and take screenshots
Given the user goes to aarp homepage and takes full screenshot
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans
	|Zipcode| <zipcode>|
#And the user goes to the view plan details page for MAPD plan and takes screenshots
	|Plan Type| <planType> |
	|Plan Name| <planName> |
#When the user clicks on PDP plans and takes screenshot
#And the user goes to the view plan details page for PDP plan and takes screenshots
	|Plan Type2| <planType2> |
	|Plan Name2| <planName2> |
And the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot
	|Plan Type| <planType> |
	|Plan Name| <planName> |
	|Drug     | <drug>     |
And the user clicks on the enroll in plan button for mapd plan and goes to med info page
	|Plan Name| <planName> |
Then the user enters info for pages in OLE flow and takes screenshots of each page
	| Plan Type                | <planType> |
	| First Name               | <firstname> |
	| Last Name                | <lastname> |
	| Medicare Number          | <medicarenumber> |
	| PartA Date               | <partadate> |
	| PartB Date               | <partbdate> |
	| Card Type                | <cardtype> |
	| DOB                      | <dob>                    |
    | Gender                   | <gender>                 |
    | Perm_Street              | <permstreet>             |
    | Perm_city                | <permcity>               |
And the user goes to Request More Help and Info link page in Our plans and takes screenshot
And the user goes to Request Agent appointment link page and takes screenshot
And the user goes to Find Uhc in your community link page and takes screenshot
And the user goes to Request PDP Inquiry Kit page and takes screenshot
And the user goes to Medicare Advantage Plans Link page under Our plans and takes screenshot
And the user goes to How do I enroll under Medicare Advantage page and takes screenshot
And the user goes to Resources and Materials page under Medicare Advantage page and takes screenshot
And the user goes to Prescription Drug Plans page from Our Plans and takes screenshot
And the user goes to How do I enroll under Prescription Drug Plans page and takes screenshot
And the user goes to Resources and Materials page under Prescription Drug Plans page and takes screenshot
And the user goes to Plan Selector page from Our Plans tab and takes screenshot
And the user goes to pharmacy locator page from Our Plans tab and takes screenshot
And the user goes to about us page from the footer and takes screenshot
And the user goes to contact us page from the footer and takes screenshot
And the user goes to sitemap page from the footer and takes screenshot
And the user goes to privacy policy page from the footer and takes screenshot
And the user goes to terms and conditions page from the footer and takes screenshot
And the user goes to disclaimer page from the footer and takes screenshot
And the user goes to agents and brokers page from the footer and takes screenshot
And the user goes to Accessibility page from the footer and takes screenshot
And the user goes to medicare eligibility page from the Medicare Eductation nav panel and takes screenshot
And the user goes to coverage choices page from the Medicare Eductation nav panel and takes screenshot
And the user goes to prescription provider and benefits page from the Medicare Eductation nav panel and takes screenshot
And the user goes to cost medicare advantage plnas page from the Medicare Eductation nav panel and takes screenshot
And the user goes to cost basics page from the Medicare Eductation nav panel and takes screenshot
And the user goes to pdp plans from the Medicare Eductation nav panel and takes screenshot
And the user goes to enrollment basics page from the Medicare Eductation nav panel and takes screenshot

Examples:
	| zipcode 	| planType | planName 										  |  drug            |planType2 | planName2 						  | cardtype | firstname | lastname | medicarenumber | partadate | partbdate |  dob      | gender | permstreet  | permcity    | 
	| 90210     | MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | PDP 	   | AARP MedicareRx Walgreens (PDP)      | HICN     | John      | Doe      | 987654333C       |  01012010 |  01012010 |  01011941 | Female | 123 Perm Rd | Los Angeles |
	
@applitoolsAcqUHC
Scenario Outline:To directly hit acquisition pages urls and take screenshots
Given the user goes to uhc homepage and takes full screenshot
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans uhc
	|Zipcode| <zipcode>|
And the user goes to the view plan details page for MAPD plan and takes screenshots uhc
	|Plan Type| <planType> |
	|Plan Name| <planName> |
When the user clicks on PDP plans and takes screenshot uhc
And the user goes to the view plan details page for PDP plan and takes screenshots uhc
	|Plan Type2| <planType2> |
	|Plan Name2| <planName2> |
And the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot uhc
	|Plan Type| <planType> |
	|Plan Name| <planName> |
	|Drug     | <drug>     |
And the user clicks on the enroll in plan button for mapd plan and goes to med info page uhc
	|Plan Name| <planName> |
Then the user enters info for pages in OLE flow and takes screenshots of each page uhc
	| Plan Type                | <planType> |
	| First Name               | <firstname> |
	| Last Name                | <lastname> |
	| Medicare Number          | <medicarenumber> |
	| PartA Date               | <partadate> |
	| PartB Date               | <partbdate> |
	| Card Type                | <cardtype> |
	| DOB                      | <dob>                    |
    | Gender                   | <gender>                 |
    | Perm_Street              | <permstreet>             |
    | Perm_city                | <permcity>               |

And the user goes to Request More Help and Info link page in Our plans and takes screenshot uhc
And the user goes to Request Agent appointment link page and takes screenshot uhc
And the user goes to Find Uhc in your community link page and takes screenshot uhc
And the user goes to Request PDP Inquiry Kit page and takes screenshot uhc
And the user goes to Medicare Advantage Plans Link page under Our plans and takes screenshot uhc
And the user goes to How do I enroll under Medicare Advantage page and takes screenshot uhc
And the user goes to Resources and Materials page under Medicare Advantage page and takes screenshot uhc
And the user goes to Prescription Drug Plans page from Our Plans and takes screenshot uhc
And the user goes to How do I enroll under Prescription Drug Plans page and takes screenshot uhc
And the user goes to Resources and Materials page under Prescription Drug Plans page and takes screenshot uhc
And the user goes to Plan Selector page from Our Plans tab and takes screenshot uhc
And the user goes to pharmacy locator page from Our Plans tab and takes screenshot uhc
And the user goes to about us page from the footer and takes screenshot uhc
And the user goes to contact us page from the footer and takes screenshot uhc
And the user goes to sitemap page from the footer and takes screenshot uhc
And the user goes to privacy policy page from the footer and takes screenshot uhc
And the user goes to terms and conditions page from the footer and takes screenshot uhc
And the user goes to disclaimer page from the footer and takes screenshot uhc
And the user goes to agents and brokers page from the footer and takes screenshot uhc
And the user goes to Accessibility page from the footer and takes screenshot uhc
And the user goes to medicare eligibility page from the Medicare Eductation nav panel and takes screenshot
And the user goes to coverage choices page from the Medicare Eductation nav panel and takes screenshot
And the user goes to prescription provider and benefits page from the Medicare Eductation nav panel and takes screenshot
And the user goes to cost medicare advantage plnas page from the Medicare Eductation nav panel and takes screenshot
And the user goes to cost basics page from the Medicare Eductation nav panel and takes screenshot
And the user goes to pdp plans from the Medicare Eductation nav panel and takes screenshot
And the user goes to enrollment basics page from the Medicare Eductation nav panel and takes screenshot

Examples:
	| zipcode 	| planType | planName 										  |  drug            |planType2 | planName2 						  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate  | dob      | gender | permstreet  | permcity      | 
	| 90210     | MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | PDP 	    | AARP MedicareRx Walgreens (PDP)     |HICN      | John      | Doe      | 123213123a    | false   |  01012010 |  01012010    | 01011941 | Female | 123 Perm Rd | Los Angeles   |      