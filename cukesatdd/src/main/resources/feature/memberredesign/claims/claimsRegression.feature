@claims @thePredetors
Feature: T1.1To validate the claims Summary page and claims Details page on the member site

  #----- beginning of VBF claims scenarios section ------------------------
  # note: runner for sanity is RunMRATDDSanityClaims
  # note: need to have these user entries in MemberRedesign-VBF.csv (users may need to be updated)
  # note:   q2_may_shipUAT001/Password@1,SHIP,SHIPCLAIMS,ShipInd
  # note:   q2_jun_uhc0004/Password@1,MAPD,UhcMapdInd
  # note:   q2_jun_aarp0028/Password@1,MAPD,COSMOSCLAIMS,ULayerInd
  # note:   q2_jun_aarp0210/Password@1,PDP,RxCLAIMS,ULayerInd
  # note:   q2_jun_grp0050/Password@1,PDP,RX_CLAIMS,grpPerf
  # note: 
  #----- beginning of VBF claims scenarios section ------------------
  @smokeTest @MemberVBF @rallyDashboard @testharness
  Scenario Outline: To validate that claims are present on claims summary page and claims details page for <claimssystem>
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    Then I validate the claims displayed based on the selection on claims summary page
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page
    And I can navigate to the Claim Details page from claims summary page
    And I can validate the Claims Table on claims details page
    And I can validate the Claims Total on claims details page

    @smokeTest_Claims
    Examples: 
      | memberType | planType | claimPeriod    | claimSystem  |
      | ShipInd    | SHIP     | Last 24 months | SHIPCLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS |
      | ULayerInd  | MAPD     | Last 24 months | NICECLAIMS   |
      | ULayerInd  | PDP      | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | BlueLayerInd | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | GroupRetiree | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | RxCLAIMS     |

    @gatingTest_Claims
    Examples: 
      | memberType | planType | claimPeriod    | claimSystem  |
      | ShipInd    | SHIP     | Last 24 months | SHIPCLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | ULayerInd	  | MAPD     | Last 24 months | NICECLAIMS   |
    #  | ULayerInd    | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | BlueLayerInd | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | GroupRetiree | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | RxCLAIMS     |
    
  @smokeTest @MemberVBF @claims_Performance
  Scenario Outline: To validate that claims are present on claims summary page for performance ATDD
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I validate the claims displayed based on the selection on claims summary page

    Examples: 
      | memberType | planType | claimPeriod    | claimSystem |
      | grpPerf    | PDP      | Last 24 months | RxCLAIMS    |
  #----- end of VBF claims scenarios section ------------------------

  #----- beginning of Regression claims scenarios section ------------------------
  #-------------------------
  # note: claims ALM cases
  # TID: 15227 - TC01_FED AARP Individual - MA Only (NICE) - Medical Claims
  # TID: 15230 - TC02_FED AARP Individual - MAPD (COSMOS) - Medical and Drug Claims
  # TID: 15299 - TC03_FED AARP Individual - PDP - Drug Claims
  # TID: 15234 - TC04_FED UHC Individual - MA Only (COSMOS) - Medical Claims
  # TID: 15235 - TC05_FED UHC Individual - MAPD  (NICE) - Medical and Drug Claims
  # TID: 15236 - TC06_SHIP Only  Claims
  # TID: 15300 - TC08_Group  - PDP - RX  Claims
  # TID: 15259 - TC10_FED and SHIP combo with tabs
  # TID: 15268 - TC11_PCP OR MEDICA claims
  # TID: 15258 - TC09_SHIP Only - PHIP - Link will be available on rally and an error on secondary page
  #-------------------------
  @claims01 @E2EClaimstcase @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims Summary and details page E2E Scenario
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the claims displayed based on the selection on claims summary page
    And I validate the pagination on the claims summary page
    And I can see the learn more and print and download option on claims summary table section
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the Claims Total on claims details page
    And I validate the claims summary link on claims detail bottom page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the claims summary link on claims detail top page
    Then I validate Claim Details page content with non zero claims value and Learn More and EOB and tooltips

    #note1 - need to locate user with claims and update csv
    Examples: 
      | TID   | planType | memberType      | claimPeriod    | claimSystem     |
      | 15227 | MA       | AARP_Individual | Last 24 months | NICE_CLAIMS     |
      | 15230 | MAPD     | AARP_Individual | Last 24 months | M_COSMOS_CLAIMS |
      #see note1 | 15230 | MAPD     | AARP_Individual | Last 24 months | D_COSMOS_CLAIMS |
      | 15234 | MA       | UHC_Individual  | Last 24 months | COSMOS_CLAIMS   |
      #see note1 | 15235 | MAPD     | UHC_Individual  | Last 24 months | M_NICE_CLAIMS   |
      | 15235 | MAPD     | UHC_Individual  | Last 24 months | D_NICE_CLAIMS   |
      | 15299 | PDP      | SSO_Individual  | Last 24 months | RX_CLAIMS       |
      | 15236 | SHIP     | Individual      | Last 24 Months | COMPASS_CLAIMS  |
      | 15300 | PDP      | GROUP           | Last 24 months | RX_CLAIMS       |
      | 15259 | SHIP     | COMBO           | Last 24 months | COMPASS_CLAIMS  |
      | 15268 | PCP      | Individual      | Last 24 months | COSMOS_CLAIMS   |
      | xxxxx | MAPD     | GROUP           | Last 24 months | COSMOS_CLAIMS   |
      | xxxxx | MA       | GROUP           | Last 24 months | COSMOS_CLAIMS   |

  @claims02 @TC_09claimsPHIP @regressionMember
  Scenario Outline: TID: <TID> -plan: <planCategory> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the Error Message for a PHIP  member on claims sumamry page
    Given login with following details logins in the member portal and validate elements
      | Plan Type     | <planType>     |
      | Plan Category | <planCategory> |
      | Claim System  | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I validate the error message for a PHIP Member on the screen

    Examples: 
      | TID   | planType | planCategory | claimSystem    |
      | 15258 | SHIP     | PHIP         | COMPASS_CLAIMS |

  # note: pageNum is the claims page where the EOB pdf is located
  # note: rowNum is the data row where EOB pdf is located - only count the data row, exclude header row
  @claims03 @claimsEOB @US1268210 @F244667 @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims eob link on claims detail page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the claims displayed based on the selection on claims summary page
    When I navigate to the Claim details page to see eob link on details page
      | Page Number | <pageNum> |
      | Row Number  | <rowNum>  |
    Then I can validate the view as pdf link on claims details page header

    Examples: 
      | FID    | planType | memberType     | claimPeriod    | claimSystem | pageNum | rowNum |
      | 244667 | MA       | EOB_Individual | Last 24 months | NICE_CLAIMS |       2 |      4 |

  @claims04 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page

    Examples: 
      | FID    | planType | memberType              | claimSystem   |
      | 267688 | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |

  @claims05 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP GROUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP

    Examples: 
      | FID    | planType | memberType | claimSystem   |
      | 267688 | SSUP     | EOB_GROUP  | COSMOS_CLAIMS |

  @claims06 @SHIP7yearsClaims @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -To validate SHIP 6years back claims using Custom Search
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
    Then I custom search claims for ship users for 6 years claims on claims summary page
    Then I can see the claims displayed based on the selection on claims summary page
    And I validate the pagination on the claims summary page
    And I can see the learn more and print and download option on claims summary table section
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the Claims Total on claims details page
    And I validate the claims summary link on claims detail bottom page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the claims summary link on claims detail top page

    Examples: 
      | TID   | planType          | memberType | claimType | claimSystem          |
      | 15259 | SHIP              | COMBO      | NA        | 7Year_COMPASS_CLAIMS |
      
  #----- end of Regression claims scenarios section ------------------------
      