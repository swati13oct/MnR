@F100686
Feature: Mobile Shopping - Plan Summary Page - BLayer
@US638058
Scenario Outline: Plan Summary DCE integration
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to DCE and adds a drug
|Plan Name|<planName>|
|Drug Name|<drugName>|
And the user validates benefits table
|Drug Cost|<drugCost>|
 Examples:
		|zipCode|county						 |planType | planName                                           |drugName| drugCost |
		|90210  |Los Angeles County|MAPD       |AARP MedicareComplete SecureHorizons Plan 1 (HMO) |lipitor | $4,040.64|
	#	|33012  |Miami-Dade County |SNP        | Preferred Special Care Miami-Dade (HMO SNP)      |lipitor | $4,052.64|
	#	|33012  |Miami-Dade County |PDP        | AARP MedicareRx Preferred (PDP)                  |lipitor | $4,040.64|
		
		
		
@US656544 @sprint3 
Scenario Outline: Integration with Med Supp VPP
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
 Examples:
		|zipCode|county						 |planType | 
		|90210  |Los Angeles County|MS       |	

@US656550 @sprint3 @rightRail
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
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
@US656550 @sprint3 @rightRail
Scenario Outline: To validate chat now widget
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
 | PlanType | <planType> |	
And the user validates chat now widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
@US656550 @sprint3 @rightRail		
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
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |

@US656550 @sprint3 		
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
		|90210  |Los Angeles County|PDP        |	 Eva        | Zhong     |weixin.zhong@optum.com|

@US656943 @planYearToggle @sprint3
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

@US657089 @planSummary @sprint3 @workingScripts
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
 And the user should see plan count for the plan type seelcted	
  		
Examples:
		|zipCode|county						   |planType  | 
		|90210  |Los Angeles County  |ma        |
		|90210  |Los Angeles County  |pdp       |
	#	|33012  |Miami-Dade County   |snp       |								
		
@US657296 @sprint3 @workingScripts
Scenario Outline: To validate enroll in plan popup
Given the user is on the vpp portfolio page 
Then the user performs plan search using zipcode 
| Zip Code |<zipCode>|
| County   |<county> |
#Then user validates plan count for all plan types on plan summary page in AARP
Then the user navigates to the following plan type
| PlanType | <planType> |
And User validate Enroll now button is not displayed for SNP plans
Examples:
		|zipCode|county						   |planType   | 
		|33012  |Miami-Dade County   |SNP        |
		
@US646136 @sprint3 @snpPlanCard		
Scenario Outline: To validate plan benefits table
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates benefit table
  | Plan Name            | <planName>        |
  | MonthlyPremium			 |<monthlypremium>   |
  | PCP	                 | <primarycare>		        |
  | Specialist           | <specialist>	    |
  | ReferralRequired     |<referralRequired>	| 
  | Prescription Drugs   | <prescriptionDrug>| 
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP) |  $19.80       |$0           |  19              | No             |  25  |

@US657296 @benefittablema @test
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates benefit table for ma
  | Plan Name            | <planName>        |
  | MonthlyPremium		  |<monthlypremium>   |
  | PCP	                | <primarycare>		        |
  | Specialist          | <specialist>	    |
  | ReferralRequired    |<referralRequired>	| 
  | Prescription Drugs  | <prescriptionDrug>| 
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|85901 | Navajo County   |  ma     |UnitedHealthcare MedicareDirect Rx (PFFS)            |   $60        | $25         |  $50             |  No            |   $4 |

@US646136 @learnmore
Scenario Outline: To validate learnmore
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validate learn more button
| Plan Name| <planName> |
Examples:
|zipCode|county          |planType | planName                                            |  
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |  

@US670704 @rightRail	@sprint4	@workingScripts
Scenario Outline: To validate Need a step back from right rail on plan details
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |		
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates Need a step back in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
				

@US670704 @rightRail @sprint4 @workingScripts
Scenario Outline: To validate chat now widget on plan details
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
 | PlanType | <planType> |
 Then the user navigates to pan details page	
 |Plan Name| <planName>|
And the user validates chat now widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
@US670704  @rightRail	 @sprint4	@workingScripts
Scenario Outline: To validate need more informationon on plan details
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates need more information widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
@US670704 @rightRail		@sprint4 @workingScripts
Scenario Outline: To validate email widget on plan details pages
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site	
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |
Examples:
		|zipCode|county            |planType	|planName																						|  firstname  | lastname  | emailaddress |
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |	 Eva        | Zhong     |weixin.zhong@optum.com|
 
