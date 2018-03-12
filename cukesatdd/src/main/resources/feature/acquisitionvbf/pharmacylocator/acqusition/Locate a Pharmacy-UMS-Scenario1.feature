@pharmacylocatorUHC
Feature:1.19-To test Locate a Pharmacy in acqusition flow UMS site TEST1
@pharmacySearch
Scenario Outline:To verify available pharmacies in UMS site
Given the user is on the UMS Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type
	| <plantype> |
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in UMS Site
	| <planName> |
#And the user searches available pharmacies by selecting "Show pharmacies for ALL types"
Then the user validates the available pharmacies page in UMS site
		
Examples:
	| zipcode     | distance  | county       |  planName 			               	  | plantype|
#	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA|
#	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    | PDP|
	
@pharmacySearchPage
Scenario Outline:To verify available pharmacies for particular pharmacy types in UMS site
Given the user is on the UMS Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type
	| <plantype> |
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in UMS Site
	| <planName> |
And the user searches available pharmacies by selecting "Show pharmacies for these services."
	| <pharmacytype> |
Then the user validates the available pharmacies page in UMS site
And the user clicks on SearchAgain and navigates to pharmacies search page

Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|plantype|
	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Long-term care|MA|
#	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    |   Standard Network Pharmacy				|PDP|
	
@validateError
Scenario Outline:To verify error message for no results found for pharmacy type in UMS site
Given the user is on the UMS Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type
	| <plantype> |
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in UMS Site
	| <planName> |
And the user validates the error message for no pharmacies found for below pharmacy
	| <pharmacytype> |
	
Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|plantype|
	| 90210       | 2        |      | AARP MedicareRx Preferred (PDP)                    |   Mail Order Pharmacy				|PDP|