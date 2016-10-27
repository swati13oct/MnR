@pharmacylocator
Feature:To test Locate a Pharmacy tool in UMS site
Scenario Outline:To verify available pharmacies for default zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
	| Distance    | <distance>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
	| plantype | memberType   | distance  |
	| PDP      |  Group     |   25      |
#	| MAPD	   | Individual |   25      |
#	| MAPD     |  Group     |    2      |
#	| MAPD	   |  Group     |    2      |

Scenario Outline:To verify available pharmacies for particular zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user clicks chineseLink in UMS Site 
And the user search pharmacies using the below information in UMS site
    | Zip Code    | 90201   |
	| Distance    | 25 |
	| County      | |
And the user chooses a plan from dropdown in UMS site
	| planName | AARP MedicareRx Walgreens (PDP)|
     
And the user clicks create pdf in AARP Site
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site
Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | 
# | MA       | 		 | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
# | MAPD     | 		 | 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
# | MAPD     | Group     | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | | 
  | PDP      | Group	 | 78006       | 25       | Bexar County      | UnitedHealthcare MedicareRx for Groups (PDP)       | 
  
Scenario Outline:To verify espanol contents and create pdf links
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user clicks espanolLink in UMS Site
And the user search pharmacies using the below information in UMS site
    | Zip Code    | 90201   |
	| Distance    | 25 |
	| County      | |
And the user chooses a plan from dropdown in UMS site
	| planName  | AARP MedicareRx Walgreens (PDP)|
And the user clicks create pdf in AARP Site
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | 
# | MA       | 		 | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
# | MAPD     | 		 | 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
# | MAPD     | Group     | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | | 
  | PDP      | Group	 | 78006       | 25       | Bexar County      | UnitedHealthcare MedicareRx for Groups (PDP)       | 

Scenario Outline:To verify pharmacies displayed for default zipcode in Locate a Pharmacy in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
	| Distance    | <distance>  |
And the user selects pharmacy type in UMS site
     | <pharmacytype> |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
	| plantype | distance | memberType   |pharmacytype               |
	| PDP      | 25       |  Group     | Standard Network Pharmacy | 
#	| MAPD	   | 2        |  Individual| Open 24 hours             |
#	| MAPD     | 2        |  Group     | Pharmacy Saver™ Program   |
#	| MAPD	   | 2        |  Group     | Open 24 hours             |
	       
Scenario Outline:To verify pharmacies displayed for particular zipcode in Locate a Pharmacy in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
	| Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |	
And the user selects pharmacy type in UMS site
        | <pharmacytype> |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site


Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 			               	  | pharmacytype               |
# | MA       | 		 | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy |
# | MAPD     | 		 | 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours             |
# | MAPD     | Group     | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program   |
  | PDP      | Group	 | 78006       | 25       | Bexar County      | UnitedHealthcare MedicareRx for Groups (PDP)       |  Open 24 hours,Standard Network Pharmacy  |
  
  
  Scenario Outline:To test Locate a Pharmacy tool in UMS site for MAPD Group
Given login with MAPD member on Blue layer
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in Blue layer site
And the user search pharmacies using the below information in Blue layer site
| Distance    | <distance>  |
And the user searches for pharmacies available in Blue layer site
Examples:
| plantype | memberType   | distance  |
| MAPD     | Individual       |   25      |