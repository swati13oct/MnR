@eob @fastandfurious
Feature: 1.04.1 To Test NON-DREAM EOB for Members - E2E

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPEob |


  @eob01 @regressionMember
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
##    Then the user validates the header section content
##    Then the user validates site leaving pop up after clicking Adobe link
    #note: moved to footer feature
    #Then the user validates Need Help section
    And the user selects the eob type
      | EOB Type | <eobType> |
    #----- Validate Date Range Last 90 Days ----  
##    And the user selects the desired date range
##      | Date Range | Last 90 Days |
##    Then the user obtains API response info for validation
##    Then the user validates search result section content
##    Then the user clicks on first eob from the list to validate pdf
##      | Real EOB | <realEob> |
##    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 3-6 months ----  
##    And the user selects the desired date range
##      | Date Range | Last 3-6 months |
##    Then the user obtains API response info for validation
##    Then the user validates search result section content
##    Then the user clicks on first eob from the list to validate pdf
##      | Real EOB | <realEob> |
##    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6-12 months ----  
##    And the user selects the desired date range
##      | Date Range | Last 6-12 months |
##    Then the user obtains API response info for validation
##    Then the user validates search result section content
##    Then the user clicks on first eob from the list to validate pdf
##      | Real EOB | <realEob> |
##    #Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12-18 months ----  
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
    @SHIP_EOBs @SHIP_EOBs1 @devRegression
    Examples: 
      | index | planType                 | memberType          | eobType | realEob | flagZeroEob |
      | 11    | SHIP_MEDICARE SUPPLEMENT | COMBO_MULTI_SHIP_EOB| Medical | false   | true        | 
      | 18    | SHIP_MEDICARE SUPPLEMENT | SHIP_EOB            | Medical | true    | true        | 

    @SHIP_EOBs @SHIP_EOBs2
    Examples: 
      | index | planType                 | memberType          | eobType | realEob | flagZeroEob |
      | 12    | SHIP_MEDICARE SUPPLEMENT | PDP_SHIP_COMBO_EOB  | Medical | false   |  false      |

    ## note: the user q3_sept_UAT4_AARP_011 has 500 expected error at range Last 12-18 range
    ## note: script doesn't handle it yet, comment out for now
    #@SHIP_EOBs @SHIP_EOBs3
    #Examples: 
    #  | index | planType                 | memberType                | eobType | realEob | flagZeroEob |
    #  | 13    | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MAPD_NICE_DEOB | Medical | false   |  true       | 

    @SHIP_EOBs @SHIP_EOBs4
    Examples: 
      | index | planType                 | memberType              | eobType | realEob | flagZeroEob |
      | 14    | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_RX_DEOB  | Medical | false   |  true       |  


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