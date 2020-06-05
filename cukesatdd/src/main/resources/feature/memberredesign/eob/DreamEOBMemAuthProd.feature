@Dreameob
Feature: 1.04.2.2 To Test DREAM EOB for Members - E2E - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPEob |


  @memAuth_dreamEob01 @E2E
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> -To verify DREAM EOB page content and PDFs
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to EOB page
    Then the user validates the header section content on DREAM EOB
    Then the user validates site leaving pop up after clicking Adobe link
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
    Then the user validates the right rail section content
    Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    @memAuth_dreamEob01a
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 01    | ashah120  | Mnrqa002  | billrosner1             | MAPD     | COSMOS_DEOB       | 1 new both, 1 old C, 1 or 2 old D overlap | true|
      | 02    | ashah120  | Mnrqa002  | sandrakaye86            | MAPD     | NICE_EOB_R        | old C and old D                   | true        |  

    @memAuth_dreamEob01b 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
#     | 03    | ashah120  | Mnrqa002  | testuserTBD             | MAPD     | MULTIEOB_NICE_DEOB | 2 Eobs Same Months               | true        |  
      | 04    | ashah120  | Mnrqa002  | nawal1215               | PDP      | PDP_RX_DEOB       | 1 new D, 1 or 2 old D             | true        |  

    @memAuth_dreamEob01c 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 05    | ashah120  | Mnrqa002  | haradaty32              | MA       | COSMOS_EOB_R      | old C                             | true        |
      | 06    | ashah120  | Mnrqa002  | Dream_EOB_MA_009        | MA       | MA_NICE_DEOB      | 1 new C, 1 old C                  | true        |

    @memAuth_dreamEob01d 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
#     | 07    | ashah120  | Mnrqa002  | Dream_EOB_PDP_001       | PDP      | COMBO_SHIP_PDP_RX_DEOB  | 1 new D, 1 or 2 old D       | true        |  
      | 08    | ashah120  | Mnrqa002  | phleauxdailles43        | MA       | COMBO_SHIP_MA_NICE_DEOB | 1 new C, 2 old C            | true        | 

    @memAuth_dreamEob01e
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 09    | ashah120  | Mnrqa002  | rldf1942                | PDP      | PDP_SSP_COMBO_EOB | old D                             | true        |
      | 10    | ashah120  | Mnrqa002  | PAULAROTH2              | PDP      | PDP_SHIP_COMBO_EOB| old D                             | true        |

    @memAuth_dreamEob01f
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
#     | 11    | ashah120  | Mnrqa002  | testuserTBD             | MAPD     | ES_CnD_NICE_EOB   | 1 new CnD spanish, old M          | true        |
#     | 12    | ashah120  | Mnrqa002  | testuserTBD             | MAPD     | ES_D_NICE_EOB     | 1 new D spanish, old M            | true        |
      