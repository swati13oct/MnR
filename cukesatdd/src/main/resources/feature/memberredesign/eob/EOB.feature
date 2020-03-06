@eob @fastandfurious
Feature: 1.04 To Test EOB for Members

  @eob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
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
    Then the user selects Custom Search with future date for From and To Date values
    Then the user validates future Date errors
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    @COSMOS_EOBs @devRegression
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 01    | MAPD     | COSMOS_EOB_R      | Medical           | true        |

    @COSMOS_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 02    | MAPD     | COSMOS_EOB_R      | Prescription Drug | true        |
      | 03    | MA       | COSMOS_EOB_R      | Medical           | true        |
     #note: SSP EOB is disabled
     # | 04    | SSP      | PDP_SSP_COMBO_EOB | Medical           | true        |

    @NICE_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 05    | MA       | NICE_EOB_R        | Medical           | true        |      
      | 06    | MAPD     | NICE_EOB_R        | Medical           | true        |      
      | 07    | MAPD     | NICE_EOB_R        | Prescription Drug | true        |      

    #note: PDP GROUP has 1000+ eobs, check to see if they can put the img loader while loading
    #note: adobe links won't come up till very very late
    @Rx_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob | 
      | 08    | PDP      | Rx_EOB            | Prescription Drug | true        |
      | 09    | PDP      | GROUP_Rx_EOB      | Prescription Drug | true        |
      | 10    | PDP      | PDP_SSP_COMBO_EOB | Prescription Drug | true        |
      | 11    | PDP      | PDP_SHIP_COMBO_EOB| Prescription Drug | true        |


  @eob02 @regressionMember
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
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
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 3-6 months ----  
    And the user selects the desired date range
      | Date Range | Last 3-6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6-12 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12- months ----  
    And the user selects the desired date range
      | Date Range | Last 12-18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    @SHIP_EOBs
    Examples: 
      | index | planType | memberType         | eobType | flagZeroEob |
      | 12    | SHIP     | SHIP_EOB           | Medical | true        | 
      | 13    | SHIP     | PDP_SHIP_COMBO_EOB | Medical | false       |

  @eob02 @regression_06_06_18FnF @regressionMember
  Scenario Outline: -index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - To validate EOB displays error message for user with SHIP PHIP active plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the eob page content for PHIP

    @SHIP_EOBs
    Examples: 
      | index | TID   | planType | memberType |
      | 14    | 15174 | PHIP     | SHIP_EOB   |
  


  #note: pending coverage until SSUP individual user is available
  @eob03 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP member accessing EOB page via top menu sub link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page

    Examples: 
      | index | FID    | planType | memberType              |
      | 15    | 267688 | SSUP     | EOB_Deeplink_Individual |

  @eob04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP GROUP member accessing EOB page via top menu sub link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP
    Then the user validates the eob page content for SSP

    @SHIP_EOBs
    Examples: 
      | index | FID    | planType | memberType | 
      | 16    | 267688 | SSUP     | GROUP_EOB  | 


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

#------------ clean up later
   #experiment
  @eob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    And the user selects the eob type
      | EOB Type | <eobType> |
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
##    Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    Then the user validates EOB count between API and UI are the same

    @COSMOS_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 12    | SHIP     | SHIP_EOB           | Medical | true        | 



 #experiment DREAM EOB
  @eob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
   # Then the user validates the header section content on DREAM EOB
   # Then the user validates site leaving pop up after clicking Adobe link
   # Then the user validates Need Help section
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same

    @COSMOS_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
#      | 01    | MAPD     | COSMOS_EOB_R      | Medical           | true        |
      | 12    | SHIP     | SHIP_EOB           | Medical | true        | 