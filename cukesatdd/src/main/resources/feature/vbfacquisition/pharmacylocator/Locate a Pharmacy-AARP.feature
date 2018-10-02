@BAT_acq_pharmacylocator
@fixedTestCaseTest
@pharmacylocatorulayer
Feature:1.18-VBF-Acq-To test Locate a Pharmacy in acqusition flow AARP site (GATED)
@pharmacylocatorulayerSmoke
Scenario Outline:To verify available pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
#When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
#	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
| planname | <planName> |
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| planname | <planName> |
		| planyear | <planYear> |
Then the user validates the available pharmacies page in AARP site
	
Examples:
	| zipcode     | distance  | county       |  planName 			               	  			  | planYear 	|
	| 90210       | 25        | None     	 | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2018    	|
#	| 80002       | 10        | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2018 		|
#	| 90210       | 2         |   None       | AARP MedicareRx Preferred (PDP)                    | 2018		|
#	| 90210       | 25        | None     	 | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2019    	|
#	| 80002       | 10        | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2019 		|
	| 90210       | 2         |   None       | AARP MedicareRx Preferred (PDP)                    | 2019		|
	
	
@availablePharmAARP
Scenario Outline:To verify available pharmacies with language in AARP site
Given the user is on the AARP Medicare Site landing page
#When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
#	| <plantype> |
When the user navigates to pharmacy search page in AARP Site
| planname | <planName> |
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
		| planname | <planName> |
		| planyear | <planYear> |
Then the user validates the available pharmacies page in AARP site
When the user selects a language from dropdown in AARP Site
	| <languageName> |
Then the user should see choose a plan in AARP site

Examples:
	| zipcode     | distance  | county       |  planName 			               	  			  | planYear |plantype|languageName|
	| 90210       | 25        | None         | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2018     | MA	  |Spanish|
#	| 80002       | 15        | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2018     |MA      |Spanish|
#	| 90210       | 2         |   None       | AARP MedicareRx Preferred (PDP)                    | 2018	 |MA      |Spanish|
#	| 90210       | 25        | None         | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2019     | MA	  |Spanish|
#	| 80002       | 15        | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2019     |MA      |Spanish|
	| 90210       | 2         |   None       | AARP MedicareRx Preferred (PDP)                    | 2019	 |MA      |Spanish|


@pharmaciesServicesAARP
Scenario Outline:To verify available pharmacies and Services in AARP site
Given the user is on the AARP Medicare Site landing page
#When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
#| <plantype> |
When the user navigates to pharmacy search page in AARP Site
| planname | <planName> |
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| planname | <planName> |
		| planyear | <planYear> |
Then the user validates the available pharmacies page in AARP site
Then the user chooses the Pharmacy Type
| <pharmacytype>|
Then the user chooses the Service Type
|<servicetype>|
Then the user validates the available pharmacies page in AARP site
	
Examples:
	| zipcode     | distance  | county       	  |  planName 			               	 			   | planYear	| plantype	| pharmacytype			  |servicetype|
	| 90210       | 25 miles  | None			      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2018		|MA			|Standard Network Pharmacy|Open 24 hours|
	| 90210       | 25 miles  | None				    | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 2019		|MA			|Standard Network Pharmacy|Open 24 hours|
	