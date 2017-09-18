@fixedTestCaseTest
@pharmacylocatorulayer
Feature:To test Locate a Pharmacy in acqusition flow AARP site
Scenario Outline:To verify available pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user validates the available pharmacies page in AARP site
	
Examples:
	| zipcode     | distance  | county       |  planName 			               	  |  plantype|
	| 80002       | 25 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |
	
Scenario Outline:To verify available pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user validates the available pharmacies page in AARP site
When the user selects a language from dropdown in AARP Site
	| <languageName> |
Then the user should see county popup in AARP site
When the user selects the county in AARP site
	| <county>	|
Then the user should see choose a plan in AARP site

Examples:
	| zipcode     | distance  | county       |  planName 			               	  |  plantype|languageName|
	| 80002       | 25 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |Spanish |
#	| 90210       | 2        |      | AARP MedicareRx Preferred (PDP)                    | PDP |

Scenario Outline:To verify available pharmacies for particular pharmacy types in AARP site
Given the user is on the AARP Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user searches available pharmacies by selecting "Show pharmacies for these services." in AARP site
	| <pharmacytype> |
Then the user validates the available pharmacies page in AARP site
And the user clicks on SearchAgain and navigates to pharmacies search page in the AARP site

Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|plantype|
#	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Long-term care|MA|
#	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    |    Standard Network Pharmacy 				|PDP|

Scenario Outline:To verify error message for no results found for pharmacy type in UMS site
Given the user is on the AARP Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validates the error message for no pharmacies found for below pharmacy in the AARP Site
	| <pharmacytype> |
	
Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|plantype|
#	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    |   Mail Order Pharmacy				|PDP|