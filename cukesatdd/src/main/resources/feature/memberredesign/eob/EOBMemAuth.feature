@eob
Feature: 1.04.1.1 To Test NON-DREAM EOB for Members - E2E - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPEob |


  #note: skip the API and UI count comparison for now because service is unstable
  @memAuth_eob01 @E2E  
  Scenario Outline: To validate via member authorization access for EOB page
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

    @memAuth_COSMOS_MEDICAL
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob | 
      | 01    | qavgogine | qavgogine | testusername     | MAPD     | COSMOS_EOB_R      | Medical           | true        |

    @memAuth_COSMOS_MEDICAL
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 02    | qavgogine | qavgogine | testusername    | MA       | COSMOS_EOB_R      | Medical           | true        |

    @memAuth_COSMOS_DRUG
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 03    | qavgogine | qavgogine | testusername    | MAPD     | COSMOS_EOB_R      | Prescription Drug | true        |

    @memAuth_NICE_MEDICAL
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 04    | qavgogine | qavgogine | testusername    | MAPD     | NICE_EOB_R        | Medical           | true        |  
      | 05    | qavgogine | qavgogine | testusername    | MA       | NICE_EOB_R        | Medical           | true        | 

    @memAuth_NICE_DRUG
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 06    | qavgogine | qavgogine | testusername    | qavgogine | qavgogine | testusername    | MAPD     | NICE_EOB_R        | Prescription Drug | true        | 

    #note: PDP GROUP has 1000+ eobs, check to see if they can put the img loader while loading
    #note: adobe links won't come up till very very late
    @memAuth_RX_PDP
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 07    | qavgogine | qavgogine | testusername    | PDP      | Rx_EOB            | Prescription Drug | true        |
      | 08    | qavgogine | qavgogine | testusername    | PDP      | GROUP_Rx_EOB      | Prescription Drug | true        |

    @memAuth_RX_PDP_COMBO
    Examples: 
      | index | username  | password  | MemUserName     | planType | memberType        | eobType           | flagZeroEob |
      | 09    | qavgogine | qavgogine | testusername    | PDP      | PDP_SSP_COMBO_EOB | Prescription Drug | true        |
      | 10    | qavgogine | qavgogine | testusername    | PDP      | PDP_SHIP_COMBO_EOB| Prescription Drug | true        |


  ##### ----------------- keep all scenarios below this line when dream EOB switches on, below are for SHIP and other non-federal cases ---------------
  @memAuth_eob02
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
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
    @memAuth_SHIP_EOBs
    Examples: 
      | index | username  | password  | MemUserName             | planType                 | memberType         | eobType | flagZeroEob |
      | 11    | qavgogine | qavgogine | q1_feb_2020SHIP_004     | SHIP_MEDICARE SUPPLEMENT | MULTI_SHIP_EOB     | Medical | true        | 
      | 12    | qavgogine | qavgogine | q3_sep_Active_combo_005 | SHIP_MEDICARE SUPPLEMENT | PDP_SHIP_COMBO_EOB | Medical | false       |
      | 13    | qavgogine | qavgogine | Dream_EOB_MA_002        | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MA_NICE_DEOB | Medical | true   | 
      | 14    | qavgogine | qavgogine | Dream_EOB_PDP_001       | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_RX_DEOB  | Medical | true   |  


  @memAuth_eob02 @regression_06_06_18FnF
  Scenario Outline: -index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - To validate EOB displays error message for user with SHIP PHIP active plan
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
    Then the user validates the eob page content for PHIP

    @memAuth_PHIP_EOBs
    Examples: 
      | index | username  | password  | MemUserName     | TID   | planType | memberType |
      | 15    | qavgogine | qavgogine | PHIP01          | 15174 | PHIP     | SHIP_EOB   |


  #note: pending coverage until SSUP individual user is available
  #@memAuth_eob03 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan
  #Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP member accessing EOB page via top menu sub link
  #  Given the user is on member auth login flow page
  #  When the member is able to login with correct username and password
  #    | Username | <username> |
  #    | Password | <password> |
  #  And Member Enters the Username he wants to search
  #    | MemUsername | <MemUserName> |
  #  And user clicks on member to select
  #  And user stores test input for validations
  #    | Username | <MemUserName> |
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #-------------- navigate to the target test page for testing
  #  When I navigate to the claims Summary page from dashboard or testharness page
  #  #Then Explanation of benefits sub navigation under Claims tab is not displayed
  #  Then Explanation of benefits deep link is invoked and validate the Page
  #
  #  Examples: 
  #    | index | username  | password  | MemUserName     | FID    | planType | memberType              |
  #    | 16    | qavgogine | qavgogine | testusername    | 267688 | SSUP     | EOB_Deeplink_Individual |


  @memAuth_eob04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan
  Scenario Outline: -index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - To validate that SSUP GROUP member accessing EOB page via top menu sub link
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
    Then the user validate sub option EXPLANATION OF BENEFITS under Claims option

    @memAuth_SSP_EOBs
    Examples: 
      | index | username  | password  | MemUserName              | FID    | planType | memberType | 
      | 17    | qavgogine | qavgogine | q2_june_Cosmos_Seg233    | 267688 | SSUP     | GROUP_EOB  | 