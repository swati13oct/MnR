@Dreameob
Feature: 1.04.2 To Test DREAM EOB for Members - E2E

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPEob |


  @dreamEob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify DREAM EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content on DREAM EOB
    Then the user validates the right rail section content
    Then the user validates site leaving pop up after clicking Adobe link
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
#    Then the user validates the eob count for all available search ranges
#      | Flag Zero EOB User | <flagZeroEob> |

    @dreamEob01a @COMBINDED_EOBs @devRegression
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 01    | MAPD     | COSMOS_DEOB       | 1 new both, 1 old C, 1 or 2 old D overlap | true|
      | 02    | MA       | MA_NICE_DEOB      | 1 new C, 1 old C                  | true        |
      | 03    | PDP      | PDP_RX_DEOB       | 1 new D, 1 or 2 old D             | true        |  

    @dreamEob01b @COMBINDED_EOBs
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 04    | MA       | COMBO_SHIP_MA_NICE_DEOB | 1 new C, 2 old C            | true        | 
      | 05    | PDP      | COMBO_SHIP_PDP_RX_DEOB  | 1 new D, 1 or 2 old D       | true        |  
      | 06    | MAPD     | MULTIEOB_NICE_DEOB | 2 Eobs Same Months               | true        |  


    @dreamEob01c @MAPD_EOBs
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 07    | MAPD     | COSMOS_EOB_R      | old C and old D                   | true        |
      | 08    | MAPD     | NICE_EOB_R        | old C and old D                   | true        |  

    @dreamEob01d @MA_EOBs
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 09    | MA       | COSMOS_EOB_R      | old C                             | true        |
      | 10    | MA       | NICE_EOB_R        | old C                             | true        | 

    @dreamEob01e @PDP_EOBs
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 11    | PDP      | Rx_EOB            | old D                             | true        |
      | 12    | PDP      | GROUP_Rx_EOB      | old D                             | true        |

    @dreamEob01f @PDP_EOBs
    Examples: 
      | index | planType | memberType        | note                              | flagZeroEob |
      | 13    | PDP      | PDP_SSP_COMBO_EOB | old D                             | true        |
      | 14    | PDP      | PDP_SHIP_COMBO_EOB| old D                             | true        |
