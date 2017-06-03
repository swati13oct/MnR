@fixedTestCaseTest
@pharmacylocatormulayer
Feature:To test Locate a Pharmacy tool in AARP site for all pharmacy types for default zipcode in AARP site
Scenario Outline:To verify all available pharmacies for default zipcode in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| <planType> |
When the user navigates to pharmacy search page in AARP site
And the user enters distance details in AARP site
	| <distance>  |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site

Examples:
	| planType | distance |
#	| PDP      | 25       |
#	| MAPD	   | 2        |

Scenario Outline:To verify pharmacies displayed for particular pharamcy type for default zipcode in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| <planType> |
When the user navigates to pharmacy search page in AARP site
And the user enters distance details in AARP site
	| <distance>  |
And the user selects "Show pharmacies for these services" in AARP Site
	| <pharmacyType> |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site

Examples:
	| planType | distance | pharmacyType							|
#	| PDP      | 25       |	Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |
#	| MAPD	   | 2        | Open 24 hours,Long-term care,Standard Network Pharmacy (90-day) |

Scenario Outline:To verify all available pharmacies for particular zipcode and plan name in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user enters zipcode and distance details for AARP site
    | Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
And the user chooses a plan from dropdown in AARP site
	| <planName> |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site
Examples:
	| plantype | zipcode | county    | distance |  planName			|
	| PDP      | 90210   | |	25   |  AARP MedicareRx Walgreens (PDP) |
#	| PDP      | 80002   | Adams County  |	25   |  AARP MedicareRx Preferred (PDP) |
	
Scenario Outline:To verify pharmacies displayed for particular zipcode, plan name and  pharmacy type in AARP site
Given registered member to verify locate a pharmacy in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user enters zipcode and distance details for AARP site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in AARP site
	| <planName>  |
And the user selects "Show pharmacies for these services" in AARP Site
	| <pharmacyType> |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available in AARP site

Examples:
	| plantype | zipCode | countyName    | distance |  planName			   | pharmacyType						     |
#	| PDP      | 90210   |  |	25      |  AARP MedicareRx Preferred (PDP) | Long-term care,Standard Network Pharmacy (90-day) |

Scenario Outline:To verify all Content in espanol and chinease
Given registered member to verify locate a pharmacy in AARP Site
	| <plantype> |
When the user navigates to pharmacy search page in AARP site
And the user clicks below Language Link in AARP site
	|<language>|
And the user enters zipcode and distance details for AARP site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in AARP site
	| <planName>  |
And the user searches for pharmacies available in AARP site
Then the user validates the pharmacies available for the above selected language in AARP site

Examples:
	| plantype | zipCode | countyName    | distance |  planName			|language|
	| PDP      | 90210   |   |	25   |  AARP MedicareRx Preferred (PDP) |Spanish|
	| PDP      | 90210   |   |	25   |  AARP MedicareRx Preferred (PDP) |Chinese|
	