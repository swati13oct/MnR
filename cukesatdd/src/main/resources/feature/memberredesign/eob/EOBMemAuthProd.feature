@eob
Feature: 1.04.1.1 To Test NON-DREAM EOB for Members - E2E - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPEob |

  #----- begin sanity
  @prod_sanity
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
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user validates search result section content

    Examples: 
      | index | username  | password  | MemUserName            | planType                 | memberType         | eobType | realEob | flagZeroEob |
      | S01   | kkumard   | mnrs786@  | gingerdrais46          | SHIP_HOSPITAL INDEMNITY  | MULTI_SHIP_EOB     | Medical | true    | false       | 

  #----- begin regression
  @prod_eob01
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
      | Real EOB | <realEob> |
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 3-6 months ----  
    And the user selects the desired date range
      | Date Range | Last 3-6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
      | Real EOB | <realEob> |
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6-12 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
      | Real EOB | <realEob> |
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12- months ----  
    And the user selects the desired date range
      | Date Range | Last 12-18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
      | Real EOB | <realEob> |
    #Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    # note: to correctly validate for SHIP, planType must be in this format: SHIP_<planCategory>
    @prod_SHIP_EOBs @prod_SHIP_EOBs1_multiShip
    Examples: 
      | index | username  | password  | MemUserName            | planType                 | memberType         | eobType | realEob | flagZeroEob |
      | 11    | kkumard   | mnrs786@  | gingerdrais46          | SHIP_HOSPITAL INDEMNITY  | MULTI_SHIP_EOB     | Medical | true    | false       | 

    @prod_SHIP_EOBs @prod_SHIP_EOBs2_singleShip
    Examples: 
      | index | username  | password  | MemUserName            | planType                 | memberType         | eobType | realEob | flagZeroEob |
      | 12    | kkumard   | mnrs786@  | cdgatling-2            | SHIP_MEDICARE SUPPLEMENT | SHIP_EOB           | Medical | true    | true       |

    @prod_SHIP_EOBs @prod_SHIP_EOBs3_shipComboShipFed
    Examples: 
      | index | username  | password  | MemUserName            | planType                 | memberType              | eobType | realEob | flagZeroEob |
      | 13    | kkumard   | mnrs786@  | phleauxdailles43       | SHIP_HOSPITAL INDEMNITY  | COMBO_SHIP_MA_NICE_DEOB | Medical | true    | false   | 

    @prod_SHIP_EOBs @prod_SHIP_EOBs4_shipComboFedShip
    Examples: 
      | index | username  | password  | MemUserName            | planType                 | memberType              | eobType | realEob | flagZeroEob |
    # | 14    | kkumard   | mnrs786@  | testusername           | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_RX_DEOB  | Medical | true    | true   |  
      | 14    | kkumard   | mnrs786@  | MaryLouMichels2        | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_RX_DEOB  | Medical | true    | true   |  


  @prod_eob02 @regression_06_06_18FnF
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

    @prod_PHIP_EOBs
    Examples: 
      | index | username  | password  | MemUserName     | TID   | planType | memberType |
      | 15    | kkumard  | mnrs786@  | kataz2525       | 15174 | PHIP     | SHIP_EOB   |


  #note: pending coverage until SSUP individual user is available
  #@prod_eob03 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan
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
  #    | 16    | kkumard  | mnrs786@  | testusername    | 267688 | SSUP     | EOB_Deeplink_Individual |


  @prod_eob04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan
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

    @prod_SSP_EOBs
    Examples: 
      | index | username  | password  | MemUserName              | FID    | planType | memberType | 
      | 17    | kkumard  | mnrs786@  | JSENFYFDRE#ERY2GO        | 267688 | SSUP     | GROUP_EOB  | 