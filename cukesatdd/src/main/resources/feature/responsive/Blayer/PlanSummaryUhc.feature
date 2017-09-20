@planSummaryPage @sprint2
Feature: To verify mobile responsive
@planCount @sprint2
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

@planhighlights @failsprint2

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

@enrollPlan @sprint2
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

@dceBlayerE2E
Scenario Outline: To validate Edit Drug List link
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
 Then the user navigates to the following plan type
| PlanType | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    | Plan Name |<planName>  | 
 
And the user search the drug using drug initials in UHC site
    |lipi|	
And the user selects following drug in UHC site
		|lipitor|
And the user selects the following dosage information in UHC site
    |Drug Dosage|<drugDosage>|
    |Quantity   |<quantity>|
    |Drug Frequency|<drugFrequency>|
    |Packages|<packages>|
And the user selects the pharamacy and navigates to plan summary page 
    |Pharmacy Name|<pharmacyName>|
    |Pharamcy Type|<pharmacyType>| 
Then the user validates edit drug link     		      				
Examples:
		|zipCode|county						 |planType  |planName					                                 |drugDosage      |quantity|drugFrequency|packages|pharmacyName         |pharmacyType| 
		|33012  |Miami-Dade County |MA        |AARP MedicareComplete Choice Plan 2 (Regional PPO)|Lipitor TAB 10MG|30      |Every 1 month|1       |null                 |Preferred Mail Service Pharmacy|

		
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
|02210  | Suffolk County  | SNP        |UnitedHealthcare Senior Care Options (HMO SNP)| AEP        | 2017        | 2018       | 
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
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
		

@rightRail
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
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
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
		|90210  |Los Angeles County|PDP        |	 Eva        | Zhong     |weixin.zhong@optum.com|
		
@planCount12		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
 And the user should see plan count for the plan type seelcted	  		
Examples:
		|zipCode|county						 |planType | 
		|90210  |Los Angeles County|MA       |
		
		
@suplementPlan		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
 Examples:
		|zipCode|county						 |planType | 
		|90210  |Los Angeles County|MS       |	 
		

@addtocomparenotdisplayed 	
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And User validate add to compare is not displayed for SNP
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |  $29.10       |$0           |  20              | No             |  25  |




@enrollnowforsnpnotdisplayed
Scenario Outline: To validate plan count from portfolio page
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




@benefittable
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates benefit table
  | Plan Name            | <planName>        |
  | MonthlyPremium		|<monthlypremium>   |
  | PCP	                | <primarycare>		        |
  | Specialist          | <specialist>	    |
  | ReferralRequired    |<referralRequired>	| 
  | Prescription Drugs  | <prescriptionDrug>| 
Examples:
|zipCode|county          |planType | planName                                            |monthlypremium | primarycare |  specialist       |referralRequired| prescriptionDrug |
|33012 |Miami-Dade County| snp     |UnitedHealthcare Dual Complete RP (Regional PPO SNP)  |  $19.80      |$0           |  19              | No             |  25  |


@benefittablema
Scenario Outline: To validate benefit table
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


@learnmore
Scenario Outline: To validate plan count from portfolio page
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

@enrollNow
Scenario Outline: To validate plan count from portfolio page
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

@US689021
Scenario Outline: To validate plan compare functionality
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user goes back to plan summary by clicking Back to all Plans Link

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA     |

@US689345
Scenario Outline: To validate footnotes on Plan Compare Page
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user goes to footnotes section and validates it

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA     |


@US689475
Scenario Outline: To validate Medical Benefits section on Plan compare Page
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates Medical Benefits section

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA    |


@US689477
Scenario Outline: To validate Prescription Drugs Benefit Section on Plan Compare page
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates Prescription Drug Benefits section

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA    |


@connectormodel
Scenario Outline: To validate plan count from portfolio page
Given user navigated to connector model page
	|PlanTypeCriteria|<planTypeCriteria>|
And user validate connector model flow
 	|Plan Name		 |<planName>		|
And User clicks on change location
 Examples:	 
	  | planTypeCriteria |planName                                        |            
	  |	Endorsed         |UnitedHealthcare Group Medicare Advantage (PPO) |



@US689310 @sprint5
Scenario Outline: To validate DCE Section on Plan Compare page
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates DCE Section

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA     |

@US689260 @sprint5
Scenario Outline: To validate the Provider section is enabled
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates Provider Section is enabled

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA     |


@US702406 @sprint5
Scenario Outline: To validate that user should not be able to see add another plan option for zipcode having only 2 plans
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects the Plan to compare
Then user validates he is not displayed add another plan to compare option

Examples:
|zipCode|county          |planType|
|95545 |Humboldt County| MA     |


@US699059 @sprint5
Scenario Outline: To validate the Provider section is enabled
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates Inpatient Hospital Co-pay

Examples:
|zipCode|county          |planType|
|90210 |Los Angeles County| MA     |

@US699362 @sprint5
Scenario Outline: To validate the Provider section is enabled
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates PCP and Specialist Co-pay

Examples:
|zipCode|county          |planType|
|28682 |Alexander| MA     |


@US698836 @sprint5
Scenario Outline: To validate Outpatient Surgery row for AARPMedicareFocus Plans
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare
Then user validates Outpatient Surgery row for AARPMedicareFocus Plans

Examples:
|zipCode|county          |planType|
|32963 |Indian River| MA     |

@US689475 @US689478 @sprint5
Scenario Outline: To validate Medical Benefits section on Plan compare Page
Given the user is on the  team-c vpp portfolio page
Then the user performs plan search TeamC using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the TeamC plan type
| PlanType | <planType> |
And User selects Plans to compare generic
| Plan Name 1| <planName1> |
|Plan Name 2 |<planName2>|
Then the user validates medical benefits
      |MP Plan1|<mpPlan1>|
      |MP Plan2|<mpPlan2>|
      |Oop Plan1|<oopPlan1>|
      |Oop Plan2|<oopPlan2>|
 And the user validates optional services     
     |OD1 |<od1> |
     |HOD1| <hod1>| 
     |OD2 |<od2> |
     |HOD2| <hod2>|  

Examples:
|zipCode|county           |planType  |                planName1                           |              planName2                            |mpPlan1 |mpPlan2 |         oopPlan1  |oopPlan2           | od1   | od2  |hod1  | hod2|
|90210 |Los Angeles County| MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | AARP MedicareComplete SecureHorizons Plan 2 (HMO) | $0     |$0      |In-Network: $0     |In-Network: $0     |  $2.50| $2.50|$12.50|$2.50|


	
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
 Examples:
		|zipCode|county						 |planType | planName                                           |drugName|
		|90210  |Los Angeles County|MAPD       |AARP MedicareComplete SecureHorizons Plan 1 (HMO) |lipitor |
		|33012  |Miami-Dade County |SNP        | Preferred Special Care Miami-Dade (HMO SNP)      |lipitor |
		|33012  |Miami-Dade County |PDP        | AARP MedicareRx Preferred (PDP)                  |lipitor |
								