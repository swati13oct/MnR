@planSummaryPage
Feature: To verify mobile responsive 
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
#Then user validates county name on plan summary page
Examples:
|zipCode|county          |planType |
|33012 |Miami-Dade County| SNP     |

@planhighlights
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates plan highlights
Examples:
|zipCode|county          |planType |
|33012 |Miami-Dade County| SNP     |

@enrollPlan
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And User click on Enroll in plan link on plan detail page
|PlanName|planName|
Examples:
|zipCode|county          |planType |planName|
|33012 |Miami-Dade County| MA     |Preferred Choice Dade (HMO) |

@dceBlayer
Scenario Outline: To validate Edit Drug List link
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    #| Plan Name |<planName>  | 
 
And the user search the drug using drug initials in UHC site
   # |lipi|	
And the user selects following drug in UHC site
		#|lipitor|
And the user selects the following dosage information in UHC site
   # |Drug Dosage|<drugDosage>|
   # |Quantity   |<quantity>|
   # |Drug Frequency|<drugFrequency>|
    #|Packages|<packages>|
And the user selects the pharamacy and navigates to plan summary page 
    #|Pharmacy Name|<pharmacyName>|
    #|Pharamcy Type|<pharmacyType>| 
Then the user validates edit drug link     		      				
Examples:
		|zipCode|county						 |planType |planName					   |drugDosage      |quantity|drugFrequency|packages|pharmacyName         |pharmacyType| 
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |Lipitor TAB 10MG|30      |Every 1 month|1       |null                 |Preferred Mail Service Pharmacy|

		
@dceBlayer
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
Then the user click on Is my Provider Covered link of SNP plans and validate Rally Connect Get Started page
| Plan Name | <planName> |
| Plan Type | <plantype> |
Examples:
|zipCode|  county         | planType  | planName                   |
|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|
		