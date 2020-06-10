@eob @fastandfurious
Feature: 1.04.1 To Test NON-DREAM EOB for Members - E2E

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPEob |


  #note: skip the API and UI count comparison for now because service is unstable
  @eob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content
    Then the user validates site leaving pop up after clicking Adobe link
    #note: moved to footer feature
    #Then the user validates Need Help section
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
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    #Then the user validates Learn More how to read medical eob PDF
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    #Then the user validates the eob count for all available search ranges
    #  | Flag Zero EOB User | <flagZeroEob> |

    @COSMOS_MEDICAL @devRegression
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob | 
      | 01    | MAPD     | COSMOS_EOB_R      | Medical           | true        |

    @COSMOS_MEDICAL
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 02    | MA       | COSMOS_EOB_R      | Medical           | true        |

    @COSMOS_DRUG  @devRegression
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 03    | MAPD     | COSMOS_EOB_R      | Prescription Drug | true        |

    @NICE_MEDICAL
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 04    | MAPD     | NICE_EOB_R        | Medical           | true        |  
      | 05    | MA       | NICE_EOB_R        | Medical           | true        | 

    @NICE_DRUG
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 06    | MAPD     | NICE_EOB_R        | Prescription Drug | true        | 

    #note: PDP GROUP has 1000+ eobs, check to see if they can put the img loader while loading
    #note: adobe links won't come up till very very late
    @RX_PDP
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 07    | PDP      | Rx_EOB            | Prescription Drug | true        |
      | 08    | PDP      | GROUP_Rx_EOB      | Prescription Drug | true        |

    @RX_PDP_COMBO
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 09    | PDP      | PDP_SSP_COMBO_EOB | Prescription Drug | true        |
      | 10    | PDP      | PDP_SHIP_COMBO_EOB| Prescription Drug | true        |


  @eob02 @regressionMember
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content
    Then the user validates site leaving pop up after clicking Adobe link
    #note: moved to footer feature
    #Then the user validates Need Help section
    And the user selects the eob type
      | EOB Type | <eobType> |
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 3-6 months ----  
    And the user selects the desired date range
      | Date Range | Last 3-6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6-12 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12- months ----  
    And the user selects the desired date range
      | Date Range | Last 12-18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    #Then the user validates the eob count for all available search ranges
    #  | Flag Zero EOB User | <flagZeroEob> |

    # note: to correctly validate for SHIP, planType must be in this format: SHIP_<planCategory>
    @SHIP_EOBs
    Examples: 
      | index | planType                 | memberType         | eobType | flagZeroEob |
      | 11    | SHIP_MEDICARE SUPPLEMENT | MULTI_SHIP_EOB     | Medical | true        | 
      | 12    | SHIP_MEDICARE SUPPLEMENT | PDP_SHIP_COMBO_EOB | Medical | false       |
      | 13    | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MA_NICE_DEOB | Medical | true   | 
      | 14    | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_RX_DEOB  | Medical | true   |  


  @eob02 @regression_06_06_18FnF @regressionMember
  Scenario Outline: -index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - To validate EOB displays error message for user with SHIP PHIP active plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the eob page content for PHIP

    @PHIP_EOBs
    Examples: 
      | index | TID   | planType | memberType |
      | 15    | 15174 | PHIP     | SHIP_EOB   |


  #note: pending coverage until SSUP individual user is available
  #@eob03 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  #Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP member accessing EOB page via top menu sub link
  #  Given login with following details logins in the member portal and validate elements
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #  When I navigate to the claims Summary page from dashboard or testharness page
  #  #Then Explanation of benefits sub navigation under Claims tab is not displayed
  #  Then Explanation of benefits deep link is invoked and validate the Page
  #
  #  Examples: 
  #    | index | FID    | planType | memberType              |
  #    | 16    | 267688 | SSUP     | EOB_Deeplink_Individual |


  @eob04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP GROUP member accessing EOB page via top menu sub link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then the user navigates to EOB page
    Then the user validate sub option EXPLANATION OF BENEFITS under Claims option

    @SSP_EOBs
    Examples: 
      | index | FID    | planType | memberType | 
      | 17    | 267688 | SSUP     | GROUP_EOB  | 