@US670717 @providerSearch @sprint4 @workingScripts
 Scenario Outline: To validate need more information on plan details
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates provider search page
Examples:
		|zipCode|county						 |planType  |planName					   |
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
@US646140 @connectormodel @sprint5 
Scenario Outline: To validate plan count from portfolio page
Given user navigated to connector model page
	|PlanTypeCriteria|<planTypeCriteria>|
And user validate connector model flow
 	|Plan Name		 |<planName>		|
And User clicks on change location
 Examples:	 
	  | planTypeCriteria |planName                                        |            
	  |	Endorsed         |UnitedHealthcare Group Medicare Advantage (PPO) |

@US674469	@sprint5
Scenario Outline: To validate Plan Documetns tab
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates plan Documents section
Examples:
		|zipCode|county						 |planType  |planName					                                  |
   	|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Essential (HMO)  |	
   	
@US674467 @optionalServices @sprint5 @workingScripts
Scenario Outline: To validate optional services
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And user validates optional services
|Optional Dental|<optionalDenatl>|
|High Optional Dental|<highOptionalDental>|
Examples:
		|zipCode|county						 |planType   |planName					                                    |optionalDenatl|highOptionalDental|
   	|90210  |Los Angeles County|MA         |AARP MedicareComplete SecureHorizons Plan 1 (HMO)     |true          |true| 
   	|90210  |Los Angeles County|MA         |AARP MedicareComplete SecureHorizons Plan 2 (HMO)     |true          |true| 
    			
 
 
 @US674468 @sprint5 @fnfUS674468 @notWorking
 Scenario Outline: To validate plan costs on plan details page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates plan costs	
|High Optional Dental|<highOptionalDental>|
|Optional Dental     |<optionalDental>|
Examples:
		|zipCode|county						 |planType   |planName					                                    |highOptionalDental|optionalDental|
		|90210  |Los Angeles County|MA         |AARP MedicareComplete SecureHorizons Plan 1 (HMO)     |true              |true          |
 
 @US670869 @addToCompareOnePlan
Scenario Outline: To validate add to compare checkbox message for first plan
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|			
Then the add to compare checkbox message should read 1 plan added, please select another plan to continue
Examples:
		|zipCode|county						 |planType  |planName					                                  |		
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |	
		
@US706738  	@msPlans
Scenario Outline: To validate med supp header and footer on plan summry page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates header and footer on plan summary page
Examples:
		|zipCode|county						     |planType   | 
		|99501  |Anchorage Municipality|MS         | 
  
 @US706784  @msPlans
Scenario Outline: To validate med supp plan on plan summary
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates header and footer on start application page
|PlanName|<planName>|
Examples:
		|zipCode|county						     |planType   |planName  |
		|99501  |Anchorage Municipality|MS         |Plan F    |
		|99501  |Anchorage Municipality|MS         |Plan G    |		  

@US706736   	@msPlans
Scenario Outline: To validate med supp plan header and footer on plan details page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates header and footer
Examples:
		|zipCode|county						     |planType   |planName  |
		|99501  |Anchorage Municipality|MS         |Plan F    |
		|99501  |Anchorage Municipality|MS         |Plan G    |		
		
@workingScripts
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


@workingScripts
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

@workingScripts
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


@workingScripts
Scenario Outline: To validate enroll now button not displayed for SNP
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And User validate Enroll now button is not displayed for SNP plans
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |  $29.10       |$0           |  20              | No             |  25  |	


@workingScripts
Scenario Outline: To validate benefit table for PFFS
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates benefit table for ma
  | Plan Name            | <planName>        |
  | MonthlyPremium		|<monthlypremium>   |
  | PCP	                | <primarycare>		        |
  | Specialist          | <specialist>	    |
  | ReferralRequired    |<referralRequired>	| 
  | Prescription Drugs  | <prescriptionDrug>| 
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|85901 | Navajo County   |  ma     |UnitedHealthcare MedicareDirect Rx (PFFS)            |   $60        | $25         |  $50             |  No            |   $4 |

Scenario Outline: To validate learn more button
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validate learn more button
| Plan Name| <planName> |
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |  $29.10       |$0           |  20              | No             |  25  |

@workingScripts
Scenario Outline: To validate enroll now link
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates enroll now link
|PlanName  |<planName>|

Examples:
    |zipCode|county						 |planType | planName |
		|90210  |Los Angeles County| MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	#	|33012  |Miami-Dade County | snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |
		|10002  |Miami-Dade County | PDP     |AARP MedicareRx Walgreens (PDP) |
    |90210  |Los Angeles County| MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
		|90210  |Los Angeles County| PDP     |AARP MedicareRx Preferred (PDP)  |