@bnc
Feature: To test plan benefits and Coverage on UMS site
Scenario Outline: Verify benefits and coverage for mapd individual nonlis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | MAPD  |
 | Member Type     | Individual|
 | Copay Category | NON LIS               |  
 | Riders         | <riderAvailableCheck> |

When the user navigates to benefits and Coverage
Then the user validates Consumer Information details in plan benefits and Coverage
	 | Member Number         | 
	 | Effective Date        |
	 | Monthly Premium |
And the user validates Medical Co-pays or Co-insurance in plan benefits and Coverage
	|Primary care provider| 
	|Specialist|
	|Inpatient hospital visits|
And the user validates Out-of-Pocket Maximum in plan benefits and Coverage
	|In-network|
	|Out-of-network|
And the user validatesMy Primary Care Provider in plan benefits and Coverage
        |KEOGH, M.D., RAYMOND J|
And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
  | Tier  Copays or Coinsurance Initial Coverage |
And the user validates no. of riders in Optional Services
And the user validates Rider information for the available riders 
	| Effective Date |
	| Termination Date|	
	| Rider Name				  |
	| Rider PDF Type Id			  |
And the user validates following Standard Network Pharmacy Retail Drug Costs details in drug copays & discounts
	  | Tier Standard Network Pharmacy Initial Coverage      |
	  | Tier Standard Network Pharmacy Coverage Gap          |
	  | Tier Standard Network Pharmacy Catastrophic Coverage |
	  | Annual Deductible|
And the user validates following Preferred Mail Service Pharmacy Drug Costs details in drug copays & discounts
  | Tier Preferred Mail Service Pharmacy Initial Coverage      |
  | Tier Preferred Mail Service Pharmacy Coverage Gap          |
  | Tier Preferred Mail Service Pharmacy Catastrophic Coverage |
  |  Annual Deductible                                         |
And the user validates Covered Drugs in plan benefits and Coverage
	|Medi Part D Annual Deductible |
And the user validates plan benefits highlights
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  | Comprehensive Formulary - Drug List_English   |


Examples:
		   | riderAvailableCheck |
 #                 | riderAvailable       |
#                  | riderNotAvailable    |




Scenario Outline: Verify benefits and coverage for mapd individual lis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | MAPD  |
 | Member Type     | Individual|
  | Copay Category | LIS               |  
 | Riders         | <riderAvailableCheck> |

When the user navigates to benefits and Coverage
Then the user validates Consumer Information details in plan benefits and Coverage
	 | Member ID        | 
	 | Effective Date        |
	 | Monthly Premium |
And the user validates Medical Co-pays or Co-insurance in plan benefits and Coverage
	|Primary care provider| 
	|Specialist|
	|Inpatient hospital visits|
And the user validates Out-of-Pocket Maximum in plan benefits and Coverage
	|In-network|
	|Out-of-network|
And the user validatesMy Primary Care Provider in plan benefits and Coverage
        |KEOGH, M.D., RAYMOND J|
And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
  |Covered generic drugs|
  |All other covered drugs|

And the user validates no. of riders in Optional Services
And the user validates Rider information for the available riders 	
	| Rider Name				  |
	| Rider PDF Type Id			  |
	| Rider Type				  |
 And the user validates the following Retail Drug Costs details in drug copays & discounts
    | Tier Initial Coverage      |
    | Tier Coverage Gap          |
    | Tier Catastrophic Coverage |
    | Annual Deductible          |
 And the user validates Covered Drugs in plan benefits and Coverage
	|Medicare Part D Annual Deductible |
And the user validates plan benefits highlights
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  | Comprehensive Formulary - Drug List_English   |


Examples:
		   | riderAvailableCheck |
#           | riderAvailable       |
#           | riderNotAvailable    |
	


Scenario Outline: Verify benefits and coverage for mapd group lis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | MAPD  |
 | Member Type     | Group |
  | Copay Category | LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates Plan Benefits and Coverage details
	 |Medical Deductible|
	 |Medical Out-of-Pocket Max|
	  | Member ID       | 
	 |Group ID|
	 | Effective Date        |
	 | Drug Deductible |
