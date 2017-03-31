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


Scenario Outline:To test Locate a Pharmacy tool in UMS site for MAPD Group
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
| Distance    | <distance>  |
And the user searches for pharmacies available in UMS site
And user validates Ballon Mappers
Then user validates the English pdf content
Examples:
| plantype | memberType   | distance  |
| MAPD     | Individual   |   25      |


Scenario Outline:To test Locate a Pharmacy tool in UMS site for MAPD Group
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
| Distance    | <distance>  |
And the user opts for chinese content in pharmacy search page
Then the user validates the chinese pdf content
Examples:
| plantype | memberType   | distance  |
| MAPD     | Individual   |   25      |


Scenario Outline:To test Locate a Pharmacy tool in UMS site for MAPD Group
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
| Distance    | <distance>  |
And the user opts for spanish content in pharmacy search page
Then the user validates the spanish pdf content
Examples:
| plantype | memberType   | distance  |
| MAPD     | Individual   |   25      |

Scenario Outline:To test Locate a Pharmacy tool in UMS site for MAPD Group
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
| Distance    | <distance>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site
Examples:
| plantype | memberType   | distance  |
| MAPD     | Individual   |   25      |



Scenario Outline:To validate disclaimer on Pharmacy Result page
Given registered member to verify locate a pharmacy page in UMS Site
| Plan Type    | <plantype>   |
| MemberType  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user search pharmacies using the below information in UMS site
| Distance    | <distance>  |
And the user searches for pharmacy available in UMS site
Then the user validates the pharmacies available in UMS site
Examples:
| plantype | memberType   | distance  |
#| MAPD     | Individual   |   25      |
#| MAPD     | Group        |   2      |
#| MAPD     | Group        |   2      |
#| PDP      | Group        |   2      |
| MAPD     | Individual   |   2      |	

 @Q5
Scenario Outline: Verify right rail widget and logo slider Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
|Username|<username>|
| Plan Type    | <plantype>   |
#| Member Type  | <memberType> |
When the user navigates to myplan page in UMS site	
When the user navigates to pharmacy search page in UMS site
#Then the user validates the right rail widget and logo slider
Then the user validates Pharmacy Locator tool plan dropdown menu for the Medica and PCP member plan
#Then the user validates Search checkbox displayed dynamically related to the pharmacy network


Examples:
|username	     |plantype    |
|blpcp_021     |PCP      |


@bluePharmacysearch
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   |
   	

@bluePharmacysearchresult
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user searches for pharmaciy search results available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual  |

   	
@bluePharmacysearchprpnandballon
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user validates the PRPN search result and red balloon marker available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group   |

@bluePharmacysearchnonaep
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user validates Non AEP plan year and type in pharmaciy search results available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group   |


@bluePharmacysearchaep
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user validates AEP plan year and type in pharmaciy search results available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   |

@bluePharmacypreferedwidget
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user validates the Preferred Mail service Pharmacy widget available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group   |

@bluePharmacysaverandballon
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user validate Pharmacy Saver pharmacies and red balloon marker available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group   |

@bluePharmacynintydaysfilter
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user validate ninty days filter available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group   |


@bluePharmacymultilang
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user validate multiple language dropdown menu in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   |

@US459522
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user searches for get direcion available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   | 


@US459888
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user validate more information is available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   |  

@texasers
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
Then the user searches for texas ers plan type is available in UMS site

Examples:
|plantype    |memberType    | 
|PDP        |Group  |
   	
@pharmacyfilterandtooltip
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user validate filter and tooltip is available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   |  
   	