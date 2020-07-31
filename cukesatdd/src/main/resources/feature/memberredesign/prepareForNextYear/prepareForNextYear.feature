@prepareForNextYear
Feature: 1.25 Member Prepare For Next Year

##### note: team and stage may have different AEM date setup, separate the scenarios

##### begin - cases for team env #################################################################
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prepareForNextYear01 @noTab @regressionMember @teamEnv
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
    @prepareForNextYear01a @devRegression
    Examples: 
	    | index | FID     | planType | memberType          |
	   #| 1-01  | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 1-03  | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

	#note: activate when ship user is available		
    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prepareForNextYear01b
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-04  | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | SHIP	 | IND_PFNY            |
	
	#note: activate when combo user is available		
	@prepareForNextYear01c
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-07  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@prepareForNextYear01d
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-08  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |
			
	@prepareForNextYear01e
    Examples: 
	    | index | FID     | planType | memberType                 |
	    | 1-09  | F443004 | PDP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-10  | F443004 | SSP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |

  @prepareForNextYear03 @hasTab @noCombTabOnPfny @regressionMember @teamEnv
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

	@prepareForNextYear03a
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-07  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@prepareForNextYear03b
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-08  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |
			
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prepareForNextYear02 @hasTab @regressionMember @teamEnv
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

	@prepareForNextYear02a @devRegression
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-01  | F437767 | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prepareForNextYear02a 
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-02  | F437767 | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prepareForNextYear02b
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-03  | F437767 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true  | true  | false | true          |
	    | 2-04  | F437767 | MA	     | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prepareForNextYear02c
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-05  | F437767 | MEDICA	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 2-06  | F437767 | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	# ignore group cases for now until code is ready
	@prepareForNextYear02d
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-07  | F443004 | MAPD	 | GRP_PFNY   | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |

	@prepareForNextYear02e
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-08  | F443004 | PDP	     | GRP_PFNY   | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |  
	    | 2-09  | F443004 | MA	     | GRP_PFNY   | true  | false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false         |

    @prepareForNextYear02f
    Examples: 
	    | index | FID     | planType | memberType           | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
        | 2-10  | F437767 | MAPD	 | IND_ESZH_PFNY        | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true          |
        | 2-11  | F437767 | MAPD	 | UHC_IND_1ACT_PFNY    | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

    #this user doesn't have anoc, re-enable this when finding a user that has it
    #@prepareForNextYear02g
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-12  | F443004 | MAPD	 | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true  | true  | true  | true  | true  | false | true          |

    @prepareForNextYear02h
    Examples: 
	    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	    | 2-13  | F443004 | PDP	     | COMBO_PDP_IND_SHIP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	    
##### end - cases for team env #################################################################

##### begin - cases for stage env #################################################################
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prepareForNextYear01 @noTab @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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
    Then the user validates Prepare For Next Year tab display behavior on Benefits page

    # note: all available PDP group offcycle users are COMBO user, tab will not show for combo user anyway 
    # note: no MA offcycle user available at the moment
    @prepareForNextYear01a
    Examples: 
	    | index | FID     | planType | memberType          |
	   #| 1-01  | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 1-03  | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prepareForNextYear01b
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-04  | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | SHIP	 | IND_PFNY            |

	@prepareForNextYear01c
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-07  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@prepareForNextYear01d
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 1-08  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |
			
	@prepareForNextYear01e
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 1-09  | F443004 | PDP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-10  | F443004 | SSP	     | COMBO_PDP_GRP_SSP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prepareForNextYear02 @hasTab @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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

	@prepareForNextYear02a
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 2-02  | F437767 | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prepareForNextYear02b
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 2-04  | F437767 | MA	     | UHC_IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prepareForNextYear02c
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-05  | F437767 | MEDICA	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 2-06  | F437767 | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	# ignore group cases for now until code is ready
	#@prepareForNextYear02d
    #Examples: 
	#    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-07  | F443004 | MAPD	  | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

	#@prepareForNextYear02e
    #Examples: 
	#    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F443004 | PDP	  | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |
	#    | 2-09  | F443004 | MA	      | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false | true          |

    @prepareForNextYear02f
    Examples: 
	    | index | FID     | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
        | 2-10  | F437767 | MAPD	 | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true        |
        | 2-11  | F437767 | MAPD	 | UHC_IND_1ACT_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true        |

    #this user doesn't have anoc, re-enable this when finding a user that has it
    #@prepareForNextYear02g
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-12  | F443004 | MAPD	 | COMBO_SHIP_MAPD_IND_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | true  | true  | true  | false | true          |

	#combo is not ready for stage testing yet
    #@prepareForNextYear02h
    #Examples: 
	#    | index | FID     | planType | memberType              | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |  
	#    | 2-13  | F443004 | PDP	     | COMBO_PDP_IND_SHIP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

  @prepareForNextYear03 @hasTab @noCombTabOnPfny @regressionMember @stageEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
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
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates the combo user with ship plan should not see ship tab on the Prepare For Next Year page

	@prepareForNextYear03a
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-01  | F443004 | SHIP	 | COMBO_SHIP_MAPD_IND_PFNY|
			
	@prepareForNextYear03b
    Examples: 
	    | index | FID     | planType | memberType              |
	    | 3-02  | F443004 | SHIP	 | COMBO_PDP_IND_SHIP_PFNY |

	    
##### end - cases for stage env #################################################################

	    