And the user validates summary of the benefits under the plan in plan benefits and Coverage
	|Primary care office visit co-pay/co-insurance|
	|Specialist visit co-pay/co-insurance|
	|Hospital inpatient co-pay/co-insurance|
	|Hospital outpatient co-pay/co-insurance|
	|Emergency co-pay/co-insurance|
	|Ambulance co-pay/co-insurance|
And the user validates Doctor choice in plan benefits and Coverage
          |HMO|
And the user validates prescription drug details in plan benefits and Coverage
    |copay and coinsurance|
    |initial coverage  |
    |covered drugs     |
    |estimate drug cost|
    |deductible       |
    
And the user validates My Resources and Plan Materials in plan benefits and Coverage
|Forms and Resources|	


Examples:
		   | riderAvailableCheck |
   #               | riderAvailable       |
 ##                  | riderNotAvailable    |




Scenario Outline: Verify benefits and coverage for mapd group nonlis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | MAPD  |
 | Member Type     | Group |
  | Copay Category | NON LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates Plan Benefits and Coverage details
	 |Medical Deductible|
	 |Medical Out-of-Pocket Max|
	  | Member ID       | 
	 |Group ID|
	 | Effective Date        |
	 | Drug Deductible |
And the user validates summary of the benefits in plan benefits and Coverage
	|Primary care office visit co-pay/co-insurance|
	|Specialist visit co-pay/co-insurance|
	|Hospital inpatient co-pay/co-insurance|
	|Hospital outpatient co-pay/co-insurance|
	|Emergency co-pay/co-insurance|
	|Ambulance co-pay/co-insurance|
And the user validates VISION in plan benefits and Coverage
         |Routine Eye Exams (refraction)|
          |Routine Eye Wear|
And the user validates DENTAL in plan benefits and Coverage
        |Routine Dental Exams|
And user validates following Standard Network Pharmacy Drug Costs details in drug copays & discounts
	  | Tier Standard Network Pharmacy Initial Coverage      |
	  | Tier Standard Network Pharmacy Coverage Gap          |
	  | Tier Standard Network Pharmacy Catastrophic Coverage |
	  | Tier Standard Network Pharmacy Annual Deductible |
And the user validates following Preferred Mail Service Drug Costs details in drug copays & discounts
  | Tier Preferred Mail Service Pharmacy Initial Coverage      |
  | Tier Preferred Mail Service Pharmacy Coverage Gap          |
  | Tier Preferred Mail Service Pharmacy Catastrophic Coverage |
   | Tier Preferred Mail Service Pharmacy Annual Deductible |
And the user validates My Resources and Plan Materials in plan benefits and Coverage
|Forms and Resources|	


Examples:
		   | riderAvailableCheck |
  #                 | riderAvailable       |
##                 | riderNotAvailable    |




Scenario Outline: Verify plan benefits and coverage for pdp group nonlis in UMS site
Given registered member with following details logins in the member portal 
 	| Plan Type      			| PDP     					|
 	| Member Type     			| Group 					|
 	| Copay Category            | NON LIS               	|  
 	| Is Us Other Territories  | <isUsOtherTerritories>  	|
When the user navigates to Benefits and coverage page
Then the user validates plan benefits and coverage details in UMS site
#Then the user validates customer details in UMS site
#	| Member ID  		| 
#	| Group ID   		|
#	| Effective Date    |
#	| Drug Deductible   |
#And the user validates summary of the benefits in UMS site
#	| Tier  Copays or Coinsurance Initial Coverage |
# And the user validates drugs covered in plan benefits and Coverage in UMS site
#	|Medicare Part D Annual Deductible |

#And user validates following Standard Network Pharmacy Drug Costs details in drug copays & discounts in UMS site
#	| Tier Standard Network Pharmacy Initial Coverage      |
#	| Tier Standard Network Pharmacy Coverage Gap          |
#	| Tier Standard Network Pharmacy Catastrophic Coverage |
#	| Tier Standard Network Pharmacy Annual Deductible     |
#And the user validates following Preferred Mail Service Drug Costs details in drug copays & discounts in UMS site
 # 	| Tier Preferred Mail Service Pharmacy Initial Coverage      |
 # 	| Tier Preferred Mail Service Pharmacy Coverage Gap          |
 # 	| Tier Preferred Mail Service Pharmacy Catastrophic Coverage |
 # 	| Tier Preferred Mail Service Pharmacy Annual Deductible     |

