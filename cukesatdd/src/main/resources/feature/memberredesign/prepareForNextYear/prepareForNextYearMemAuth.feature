@prepareForNextYear
Feature: 1.25.1 Member Prepare For Next Year - Member Auth

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @memAuth_prepareForNextYear01 @noTab
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
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
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 06/14/2020     |
      | AEM Show Tab EndDate   | 12/31/2020     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page

    # note: all available PDP group offcycle users are COMBO user, tab will not show for combo user anyway 
    # note: no MA offcycle user available at the moment
    @memAuth_prepareForNextYear01a
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	   #| 01    | F437767 | qavgogine | qavgogine | testUserName            | PDP	   | GRP_OFFCYC_PFNY     |
	   #| 02    | F437767 | qavgogine | qavgogine | testUserName            | MA	   | GRP_OFFCYC_PFNY     |
	    | 03    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group324    | MAPD     | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @memAuth_prepareForNextYear01b
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 04    | F437767 | qavgogine | qavgogine | preeffectiveFEDMA_001   | MA	   | IND_PREEFF_PFNY     |
	    | 05    | F437767 | qavgogine | qavgogine | q2_june_Cosmos_Seg056   | MA	   | IND_TERM_PFNY       |
	    | 06    | F437767 | qavgogine | qavgogine | PaidInFullShip0011      | SHIP	   | IND_PFNY            |
			
	@memAuth_prepareForNextYear01c
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 07    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group163    | SHIP	   | COMBO_SHIP_MAPD_PFNY|
	    | 08    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group163    | MAPD	   | COMBO_SHIP_MAPD_PFNY|
			
	@memAuth_prepareForNextYear01d
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 09    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_AARP013     | PDP	   | COMBO_PDP_SHIP_PFNY |
	    | 10    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_AARP013     | SHIP	   | COMBO_PDP_SHIP_PFNY |
			

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @memAuth_prepareForNextYear02 @hasTab
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
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
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 08/31/2020     |
      | AEM Show Tab EndDate   | 12/31/2020     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then test setup stores documents expectation info  
      | Show Next Year PlanName| <showNxtYrPlan>|
      | Annual Notice of Changes English       | <an_us> | 
      | Annual Notice of Changes Spanish       | <an_es> |
      | Annual Notice of Changes Chinese       | <an_zh> |
      | Evidence of Coverage English           | <ev_us> |
      | Evidence of Coverage Spanish           | <ev_es> |
      | Evidence of Coverage Chinese           | <ev_zh> |
      | Comprehensive Formulary English        | <co_us> |
      | Comprehensive Formulary Spanish        | <co_es> |
      | Comprehensive Formulary Chinese        | <co_zh> |
      | Provider Directory English             | <pr_us> |
      | Provider Directory Spanish             | <pr_es> |
      | Provider Directory Chinese             | <pr_zh> |
      | Vendor Information Sheet English       | <ve_us> |
      | Vendor Information Sheet Spanish       | <ve_es> |
      | Vendor Information Sheet Chinese       | <ve_zh> |
      | Pharmacy Directory Information English | <ph_us> |
      | Pharmacy Directory Information Spanish | <ph_es> |
      | Pharmacy Directory Information Chinese | <ph_zh> |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
    Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content

	@memAuth_prepareForNextYear02a
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 11    | F437767 | qavgogine | qavgogine | q2_apr_aarp0250        | MAPD	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 12    | F437767 | qavgogine | qavgogine | ucpaarpmapd01          | MAPD	  | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@memAuth_prepareForNextYear02b
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 13    | F437767 | qavgogine | qavgogine | q2_jun_aarp0112        | PDP	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 14    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_AARP203    | MA	      | UHC_IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@memAuth_prepareForNextYear02c
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 18    | F437767 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020    | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 19    | F437767 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022    | PCP	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	# ignore group cases for now until code is ready
	#@memAuth_prepareForNextYear02d
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 16    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group074   | MAPD	   | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#@memAuth_prepareForNextYear02e
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 15    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group316   | PDP	   | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |
	#    | 17    | F437767 | qavgogine | qavgogine | q2_jun_grp0428         | MA	   | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |
	    