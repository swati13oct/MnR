#@pharmacylocator
Feature:To test Locate a Pharmacy tool in AARP site

@PharmacyDistance
Scenario Outline:To verify all available pharmacies for default zipcode in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| Plan Type | <planType> |
When the user navigates to pharmacy search page in AARP site
And the user enters distance details in AARP site
	| Distance | <distance>  |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site

Examples:
	| planType | distance |
	| PDP      | 25       |
	| MAPD	   | 2        |

@PharmacyFilters
Scenario Outline:To verify pharmacies displayed for particular pharamcy type for default zipcode in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <planType> |
When the user navigates to pharmacy search page in AARP site
And the user enters distance details in AARP site
| Distance	| <distance>  |
And the user selects "Show pharmacies for these services" in AARP Site
	| <pharmacyType> |
And the user searches for pharmacy available in AARP Site
Then the user validates the pharmacies available in AARP Site

Examples:
	| planType | distance | pharmacyType							|
	| PDP      | 25       |	Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |
#	| MAPD	   | 2        | Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |


Scenario Outline:To verify all available pharmacies for particular zipcode and plan name in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user clicks chinese in AARP Site 
And the user enters zipcode and distance details for AARP Site
    | Zip Code    | <zipcode>  |
	| Distance    | <distance> |
	| County      | <countyname> |
And the user chooses a plan from dropdown in AARP site
	| Plan Name | <planName> |
And the user clicks create pdf in AARP Site
And the user searches for pharmacy available in AARP Site
Then the user validates the pharmacies available in AARP Site
Examples:
	| plantype | zipcode | countyname    | distance |  planName			|
	| PDP      | 80002   | Adams County  |	25   |  AARP MedicareRx Preferred (PDP) |
#	| PDP      | 80001   |		     |	25   |  AARP MedicareRx Preferred (PDP) |
#	| MAPD	   | 80002   |		     |	25   |  AARP MedicareRx Preferred (PDP) |
	


	  
Scenario Outline:To verify pharmacies displayed for particular zipcode, plan name and  pharmacy type in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user enters zipcode and distance details for AARP Site
        | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in AARP site
| Plan Name	| <planName>  |
And the user selects "Show pharmacies for these services" in AARP Site
| Pharmacy Type	| <pharmacyType> |
And the user searches for pharmacy available in AARP Site
Then the user validates the pharmacies available in AARP Site

Examples:
	| plantype | zipCode | countyName    | distance |  planName			   | pharmacyType						     |
#	| PDP      | 80002   | Adams County  |	25      |  AARP MedicareRx Preferred (PDP) | Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |
#	| PDP      | 80001   |		     |	25      |  AARP MedicareRx Preferred (PDP) | Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |
#	| MAPD	   | 80002   |		     |	25      |  AARP MedicareRx Preferred (PDP) | Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |

@pharmacylocator
Scenario Outline:To verify pharmacies displayed based on contract and PBP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user chooses the year and a plan from dropdown in AARP site
    |  Year     | <year> |
	| Plan Name | <planName>  |
And the user hovers over the tooltip in AARP Site
| Pharmacy Type	| <pharmacyType> |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site

Examples:
	| plantype | year |  planName			                | pharmacyType						     |
	| PDP      | 2016 |  AARP MedicareRx Saver Plus (PDP)   | Preferred Retail Pharmacy Network      | 
	
	
@pharmacysearch
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| Plan Type | <plantype> |
When the user navigates to pharmacy search page in AARP site
#And the user searches for pharmaciy search results available in AARP site
Then the user validates the content on pharmacy search page

Examples:
	| plantype | 
	| PDP     |  
	
@pharmacysearchresult
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user searches for pharmaciy search results available in AARP site

Examples:
	| plantype | 
	| PDP     |

@pharmacyshowmap
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user searches for show on map available in AARP site


Examples:
	| plantype | 
	| PDP     |
	
@pharmacymultilang
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user validate multiple language dropdown available in AARP site

Examples:
	| plantype | 
	| MAPD     |
	
@pharmacyresultpdf
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user searches for view result as pdf available in AARP site

Examples:
	| plantype | 
	| PDP     |

	
	
@pharmacyprpnwidget
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
Then the user validates the PRPN widget available in AARP site

Examples:
	| plantype | 
	| PDP     |
	
@pharmacynonaep
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user validates Non AEP plan year and type in pharmaciy search results available in AARP site

Examples:
	| plantype | 
	| PDP     |
	
@pharmacyaep
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user validates AEP plan year and type in pharmaciy search results available in AARP site

Examples:
	| plantype | 
	| PDP     |
	
@pharmacysearchandballon
Scenario Outline:To verify pharmacies displayed based on MAPD and PDP in AARP site
Given registered member to verify locate a pharmacy in AARP Site
| Plan Type	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user validates the PRPN search result and red balloon marker available in AARP site

Examples:
	| plantype | 
	| PDP     |
