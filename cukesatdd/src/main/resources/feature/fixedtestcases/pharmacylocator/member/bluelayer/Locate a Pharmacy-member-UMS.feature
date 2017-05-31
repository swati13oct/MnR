@fixedTestCaseTest
@pharmacylocatormblayer
Feature:To test Locate a Pharmacy tool in UMS site
Scenario Outline:To verify available pharmacies for default zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters distance details in UMS site
	| Distance	| <distance>	|
	| County	| <countyName>	|
And the user chooses a plan from dropdown in UMS site
	| <planName> |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
	| plantype | memberType   | distance  | countyName |planName|
	| MAPD      |  Group     |    25      | Cayuga County|UnitedHealthcare MedicareComplete Choice Plan 1 (Regional PPO)|

Scenario Outline:To verify available pharmacies for default zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters distance details in UMS site
	| Distance	| <distance>	|
	| County	| <countyName>	|
And the user chooses a plan from dropdown in UMS site
	| <planName> |
And the user selects "Show pharmacies for these services" in UMS Site
	| <pharmacyType> | 
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
	| plantype | memberType   | distance  | countyName |planName|pharmacyType						     |
	| MAPD      |  Group     |   25      | Cayuga County|UnitedHealthcare MedicareComplete Choice Plan 1 (Regional PPO)|Standard Network Pharmacy |
	
Scenario Outline:To verify available pharmacies for particular zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters zipcode and distance details for UMS site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | pharmacyType						     |
  | MAPD    | 	Group	 | 90210       | 2        |       | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | Standard Network Pharmacy |

Scenario Outline:To verify available pharmacies for particular zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters zipcode and distance details for UMS site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |
And the user selects "Show pharmacies for these services" in UMS Site
	| <pharmacyType> | 
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | pharmacyType						     |
  | MAPD    | 	Group	 | 90210       | 2        |       | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | Standard Network Pharmacy |

Scenario Outline:To verify espanol and chinese contents
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user clicks below Language Link in UMS site
	|<language>|
And the user enters zipcode and distance details for UMS site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available for the above selected language in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | language						     |
  | MAPD    | 	Group	 | 90210       | 2        |       | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |Spanish |
  | MAPD    | 	Group	 | 90210       | 2        |       | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |Chinese |