#And the user validates My Resources and Plan Materials in plan benefits and Coverage in UMS site
  	|Forms and Resources|	

Examples:
		   | isUsOtherTerritories   |
  #        | usOtherTerrirtories    |
  #         | nonUsOtherTerrirtories |




Scenario Outline: Verify benefits and coverage for pdp group lis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | PDP  |
 | Member Type     | Group |
  | Copay Category | LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates Plan Benefits and Coverage details
	   | Member ID       | 
	 |Group ID|
	 | Effective Date        |
	 | Drug Deductible |
And the user validates summary of the benefits in plan benefits and Coverage
	| Tier  Copays or Coinsurance Initial Coverage |
 And the user validates drugs covered in plan benefits and Coverage
	|Medicare Part D Annual Deductible |

And user validates following Standard Network Pharmacy Drug Costs details in drug copays & discounts
	  | Tier Standard Network Pharmacy Initial Coverage      |
	  | Tier Standard Network Pharmacy Coverage Gap          |
	  | Tier Standard Network Pharmacy Catastrophic Coverage |
	  | Tier Standard Network Pharmacy Annual Deductible |
And the user validates following Preferred Mail Service Drug Costs details in drug copays & discounts
  | Tier Preferred Mail Service Pharmacy Initial Coverage      |
  | Tier Preferred Mail Service Pharmacy Coverage Gap          |
  | Tier Preferred Mail Service Pharmacy Catastrophic Coverage |
   | Tier Preferred Mail Service Pharmacy Annual Deductible |

And the user validates My Resources and Plan Materials in plan benefits and Coverage
|Forms and Resources|	
	

Examples:
		   | riderAvailableCheck |
  #                 | riderAvailable       |
 #                | riderNotAvailable    |




Scenario Outline: Verify benefits and coverage for ma group lis in UMS site
Given registered UHC with following details for benefits and coverage flow
  | Plan Type      | MA  |
 | Member Type     | Group |
  | Copay Category | LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates Plan Benefits and Coverage details
	  |Medical Deductible|
	 |Medical Out-of-Pocket Max|
	  | Member ID       | 
	 |Group ID|
	 | Effective Date        |
And the user validates summary of the benefits in plan benefits and Coverage
	|Doctor choice|
	|Primary care office visit co-pay/co-insurance|
	|Specialist visit co-pay/co-insurance|
	|Hospital inpatient co-pay/co-insurance|
	|Hospital outpatient co-pay/co-insurance|
	|Emergency co-pay/co-insurance|
	|Ambulance co-pay/co-insurance|
And the user validates prescription drug details in plan benefits and Coverage
|Your Inital Coverage|
|Covered Drugs|
And the user validates My Resources and Plan Materials in plan benefits and Coverage
|Forms and Resources|	


Examples:
		   | riderAvailableCheck |
    #               | riderAvailable       |
   #              | riderNotAvailable    |



Scenario Outline: Verify benefits and coverage for ma individual nonlis in UMS site
Given registered UHC with following details for benefits and coverage flow
  | Plan Type      | MA                    |
  | Member Type     | Individual            |
  | Copay Category | NON LIS               |  
  | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage 
Then the user validates MA Consumer Information details in plan benefits and Coverage
	  | Member ID       | 
	 |Monthly Premium|
	 | Effective Date        |
And the user validates Medical Co-pays or Co-insurance in plan benefits and Coverage
	|Primary care provider| 
	|Specialist|
	|Inpatient hospital visits|
And the user validates Out-of-Pocket Maximum in plan benefits and Coverage
	|In-network|
	|Out-of-network|
And the user validatesMy Primary Care Provider in plan benefits and Coverage
        |REAGAN, M.D., J THOMAS|
And the user validates no. of riders in Optional Services
And the user validates Rider information for the available riders 
	| Rider Name				  |
	| Rider PDF 			  |
And the user validates plan benefits highlights
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  

Examples:
		   | riderAvailableCheck |
    #              | riderAvailable       |
    #             | riderNotAvailable    |



Scenario Outline: Verify benefits and coverage for ma individual lis in UMS site
Given registered UHC with following details for benefits and coverage flow
  | Plan Type      | MA        |
 | Member Type     | Individual |
  | Copay Category | LIS       |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates MA Consumer Information details in plan benefits and Coverage
	  | Member ID       | 
	 |Monthly Premium|
	 | Effective Date        |
