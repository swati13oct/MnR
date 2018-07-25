@fixedTestCaseTest
@applitools
Feature:2.04-VBF-Acq-To test applitools in AARP and UHC sites
	
@applitoolsAARP_VPP
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

@applitoolsAARP_DCE
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
	
@applitoolsAARP_OLE
Scenario Outline:To use applitools to take screenshots of the DCE pages
Given the user goes to aarp homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
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

Examples:
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 										  |  cardtype | firstname | lastname | medicarenumber | partadate | partbdate |  dob      | gender | permstreet  | permcity    | 
	| 90210     |  no         | no         |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)|  HICN     | John      | Doe      | 987654333C       |  01012010 |  01012010 |  01011941 | Female | 123 Perm Rd | Los Angeles |
		
@applitoolsAARP_Batch2
Scenario Outline:To take screenshots of batch 2 pages for acquisition aarp
When the user goes to Request More Help and Info link page in Our plans and takes screenshot
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
Then the user goes to contact us page from the footer and takes screenshot

Examples:
	|<placeholder>|
	|place holder |

@applitoolsAARP_Batch3
Scenario Outline:To take screenshots of batch 3 pages for acquisition aarp
When the user goes to sitemap page from the footer and takes screenshot
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
Then the user goes to enrollment basics page from the Medicare Eductation nav panel and takes screenshot	

Examples:
	|<placeholder>|
	|place holder |
	
@applitools_UHC_VPP
Scenario Outline:To directly hit acquisition pages urls and take screenshots
Given the user goes to uhc homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans uhc
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
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

Examples:
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 										  |  drug            |planType2 | planName2 						  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate  | dob      | gender | permstreet  | permcity      | 
	| 90210     | yes         | yes         |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | PDP 	    | AARP MedicareRx Walgreens (PDP)     |HICN      | John      | Doe      | 123213123a    | false   |  01012010 |  01012010    | 01011941 | Female | 123 Perm Rd | Los Angeles   |      

@applitools_UHC_OLE
Scenario Outline:To go through OLE flow on UHC site and take screenshots
Given the user goes to uhc homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans uhc
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
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

Examples:
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 								        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate  | dob      | gender | permstreet  | permcity      | 
	| 90210     | no        | no        |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |HICN      | John      | Doe      | 123213123a    | false   |  01012010 |  01012010    | 01011941 | Female | 123 Perm Rd | Los Angeles   |      


@applitools_UHC_DCE
Scenario Outline:To go throught the UHC dce flow and take screenshots
Given the user goes to uhc homepage and takes full screenshot
	|Home Screenshot| <screenshot1>|
When the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans uhc
	|Zipcode| <zipcode>|
	|VPP Screenshot| <screenshot2>|
And the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot uhc
	|Plan Type| <planType> |
	|Plan Name| <planName> |
	|Drug     | <drug>     |

Examples:
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 										  |  drug            | 
	| 90210     | no         | no        |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG |       

@applitoolsUHC_Batch2
Scenario Outline:To take screenshots of batch 2 pages for acquisition uhc
When the user goes to Request More Help and Info link page in Our plans and takes screenshot uhc
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


@applitoolsUHC_Batch3
Scenario Outline:To take screenshots of batch 3 pages for acquisition uhc
When the user goes to sitemap page from the footer and takes screenshot uhc
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
	| zipcode 	| screenshot1 |screenshot2  | planType | planName 										  |  drug            |planType2 | planName2 						  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate  | dob      | gender | permstreet  | permcity      | 
	| 90210     | yes         | yes         |   MA	   | AARP MedicareComplete SecureHorizons Plan 1 (HMO)| Lipitor TAB 10MG | PDP 	    | AARP MedicareRx Walgreens (PDP)     |HICN      | John      | Doe      | 123213123a    | false   |  01012010 |  01012010    | 01011941 | Female | 123 Perm Rd | Los Angeles   |      