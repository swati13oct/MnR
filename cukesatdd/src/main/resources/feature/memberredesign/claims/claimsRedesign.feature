@claims @theTransformers
Feature: T1.1To validate the new changes related to claims page on the member site

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


    #----- beginning of VBF claims scenarios section ------------------   
    @smokeTest @MemberVBF @rallyDashboard @testharness
    Scenario Outline: To validate that claims are present on claims summary page and claims details page for <claimssystem>
	    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
          | Claim System   | <claimSystem>  |
	      | Member Type    | <memberType>   |
	    When I navigate to the claims Summary page from dashboard or testharness page
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
        Then I validate the claims displayed based on the selection on claims summary page
		And I validate the EOB section based on claims system on claims summary page
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
        And I validate the DownloadMyData section on claims summary page
	      | Plan Type    | <planType>    |
        And I can navigate to the Claim Details page from claims summary page
          | Claim System | <claimSystem> |
        And I can validate the Claims Table on claims details page
        And I can validate the Claims Total on claims details page

	    @smokeTest_Claims
        Examples: 
          | memberType   | planType | claimPeriod    | claimSystem  | 
 	      | ShipInd 	 | SHIP     | Last 24 months | SHIPCLAIMS   | 
          | ULayerInd 	 | MAPD     | Last 24 months | COSMOSCLAIMS | 
          | ULayerInd	 | MAPD     | Last 24 months | NICECLAIMS   | 
       	  | ULayerInd    | MAPD     | Last 24 months | RxCLAIMS     | 
       #  | BlueLayerInd | MAPD     | Last 24 months | COSMOSCLAIMS | 
       #  | BlueLayerInd | MAPD     | Last 24 months | RxCLAIMS     | 
       #  | BlueLayerInd | MAPD     | Last 24 months | NICECLAIMS   | 
       #  | GroupRetiree | MAPD     | Last 24 months | COSMOSCLAIMS | 
       #  | GroupRetiree | MAPD     | Last 24 months | NICECLAIMS   | 
       #  | GroupRetiree | MAPD     | Last 24 months | RxCLAIMS     | 

       @gatingTest_Claims
       Examples: 
          | memberType   | planType | claimPeriod    | claimSystem  |
 		  | ShipInd 	 | SHIP     | Last 24 months | SHIPCLAIMS   |
          | ULayerInd 	 | MAPD     | Last 24 months | COSMOSCLAIMS |
       #  | ULayerInd	 | MAPD     | Last 24 months | NICECLAIMS   |
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
          | Plan Type      | <planType>     |
          | Claim System   | <claimSystem>  |
	      | Member Type    | <memberType>   |
	    When I navigate to the claims Summary page from dashboard or testharness page
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
        Then I validate the claims displayed based on the selection on claims summary page
    
        Examples: 
          | memberType    | planType | claimPeriod     | claimSystem |
 	      | grpPerf 	  | PDP      | Last 24 months  | NICECLAIMS  |

    #----- end of VBF claims scenarios section ------------------------   


    @claims01 @E2EClaimstcase @regressionMember
    Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims Summary and details page E2E Scenario
	Given login with following details logins in the member portal and validate elements
         | Plan Type      | <planType>     |
	     | Member Type    | <memberType>   |
         | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
	Then I can validate the claims summary header on claims summary page
	     | Plan Type      | <planType>     |
	     | Member Type    | <memberType>   |
	And I can search claims for the following claim period on claims summary page
	     | Plan Type    | <planType>    |
	     | Claim Period | <claimPeriod> |
	Then I can see the claims displayed based on the selection on claims summary page
	And I validate the pagination on the claims summary page
	And I can see the learn more and print and download option on claims summary table section 
	And I validate the EOB section based on claims system on claims summary page
	     | Plan Type    | <planType>    |
	     | Claim System | <claimSystem> |
	And I validate the DownloadMyData section on claims summary page
	     | Plan Type    | <planType>    |
	Then I navigate to the Claim Details page from claims summary page
	     | Plan Type  | <planType>    |
	And I validate the Claims Total on claims details page
	     | Plan Type  | <planType>    |
	And I validate the claims summary link on claims detail bottom page
	     | Plan Type  | <planType>    |
	Then I navigate to the Claim Details page from claims summary page
	     | Plan Type  | <planType>    |
	And I validate the claims summary link on claims detail top page
	     | Plan Type  | <planType>    |
	Then I validate Claim Details page content value and Learn More and EOB and tooltops		  
	     | Plan Type    | <planType>    |
	     | Claim System | <claimSystem> |
	  
	   Examples:   
	     | TID   | planType | memberType | claimPeriod    | claimSystem   | 
	     | 15227 | MA       | Individual | Last 24 months | NICE_CLAIMS   | 
	     | 15230 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS |
	     | 15299 | PDP      | Individual | Last 24 months | RX_CLAIMS     | 
	     | 15227 | MA       | Individual | Last 24 months | COSMOS_CLAIMS |
	     | 15230 | MAPD     | Individual | Last 24 months | NICE_CLAIMS   |
	     | 15236 | SHIP     | Individual | Last 24 Months | COMPASS_CLAIMS|
         | 15300 | PDP      | GROUP      | Last 24 months | RX_CLAIMS     |
         | 15259 | SHIP     | COMBO      | Last 24 months | COMPASS_CLAIMS|
	     | 15268 | PCP      | Individual | Last 24 months | COSMOS_CLAIMS |
	     | xxxxx | MAPD     | GROUP      | Last 24 months | COSMOS_CLAIMS |
	     | xxxxx | MA       | GROUP      | Last 24 months | COSMOS_CLAIMS | 