And the user validates Medical Co-pays or Co-insurance in plan benefits and Coverage
	|Primary care provider| 
	|Specialist|
	|Inpatient hospital visits|
	|Outpatient Surgery Center visits|
And the user validates Out-of-Pocket Maximum in plan benefits and Coverage
	|In-network|
	|Out-of-network|
And the user validatesMy Primary Care Provider in plan benefits and Coverage
        |KRAMER, M.D., JUDITH|
And the user validates no. of riders in Optional Services
And the user validates Rider information for the available riders 
	| Rider Name				  |
	| Rider PDF 			  |
And the user validates plan benefits highlights
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  

Examples:
		   | riderAvailableCheck |
    #              | riderAvailable       |
    #             | riderNotAvailable    |





Scenario Outline: Verify benefits and coverage for ssup group nonlis in UMS site
Given registered UHC with following details for benefits and coverage flow
 | Plan Type      | SSUP  |
 | Member Type     | Group |
  | Copay Category | NON LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage
Then the user validates Consumer Information details in plan benefits and Coverage
	 | Member ID       | 
	 |Group ID|
	 | Effective Date        |
	 |Medical Deductible|
	 | Medical Out-of-Pocket Max |
And the user validates summary of the benefits under the plan in plan benefits and Coverage
	|Doctor choice|
	|Primary care office visit co-pay/co-insurance|
	|Specialist visit co-pay/co-insurance|
	|Hospital inpatient co-pay/co-insurance|
	|Hospital outpatient co-pay/co-insurance|
	|Emergency co-pay/co-insurance|
	|Ambulance co-pay/co-insurance|
And the user validates Out-of-Pocket Maximum in plan benefits and Coverage
	|In-network|
And the user validates My Resources and Plan Materials in plan benefits and Coverage
|Forms and Resources|	


Examples:
		   | riderAvailableCheck |
   #                | riderAvailable       |
    #               | riderNotAvailable    |

    
     
    
  # The below scenario to cover validate pdfs links section after in member area  
  Scenario Outline: To verify login in UHC site
    Given the user is on the UHC medicare site login page
    When registered member with following details logins in the member portal 
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |    
    Then the user validatespdf links after login in UHC site
    
    Then valiadte the actual and expected data of bluelayer benefets and coverage pdfs
    Examples: 
      | planType | memberType |
     # | MA       | Individual |
      #	| MA       | Group      |
      #| MAPD     | Individual |
      #| MAPD     | Individual |
@Q4
Scenario Outline:To validate the pharmacy saver widget in benefits and coverage page in UMS site
Given registered member with following details logins in the member portal 
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to benefits and coverage page under my plans in UMS site
Then the user validates pharmacy saver widget in UMS site

Examples:
	| plantype | memberType   |
	| MAPD     | Individual   |
	
@Q4
Scenario Outline:To validate the pharmacy saver widget in benefits and coverage page in UMS site
Given registered member with following details logins in the member portal 
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to benefits and coverage page under my plans in UMS site
Then the user validates drug cost table in UMS site

Examples:
	| plantype | memberType   |
	| MAPD     | Group        |
	| PDP      | Group        |
	| MAPD     | Individual   |


@benefitAndCoverage
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered member with following details logins in the member portal 
| Plan Type      | MAPD  |
| Member Type     | Individual|
| Copay Category | NON LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to Benefits and coverage page
Then the user validates riders,benefit tiering and split tier deductibles 3,4,5 after login in UHC site
Examples:

| riderAvailableCheck |
#| riderAvailable       |
| riderNotAvailable    |

@mapdnonlisnonrider
Scenario Outline:To validate the coverage and benefit amounts in benefits and coverage page in UMS site
Given registered member with following details logins in the member portal 
       | Plan Type    |MAPD|
       | Member Type  |Individual|
       | Copay Category |NON LIS|  
       | Riders         | <riderAvailableCheck> |      
When the user navigates to Benefits and coverage page
Then the user validates riders after login in UHC site

Examples:
        | riderAvailableCheck |
	   |riderAvailable|
		#|riderNotAvailable|
		

