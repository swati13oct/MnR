@bnc
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
      | Primary care provider     |
      | Specialist                |
      | Inpatient hospital visits |
      | In-network                |
      | Out-of-network            |
    And the user validates following Drug Co-pays or Co-insurance Details in dr	ug benefits
      | Tier  Copays or Coinsurance Initial Coverage |
    And the user validates no. of riders in Optional Services
    And the user validates Rider information for the available riders
      | Rider Premium               |
      | Rider Marketing Description |
      | Rider GPS Plan Code         |
      | Rider Id                    |
      | Rider Name                  |
      | Rider Type                  |
      | Rider PDF Type Id           |
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
      | Why Enroll Summary |
    And the user validates following Resources and Plan Materials Details
      | Summary of Benefits_English                 |
      | Evidence of Coverage_English                |
      | Comprehensive Formulary - Drug List_English |
    And the user validates preferred tier deductible in case of split tier plan
      | Preferred Tier Deductible |

    Examples: 
      | riderAvailableCheck |

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
      | Primary care provider     |
      | Specialist                |
      | Inpatient hospital visits |
      | In-network                |
      | Out-of-network            |
    And the user validates following Drug Co-pays or Co-insurance Details in drug benefits
      | Tier  Copays or Coinsurance Initial Coverage |
    And the user validates no. of riders in Optional Services
    And the user validates Rider information for the available riders
      | Rider Premium               |
      | Rider Marketing Description |
      | Rider GPS Plan Code         |
      | Rider Id                    |
      | Rider Name                  |
      | Rider Type                  |
      | Rider PDF Type Id           |
    And the user validates all tier Annual deductible
      | All tier annual deductible |
    And the user validates the following Retail Drug Costs details in drug copays & discounts
      | Tier Initial Coverage      |
      | Tier Coverage Gap          |
      | Tier Catastrophic Coverage |
    And the user validates plan benefits highlights
      | Why Enroll Summary |
    And the user validates following Resources and Plan Materials Details
      | Summary of Benefits_English                 |
      | Evidence of Coverage_English                |
      | Comprehensive Formulary - Drug List_English |
    And the user validates preferred tier deductible in case of split tier plan
      | Preferred Tier Deductible |

    Examples: 
      | riderAvailableCheck |

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
      | Primary care provider     |
      | Specialist                |
      | Inpatient hospital visits |
      | In-network                |
      | Out-of-network            |
    And the user validates no. of riders in Optional Services
    And the user validates Rider information for the available riders
      | Rider Premium               |
      | Rider Marketing Description |
      | Rider GPS Plan Code         |
      | Rider Id                    |
      | Rider Name                  |
      | Rider Type                  |
      | Rider PDF Type Id           |
    And the user validates all tier Annual deductible
      | All tier annual deductible |
    And the user validates plan benefits highlights
      | Why Enroll Summary |
    And the user validates following Resources and Plan Materials Details
      | Summary of Benefits_English  |
      | Evidence of Coverage_English |

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
      | planType | usOtherTerritoriesCheck | copayCategory |
      | PDP      | NotUsOtherTerritories   | NON LIS       |

  #       | PDP     | usOtherTerritories      | NON LIS        |
  Scenario Outline: Verify benefits and coverage in AARP site for PDP LIS member
    Given registered AMP with following details for benefits and coverage flow in AARP site
      | Plan Type          | <planType>                |
      | Copay Category     | <copayCategory>           |
      | UsOtherTerritories | <UsOtherTerritoriesCheck> |
    When the user navigates to benefits and Coverage in AARP site
    Then the user validates following Consumer Information details in plan benefits and Coverage
      | Member Number  |
      | Effective Date |
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
      | Summary of Benefits_English                 |
      | Evidence of Coverage_English                |
      | Comprehensive Formulary - Drug List_English |

    Examples: 
      | planType | UsOtherTerritoriesCheck | copayCategory |

  #       | PDP     | NotUsOtherTerritories   | LIS           |
  #       | PDP     | usOtherTerritories      | LIS           |
  Scenario Outline: Verify benefits and coverage in AARP site for MS member
    Given registered AMP with following details for benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user navigates to benefits and Coverage in AARP site
    Then the user validates following consumer details
      | Member Number  |
      | Effective Date |
    And the user validates following benefits
      | plan Benefits |
    And the user validates following Plan Benefits Documents
      | Plan Benefits Table (PDF) |
      | Plan Overview (PDF)       |

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
      | planType | riderAvailableCheck |

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
      | planType | riderAvailableCheck |

  #		| MA      |  riderAvailable       |
  # The below scenario to cover validate pdfs links section after in member area
  Scenario Outline: To verify login in AARP site
    Given the user is on the AARP medicare site login page
    When registered AARP with following details for plan benefits and coverage flow in AARP site
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user validatespdf links after login in AARP site
    Then valiadte the actual and expected data of ulayer benefets and coverage pdfs

    Examples: 
      | planType | memberType |
      #| MA       | Individual |
      #	| MA       | Group      |
      #| MAPD     | Individual |
      | PDP      | Individual |


