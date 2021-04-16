@Dreameob
Feature: 1.04.2.2 To Test DREAM EOB for Members - E2E - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPEob |

  #----- begin sanity
  @prod_sanity
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
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user validates search result section content for DREAM EOB

    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | flagZeroEob |
      | S01   | kkumard   | tnps459#  | WFBATES@GMAIL.COM       | MAPD     | COSMOS_DEOB       | true        |
 
  #----- begin regression
  @prod_dreamEob01 @E2E
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
    #Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    #Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    #Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    #Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    #Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    #Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    #Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on each eob on first page to validate pdf for DREAM EOB
    Then the user validates the right rail section content
    #Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    #note: WFBATES has partC n D EOB
    @prod_dreamEob01a_mapdCosmos
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | flagZeroEob |
      | 01    | kkumard   | tnps459#  | WFBATES@GMAIL.COM       | MAPD     | COSMOS_DEOB       | true        |

    @prod_dreamEob01b_mapdNice
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
    #x| 02    | kkumard   | tnps459#  | sandrakaye86            | MAPD     | NICE_DEOB          | true        |  
      | 02    | kkumard   | tnps459#  | wq2451601               | MAPD     | NICE_DEOB          | true        |  

    @prod_dreamEob01c_pdp 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | flagZeroEob |
#     | 03    | kkumard   | tnps459#  | testuserTBD             | MAPD     | MULTIEOB_NICE_DEOB| true        |  
      | 04    | kkumard   | tnps459#  | JAN06ARY                | PDP      | PDP_RX_DEOB       | true        |  

    @prod_dreamEob01d_maCosmos 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
    #x| 05    | kkumard   | tnps459#  | haradaty32              | MA       | COSMOS_DEOB        | true        |
      | 05    | kkumard   | tnps459#  | ExDesertrat             | MA       | COSMOS_DEOB        | true        |

    #@prod_dreamEob01e_maNice 
    #Examples: 
    #  | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
    #  | 06    | kkumard   | tnps459#  | haradaty32              | MA       | MA_NICE_DEOB       | true        |

    @prod_dreamEob01f_fedComboShipFed 
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType              | flagZeroEob |
#     | 07    | kkumard   | tnps459#  | testuserTBD             | PDP      | COMBO_SHIP_PDP_RX_DEOB  | true        |  
    #x| 08    | kkumard   | tnps459#  | phleauxdailles43        | MA       | COMBO_SHIP_MA_NICE_DEOB | true        | 
      | 08    | kkumard   | tnps459#  | VirginiaRuth1936        | MA       | COMBO_SHIP_MA_NICE_DEOB | true        | 

    @prod_dreamEob01g_pdpComboPdpSsp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
    #x| 09    | kkumard   | tnps459#  | rldf1942                | PDP      | PDP_SSP_COMBO_DEOB | true        |
      | 09    | kkumard   | tnps459#  | DKELLY27                | PDP      | PDP_SSP_COMBO_DEOB | true        |

    @prod_dreamEob01h_fedComboFedShip
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
      | 10    | kkumard   | tnps459#  | Norm749                 | PDP      | PDP_SHIP_COMBO_DEOB| true        |

    @prod_dreamEob01i
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
#     | 11    | kkumard   | tnps459#  | testuserTBD             | MAPD     | ES_CnD_NICE_DEOB   | true        |
#     | 12    | kkumard   | tnps459#  | testuserTBD             | MAPD     | ES_D_NICE_DEOB     | true        |

    @prod_dreamEob01m_dsnp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType         | flagZeroEob |
      | 13    | kkumard   | tnps459#  | Arm8bur                 | MAPD     | DSNP_DEOB          | false       |        

    @prod_dreamEob01n_ssp
    Examples: 
      | index | username  | password  | MemUserName             | planType | memberType        | flagZeroEob |
      | 14    | kkumard   | tnps459#  | DKELLY27                | SSP      | COMBO_PDP_SSP_DEOB| false       |                          