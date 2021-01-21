@Dreameob
Feature: 1.04.2.1 To Test DREAM EOB for Members - E2E - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on test env
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

    @memAuth_dreamEob01a_mapdCosmos
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 01    | qavgogine | qavgogine | Dream_EOB_MAPD_007      | MAPD     | COSMOS_DEOB       | 1 new both, 1 old C, 1 or 2 old D overlap | true|

    @memAuth_dreamEob01b_mapdNice
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 02    | qavgogine | qavgogine | q4_Nice_UAT4_004        | MAPD     | NICE_DEOB         | old C and old D                   | true        |  

    @memAuth_dreamEob01c_mapdNiceSameMon
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 03    | qavgogine | qavgogine | Dream_multiEOB          | MAPD     | MULTIEOB_NICE_DEOB | 2 Eobs Same Months               | true        |  

    @memAuth_dreamEob01d_pdp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 04    | qavgogine | qavgogine | q3_sep_UAT4_AARP057     | PDP      | PDP_RX_DEOB       | 1 new D, 1 or 2 old D             | true        |  

    @memAuth_dreamEob01e_maCosmos 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 05    | qavgogine | qavgogine | q3_sep_Cosmos_claims_001| MA       | COSMOS_DEOB       | old C                             | true        |

    @memAuth_dreamEob01f_maNice 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 06    | qavgogine | qavgogine | Dream_EOB_106           | MA       | MA_NICE_DEOB      | 1 new C, 1 old C                  | true        |

    @memAuth_dreamEob01g_pdpComboShipFed
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 07    | qavgogine | qavgogine | q2_RxRetail_015         | PDP      | COMBO_SHIP_PDP_RX_DEOB  | na                          | false       |  

    @memAuth_dreamEob01h_mapdComboShipFed
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 08    | qavgogine | qavgogine | GENARO_Q4_COMBO         | MAPD     | COMBO_SHIP_MAPD_NICE_DEOB | NA                        | false       | 

    @memAuth_dreamEob01i_pdpComboPdpSsp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | note                              | flagZeroEob |
      | 09    | qavgogine | qavgogine | q2_jun_grp0255          | PDP      | PDP_SSP_COMBO_DEOB | old D                             | false       |

    @memAuth_dreamEob01j_pdpComboFedShip
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 10    | qavgogine | qavgogine | q4_ShipVAS_005          | PDP      | PDP_SHIP_COMBO_DEOB| na                                | false       |

    @memAuth_dreamEob01k_mapdEsCnD
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 11    | qavgogine | qavgogine | q2_DreamEOB_0002        | MAPD     | ES_CnD_NICE_DEOB  | 1 new CnD spanish, old M          | true        |

    @memAuth_dreamEob01l_mapdEsD 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 12    | qavgogine | qavgogine | q2_DreamEOB_0003        | MAPD     | ES_D_NICE_DEOB    | 1 new D spanish, old M            | true        |

    @memAuth_dreamEob01m_dsnp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 13    | qavgogine | qavgogine | q4_DSNP_052             | MAPD     | DSNP_DEOB         | DSNP EOB                          | true        |        

    @memAuth_dreamEob01n_ssp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | note                              | flagZeroEob |
      | 14    | qavgogine | qavgogine | q3_sep_UAT4_UHC063      | SSP      | COMBO_PDP_SSP_DEOB| SSP EOB                           | true        |                    