Feature: To test plan benefits and Coverage on AARP site for Federal members
Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 

		Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | NON LIS        | 


Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 

		Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 2        | 

		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 

		Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 3        | 
		

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 4        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 4        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 4        | 

		Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits no tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 4        | 
		
Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits all tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
        | MAPD     | LIS 4        | 	

Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits split tier
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                |
| Copay Category     | <copayCategory>           | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  | copayCategory  |
<<<<<<< HEAD

        | MAPD     | LIS 4        | 
		


Scenario Outline:To verify the benefits and coverage page for MA and MAPD member in AARP site
Given registered member for forms and resources in AARP Site
	| <planType> |
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page
And the user clicks on the start search button on benefits and coverage page
And the user clicks on the change your pcp button on benefits and coverage page

Examples:

| planType |
| MA	   |
| MAPD	   |


        | MAPD     | LIS 4        |

Scenario Outline: Verify benefits and coverage in AARP site for SHIP (Medicare Supplement + Riders)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page     
Examples:
        |planType  |
        | MAPD     |
        
Scenario Outline: Verify benefits and coverage in AARP site for SHIP (Medicare Supplement)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page     
Examples:
        |planType  |
        | MAPD     |

Scenario Outline: Verify benefits and coverage in AARP site for SHIP (HAP)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page     
Examples:
        |planType  |
        | MAPD     |
Scenario Outline: Verify benefits and coverage in AARP site for SHIP (HIP)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  |
        | MAPD     |
        
        
Scenario Outline: Verify benefits and coverage in AARP site for SHIP (EPHIP)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  |
        | MAPD     |
        

Scenario Outline: Verify benefits and coverage in AARP site for SHIP (MAP)
Given registered AMP with following details for plan benefits and coverage flow in AARP site
| Plan Type          | <planType>                | 
When the user view forms and resources in AARP site
Then the user view benefits and coverage in AARP site
And the user validates the content on benefits and coverage page    	 
Examples:
        |planType  |
        | MAPD     |
        | MAPD     | LIS 4        | 
        
Scenario Outline: Verify benefits and coverage in AARP site for G01 Ship member
Given registered AMP with following details for plan benefits and coverage flow in AARP site
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
        |planType  |planGroup|sequenceRefNum1-4|sequenceRefNum5                              |sequenceRefNum6-8             |sequenceRefNum9 |sequenceRefNum10                             |sequenceRefNum11-12  |sequenceRefNum13                   |benefitText1    |benefitText2     |benefitText3           |benefitText4            |benefitText5                    |benefitText6                      |benefitText7      |benefitText8                |benefitText9                  |benefitText10                     |benefitText11                        |benefitText12         |benefitText13                |
        | SHIP     | G01     |Hospital stays   |Blood or packed red blood cells under Part A |Skilled nursing facility stays|Hospice care    |Blood or packed red blood cells under Part B |Medical care				 |Emergency care in foreign countries|For days 1 - 60 |For days 61 - 90 |For days 91 and beyond |For days 91 and greater | will pay Medicare Part A costs |Since Medicare covers days 1 - 20 |For days 21 - 100 |Must follow a hospital stay |Hospice Care and Respite Care |Medicare Part B costs not covered |20% of the Medicare-eligible expense |Part B Excess charge  | $250 emergency medical care |        



  Scenario Outline: Verify PDF flyer on benefits and coverage in AARP site 
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType> |
      
    When the user navigates to plan benefits and coverage in AARP site
    Then I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature
Examples:

| planType |
| MAPD     |
