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

  Scenario Outline: To validate the pharmacy saver widget in benefits and coverage page in AARP site
    Given registered member to login in AARP site
      | <plantype> |
    When the user navigates to benefits and coverage page under my plans in AARP site
    Then the user validates pharmacy saver widget in AARP site

    Examples: 
      | plantype |
      | MAPD     |

  @Q4
  Scenario Outline: To validate the preferred and standard drug costs table in benefits and coverage page in AARP site
    Given registered member to login in AARP site
      | <plantype> |
    When the user navigates to benefits and coverage page under my plans in AARP site
    Then the user validates drug cost table in AARP site

    Examples: 
      | plantype |
      | MAPD     |
      | PDP      |

  Scenario Outline: To verify pdfs displayed in forms and resources for MA member in AARP site
    Given registered member for forms and resources in AARP Site
      | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      #| MA	   |
      | MAPD     |

  #| PDP      |
  #| MS       |
  #| HIP      |
  @MAPDProviderLIS1
  Scenario Outline: To validate the office and hospital visits in benefits and coverage page in AARP site for MAPD LIS1 member
    Given registered member to login in AARP site
      | Plan Type        | <planType>        |
      | LIS Level        | <lisLevel>        |
      | Provider Tiering | <providerTiering> |
      | PartD Deductible | <partDDeductible> |
    When the user navigates to benefits and coverage page under my plans in AARP site
    Then the user validates the office and hospital visit in AARP site

    Examples: 
      | planType | lisLevel | providerTiering | partDDeductible |
      | MAPD     |        1 | true            | AllTier         |

  #| MAPD	   | 1      |true           | SplitTier  |
  #| MAPD	   | 1      |true           | NoTier     |
  #| MAPD	   | 1      |false          | AllTier     |
  #| MAPD	   | 1      |false          | SplitTier   |
  #| MAPD	   | 1      |false           | NoTier     |
  @MAProviderT
  Scenario Outline: To validate the office and hospital visits in benefits and coverage page in AARP site for MA member
    Given registered member to login in AARP site
      | Plan Type        | <plantype> |
      | Provider Tiering | <tiering>  |
    When the user navigates to benefits and coverage page under my plans in AARP site
    And the user navigates to benefits and coverage page under my plans in AARP site
    Then the user validates the office and hospital visit in AARP site

    Examples: 
      | plantype | tiering |
      #| MAPD     |true   |
      | MA       | true    |

  #| MAPD     |false    |
  #| MA       |false    |
  @bncUlayer
  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis non provider tiering with office visits and hospital visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd non lis provider tiering with office visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 non provider tiering with office visits and hospital visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 2 provider tiering with office visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 non provider tiering with office visits and hospital visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 3 provider tiering with office visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 3         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 non provider tiering with office visits and hospital visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits no tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits all tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify benefits and coverage in AARP site for mapd lis 4 provider tiering with office visits split tier
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 4         |

  Scenario Outline: To verify the benefits and coverage page for MA and MAPD member in AARP site
    Given registered member for forms and resources in AARP Site
      | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    And the user clicks on the start search button on benefits and coverage page
    And the user clicks on the change your pcp button on benefits and coverage page

    Examples: 
      | planType |       |
      | MA       |       |
      | MAPD     |       |
      | MAPD     | LIS 4 |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (Medicare Supplement + Riders)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      | MAPD     |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (Medicare Supplement)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      | MAPD     |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (HAP)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      | MAPD     |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (HIP)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      | MAPD     |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (EPHIP)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |
      | MAPD     |

  Scenario Outline: Verify benefits and coverage in AARP site for SHIP (MAP)
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType |       |
      | MAPD     |       |
      | MAPD     | LIS 4 |

  Scenario Outline: Verify riders on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
      | MAPD     | LIS 1         |
      | MAPD     | LIS 2         |
      | MAPD     | LIS 3         |
      | MAPD     | LIS 4         |

  Scenario Outline: Verify Federal Active Riders Dental 260 on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify Federal Active Riders Dental Platinum on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify Federal Active Riders Optional Dental on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify Federal Available Riders Optional Dental on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS 2         |

  @availableRiders
  Scenario Outline: Verify Federal Available Riders Dental Platinum on benefits and coverage in AARP site for MAPD Lis 2 member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
      
   @availableRiders1
  Scenario Outline: Verify Federal Available Riders Dental Platinum on benefits and coverage in AARP site for MAPD Lis 2 member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    #When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  Scenario Outline: Verify Federal Optional Dental on benefits and coverage in AARP site
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type | <planType> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates Available riders in AARP site

    Examples: 
      | planType |
      | MA       |

  @activeRider
  Scenario Outline: Verify Federal Active Riders Fitness on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Remove This Rider button
    Then Add rider popup appears and clicks Remove This Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
      
  @activeRider3
  Scenario Outline: Verify Federal Active Riders Fitness on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    Then user clicks on Remove This Rider button
    #Then Add rider popup appears and clicks Remove This Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS2       |

  @availablehighOptionRiders
  Scenario Outline: Verify Federal Available High Optional Dental riders on benefits and coverage in AARP site for MAPD Lis 2 member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
#Data Used: q1_feb_ulayer072
 
  @availablehighOptionRidersjenkins
  Scenario Outline: Verify Federal Available High Optional Dental riders on benefits and coverage in AARP site for MAPD Lis 2 member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    Then user clicks on Add Rider button
    #Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS3          |

  @availableRider
  Scenario Outline: Verify Federal Available  Dental Platinum  riders on benefits and coverage in AARP site for  MAPD member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    #When user clicks on Add Rider button
    #Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
      
  @availableRider3
  Scenario Outline: Verify Federal Available  Dental 260  riders on benefits and coverage in AARP site for  MAPD member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    Then user clicks on Add Rider button
    #Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | LIS2          |

  @availableRider2
  Scenario Outline: Verify Federal Available  Fitness riders on benefits and coverage in AARP site for  MAPD member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  @replaceRider
  Scenario Outline: Verify Replace Rider Pop Up for Federal Available Dental Platinum Riders
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Replace rider popup appears and clicks Replace Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  @pendingRider1
  Scenario Outline: Verify Federal Pending Fitness riders on benefits and coverage in AARP site for  MAPD member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  @needHelp
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
#Data Used: DentalPlatinumLis2

@needHelp1
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view jenkins benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
#Data Used: DentalPlatinumLis2

  @disclaimers
  Scenario Outline: Verify Disclaimers section is in place on Benefits and Coverage page
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user clicks on Disclaimers link
    And the user validates the content on benefits and coverage page

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |

  @needHelpContactUs
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When the user navigates to contact us page in AARP site
    Then the user validates the contact us page in AARP site

    Examples: 
      | planType | copayCategory |
      | MAPD     | NON LIS       |
@validatePdfsection
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    And the user validates view and documents label
    And the user validates the language dropdown and the value displayed by default
      | Language      | <language>      |
    And the user selects new value in dropdown successfully
    
     Examples: 
      | planType | language | 
      | SHIP     | SPANISH  |  
      | SHIP     | CHINESE  |
