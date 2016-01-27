@BnCTest1
Feature: To test plan benefits and Coverage on AARP site for Federal members
Scenario Outline: Verify benefits and coverage in AARP site for MAPD NON LIS member
Given registered AMP with following details for benefits and coverage flow in AARP site
 | Plan Type      | MAPD                  |
 | Copay Category | NON LIS               |  
 | Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage in AARP site
Then the user validates following Consumer Information details in plan benefits and Coverage
  | Member Number         | 
  | Effective Date        |
  | Primary Care Provider |
  
And the user validates following Premium details in plan benefits and Coverage
  | Monthly Premium         |
  | Late Enrollment Penalty |
And the user validates following Medical Co-pays or Co-insurance and Out-of-Pocket Maximum Details in medical benefits
  | Primary care provider      |
  | Specialist                 |
  | Inpatient hospital visits  |
  | In-network                 |
  | Out-of-network             |    
And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
  | Tier  Copays or Coinsurance Initial Coverage |

And the user validates no. of riders in Optional Services

And the user validates Rider information for the available riders
  	| Rider Premium				  |
	| Rider Marketing Description |
	| Rider GPS Plan Code		  |
	| Rider Id					  |
	| Rider Name				  |
	| Rider Type				  |
	| Rider PDF Type Id			  |
      
And the user validates all tier Annual deductible
  | All tier annual deductible |

And the user validates following Standard Network Pharmacy Retail Drug Costs details in drug copays & discounts
	  | Tier Standard Network Pharmacy Initial Coverage      |
	  | Tier Standard Network Pharmacy Coverage Gap          |
	  | Tier Standard Network Pharmacy Catastrophic Coverage |

And the user validates following Preferred Mail Service Pharmacy Drug Costs details in drug copays & discounts
  | Tier Preferred Mail Service Pharmacy Initial Coverage      |
  | Tier Preferred Mail Service Pharmacy Coverage Gap          |
  | Tier Preferred Mail Service Pharmacy Catastrophic Coverage |

And the user validates plan benefits highlights
  | Why Enroll Summary  |
     	
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  | Comprehensive Formulary - Drug List_English   |

And the user validates preferred tier deductible in case of split tier plan
  | Preferred Tier Deductible |
   	 
Examples:

   | riderAvailableCheck  |
#   | riderAvailable       | 
#   | riderNotAvailable    | 
 
Scenario Outline: Verify benefits and coverage in AARP site for MAPD LIS member
Given registered AMP with following details for benefits and coverage flow in AARP site
 | Plan Type      | MAPD                  |
 | Copay Category | LIS                   |  
 | Riders         | <riderAvailableCheck> |

When the user navigates to benefits and Coverage in AARP site
Then the user validates following Consumer Information details in plan benefits and Coverage
  | Member Number         | 
  | Effective Date        |
  | Primary Care Provider |
And the user validates following Premium details in plan benefits and Coverage
  | Monthly Premium         |
  | Late Enrollment Penalty |
And the user validates following Medical Co-pays or Co-insurance and Out-of-Pocket Maximum Details in medical benefits
  | Primary care provider      |
  | Specialist                 |
  | Inpatient hospital visits  |
  | In-network                 |
  | Out-of-network             |    
And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
  | Tier  Copays or Coinsurance Initial Coverage |

And the user validates no. of riders in Optional Services

And the user validates Rider information for the available riders
  	| Rider Premium				  |
	| Rider Marketing Description |
	| Rider GPS Plan Code		  |
	| Rider Id					  |
	| Rider Name				  |
	| Rider Type				  |
	| Rider PDF Type Id			  |
      
And the user validates all tier Annual deductible
  | All tier annual deductible |
 
 And the user validates the following Retail Drug Costs details in drug copays & discounts
    | Tier Initial Coverage      |
    | Tier Coverage Gap          |
    | Tier Catastrophic Coverage |
	
And the user validates plan benefits highlights
  	| Why Enroll Summary  |
     	
And the user validates following Resources and Plan Materials Details
	  | Summary of Benefits_English                   |
	  | Evidence of Coverage_English                  |
	  | Comprehensive Formulary - Drug List_English   |

And the user validates preferred tier deductible in case of split tier plan
     | Preferred Tier Deductible |
 
 Examples:
     | riderAvailableCheck  |
#     | riderAvailable       |
#     | riderNotAvailable    |

Scenario Outline: Verify benefits and coverage in AARP site for MA LIS member
Given registered AMP with following details for benefits and coverage flow in AARP site
 	| Plan Type      | <planType>            |
 	| Copay Category | <copayCategory>       |  
 	| Riders         | <riderAvailableCheck> |
When the user navigates to benefits and Coverage in AARP site
Then the user validates following Consumer Information details in plan benefits and Coverage
  | Member Number         | 
  | Effective Date        |
  | Primary Care Provider |
  
And the user validates following Premium details in plan benefits and Coverage
  | Monthly Premium         |
  | Late Enrollment Penalty |

And the user validates following Medical Co-pays or Co-insurance and Out-of-Pocket Maximum Details in medical benefits
  | Primary care provider      |
  | Specialist                 |
  | Inpatient hospital visits  |
  | In-network                 |
  | Out-of-network             |       

And the user validates no. of riders in Optional Services

