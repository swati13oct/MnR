@planSummaryPage
Feature: To verify mobile responsive
@planCount @sprint1
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

@planhighlights @sprint1
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

@enrollPlan @sprint1
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


@planYearToggle
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validate the Blue banner and plan year toggle
|Current Period |<curentPeriod>|
|CurrentYear|<currentYear>|
|FutureYear |<futureYear>|
|Plan Name  |<planName>|
Examples:
|zipCode|  county         | planType   | planName                                     | curentPeriod | currentYear | futureYear | 
|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)| AEP        | 2016        | 2017       | 
#|02210  | Suffolk County  | MA         |AARP MedicareComplete Plan 2 (HMO)            | AEP        | 2016        | 2017       | 

@rightRail		
Scenario Outline: To validate Need a step back from right rail
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |		
And the user validates Need a step back in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|

@rightRail
Scenario Outline: To validate chat now widget
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
And the user validates chat now widget in right rail widgets
| PlanType | <planType> |		
Examples:
		|zipCode|county						 |planType |planName					   |
		|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|
		
@rightRail		
Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
And the user validates need more information widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|
		
@rightRail		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site	
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |
Examples:
		|zipCode|county            |planType	|  firstname | lastname | emailaddress |
		|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|
		
		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
 And the user validates navigates plan selector page and validates the contents	  		
Examples:
		|zipCode|county						 |planType |planName					   |
		|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)|
