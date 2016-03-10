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
           | nonUsOtherTerrirtories |




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
