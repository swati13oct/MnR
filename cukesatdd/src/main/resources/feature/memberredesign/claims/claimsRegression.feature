@claims @thePredetors
Feature: 1.12 Member claims Summary page/claims Details page 

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of VBF claims scenarios section ------------------------
  # note: runner for sanity is RunMRATDDClaimsVBF
  # note: need to have these user entries in MemberRedesign-VBF.csv (users may need to be updated)
  # note:   q2_may_shipUAT001/Password@1,SHIP,SHIPCLAIMS,ShipInd
  # note:   q2_jun_uhc0004/Password@1,MAPD,UhcMapdInd
  # note:   q2_jun_aarp0028/Password@1,MAPD,COSMOSCLAIMS,ULayerInd
  # note:   q2_jun_aarp0210/Password@1,PDP,RxCLAIMS,ULayerInd
  # note:   q2_jun_grp0050/Password@1,PDP,RX_CLAIMS,grpPerf
  # note: 
  #----- beginning of VBF claims scenarios section ------------------
  @smokeTest @MemberVBF @rallyDashboard @testharness @vbfGate
  Scenario Outline: To validate that claims are present on claims summary page and claims details page for <claimSystem>
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
     # | ShipInd    | SHIP     | Last 24 months | SHIPCLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS |
     # | ULayerInd  | MAPD     | Last 24 months | NICECLAIMS   |
    #  | ULayerInd  | PDP      | Last 24 months | RxCLAIMS     |
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

  #----- beginning of Feature Gating scenarios section ------------------------
  # note: Step is already merged into E2E scenario, this scenario is purely for gating purposes.  
  # note: Can be remove later on for consolidation purposes
  @F279237
  Scenario Outline: To validate that segment ID present on claims summary page
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
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |

    Examples: 
      | memberType | planType | claimPeriod    | claimSystem  | segmentId |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS | 000       |
  #----- end of Feature Gating scenarios section ------------------------

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
  @claims01 @E2EClaimsMedicalCase @segmentId @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -Segment ID: <segmentId> - To validate the MEDICAL/SHIP claims Summary and details page E2E Scenario
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |
    #----------------- Test Custom calendar and search error cases --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
	Then I can validate the calendar will show up for custom search when click on From and To calendars    
    And I should be able to see the error message when no to and from dates being entered
    And I custom search claims for the following invalid time interval on claims summary page
      | Claims From Date | 01/02/2019 |
      | Claims To Date   | 01/02/2018 |
    Then I should be able to see the from date is greater than the to date error message being displayed
    And I custom search claims for over two years time interval from current date on claims summary page
    Then I should be able to see the search range is greater than two years error
	#----------------- Test for Custom search --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
    And I custom search claims for the specific time interval on claims summary page
    Then I can see the number of claims
    #----------------- Test for input specific claim period  --------------------------
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the number of claims
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

    @claims01a
    Examples: 
      | TID   | planType | memberType          | claimPeriod    | claimSystem     | segmentId | claimType         |
      | 15227 | MA       | AARP_Individual_000 | Last 24 months | NICE_CLAIMS     | 000       | Medical           |
      | 15234 | MA       | UHC_Individual      | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |
      | xxxxx | MA       | GROUP               | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |
    # note: no non-000 segment ID user for time being, uncomment this when data is available
    # | xxxxx | MA       | AARP_Individual_001 | Last 24 months | NICE_CLAIMS     | 001       | Medical           |

    @claims01b
    Examples: 
      | TID   | planType | memberType          | claimPeriod    | claimSystem     | segmentId | claimType         |
      | 15268 | PCP      | Individual          | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |

    @claims01c
    Examples: 
      | TID   | planType | memberType          | claimPeriod    | claimSystem     | segmentId | claimType         |
      | 15235 | MAPD     | UHC_Individual      | Last 24 months | M_NICE_CLAIMS   | 000       | Medical           |
      | 15230 | MAPD     | AARP_Individual     | Last 24 months | M_COSMOS_CLAIMS | 000       | Medical           |
      | xxxxx | MAPD     | COMBO_GROUP         | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |

    @claims01d
    Examples: 
      | TID   | planType | memberType          | claimPeriod    | claimSystem     | segmentId | claimType         |
      | 15236 | SHIP     | Individual          | Last 24 months | COMPASS_CLAIMS  | 000       | NA                |
      | 15259 | SHIP     | COMBO               | Last 24 months | COMPASS_CLAIMS  | 000       | NA                |

  ### note: keep PDP SSO_Individual case but comment out b/c it's hard to find a member that has SSO enabled
  @claims02 @E2EClaimsDrugCase @segmentId @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem>  -segmentId: <segmentId> - To validate the DRUG claims Summary E2E Scenario
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the number of claims
    Then I can see the claims displayed based on the selection on claims summary page
    And I validate the pagination on the claims summary page
    And I can see the learn more and print and download option on claims summary table section
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page

    @claims02a
    Examples: 
      | TID   | planType | memberType      | claimPeriod    | claimSystem     | segmentId | claimType         |
      | 15230 | MAPD     | AARP_Individual | Last 24 months | D_COSMOS_CLAIMS | 000       | Prescription drug |
      | 15235 | MAPD     | UHC_Individual  | Last 24 months | D_NICE_CLAIMS   | 000       | Prescription drug |

    @claims02b
    Examples: 
      | TID   | planType | memberType      | claimPeriod    | claimSystem     | segmentId | claimType         |
     #| 15299 | PDP      | SSO_Individual  | Last 24 months | RX_CLAIMS       | 000       | Prescription drug |
      | 15299 | PDP      | Individual      | Last 24 months | RX_CLAIMS       | 000       | Prescription drug |
      | 15300 | PDP      | GROUP           | Last 24 months | RX_CLAIMS       | 000       | Prescription drug |


  @claims03 @TC_09claimsPHIP @regressionMember
  Scenario Outline: TID: <TID> -plan: <planCategory> -planCategory: <planCategory> -claimSystem: <claimSystem> - To validate the Error Message for a PHIP  member on claims sumamry page
    Given login with following details logins in the member portal and validate elements
      | Plan Type     | <planType>     |
      | Plan Category | <planCategory> |
      | Claim System  | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I validate the error message for a PHIP Member on the screen

    Examples: 
      | TID   | planType | planCategory | claimSystem    |
      | 15258 | SHIP     | PHIP         | COMPASS_CLAIMS |

  ### note: pageNum is the claims page where the EOB pdf is located
  ### note: rowNum is the data row where EOB pdf is located - only count the data row, exclude header row
  ### note: comment out NICE entry for now since no user data available
  @claims04 @claimsEOB @US1268210 @F244667 @regressionMember
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
    Then I can see the number of claims
    Then I can see the claims displayed based on the selection on claims summary page
    When I navigate to the Claim details page to see eob link on details page
      | Page Number | <pageNum> |
      | Row Number  | <rowNum>  |
    Then I can validate the view as pdf link on claims details page header

    Examples: 
      | FID    | planType | memberType     | claimPeriod    | claimSystem   | pageNum | rowNum |
     #| 244667 | MA       | EOB_Individual | Last 24 months | NICE_CLAIMS   |       2 |      4 |
      | 244667 | MA       | EOB_Individual | Last 24 months | COSMOS_CLAIMS |       1 |      1 |

  @claims05 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
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

  @claims06 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
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

  @claims07 @SHIP7yearsClaims @regressionMember
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
    Then I can see the number of claims
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

