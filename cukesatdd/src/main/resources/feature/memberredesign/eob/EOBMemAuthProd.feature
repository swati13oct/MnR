@eob
Feature: 1.04.1.1 To Test NON-DREAM EOB for Members - E2E - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPEob |


  ##### ----------------- keep all scenarios below this line when dream EOB switches on, below are for SHIP and other non-federal cases ---------------
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
    #Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 3-6 months ----  
    And the user selects the desired date range
      | Date Range | Last 3-6 months |
    #Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6-12 months ----  
    And the user selects the desired date range
      | Date Range | Last 6-12 months |
    #Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12- months ----  
    And the user selects the desired date range
      | Date Range | Last 12-18 months |
    #Then the user obtains API response info for validation
    Then the user validates search result section content
    Then the user clicks on first eob from the list to validate pdf
    #Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    #Then the user validates the eob count for all available search ranges
    #  | Flag Zero EOB User | <flagZeroEob> |

    # note: to correctly validate for SHIP, planType must be in this format: SHIP_<planCategory>
    @prod_SHIP_EOBs @prod_SHIP_EOBs1
    Examples: 
      | index | username  | password  | MemUserName             | planType                 | memberType         | eobType | flagZeroEob |
      | 11    | ashah120  | Mnrqa003  | gingerdrais46           | SHIP_HOSPITAL INDEMNITY | MULTI_SHIP_EOB     | Medical | false       | 

    @prod_SHIP_EOBs @prod_SHIP_EOBs2
    Examples: 
      | index | username  | password  | MemUserName             | planType                 | memberType         | eobType | flagZeroEob |
      | 12    | ashah120  | Mnrqa003  | Norm749                 | SHIP_MEDICARE SUPPLEMENT | PDP_SHIP_COMBO_EOB | Medical | false       |

    @prod_SHIP_EOBs @prod_SHIP_EOBs3
    Examples: 
      | index | username  | password  | MemUserName             | planType                 | memberType         | eobType | flagZeroEob |
      | 13    | ashah120  | Mnrqa003  | phleauxdailles43        | SHIP_HOSPITAL INDEMNITY  | COMBO_SHIP_MA_NICE_DEOB | Medical | true   | 

@abc    @prod_SHIP_EOBs @prod_SHIP_EOBs4
    Examples: 
      | index | username  | password  | MemUserName             | planType                 | memberType         | eobType | flagZeroEob |
    # | 14    | ashah120  | Mnrqa003  | testusername            | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_RX_DEOB  | Medical | true   |  
      | 14    | ashah120  | Mnrqa003  | MaryLouMichels2         | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_RX_DEOB  | Medical | true   |  


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
      | 15    | ashah120  | Mnrqa003  | kataz2525       | 15174 | PHIP     | SHIP_EOB   |


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
  #    | 16    | ashah120  | Mnrqa003  | testusername    | 267688 | SSUP     | EOB_Deeplink_Individual |


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
      | 17    | ashah120  | Mnrqa003  | JSENFYFDRE#ERY2GO        | 267688 | SSUP     | GROUP_EOB  | 