#    #need test data to execute this specific scenario, will re-active this once data is available
 @claims6 @TC_09claimsPHIP @regressionMember
  Scenario Outline: TID: <TID> -plan: <planCategory> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the Error Message for a PHIP  member on claims sumamry page
    Given login with following details logins in the member portal and validate elements
      | Plan Type     | <planType>     |
      | Plan Category | <planCategory> |
      | Member Type   | <memberType>   |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I validate the error message for a PHIP Member on the screen

    Examples: 
      | TID   | planType | planCategory | memberType |
      | 15258 | SHIP     | PHIP         | SHIP_PHIP  |
      
    @claims01 @claimsEOB @US1268210 @F244667 @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims eob link on claims detail page
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
          | Plan Type    | <planType>    |
          | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection on claims summary page
    When I navigate to the Claim details page to see eob link on details page
    Then I can validate the view as pdf link on claims details page header
          | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |

    Examples: 
          | FID    | planType | memberType     | claimPeriod    | claimSystem  |
          | 244667 | MA       | EOB_Individual | Last 24 months | NICE_CLAIMS  |

    @claims02 @claims16 @US1662790 @F267688 @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that sub-navigation to EOB page under Claims tab is suppressed for SSUP Only Plan member
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
 		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed

    Examples: 
          | FID    | planType | memberType              | claimSystem   |
          | 267688 | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |
      
    @claims03 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page
    Examples: 
          | FID    | planType | memberType              | claimSystem   |
          | 267688 | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |
      
      
    @claims04 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate that SSUP GROUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP
    Examples: 
          | FID    | planType | memberType | claimSystem   |
          | 267688 | SSUP     | EOB_GROUP  | COSMOS_CLAIMS |

	     
	#----- beginning of claims00 ---------------------------------------------------------
	# DO NOT REMOVE this scenario
    # This scenario is not part of the regular regression run BUT is a daily run being monitored by the team
    # note: bypassIssue-1 - YourShare value mismatch between summary and detail - INC10332773
    # note: bypassIssue-2 - MA NICE missing Search EOB History on both summary and detail page - INC11365785
    # note: bypassIssue-2 - MAPD NICE missing Search EOB History on detail page - INC11365785
    # note: bypassIssue-3 - MA and MAPD NICE missing This page contains PDF doc text on detail page - INC11365785
	# note: any additional Example will need to tag with either one of these 
	# note:   @claims00_COSMOS_MEDICAL, @claims00_COSMOS_DRUG, 
	# note:   @claims00_NICE_MEDICAL, @claims00_NICE_DRUG or @claims00_NOT_NICE_OR_COSMOS
	# note: 
	#----------------------------------------------------------------------------------
    @claims00 @def1041 @thePredators
	Scenario Outline: DID: <DID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -claimType: <claimType> - <index> - Perform detail validation for claims on both summary and detail page for each search range options
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>           |
		  | Member Type    | <memberType>         |
		  | Claim System   | <claimSystem>        |
	    When if I access via dashboard I can navigate to claims summary page from View Your Claims 
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type    | <planType>             |
		  | Member Type    | <memberType>         |
		#----------------- Test Custom search error cases --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type    | <memberType>          |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		And I should be able to see the error message when no to and form dates being entered
		And I custom search claims for the following invalid time interval on claims summary page
		  | Plan Type        | <planType>          |
		  | Claims From Date | 01/02/2019          |
		  | Claims To Date   | 01/02/2018          |
		Then I should be able to see the from date is greater than the to date error message being displayed
		  | Plan Type        | <planType>          |
		And I custom search claims for over two years time interval from current date on claims summary page
		  | Plan Type        | <planType>          |
		Then I should be able to see the search range is greater than two years error
		  | Plan Type        | <planType>          |
		#----------------- Test for Custom search --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type    | <memberType>          |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		And I custom search claims for the specific time interval on claims summary page
		  | Plan Type    | <planType>              |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		#----------------- Test for- Last 30 days --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 30 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 30 days            |
		#----------------- Test for Last 90 days --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 90 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 90 days            |
		#----------------- Test for Last 6 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 6 months           |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 6 months           |
		#----------------- Test for Last 12 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 12 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 12 months          |
		#----------------- Test for Last 24 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 24 months          |
		Then I can validate the learn more and print and download option and DownloadMyData section on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim Period | Last 24 months          |
		Then I can validate claims table displayed based on the selection on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		And I can validate the EOB section based on claims system on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim System | <claimSystem>           |
		And I validate the Need Help section content on claims summary page
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		#----------------- Final Test claims number makes sense from search periods --------------
		And I can validate the numbers of claims from all search periods
		  | Flag Zero Claims User | <flagZeroClaimsUser> |
		  
	@claims00_01 @claims00_MAPD @claims00_COSMOS_MEDICAL @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser | 
	  |01    |1041| MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS| Medical           | Yes                | 

	@claims00_02 @claims00_MAPD @claims00_COSMOS_DRUG @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |02    |1041| MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Prescription drug| No                 |

	@claims00_03 @claims00_MA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |03    |1041| MA       | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_04 @claims00_MA @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |04    |1041| MA       | Individual                 | NICE_CLAIMS  | Medical           | Yes                |

	@claims00_05 @claims00_MAPD @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |05    |1041| MAPD     | Individual                 | NICE_CLAIMS  | Medical           | Yes                |

	@claims00_06 @claims00_MAPD @claims00_NICE_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |06    |1041| MAPD     | Individual                 | NICE_CLAIMS  | Prescription drug | No                 |

	@claims00_07 @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |07    |1041| MAPD     | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_08 @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |08    |1041| MAPD     | Individual                 | COSMOS_CLAIMS| Prescription drug | No                 |

	@claims00_09 @claims00_PCP @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |09    |1041| PCP      | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_10 @claims00_PCP @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem    | claimType         | flagZeroClaimsUser |
	  |10    |1041| PCP      | Individual                 | COSMOS_CLAIMS  | Prescription drug | No                 |

	@claims00_11 @claims00_MEDICA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |11    |1041| MEDICA   | Individual                 | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_12 @claims00_MEDICA @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |12    |1041| MEDICA   | Individual                 | COSMOS_CLAIMS | Prescription drug | Yes                |

	@claims00_13 @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |13    |1041| PDP      | Individual                 | RX_CLAIMS     | Prescription drug | Yes                |

	@claims00_14 @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |14    |1041| SHIP     | Individual                 | COMPASS_CLAIMS| NA                | Yes                |

	@claims00_15 @claims00_COMBO @claims00_GROUP @claims00_PDP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |15    |1041| PDP      | COMBO_GROUP                | RX_CLAIMS     | Prescription drug | No                 |

	@claims00_16 @claims00_COMBO @claims00_GROUP @claims00_SSUP @claims00_COSMOS @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |16    |1041| SSUP     | COMBO_GROUP                | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_17 @claims00_COMBO @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |17    |1041| SHIP     | COMBO                      | COMPASS_CLAIMS| NA                | Yes                |

	@claims00_18 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |18    |1041| MAPD     | GROUP                      | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_19 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |19    |1041| MAPD     | GROUP                      | COSMOS_CLAIMS | Prescription drug | No                 |

	@claims00_20 @claims00_GROUP @claims00_MA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |20    |1041| MA       | GROUP                      | COSMOS_CLAIMS | Medical           | No                 |

	@claims00_21 @claims00_GROUP @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |21    |1041| PDP      | GROUP                      | RX_CLAIMS     | Prescription drug | No                 |

    #note: these will be in team-a env only
	#  |xx    |1041| MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Medical           | No                |
	#  |xx    |1041| MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Prescription drug | No                |
	#----- end of claims00 ---------------------------------------------------------------

	

    #----- beginning of claims test for offline prod - local run only ------------------
	# DO NOT REMOVE this scenario
    # This scenario is not part of the regular regression run BUT is for aiding the team to do offline prod testing if needed
    # note: this setup is for the case when we need to validate on offline prod environment
    # note: this is intended for local run where you can put in your own member auth username/password and offline username
    # note: run with environment variable set to offline. -Denvironment="offline"
    # note: *** DO NOT save your login or test username to github ***
    # note: replace the following fields with valid value -
    # note:   username = your memAuth page login username 
    # note:   password = your memAuth page login password
    # note:   MemUsername =  username of the user on offline prod that you want to test
    # note:   planType = the type of plan this test user has e.g. MAPD/MA/SHIP, etc
    # note:   memberType = e.g. Individual / GROUP/ COMBO, etc
    # note:   claimSystem = e.g. COSMOS / NICE / RX / COMPASS
    # note:   claimType = e.g. Prescription drug / Medical / NA (for ship)        
    # note:   flagZeroClaimsUser = Yes / No (do you want to fail the test if user has 0 claims)
    @forLocalTestOnly
	Scenario Outline: To validate via member authorization access 
	    Given the user is on member auth login flow page
	    When the member is able to login with correct username and password
	      | Username      | <username>     |
	      | Password      | <password>     |
	    And Member Enters the Username he wants to search
	      | MemUsername | <MemUserName> |   
	    And user clicks on member to select
	    When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type    | <planType>             |
		  | Member Type    | <memberType>         |
		#----------------- Test for Last 24 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 24 months          |
		Then I can validate the learn more and print and download option and DownloadMyData section on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim Period | Last 24 months          |
		Then I can validate claims table displayed based on the selection on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		And I can validate the EOB section based on claims system on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim System | <claimSystem>           |
		And I validate the Need Help section content on claims summary page
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		  
  Examples: 
	  |index |TID | username   | password   | MemUserName  | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |01    |000 | myUsername | myPassword | testUsername | SHIP     | COMBO                      | COMPASS_CLAIMS| NA                | Yes                |
    #----- end of claims test for offline prod - local run only ------------------------

