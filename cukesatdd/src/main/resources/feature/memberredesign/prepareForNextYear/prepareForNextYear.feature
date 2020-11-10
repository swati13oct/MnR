@prepareForNextYear
Feature: 1.25 Member Prepare For Next Year

##### note: team and stage may have different AEM date setup, separate the scenarios

##### begin - cases for team env #################################################################
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @pfny01 @noTab @regressionMember @teamEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 06/16/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page

    # note: all available PDP group offcycle users are COMBO user, tab will not show for combo user anyway 
    # note: no MA offcycle user available at the moment
    @pfny01_offcycle @devRegression
    Examples: 
	    | index | FID     | planType | memberType          |
	   #| 1-01  | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 1-03  | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

	#note: activate when ship user is available		
    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @pfny01_preTermShip
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-04  | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | SHIP	 | IND_PFNY            |
	
	@pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | planType | memberType                 |
	    | 1-07  | F443004 | PDP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-08  | F443004 | SSP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |

	@pfny01_comboMaPdp
    Examples: 
	    | index | FID     | planType | memberType                |
	    | 1-09  | F443004 | MA	     | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | PDP	     | COMBO_MA_GRP_PDP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @pfny02 @hasTab @regressionMember @teamEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 06/16/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
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

	@pfny02_ind_mapd_aarp @devRegression
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-01  | F437767 | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_mapd_uhc 
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-02  | F437767 | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_pdp
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-03  | F437767 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@pfny02_ind_ma
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-04  | F437767 | MA	     | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_medica
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-05  | F437767 | MEDICA	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_pcp
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-06  | F437767 | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_grp_mapd @devRegression
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-07  | F443004 | MAPD	 | UHC_GRP_PFNY| true | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |

	@pfny02_grp_pdp
    Examples: 
	    | index | FID     | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-08  | F443004 | PDP	     | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |  

	@pfny02_grp_ma
    Examples: 
	    | index | FID     | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-09  | F443004 | MA	     | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |

    @pfny02_ind_zh
    Examples: 
	    | index | FID     | planType | memberType           | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
        | 2-10  | F437767 | MAPD	 | IND_ESZH_PFNY        | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false | true          |

	# note: re-enable when user available
    #@pfny02_ind_1act
    #Examples: 
	#    | index | FID     | planType | memberType           | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
<<<<<<< HEAD
    #    | 2-11  | F437767 | MAPD	 | UHC_IND_1ACT_PFNY    | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
=======
    #    | 2-11  | F437767 | MAPD	  | UHC_IND_1ACT_PFNY    | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    #note: this user doesn't have anoc, re-enable this when finding a user that has it
    #@pfny02_combo_ship_fed
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-12  | F443004 | MAPD	  | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true  | true  | true  | false | false | false | true          |

    @pfny02_combo_fed_ship @devRegression
    Examples: 
	    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-13  | F443004 | PDP	     | COMBO_PDP_IND_SHIP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |


  @pfny03 @hasTab @noCombTabOnPfny @regressionMember @teamEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 06/16/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates the combo user with ship plan should not see ship tab on the Prepare For Next Year page

	@pfny03a
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-01  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@pfny03b
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-02  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |
			

  @pfny04 @hasTab @regressionMember @teamEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
	Then test setup stores AEM and timeline milestones info for user with SARs plan 
      | EndOfTestRollBackTime  | false          |
      | AEM Show Tab StartDate | 06/16/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
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

    @pfny04_sars @devRegression
    Examples: 
	    | index | FID     | planType | memberType              | showNxtYrPlan |  
	    | 4-01  | F443004 | MA       | UHC_SARS_PFNY           | false         |
	    | 4-02  | F443004 | MAPD     | SARS_PFNY               | false         |

<<<<<<< HEAD
    @pfny04_sars
    Examples: 
	    | index | FID     | planType | memberType              | showNxtYrPlan |  
	    | 4-02  | F443004 | PDP      | SARS_PFNY               | false         |
=======
	#note: don't have PDP SAR user for the time being
    #@pfny04_sars
    #Examples: 
	#    | index | FID     | planType | memberType              | showNxtYrPlan |  
	#    | 4-02  | F443004 | PDP      | SARS_PFNY               | false         |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

	    
