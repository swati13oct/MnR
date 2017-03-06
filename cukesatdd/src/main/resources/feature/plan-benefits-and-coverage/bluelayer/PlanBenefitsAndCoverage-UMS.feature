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
	|Medicare Part D Annual Deductible |
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
Given registered UHC with following details for plan benefits and coverage flow in UMS site
 	| Plan Type      			| PDP     					|
 	| Member Type     			| Group 					|
 	| Copay Category            | NON LIS               	|  
 	| Is Us Other Territories  | <isUsOtherTerritories>  	|
When the user navigates to plan benefits and Coverage in UMS site
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
    When registered UHC with following details for plan benefits and coverage flow in UMS site
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
Given registered member to login in UMS site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to benefits and coverage page under my plans in UMS site
Then the user validates pharmacy saver widget in UMS site

Examples:
	| plantype | memberType   |
	| MAPD     | Individual   |
	
@Q4
Scenario Outline:To validate the pharmacy saver widget in benefits and coverage page in UMS site
Given registered member to login in UMS site
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
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type      | MAPD  |
| Member Type     | Individual|
| Copay Category | NON LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to plan benefits and Coverage in UMS site
Then the user validates riders,benefit tiering and split tier deductibles 3,4,5 after login in UHC site
Examples:

| riderAvailableCheck |
#| riderAvailable       |
| riderNotAvailable    |

@mapdnonlisnonrider
Scenario Outline:To validate the coverage and benefit amounts in benefits and coverage page in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
       | Plan Type    |MAPD|
       | Member Type  |Individual|
       | Copay Category |NON LIS|  
       | Riders         | <riderAvailableCheck> |      
When the user navigates to plan benefits and Coverage in UMS site
Then the user validates riders after login in UHC site

Examples:
        | riderAvailableCheck |
	   |riderAvailable|
		#|riderNotAvailable|
		

@mapdnonlisrider
Scenario Outline:To validate the coverage and benefit amounts in benefits and coverage page in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
       | Plan Type    |MAPD|
       | Member Type  |Individual|
       | Copay Category |NON LIS|  
       | Riders         | <riderAvailableCheck> |      
When the user navigates to plan benefits and Coverage in UMS site
Then the user validates riders after login in UHC site

Examples:
        | riderAvailableCheck |
	   #|riderAvailable|
		|riderNotAvailable|
		
@marider
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type      | MA  |
| Member Type     | Individual|
| Copay Category |  LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to plan benefits and Coverage in UMS site
And the user validates riders after login in UHC site
Examples:

| riderAvailableCheck |
| riderAvailable       |
#| riderNotAvailable    |
		
@manonrider
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type      | MA  |
| Member Type     | Individual|
| Copay Category |  LIS               |  
| Riders         | <riderAvailableCheck> |
When the user navigates to plan benefits and Coverage in UMS site
And the user validates riders after login in UHC site
Examples:

| riderAvailableCheck |
#| riderAvailable       |
| riderNotAvailable    |

@Q4
Scenario Outline: Verify My Medical Costs & Benefits Summary in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
 | Plan Type      |MAPD  |
 | Member Type    |Individual|
 | Copay Category |NON LIS               |  
 | Riders         |<riderAvailableCheck> |
 When the user navigates to plan benefits and Coverage in UMS site
 Then the user validates My Optional Service and PDF links
 
  
 Examples:

| riderAvailableCheck |
| riderAvailable       |
#| riderNotAvailable    |

@US436849
Scenario Outline:To verify PCP text on plan and benefits page for members in UMS site
Given registered member to login in UMS site
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
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view benefits and coverage in UMS site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     |
        | SSRD     | NON LIS        | Group						| 

@outofp       
Scenario Outline: Verify benefits and coverage in UMS site for mapd and ma non lis with out of pocket
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view benefits and coverage in UMS site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     |
        | SSRD     |  NON LIS        | Group						| 
        


@officev      
Scenario Outline: Verify benefits and coverage in UMS site for mapd and ma non lis with office visits
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
| Member Type				 | <Member Type>	 |
| Plan Name					 | <plan Name>		 |
When the user view forms and resources in UMS site
Then the user view benefits and coverage in UMS site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |Member Type     | plan Name |
        | SSRD     | NON LIS        | Group					 | HMO       |
        
@dashboardfr       
Scenario Outline: Verify dashboard forms and resources for mapd and ma in UMS site
Given registered UHC with following details for plan benefits and coverage flow in UMS site
| Plan Type          | <planType>                |
| Member Type				 | <Member Type>						 |
When the user view forms and resources in UMS site
Then the user view mydocument in UMS site
Then the user validates the content on mydocument page
Then the user validates the backtopreviouspage link on mydocument page


Examples:
        |planType  |Member Type     |
        |MA        |Individual						| 

@bncfnf
Scenario Outline:To verify Add Plan link not available on plan and benefits page for members in UMS site
Given registered member to login in UMS site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
	| Group Type   | <groupType>  |
When the user navigates to benefits and coverage page under my plans in UMS site
Then validates that add plans tab is not available

Examples:

| planType | memberType | groupType |
#| MAPD     | Group      | ALPEEHIP  |
| MA			 | Group	  	| ALPEEHIP  |



@US463479
Scenario Outline: To verify pdfs displayed in forms and resources in UMS site
Given registered member to login in UMS site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to benefits and coverage page under my plans in UMS site
Then I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature

Examples:

| planType | memberType  |
| MA       |Individual |
| MAPD     |Individual |