And the user validates Rider information for the available riders
  	| Rider Premium				  |
	| Rider Marketing Description |
	| Rider GPS Plan Code		  |
	| Rider Id					  |
	| Rider Name				  |
	| Rider Type				  |
	| Rider PDF Type Id			  |

And the user validates all tier Annual deductible
  | All tier annual deductible |
  
And the user validates plan benefits highlights
  | Why Enroll Summary  |

And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
 

Examples:
        | planType | copayCategory | riderAvailableCheck | 
#        | MA       | LIS           | riderNotAvailable   | 
#	    | MA       | NON LIS       | riderNotAvailable   | 
#	    | MA       | NON LIS       | riderAvailable      | 
#	    | MA       | LIS           | riderAvailable      | 
		
Scenario Outline: Verify plan benefits and coverage in AARP site for PDP NON LIS member
Given registered AMP with following details for plan benefits and coverage flow in AARP site
 | Plan Type          | <planType>                |
 | Copay Category     | <copayCategory>           |  
 | UsOtherTerritories | <usOtherTerritoriesCheck> |    
When the user navigates to plan benefits and coverage in AARP site
Then the user validates plan benefits and coverage of the member in AARP site
Examples:
        |planType | usOtherTerritoriesCheck | copayCategory  |
        | PDP     | NotUsOtherTerritories   | NON LIS        |
#       | PDP     | usOtherTerritories      | NON LIS        |

	   
	   
Scenario Outline: Verify benefits and coverage in AARP site for PDP LIS member
Given registered AMP with following details for benefits and coverage flow in AARP site
 | Plan Type          | <planType>                |
 | Copay Category     | <copayCategory>           |  
 | UsOtherTerritories | <UsOtherTerritoriesCheck> |    

When the user navigates to benefits and Coverage in AARP site
Then the user validates following Consumer Information details in plan benefits and Coverage
  | Member Number         | 
  | Effective Date        |

And the user validates following Premium details in plan benefits and Coverage
  | Monthly Premium         |
  | Late Enrollment Penalty |

And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
  | Tier  Copays or Coinsurance Initial Coverage |
 
And the user validates following Standard Network Pharmacy Retail Drug Costs details in drug copays & discounts
	  | Tier Standard Network Pharmacy Initial Coverage      |
	  | Tier Standard Network Pharmacy Coverage Gap          |
	  | Tier Standard Network Pharmacy Catastrophic Coverage |

And the user validates following Preferred Mail Service Pharmacy Drug Costs details in drug copays & discounts
  | Tier Preferred Mail Service Pharmacy Initial Coverage      |
  | Tier Preferred Mail Service Pharmacy Coverage Gap          |
  | Tier Preferred Mail Service Pharmacy Catastrophic Coverage |
  
 And the user validates following Preferred Retail Pharmacy Drug Costs details in drug copays & discounts
  | Tier Preferred Retail Pharmacy Initial Coverage      |
  | Tier Preferred Retail Pharmacy Coverage Gap          |
  | Tier Preferred Retail Pharmacy Catastrophic Coverage |

And the user validates all tier Annual deductible
  | All tier annual deductible |
  
And the user validates following Resources and Plan Materials Details
  | Summary of Benefits_English                   |
  | Evidence of Coverage_English                  |
  | Comprehensive Formulary - Drug List_English   |

Examples:
       |planType | UsOtherTerritoriesCheck | copayCategory |
#       | PDP     | NotUsOtherTerritories   | LIS           |
#       | PDP     | usOtherTerritories      | LIS           |


Scenario Outline: Verify benefits and coverage in AARP site for MS member
Given registered AMP with following details for benefits and coverage flow in AARP site
    | Plan Type | <planType> |
When the user navigates to benefits and Coverage in AARP site
Then the user validates following consumer details
    | Member Number   | 
    | Effective Date  |
And the user validates following benefits	
    | plan Benefits |	
And the user validates following Plan Benefits Documents
   | Plan Benefits Table (PDF)    |
   | Plan Overview (PDF)          |
   
   Examples:
   | planType |
#   | MS       |
      
Scenario Outline: Verify benefits and coverage in AARP site for HIP member
Given registered AMP with following details for benefits and coverage flow in AARP site
    | Plan Type | <planType> |
When the user navigates to benefits and Coverage in AARP site
Then the user validates following consumer details
    | Member Number  | 
    | Effective Date |
And the user validates following benefits
    | plan Benefits |	
And the user validates following Plan Benefits Documents
   | Privacy Authorization | 
   
   Examples:
   | planType |
#   | HIP      |

Scenario Outline: create rider in AARP site
Given registered AMP with following details for benefits and coverage flow in AARP site
	| Plan Type      | <planType>            |
	| Copay Category | LIS                   |
	| Riders         | <riderAvailableCheck> |
	
When the user navigates to benefits and Coverage in AARP site
And user adds a rider in AARP site
Then the user validates create rider in AARP site
		

Examples:
		| planType | riderAvailableCheck  | 
#		| MAPD    |  riderAvailable       | 
		



Scenario Outline: remove rider in AARP site
Given registered AMP with following details for benefits and coverage flow
	| Plan Type      | <planType>            |
	| Copay Category | LIS                   |
	| Riders         | <riderAvailableCheck> |

When the user navigates to benefits and Coverage in AARP site
And user removes a rider in AARP site
Then the user validates remove rider in AARP site
		

Examples:
		| planType | riderAvailableCheck  |
#		| MA      |  riderAvailable       |
		
		