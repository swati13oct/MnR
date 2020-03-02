@eob @fastandfurious
Feature: 1.04 To Test EOB for Members

  @eob01 @E2E @regressionMember 
  Scenario Outline: -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content
    Then the user validates site leaving pop up after clicking Adobe link
    Then the user validates Need Help section
    And the user selects the eob type
      | EOB Type | <eobType> |
    #----- Validate Date Range Custom Search invalid cases ----  
    When the user selects Custom Search with blank From and To Date values
    Then the user validates blank Date errors 
    When the user selects Custom Search with To Date older From Date values
    Then the user validates To Date older than From Date errors
    When the user selects Custom Search with Date Range greater than 18 months
    Then the user validates greater than 18 months error
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    @COSMOS_EOBs
    Examples: 
      | planType | memberType        | eobType           | flagZeroEob |
      | MAPD     | COSMOS_EOB_R      | Medical           | true        |
      | MAPD     | COSMOS_EOB_R      | Prescription Drug | true        |
      | MA       | COSMOS_EOB_R      | Medical           | true        |
     # | SSP      | PDP_SSP_COMBO_EOB | Medical           | true        |

    @NICE_EOBs
    Examples: 
      | planType | memberType        | eobType           | flagZeroEob |
      | MAPD     | NICE_EOB_R        | Medical           | true        |      
      | MAPD     | NICE_EOB_R        | Prescription Drug | true        |      

    @Rx_EOBs
    Examples: 
      | planType | memberType        | eobType           | flagZeroEob | 
      | PDP      | Rx_EOB            | Prescription Drug | true        |
      | PDP      | PDP_SSP_COMBO_EOB | Prescription Drug | true        |
      | PDP      | PDP_SHIP_COMBO_EOB| Prescription Drug | true        |


  @eob02 @regressionMember
  Scenario Outline: -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content
    Then the user validates site leaving pop up after clicking Adobe link
    Then the user validates Need Help section
    And the user selects the eob type
      | EOB Type | <eobType> |
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 3-6 months ----  
    And the user selects the desired date range
      | Date Range | Last 3-6 months |
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 6-12 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #----- Validate Date Range Last 12- months ----  
    And the user selects the desired date range
      | Date Range | Last 12-18 months |
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    @SHIP_EOBs
    Examples: 
      | planType | memberType         | eobType | flagZeroEob |
      | SHIP     | SHIP_EOB           | Medical | true        | 
      | SHIP     | PDP_SHIP_COMBO_EOB | Medical | false       |


  #note: pending coverage until SSUP individual user is available
  @eob03 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP member accessing EOB page via top menu sub link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page

    Examples: 
      | FID    | planType | memberType              |
      | 267688 | SSUP     | EOB_Deeplink_Individual |

  @eob04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP GROUP member accessing EOB page via top menu sub link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP

    @SHIP_EOBs
    Examples: 
      | FID    | planType | memberType | 
      | 267688 | SSUP     | GROUP_EOB  | 


  ######################   KEEP FOR NOW EOB Regression ###############################
  @eob01 @febRelease2018 @hsideob @regressionMember
  Scenario Outline: plan: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates site leaving pop up after clicking Adobe link
    And the user selects the eob type
    And the user selects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |
    Then the user validates EOB count
      | EOB COUNT | <eobCount> |
    And the user validates how to read medical eob PDF
      | EOB Type | <eobType> |
    And the user clicks on first eob from the list

    #@COSMOS_EOBs
    Examples: 
      | planType | memberType   | dateRange      | eobType           | eobCount |
      | MAPD     | COSMOS_EOB_R | Last 18 months | Medical           |       17 |
      | MA       | COSMOS_EOB_R | Last 12 months | Medical           |       10 |
      | MAPD     | COSMOS_EOB_R | Last 6 months  | Prescription Drug |        4 |

    #@NICE_EOBs
    Examples: 
      | planType | memberType | dateRange      | eobType           | eobCount |
      | MAPD     | NICE_EOB_R | Last 18 months | Prescription Drug |       12 |
      | MAPD     | NICE_EOB_R | Last 6 months  | Medical           |        3 |

    #Q: what's the different between these two ship
    #@SHIP_EOBs
    Examples: 
      | planType     | memberType | dateRange        | eobType | eobCount |
      | SHIP_ACTIVE  | SHIP_EOB   | Last 6-12 months | Medical |        1 |
      | SHIP_ACTIVE2 | SHIP_EOB2  | Last 6-12 months | Medical |        1 |

    #@Rx_EOBs
    Examples: 
      | planType | memberType | dateRange      | eobType           | eobCount | 
      | PDP      | Rx_EOB     | Last 12 months | Prescription Drug |        9 | 
      | PDP      | RxGrp_EOB  | Last 18 months | Prescription Drug |       14 | 

  # need to add coverage for (if has EOB)
  # combo - fed+ship
  # combo - ship + fed
  # multi ship
  # term
  # pre-eff
  # move the two claims tests about EOB navigation for SSUP to here
  
  #     |15167    | PDPI         | COSMOS_EOB_R     | Last 18 months |Medical  |     0     |
  #     |15166    | SHIP_Termnated| SHIP_EOB     | Last 12-18 months |Medical  |     1     |
  #      |15141   | MAPD          | NICETermin_EOB_R | Last 18 months |Medical  |     1     |

  # need to get user
  @eob02 @regression_06_06_18FnF @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate EOB displays error message for user with SHIP PHIP active plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab1> |
    And the user gets the error message for PHIP member

    @SHIP_EOBs
    Examples: 
      | TID   | planType | memberType |
      | 15174 | PHIP     | SHIP_EOB   |
  
  
  ########################### END EOB  Regression #######################################

  ##### TO BE REMOVED 
  # duplicated
  @eob1 @Eobsiteleavingpopup
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType>- Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates site leaving pop up

    Examples: 
      | TID   | planType | memberType          |
      | 15140 | MAPD     | IndividualAARPWOEOB |
      | 15120 | MA       | IndividualAARPWOEOB |

  # duplicated
  @eob2 @eobCountdaterange
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange> -To verify EOB result list
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    And the user slects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |
    Then the user validates EOB count
      | EOB COUNT | <eobCount> |

    Examples: 
      | TID   | planType | memberType  | dateRange | eobType           | eobCount |
      | 15134 | PCP      | withEOB     | 18 Months | Medical           |        4 |
      | 15140 | MAPD     | aarpWithEOB | 90 Days   | Medical           |        4 |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Prescription Drug |        1 |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Prescription Drug |        1 |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Prescription Drug |        1 |


  # duplicated
  @eob4 @dropDownFuntion
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange> - To validate page functionality with different dropdowns
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page and validates the page
      | Date Range | <dateRange>   |
      | Plan Type  | <planType>    |
      | EOB Type   | <eobTypeData> |
    Then the user validates content displayed on EOB page without EOB type dropdown
      | Plan Type | <planType> |

    Examples: 
      | TID   | planType | memberType          | eobTypeData       | dateRange   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 6 Months    |
      | 15140 | MAPD     | IndividualAARPWOEOB | Prescription Drug | 6 Months    |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 12 Months   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 18 Months   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 90 Days     |
      | 15165 | SHIP     | Individual          | Medical           | 6-12 Months |
      | 15165 | SHIP     | Individual          | Medical           | 90 Days     |

  # duplicated
  @eob5 @learnAboutMedicalEOB
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange>- To verify How to read a medical EOB PDF
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page and validates the page
      | Date Range | <dateRange>   |
      | Plan Type  | <planType>    |
      | EOB Type   | <eobTypeData> |
    And the user validates how to read medical eob PDF

    Examples: 
      | TID   | planType | memberType  | dateRange | eobTypeData |
      | 15134 | PCP      | withEOB     | 18 Months | Medica      |
      | 15140 | MAPD     | aarpWithEOB | 90 Days   | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Medical     |

  # duplicate
  @eob7 @regression_06_06_18FnF
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify EOB accessible for PDP + MEDSup Plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab1> |
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab2> |

    Examples: 
      | TID   | planType | memberType     | dateRange      | eobType | eobCount | planTab1 | planTab2 |
      | 15167 | PDP      | comboEOBMedSup | Last 18 Months | Medical |        0 | PDP      | MedSup   |