@mapdnonlisrider
Scenario Outline:To validate the coverage and benefit amounts in benefits and coverage page in UMS site
Given registered member with following details logins in the member portal 
       | Plan Type    |MAPD|
       | Member Type  |Individual|
       | Copay Category |NON LIS|  
       | Riders         | <riderAvailableCheck> |      
When the user navigates to Benefits and coverage page
Then the user validates riders after login in UHC site

Examples:
        | riderAvailableCheck |
	   #|riderAvailable|
		|riderNotAvailable|
		
@marider
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered member with following details logins in the member portal 
| Plan Type      | MA  |
| Member Type     | Individual|
| Copay Category |  LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to Benefits and coverage page
And the user validates riders after login in UHC site
Examples:

| riderAvailableCheck |
| riderAvailable       |
#| riderNotAvailable    |
		
@manonrider
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered member with following details logins in the member portal 
| Plan Type      | MA  |
| Member Type     | Individual|
| Copay Category |  LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to Benefits and coverage page
And the user validates riders after login in UHC site
Examples:

| riderAvailableCheck |
#| riderAvailable       |
| riderNotAvailable    |

@Q4
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered member with following details logins in the member portal 
 | Plan Type      |MAPD  |
 | Member Type    |Individual|
 | Copay Category |NON LIS               |  
 | Riders         |<riderAvailableCheck> |
 When the user navigates to Benefits and coverage page
 Then the user validates My Optional Service and PDF links
 
  
 Examples:

| riderAvailableCheck |
| riderAvailable       |
#| riderNotAvailable    |

@US436849
Scenario Outline:To verify PCP text on plan and benefits page for members in UMS site
Given registered member with following details logins in the member portal 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates directly to plan benefits and Coverage in UMS site
Then the user validates PCP

Examples:

| planType | memberType  |
#| MA   |Individual |
#| MAPD     |Individual |
| MAPD     | Group    |
| MA     | Group    |
#| PDP      | Group    |
| SSUP     | Group    |


@hospital       
Scenario Outline: Verify benefits and coverage in UMS site for mapd and ma non lis with hospital visits
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>						 |
When the user navigates to Benefits and coverage page
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     |
        | SSRD     | NON LIS        | Group						| 

@outofp       
Scenario Outline: Verify benefits and coverage in UMS site for mapd and ma non lis with out of pocket
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>						 |
When the user navigates to Benefits and coverage page
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     |
        | SSRD     |  NON LIS        | Group						| 
        


@officev      
Scenario Outline: Verify benefits and coverage in UMS site for mapd and ma non lis with office visits
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>	 |
| Plan Name					 | <plan Name>		 |
When the user navigates to Benefits and coverage page
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     | plan Name |
        | SSRD     | NON LIS        | Group					 | HMO       |
        
@dashboardfr       
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the content on mydocument page


Examples:
        |planType  |Member Type     |
        |MAPD        |Individual						| 
        
@backtopre       
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the content on mydocument page
Then the user validates the backtopreviouspage link on mydocument page in UMS site


Examples:
        |planType  |Member Type     |
        |MAPD        |Individual						| 
        
@udocdownload       
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the custom search on mydocument page
Then the user validates the content on mydocument page
Then the user validates the view/download link on mydocument page


Examples:
        |planType  |Member Type     |
        |MAPD        |Individual				| 
        


@docpagination
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the pagination link on mydocument page
Then the user validates the content on mydocument page

Examples:
        |planType  |Member Type     |
        |MAPD        |Individual			| 

        
@docsorting
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the sorting link on mydocument page
Then the user validates the content on mydocument page

Examples:
        |planType  |Member Type     |
        |MAPD        |Individual    | 




@bncfnf
Scenario Outline:To verify Add Plan link not available on plan and benefits page for members in UMS site
Given registered member with following details logins in the member portal 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
	| Group Type   | <groupType>  |
When the user navigates to Benefits and coverage page
Then validates that add plans tab is not available

Examples:

| planType | memberType | groupType |
| MAPD     | Group      | ALPEEHIP  |
#| MA			 | Group	  	| ALPEEHIP  |



@US463479

Scenario Outline: To verify pdfs displayed in forms and resources in UMS site

Given registered member with following details logins in the member portal 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to Benefits and coverage page
Then I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature

Examples:

| planType | memberType  |
| MA       |Individual |
| MAPD     |Individual |

