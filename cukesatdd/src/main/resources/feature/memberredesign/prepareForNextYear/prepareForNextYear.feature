@prepareForNextYear
Feature: 1.21 Member Prepare For Next Year

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
	   #| 01    | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 02    | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 03    | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prepareForNextYear01b
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 04    | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 05    | F437767 | MA	     | IND_TERM_PFNY       |
	    | 06    | F437767 | SHIP	 | IND_PFNY            |
			
	@prepareForNextYear01c
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 07    | F437767 | SHIP	 | COMBO_SHIP_MA_PFNY  |
	    | 08    | F437767 | MA	     | COMBO_SHIP_MA_PFNY  |
			
	@prepareForNextYear01d
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 09    | F437767 | PDP	     | COMBO_PDP_SHIP_PFNY |
	    | 10    | F437767 | SHIP	 | COMBO_PDP_SHIP_PFNY |
			

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
      | Annual Notice of Changes English       | <an_us> | 
      | Annual Notice of Changes Spanish       | <an_es> |
      | Annual Notice of Changes Chinese       | <an_zh> |
      | Evidence of Coverage English           | <ev_us> |
      | Evidence of Coverage Spanish           | <ev_es> |
      | Evidence of Coverage Chinese           | <ev_zh> |
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
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | 
	    | 11    | F437767 | PDP	     | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 12    | F437767 | MAPD	 | IND_PFNY   | true  | true  | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 13    | F437767 | MA	     | IND_PFNY   | true  | true  | false | false | false | false | false | false | false | false | false | false | false | false | false |

	# ignore group cases for now until code is ready
	#@prepareForNextYear02b
    #Examples: 
	#    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |
	#    | 14    | F437767 | PDP	     | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false |  
	#    | 15    | F437767 | MAPD	 | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	#    | 16    | F437767 | MA	     | GRP_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false |

	@prepareForNextYear02c
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |  
	    | 17    | F437767 | MEDICA	 | IND_PFNY   | true  | false | false  | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 18    | F437767 | PCP	     | IND_PFNY   | true  | false | false | false | false | false | false | false | false | false | false | false | false | false | false |

    #tbd clean up later, these are invalid, user must have english to be able to have spanish or chinese
	#tbd @prepareForNextYear02d
    #tbd Examples: 
	#tbd     | index | FID     | planType | memberType     | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |  
	#tbd     | 19    | F437767 | MAPD	 | IND_ES_PreNexYr| false | true  | false | false | false | false | false | false | false | false | false | false | false | false | false |
	#tbd     | 20    | F437767 | MAPD	 | IND_ZH_PreNexYr| false | false | true  | false | false | false | false | false | false | false | false | false | false | false | false |
	#tbd     | 21    | F437767 | MAPD	 | IND_ESZH_PreNexYr| false  | true  | true  | false | false | false | false | false | false | false | false | false | false | false | false |
	    
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
      | AEM Toggle             | OFF            |
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
	   #| 01    | F437767 | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 02    | F437767 | MA	     | GRP_OFFCYC_PFNY     |
	    | 03    | F437767 | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prepareForNextYear01b
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 04    | F437767 | MA	     | IND_PREEFF_PFNY     |
	    | 05    | F437767 | MA	     | IND_TERM_PFNY       |
	    | 06    | F437767 | SHIP	 | IND_PFNY            |
			
	@prepareForNextYear01c
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 07    | F437767 | SHIP	 | COMBO_SHIP_MA_PFNY  |
	    | 08    | F437767 | MA	     | COMBO_SHIP_MA_PFNY  |
			
	@prepareForNextYear01d
    Examples: 
	    | index | FID     | planType | memberType          |
	    | 09    | F437767 | PDP	     | COMBO_PDP_SHIP_PFNY |
	    | 10    | F437767 | SHIP	 | COMBO_PDP_SHIP_PFNY |
			

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
      | AEM Toggle             | OFF            |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then test setup stores documents expectation info  
      | Annual Notice of Changes English       | <an_us> | 
      | Annual Notice of Changes Spanish       | <an_es> |
      | Annual Notice of Changes Chinese       | <an_zh> |
      | Evidence of Coverage English           | <ev_us> |
      | Evidence of Coverage Spanish           | <ev_es> |
      | Evidence of Coverage Chinese           | <ev_zh> |
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
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |
	    | 11    | F437767 | PDP	     | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 12    | F437767 | MAPD	 | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 13    | F437767 | MA	     | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |

	# ignore group cases for now until code is ready
	#@prepareForNextYear02b
    #Examples: 
	#    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |
	#    | 14    | F437767 | PDP	     | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	#    | 15    | F437767 | MAPD	 | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	#    | 16    | F437767 | MA	     | GRP_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |

	@prepareForNextYear02c
    Examples: 
	    | index | FID     | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | 
	    | 17    | F437767 | MEDICA	 | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    | 18    | F437767 | PCP	     | IND_PFNY   | false | false | false | false | false | false | false | false | false | false | false | false | false | false | false |
	    
##### end - cases for stage env #################################################################

	    