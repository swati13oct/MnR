@blogin
Feature:To test Login on UHCM site in mobile
Scenario Outline:Verify login in UHCM site for MA or MAPD members in mobile
Given the user is on the UHC medicare site mobile login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates plan and member details on benefits summary page in UHC site 

Examples:
	| planType |
	| MAPD     |
	
	
	
Scenario Outline:Verify Pharmacy Locator page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates Pharmacy Locator page in UHC site

Examples:
	| planType |
	| MAPD     |
	
	
Scenario Outline:Verify Provider Search page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates Provider Search page in UHC site

Examples:
	| planType |
	| MAPD     |
	
Scenario Outline:Verify Customer Service page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates Customer Service page in UHC site

Examples:
	| planType |
	| MAPD     |


Scenario Outline:Verify My benefit details page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates My benefit details page in UHC site

Examples:
	| planType |
	| MAPD     |

Scenario Outline:Verify View My Plan Benefits page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates View My Plan Benefits page in UHC site

Examples:
	| planType |
	| MAPD     |

Scenario Outline:Verify View Drug Benefits page in mobile
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMS with following details in UHC site
	| Plan Type   | <planType>  |
Then the user validates View Drug Benefits page in UHC site

Examples:
	| planType |
	| MAPD     |
	
	