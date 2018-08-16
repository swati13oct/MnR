@BAT_acq_pharmacylocator
@aeppharmacylocator
Feature:1.18-VBF-Acq-To test Locate a Pharmacy in acqusition flow AARP site
Scenario Outline:To verify available pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
	| PlanType	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses year from planyear in AARP Site
	|  <year>		|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user validates the available pharmacies page in AARP site	
Examples:
	| zipcode     | distance  | county       |  planName 			               	  |  plantype|	year	|
	| 80002       | 25 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |  2018 |
	| 80002       | 25 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |  2019 |
