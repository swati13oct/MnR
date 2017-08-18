@pharmacylocator
Feature:To test Locate a Pharmacy in acqusition flow UMS site
Scenario Outline:To verify available pharmacies in UMS site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in UMS Site
	| <planName> |
And the user searches available pharmacies by selecting "Show pharmacies for ALL types"
Then the user validates the available pharmacies page in UMS site

Examples:
	| zipcode     | distance  | county       |  planName 			               	  | 
	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
#        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   | 




Scenario Outline:To verify available pharmacies for particular pharmacy types in UMS site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in UMS Site
	| <planName> |
And the user searches available pharmacies by selecting "Show pharmacies for these services"
	| <pharmacytype> |
Then the user validates the available pharmacies page in UMS site

Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|
	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Open 24 hours	|
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours				|
 #       | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program			|
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours				|

@pharmacysaverwidget
Scenario Outline: To verify pharmacysaverwidget in AARP site
Given the user is on the UMS Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in UMS Site
And the user enters following details for pharmacy search in UMS Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in UMS Site
  |  Year | <year> |
	| Plan Name| <planName> |	
And the user validate pharmacy saver widget in UMS Site

Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@Pharmacylist
Scenario Outline: To verify Pharmacylist in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
  |  Year | <year> |
	| Plan Name| <planName> |	
And the user searches for pharmacy search results available in AARP site
	
Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@chineselanguage
Scenario Outline: To verify pharmacy locator language in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user clicks chineseLink in AARP Site
And the user enters following details for pharmacy search in AARP Site
  | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
  |  Year | <year> |
	| Plan Name| <planName> |	
And the user searches multi lang for pharmacy search results available in AARP site
   
Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@spanishlanguage
Scenario Outline: To verify pharmacy locator language in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
Then the user validate multiple language dropdown menu in AARP site
And the user enters following details for pharmacy search in AARP Site
  | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
  |  Year | <year> |
	| Plan Name| <planName> |	
And the user searches multi lang for pharmacy search results available in AARP site

Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 
	
	
@resultpdfpharmacysaver
Scenario Outline: To verify pharmacy locator pdf results in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|	
And the user chooses the year and a plan from dropdown in AARP site
	|  Year | <year> |
	| Plan Name| <planName> |
And the user searches for pharmacy search results available in AARP site
Then the user click on view search PDF link in AARP Site
	
Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
	
@moreinfopharmacysaver
Scenario Outline: To verify moreinfo for pharmacy saver plantype in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
	|  Year | <year> |
	| Plan Name| <planName> |
And the user searches for pharmacy search results available in AARP site
And the user validate more information content based on plan type in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	


@redballonpharmacysaver
Scenario Outline: To verify google map red ballon for pharmacy saver plantype in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
	|  Year | <year> |
	| Plan Name| <planName> |
And the user searches for pharmacy search results available in AARP site
Then the user validate google map red ballon based on plan type in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	

@tooltippharmacysaver
Scenario Outline: To verify tooltip for pharmacy saver plantype in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses the year and a plan from dropdown in AARP site
	|  Year | <year> |
	| Plan Name| <planName> |
And the user searches for pharmacy search results available in AARP site
Then the user validate tool tip for pharmacy saver plan type in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	