@claimsMicroApp @thePredetors
Feature: 1.12 To validate the claims Summary page and claims Details page on the member site

#----- beginning of VBF section ----------------------------------------------------
  @F355345
  Scenario Outline: -planType: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -Segment ID: <segmentId> - To validate the MEDICAL/SHIP claims Summary and details page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Claim System   | <claimSystem>   |
      | Member Type    | <memberType>    |
      | User Selection | <userSelection> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #----------------- Test for input specific claim period  --------------------------
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the number of claims
    And I validate the pagination on the claims summary page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the Claims Total on claims details page

    Examples: 
      | planType | userSelection | memberType      | claimSystem     | claimType         | claimPeriod    | 
      | MAPD     | xxxxx         | ULayerInd       | COSMOSCLAIMS    | Medical           | Last 24 months | 
      | MAPD     | xxxxx         | ULayerInd       | NICECLAIMS      | Medical           | Last 24 months | 
      | MAPD     | xxxxx         | ULayerInd       | RxCLAIMS        | Prescription drug | Last 24 months | 

#----- end of VBF section ----------------------------------------------------------

#----- beginning of regression section ---------------------------------------------
  @claimsMicroApp01
  Scenario Outline: -index: <index> -TID: <TID> -planType: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -Segment ID: <segmentId> - To validate the MEDICAL/SHIP claims Summary and details page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
    When I navigate to the claims Summary page from dashboard or testharness page
    #When I am validating UI only
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

    @mapd_medical_cosmos1 @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 01_1  | 15230 | MAPD-COS-q3_sep_uat4_cosmos_008   | MAPD     | AARP_Individual | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 
      | 01_2  | xxxxx | MAPD-q3_sep_UAT4_Group029         | MAPD     | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 
      | 01_3  | 15235 | MAPD-UHC-COSMOS-q2_jun_uhc0009    | MAPD     | UHC_Individual  | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 

    @mapd_medical_cosmos2 @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 01_4  | xxxxx | SSP_CLAIMS_q1_feb_ssp_001         | SSUP     | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 
      | 01_5  | 15268 | MEDICA-COSMOS-q2_jun_sofl0013     | MEDICA   | Individual      | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 
      | 01_6  | 15268 | PCP_CLAIMS_q3_sept_UAT4_AARP_032  | PCP      | Individual      | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 

	 # note: don't have a working user that is SSP COMBO
     #| 01_4  | 15259 | SSP-UHC-GROUP-COSMOS-q2_dec_grp0288 | SSUP   | UHC_COMBO_GROUP | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 

    @ma_medical_cosmos @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 02_1  | 15234 | MA-q2_may_rally017                | MA       | UHC_Individual  | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months |
      | 02_2  | xxxxx | MA-COS-q2_jun_grp0154             | MA       | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Last 24 months | 

    @mapd_medical_nice @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 03_1  | 15235 | NICE-q2_jun_aarp0028              | MAPD     | AARP_Individual | NICE_CLAIMS     | Medical           | 000       | Last 24 months | 

    @ship @devRegression @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 04_1  | 15236 | SHIP_CLAIMS_q1_feb_2020SHIP_034   | SHIP     | Individual      | COMPASS_CLAIMS  | NA                | 000       | Last 24 months | 

    #These items still pending data
    # | 15227 | MA       | AARP_Individual_000 | Last 24 months | NICE_CLAIMS     | 000       | Medical           |
    # | xxxxx | MA       | AARP_Individual_001 | Last 24 months | NICE_CLAIMS     | 001       | Medical           |


  ### note: this scenario is identical to the medical claims, any update related to summary steps need to apply to both scenarios
  ### note: this scenario doesn't contains steps related to detail page because drug case doesn't have detail page 
  @claimsMicroApp02
  Scenario Outline: -index: <index> -TID: <TID> -planType: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -Segment ID: <segmentId> - To validate the DRUG claims Summary page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
    When I navigate to the claims Summary page from dashboard or testharness page
    #When I am validating UI only
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #Then I can validate the segment ID value in localStorage on claims summary page
    #  | Segment ID   | <segmentId>   |
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

    @mapd_drug @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    | 
      | 05_1  | xxxxx | MAPD-q3_sep_UAT4_Group029         | MAPD     | UHC_GROUP       | RX_CLAIMS       | Prescription drug | 000       | Last 24 months | 
      | 05_2  | 15230 | MAPD-RX-q2_jun_aarp0042           | MAPD     | AARP_Individual | RX_CLAIMS       | Prescription drug | 000       | Last 24 months | 
      | 05_3  | 15235 | MAPD-UHC-COSMOS-q2_jun_uhc0009    | MAPD     | UHC_Individual  | RX_CLAIMS       | Prescription drug | 000       | Last 24 months | 

    @pdp_drug @devRegression @mocked
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | claimPeriod    |
      | 06_1  | 15299 | PDP-RX-q3_sep_UAT4_AARP315        | PDP      | Individual      | RX_CLAIMS       | Prescription drug | 000       | Last 24 months |
      | 06_2  | 15300 | PDP-RX-q3_sep_UAT4_Group217       | PDP      | GROUP           | RX_CLAIMS       | Prescription drug | 000       | Last 24 months |


  @claimsMicroApp03 @TC_09claimsPHIP @regressionMember
  Scenario Outline: -TID: <TID> -planType: <planType> -claimSystem: <claimSystem> - To validate the Error Message for a PHIP  member on claims sumamry page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Plan Category  | <planCategory>  |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I validate the error message for a PHIP Member on the screen

    @devRegression @mocked
    Examples: 
      | TID   | userSelection                | planType | planCategory | claimSystem    |
      | 15258 | SHIP-COM-q2_june_preffec_019 | SHIP     | PHIP         | COMPASS_CLAIMS |


  ### Waiting for data
  ### note: pageNum is the claims page where the EOB pdf is located
  ### note: rowNum is the data row where EOB pdf is located - only count the data row, exclude header row
  ### note: comment out NICE entry for now since no user data available
  #@claimsMicroApp04 @claimsEOB @US1268210 @F244667 @regressionMember
  #Scenario Outline: -FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims eob link on claims detail page
  #  Given login with following details logins in the member portal and validate elements
  #    | Plan Type      | <planType>    |
  #    | Member Type    | <memberType>  |
  #    | Claim System   | <claimSystem> |
  #    | User Selection | <userSelection> |
  #  When I navigate to the claims Summary page from dashboard or testharness page
  #  And I can search claims for the following claim period on claims summary page
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #    | Claim Period | <claimPeriod> |
  #    | Claim System | <claimSystem> |
  #  Then I can see the number of claims
  #  Then I can see the claims displayed based on the selection on claims summary page
  #  When I navigate to the Claim details page to see eob link on details page
  #    | Page Number | <pageNum> |
  #    | Row Number  | <rowNum>  |
  #  Then I can validate the view as pdf link on claims details page header
  #
  #  Examples: 
  #    | FID    | userSelection | planType | memberType     | claimPeriod    | claimSystem   | pageNum | rowNum |
  #   #| 244667 | TBD           | MA       | EOB_Individual | Last 24 months | NICE_CLAIMS   |       2 |      4 |
  #    | 244667 | TBD           | MA       | EOB_Individual | Last 24 months | COSMOS_CLAIMS |       1 |      1 |

  ### Waiting for data
  #@claimsMicroApp05 @US1662790 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  #Scenario Outline: -FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP member accessing EOB page via deep link
  #  Given login with following details logins in the member portal and validate elements
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #    | Claim System | <claimSystem> |
  #    | User Selection | <userSelection> |
  #  When I navigate to the claims Summary page from dashboard or testharness page
  #  Then Explanation of benefits sub navigation under Claims tab is not displayed
  #  Then Explanation of benefits deep link is invoked and validate the Page
  #
  #  Examples: 
  #    | FID    | userSelection | planType | memberType              | claimSystem   |
  #    | 267688 | TBD           | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |

  @claimsMicroApp06 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
  Scenario Outline: -FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP GROUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP

    @devRegression @mocked
    Examples: 
      | FID    | userSelection                 | planType | memberType | claimSystem   |
      | 267688 | SSP-GRP-q2_june_Cosmos_Seg233 | SSUP     | EOB_GROUP  | COSMOS_CLAIMS |

  @claimsMicroApp07 @SHIP7yearsClaims @regressionMember
  Scenario Outline: -TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -To validate SHIP 6years back claims using Custom Search
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
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

    @devRegression @mocked
    Examples: 
      | TID   | userSelection             | planType | memberType | claimType | claimSystem          |
      | 15259 | SHIP-COM-SHIP7yearsclaims | SHIP     | Individual | NA        | 7Year_COMPASS_CLAIMS |

#----- end of regression section ---------------------------------------------------
