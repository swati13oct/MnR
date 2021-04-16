@prepareForNextYear
Feature: 1.25.1 Member Prepare For Next Year - Member Auth

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @memAuth_pfny01 @noTab
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
      | AEM Show Tab StartDate | 09/14/2020     |
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
    @memAuth_pfny01_offcycle
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	   #| 1-01  | F437767 | qavgogine | qavgogine | testUserName            | PDP	   | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | qavgogine | qavgogine | testUserName            | MA	   | GRP_OFFCYC_PFNY     |
	    | 1-03  | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group324    | MAPD     | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @memAuth_pfny01_preTermShip
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 1-04  | F437767 | qavgogine | qavgogine | preeffectiveFEDMA_001   | MA	   | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | qavgogine | qavgogine | q2_june_Cosmos_Seg056   | MA	   | IND_TERM_PFNY       |
	    | 1-06  | F437767 | qavgogine | qavgogine | q4_Ship_ANOC_009      | SHIP	   | IND_PFNY            |
			
	@memAuth_pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 1-07  | F443004 | qavgogine | qavgogine | q2_jun_grp0255          | PDP	   | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-08  | F443004 | qavgogine | qavgogine | q2_jun_grp0255          | SSP	   | COMBO_PDP_GRP_SSP_GRP_PFNY |
			
	@memAuth_pfny01_comboMaPdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 1-09  | F443004 | qavgogine | qavgogine | johndeere1001           | MA	   | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | qavgogine | qavgogine | johndeere1001           | PDP	   | COMBO_MA_GRP_PDP_GRP_PFNY |
			

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @memAuth_pfny02 @hasTab
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
      | AEM Show Tab StartDate | 09/14/2020     |
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

	@memAuth_pfny02_ind_mapd_aarp
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | qavgogine | qavgogine | q3_Sep_FedANOC_002     | MAPD	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@memAuth_pfny02_ind_mapd_uhc
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-02  | F437767 | qavgogine | qavgogine | q3_Sep_FedANOC_009     | MAPD	  | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@memAuth_pfny02_ind_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | qavgogine | qavgogine | q2_jun_aarp0112        | PDP	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

    #note: alternative q2_jun_uhc0050
	@memAuth_pfny02_ind_ma
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-04  | F437767 | qavgogine | qavgogine | perftest_federal_000002| MA	      | UHC_IND_PFNY | true| true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@memAuth_pfny02_ind_medica
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-05  | F437767 | qavgogine | qavgogine | RenewActive_Fed_083    | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@memAuth_pfny02_ind_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-06  | F437767 | qavgogine | qavgogine | q3_Sep_FedANOC_012     | PCP	  | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@memAuth_pfny02_grp_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-07  | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group074   | MAPD	  | UHC_GRP_PFNY | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#note: haven't been able to locate group user w/ 2021 doc yet
	#@memAuth_pfny02_grp_pdp
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName            | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group267   | PDP	   | UHC_GRP_PFNY | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#note: haven't been able to locate group user w/ 2021 doc yet
	#@memAuth_pfny02_grp_ma
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName            | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-09  | F437767 | qavgogine | qavgogine | q2_jun_grp0428         | MA	   | UHC_GRP_PFNY | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

    @memAuth_pfny02_ind_zh
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
        | 2-09  | F437767 | qavgogine | qavgogine | q3_Sep_FedANOC_005     | MAPD	  | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false   true        |

	#note: reenable when locate applicable user
    #@memAuth_pfny02_ind_1act
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName            | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-10  | F437767 | qavgogine | qavgogine | q4_dec_uhc102          | MAPD	   | UHC_IND_1ACT_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true        |

    #this user doesn't have anoc, re-enable this when finding a user that has it
    #@memAuth_pfny02_combo_ship_fed
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName          | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-11  | F443004 | qavgogine | qavgogine | GENARO_Q4_COMBO      | MAPD	 | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | true  | true  | true  | false | true          |

    @memAuth_pfny02_combo_fed_ship
    Examples: 
	    | index | FID     | username  | password  | MemUserName          | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-12  | F443004 | qavgogine | qavgogine | q4_ShipVAS_005  | PDP	    | COMBO_PDP_IND_SHIP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |


  @memAuth_pfny03 @hasTab @noCombTabOnPfny
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
      | AEM Show Tab StartDate | 09/14/2020     |
      | AEM Show Tab EndDate   | 12/31/2020     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates the combo user with ship plan should not see ship tab on the Prepare For Next Year page

	@memAuth_pfny03a
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-01  | F437767 | qavgogine | qavgogine | GENARO_Q4_COMBO         | SHIP	   | COMBO_SHIP_MAPD_IND_PFNY|
			
	@memAuth_pfny03b
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-02  | F437767 | qavgogine | qavgogine | q4_ShipVAS_005     | SHIP	   | COMBO_PDP_IND_SHIP_PFNY |

  @memAuth_pfny04 @hasTab
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
	Then test setup stores AEM and timeline milestones info for user with SARs plan 
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 10/02/2020     |
      | AEM Show Tab EndDate   | 12/31/2020     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 10/01/2020     |
      | Milestone 2 Date       | 10/15/2020     |
      | Milestone 3 Date       | 01/01/2021     |
    Then test setup stores documents expectation info for user with SARs plan 
      | Show Next Year PlanName| <showNxtYrPlan>|
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
    Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content for user with SARs plan

    @memAuth_pfny04_sars @devRegression
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              | showNxtYrPlan |  
	    | 4-01  | F443004 | qavgogine | qavgogine | q3_Sep_FedANOC_037      | MA     | UHC_SARS_PFNY           | false         |
	    | 4-02  | F443004 | qavgogine | qavgogine | PerfCCM_07109           | MAPD     | SARS_PFNY           | false         |

	#note: don't have PDP SAR user for the time being
    #@memAuth_pfny04_sars
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName             | planType | memberType              | showNxtYrPlan |  
	#    | 4-02  | F443004 | qavgogine | qavgogine | testUserName            | PDP      | SARS_PFNY               | false         |
	    