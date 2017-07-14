@pharmacylocator
Feature:To test Locate a Pharmacy in acqusition flow AARP site
Scenario Outline:To verify available pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user searches available pharmacies by selecting "Show pharmacies for ALL types" in AARP site
Then the user validates the available pharmacies page in AARP site

Examples:
	| zipcode     | distance  | county       |  planName 			               	  | 
	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
#        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   | 




Scenario Outline:To verify available pharmacies for particular pharmacy types in AARP site
Given the user is on the AARP Medicare Site landing page
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

Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype				|
	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Open 24 hours	|
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours				|
 #       | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program			|
#	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours				|

@multicounty
Scenario Outline: To verify pharmacy locator multi county lookup modal in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|

Examples:
	| zipcode     | distance  | county            |			 
	| 80002       | 15        | Adams County      |

@languageselection
Scenario Outline: To verify pharmacy locator language in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
  | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
Then the user validate multiple language dropdown menu in AARP site
   
Examples:
	| zipcode     | distance  | county            |			 
	| 90210       | 15        | Los Angeles       |
	
@planType
Scenario Outline: To verify plantype in pharmacy locator page in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
  | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user click on view search PDF link in AARP Site
Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles      | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@zipcodeEntry
Scenario Outline: To verify pharmacy locator zipcode entry in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
  | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles      | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@showonmap
Scenario Outline: To verify pharmacy locator showmap in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|	
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user click on show on map link in AARP Site
	
Examples:
	| zipcode     | distance  | planName 			                 	  							|			 
	| 90210       | 15        | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
@resultpdf
Scenario Outline: To verify pharmacy locator pdf results in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|	
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user click on view search PDF link in AARP Site
	
Examples:
	| zipcode     | distance  | planName 			                 	  							|			 
	| 90210       | 15        | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
	
@googlemap
Scenario Outline: To verify google maps for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|	
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
Then the user validate google map colcor for pharmacy and standard network in AARP Site
	
Examples:
	| zipcode     | distance  | planName 			                 	  							|			 
	| 80002       | 15        | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
@MAplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
	
@Widgets
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate pharmacy saver widget in AARP site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	

@moreinfoPDPplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page for PDP plantype
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate more information content based on plan type in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 82001       | 15        | Los Angeles       | AARP MedicareRx Walgreens (PDP) |	


@moreinfoMAplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate more information content based on plan type in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	


@chatPDPplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page for PDP plantype
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate chat widget in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                | 		 
	| 82001       | 15        | Los Angeles       | AARP MedicareRx Walgreens (PDP) |	
	
	
@chatMAplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate chat widget in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	

@TFNPDPplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page for PDP plantype
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate TFN widget in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                | 		 
	| 82001       | 15        | Los Angeles       | AARP MedicareRx Walgreens (PDP) |	
	
	
@TFNMAplantype
Scenario Outline: To verify MAplan for pharmacies in AARP site
Given the user is on the AARP Medicare Site landing page
When the user navigates to Request more info page
When the user navigates to pharmacy search page in AARP Site
And the user enters following details for pharmacy search in AARP Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP Site
	| <planName> |
And the user validate TFN widget in AARP Site

Examples:
	Examples:
	| zipcode     | distance  | county            |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |		
	
	
@pharmacysaverwidget
Scenario Outline: To verify MAplan for pharmacies in AARP site
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
And the user validate pharmacy saver widget in AARP site

Examples:
	| zipcode     | distance  | county            | year     |  planName 			                 	  							|			 
	| 90210       | 15        | Los Angeles       | 2017     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |	