##### end - cases for team env #################################################################

##### begin - cases for stage env #################################################################
  #----- begin sanity
  #note: code will skip some validations for sanity when it see the sanity tag
  @sanity01 @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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
<<<<<<< HEAD
=======
	##note: will only valiate timeline box for sanity
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
	Then the user validates Prepare For Next Year page content

	@pfny_ind_mapd_aarp_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-01 | F437767 | kkumard   | mnrs786@  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny_grp_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-06 | F437767 | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |


  
  #----- begin regression
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @pfny01 @noTab @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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
    @pfny01_offcycle
    Examples: 
	    | index | FID     | planType | memberType          |
	   #| 1-01  | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 1-03  | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @pfny01_preTermShip
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-04  | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | SHIP	 | IND_PFNY            |

	@pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-07  | F443004 | PDP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-18  | F443004 | SSP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |

	@pfny01_comboMaPdp
    Examples: 
	    | index | FID     | planType | memberType                |
	    | 1-09  | F443004 | MA	     | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | PDP	     | COMBO_MA_GRP_PDP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @pfny02 @hasTab @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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

	@pfny02_ind_mapd_aarp
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_mapd_uhc
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-02  | F437767 | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_pdp
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_ind_ma
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-04  | F437767 | MA	     | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

    #note: not stable, API get non-200 from time to time
	@pfny02_ind_medica
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-05  | F437767 | MEDICA	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

    #note: not stable, API get non-200 from time to time
	@pfny02_ind_pcp
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-06  | F437767 | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@pfny02_grp_mapd
    Examples: 
	    | index | FID     | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-07  | F443004 | MAPD	 | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#note: haven't been able to locate group user w/ 2021 doc yet
	#@pfny02_grp_pdp
    #Examples: 
	#    | index | FID     | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F443004 | PDP	  | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#note: haven't been able to locate group user w/ 2021 doc yet
	#@pfny02_grp_ma
    #Examples: 
	#    | index | FID     | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
<<<<<<< HEAD
	#   | 2-09  | F443004 | MA	     | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true           |
=======
	#    | 2-09  | F443004 | MA	      | UHC_GRP_PFNY | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    @pfny02_ind_zh
    Examples: 
	    | index | FID     | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
        | 2-10  | F437767 | MAPD	 | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false | true          |

	#note: re-enable when user available
    #@pfny02_ind_1act
    #Examples: 
	#    | index | FID     | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
<<<<<<< HEAD
    #    | 2-11  | F437767 | MAPD	 | UHC_IND_1ACT_PFNY | false | false | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true        |

    #note: this user doesn't have anoc, re-enable this when finding a user that has it
    #@pfny02_combo_ship_fed
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-12  | F443004 | MAPD	 | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | true  | true  | true  | false | true          |
=======
    #    | 2-11  | F437767 | MAPD	  | UHC_IND_1ACT_PFNY | false | false | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

    #note: this user doesn't have anoc, re-enable this when finding a user that has it
    #@pfny02_combo_ship_fed
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-12  | F443004 | MAPD	  | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | true  | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    @pfny02_combo_fed_ship
    Examples: 
	    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-13  | F443004 | PDP	     | COMBO_PDP_IND_SHIP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | false | false | false | true          |


  @pfny03 @hasTab @noCombTabOnPfny @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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

	@pfny03a
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-01  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@pfny03b
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-02  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |

  @pfny04 @hasTab @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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

    @pfny04_sars
    Examples: 
	    | index | FID     | planType | memberType              | showNxtYrPlan |  
<<<<<<< HEAD
	    | 4-01  | F443004 | MAPD     | UHC_SARS_PFNY           | false         |
	    | 4-01  | F443004 | MAPD     | SARS_PFNY               | false         |
=======
	    | 4-01  | F443004 | MA       | UHC_SARS_PFNY           | false         |
	    | 4-02  | F443004 | MAPD     | SARS_PFNY               | false         |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

	#note: don't have PDP SAR user for the time being
    #@pfny04_sars
    #Examples: 
	#    | index | FID     | planType | memberType              | showNxtYrPlan |  
	#    | 4-02  | F443004 | PDP      | SARS_PFNY               | false         |
	    
##### end - cases for stage env #################################################################

	    