Scenario Outline: Verify benefits and coverage in AARP site for G01 Ship member
Given registered member with following details logins in the member portal 
| Plan Type          | <planType>                | 
| Plan Group         | <planGroup>               |
And the user navigates to plan benefits and coverage and validates summary left row for G01      
|Sequence Ref Num 1-4  |<sequenceRefNum1-4>  |
|Sequence Ref Num 5    |<sequenceRefNum5>    |
|Sequence Ref Num 6-8  |<sequenceRefNum6-8>  |
|Sequence Ref Num 9    |<sequenceRefNum9>    |
|Sequence Ref Num 10   |<sequenceRefNum10>   |
|Sequence Ref Num 11-12|<sequenceRefNum11-12>|
|Sequence Ref Num 13   |<sequenceRefNum13>   |
And the user navigates to plan benefits and coverage and validates summary right row for G01
|Benefit Text 1 |<benefitText1>  |
|Benefit Text 2 |<benefitText2>  |
|Benefit Text 3 |<benefitText3>  |
|Benefit Text 4 |<benefitText4>  |
|Benefit Text 5 |<benefitText5>  |
|Benefit Text 6 |<benefitText6>  |
|Benefit Text 7 |<benefitText7>  |
|Benefit Text 8 |<benefitText8>  |
|Benefit Text 9 |<benefitText9>  |
|Benefit Text 10|<benefitText10> |
|Benefit Text 11|<benefitText11> |
|Benefit Text 12|<benefitText12> |
|Benefit Text 13|<benefitText13> |

Examples:
|planType  |planGroup|sequenceRefNum1-4|sequenceRefNum5                              |sequenceRefNum6-8             |sequenceRefNum9 |sequenceRefNum10                             |sequenceRefNum11-12  |sequenceRefNum13                   |benefitText1    |benefitText2     |benefitText3           |benefitText4            |benefitText5                    |benefitText6|benefitText11                        |benefitText12         |benefitText13                |
| SHIP     | G01     |Hospital stays   |Blood or packed red blood cells under Part A |Skilled nursing facility stays|Hospice care    |Blood or packed red blood cells under Part B |Medical care                          |Emergency care in foreign countries|For days 1 - 60 |For days 61 - 90 |For days 91 and beyond |For days 91 and greater | will pay Medicare Part A costs |Since Medicare covers days 1 - 20 |For days 21 - 100 |Must follow a hospital stay |Hospice Care and Respite Care |Medicare Part B costs not covered |20% of the Medicare-eligibleexpense |Part B Excess charge  | $250 emergency medical care |

@needHelpums
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
    When the user navigates to Benefits coverage page
    And the user validates the content on benefits and coverage page
    And the user validates contactus section
    And the user validates Needhelp header and disclaimer link
    And the user clicks on Disclaimers link
    
    Examples: 
      | planType | 
      | MA       |


@contactussection
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage pageR
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type     | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page     
    And the user validates contactus section
    
    Examples: 
      | planType | memberType| copayCategory |
      | MAPD     | Group     |     NON LIS   |
      
@disclaimersection
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type     | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    And the user validates Needhelp header and disclaimer header
    
    
    Examples: 
      | planType | memberType| copayCategory |
      | MAPD     | Group     |     NON LIS   |

      

      
  @validatePdfsectiongroupenglish
      Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates the content on benefits and coverage page
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default should be English
   
     Examples:
      
      | planType|  memberType  | copayCategory |
      | MAPD    |  Group       |  NON LIS      | 
      | MA      |  Group       |  LIS 1        |
      | PDP     |  Group       |  NON LIS      |
      ##q2_jun_grp340


 @validatePdfsectiongroupspanishchinese
    Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates the content on benefits and coverage page
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
 
     Examples:
      
      | planType|  memberType  | copayCategory |
      | MAPD    |  Group       |  NON LIS      | 

 @validatePdfsectionindividual
    Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates the content on benefits and coverage page
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
 
     Examples:
      
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      | MA      |  Individual  |  LIS 1        |
      | PDP     |  Individual  |  NON LIS      |
      
 @Ancillarysecjenkins
   Scenario Outline: Verify Ancilliary section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
    When the user navigates to Benefits coverage page
    And the user validates the content on benefits and coverage page
    Then the user validates Header section
    Then the user validates Hearing section
    Then the user validates the Hearing Aid section
    Then the user validates the Vision section
    Then the user validates the Dental section
    Then the user validates chiropractic section
    
     Examples: 
      | planType | 
      | Group    | 
      #| GroupPDP | 
      | GroupMA  |
     
      
   @drugcopaysectionnonlis
    Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates the content on benefits and coverage page
    And the user view the Drug Copays & Discounts header 
    And the user validates the Learn More section link for stage and tier
    #And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates plandocumentsection and Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    #And the user should see drug copay and discount table
    Examples: 
      | planType|  memberType  | copayCategory |
      | PDP     |  Group       |  NON LIS      |
      | MAPD    |  Group       |  NON LIS      |
      | MAPD    |  Individual  |  NON LIS      |
      ##q3_sep_blayer001
      ##q3_sep_grp285
      ##q3_sep_grp004
      
    @drugcopaysectionlis
    Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates the content on benefits and coverage page
    And the user view the Drug Copays & Discounts header 
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display 
    #And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates plandocumentsection and Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    #And the user should see drug copay and discount table
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |   LIS 1       |
      | MAPD    |  Group       |   LIS 3       |
      | PDP     |  Group       |   LIS 2       |     
      ##q3_sep_blayer006
      ##q3_sep_grp271
      ##q3_sep_grp324
      
      

    @drugcosttablesectiongroupmemberlis
    Scenario Outline: Verify that drug cost table  is in place on Benefits and Coverage page for LIS Members
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user view the Drug Copays & Discounts header 
    And the user should see drug cost table for Lis members
    Examples: 
      | planType|  memberType  | copayCategory|
      | PDP     |  Group       |  LIS         |
     # | MAPD    |  Group       |  LIS 1       |
      
      
      
    @PlanOverview
    Scenario Outline: Verify that drug cost table  is in place on Benefits and Coverage page for LIS Members
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>| 
    Then the user navigates to Benefits and coverage page

    And the user validates plan overview section 

    Examples: 
      | planType|  memberType  | 
      | MAPD    |  Group       | 
      
 
       
    @BncHeadersIndividual
     Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
       | Plan Type      | <planType>     |
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for indi members
     Examples: 
    | planType|
    | MAPD    |
    | MA    |
    
     
     @BncHeadersGroup
     Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
        | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for group members
    
     Examples: 
  | planType|  memberType  | copayCategory |
  | PDP     |  Group       |  NON LIS      |
  | MAPD    |  Group       |  NON LIS      | 
      
      
  @PlanOverviewNonLis
    Scenario Outline: Verify that Plan Overview  is in place on Benefits and Coverage page for Non LIS Members
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates plan overview section 

    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      #| MA      |  Individual  |  NON LIS      |
     | MAPD    |  Group       |  NON LIS      |
     | PDP     |  Group       |  NON LIS      |  
      
      @PlanOverviewLis
    Scenario Outline: Verify that Plan Overview is in place on Benefits and Coverage page for LIS Members
    Given registered member with following details logins in the member portal 
       | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates plan overview section for a Lis member

    Examples: 
    | planType|  memberType  | copayCategory |
    | MAPD    |  Individual  |   LIS 1       |
    | MAPD    |  Group       |   LIS 3       |
    
    

   @PrimaryCareProviderIndi
    Scenario Outline: Verify the Promary Care provider  is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
       | Plan Type      | <planType>     |
    Then the user navigates to Benefits and coverage page    
    And the user validates the Primarycare Provider section
    
      Examples: 
    | planType|
    | MAPD    |
    | MA      |
   
    
    
   @PrimaryCareProviderGroup
    Scenario Outline: Verify the Promary Care provider  is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
    | Plan Type          | <planType>   |
| Member Type				 | <Member Type>	  |
| Plan Name					 | <plan Name>		  |
    Then the user navigates to Benefits and coverage page    
    And the user validates the Primarycare Provider section for Group
    Examples:
        |planType  |Member Type     | plan Name |
        | MAPD     | Group				 | HMO       |
        | MAPD     | Group				 | PPO       |
        | MA     | Group					 | HMO       |    
        | MA     | Group					 | PPO       |
    
   
    
      
 
      
      
  
      
      
    
    

