<<<<<<< HEAD
@prepareForNextYear
Feature: 1.25.2 Member Prepare For Next Year - PROD

  #----- begin sanity
  #note: code will skip some validations for sanity when it see the sanity tag
  @prod_sanity01
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
<<<<<<< HEAD
=======
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	##note: will only valiate timeline box for sanity
    Then the user validates Prepare For Next Year page content

	@prod_pfny_ind_mapd_aarp_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-01 | F437767 | kkumard   | mnrs786@  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_grp_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-06 | F437767 | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |


  
  #----- begin regression
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny01 @noTab
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
    # note: no MA/MAPD offcycle user available at the moment
    @prod_pfny01_offcycle
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	    | 1-01  | F437767 | kkumard   | mnrs786@  |  1MGriffin2       | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | kkumard   | mnrs786@  |  testUserName     | MA	     | GRP_OFFCYC_PFNY     |
       #| 1-03  | F437767 | kkumard   | mnrs786@  |  diannahill1      | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prod_pfny01_preTermShip
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	   #| 1-04  | F437767 | kkumard   | mnrs786@  | Ranch1955         | MA	     | IND_PREEFF_PFNY     |
	    | 1-04  | F437767 | kkumard   | mnrs786@  | Teripappas          | MAPD     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | kkumard   | mnrs786@  | BEVERLY_BOB5      | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | kkumard   | mnrs786@  | Pramila1946       | SHIP	 | IND_PFNY            |
			
	@prod_pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                 |
	    | 1-07  | F437767 | kkumard   | mnrs786@  | JSENFYFDRE#ERY2GO | PDP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-08  | F437767 | kkumard   | mnrs786@  | JSENFYFDRE#ERY2GO | SSP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
		
	@prod_pfny01_comboMaPdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                |
	    | 1-09  | F443004 | kkumard   | mnrs786@  | rc4614            | MA	     | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | kkumard   | mnrs786@  | rc4614            | PDP	     | COMBO_MA_GRP_PDP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny02 @hasTab
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
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content

<<<<<<< HEAD
	@prod_pfny_ind_mapd_aarp_sanity
=======
	@prod_pfny02_ind_mapd_aarp
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
<<<<<<< HEAD
	    | S2-01 | F437767 | kkumard   | mnrs786@  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |
=======
	    | 2-01  | F437767 | kkumard   | mnrs786@  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

<<<<<<< HEAD
	@prod_pfny02_grp_mapd_sanity
=======
	@prod_pfny02_ind_mapd_uhc
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | kkumard   | mnrs786@  | LMHOCHSCHILD11            | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-02  | F437767 | kkumard   | mnrs786@  | nawal1215                 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_ind_ma
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | kkumard   | mnrs786@  | haradaty32                | MA	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_medica
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-04  | F437767 | kkumard   | mnrs786@  | ALREALESTATE@AOL.COM      | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-05  | F437767 | kkumard   | mnrs786@  | BATLLOT@AOL.COM           | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_grp_mapd
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
<<<<<<< HEAD
	    | S2-06 | F437767 | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
=======
	    | 2-06  | F437767 | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

<<<<<<< HEAD
=======
    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_pdp
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-07  | F437767 | kkumard   | mnrs786@  | 7547MCGEE                 | PDP	  | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

<<<<<<< HEAD
  
  #----- begin regression
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny01 @noTab
=======
    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_ma
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F437767 | kkumard   | mnrs786@  | 1GIRL4DEAN                | MA	      | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #@prod_pfny02_ind_zh
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-09  | F437767 | kkumard   | mnrs786@  | testUserName             | MAPD	 | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false | false | false | false | true        |

    #@prod_pfny02_ind_1act
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-10  | F437767 | kkumard   | mnrs786@  | testUserName             | MAPD	 | UHC_IND_1ACT_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true        |

	@prod_pfny02_combo_ship_fed
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-11  | F437767 | kkumard   | mnrs786@  | phleauxdailles43          | MA       | COMBO_SHIP_MA_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_combo_fed_ship
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-12  | F437767 | kkumard   | mnrs786@  | PAULAROTH2                | PDP	     | COMBO_PDP_IND_SHIP_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
	    
  @prod_pfny03 @hasTab @noCombTabOnPfny
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
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
<<<<<<< HEAD
      | AEM Show Tab EndDate   | 12/31/2020     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page

    # note: all available PDP group offcycle users are COMBO user, tab will not show for combo user anyway 
    # note: no MA/MAPD offcycle user available at the moment
    @prod_pfny01_offcycle
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	    | 1-01  | F437767 | kkumard   | mnrs786@  |  1MGriffin2       | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | kkumard   | mnrs786@  |  testUserName     | MA	     | GRP_OFFCYC_PFNY     |
       #| 1-03  | F437767 | kkumard   | mnrs786@  |  diannahill1      | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prod_pfny01_preTermShip
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	   #| 1-04  | F437767 | kkumard   | mnrs786@  | Ranch1955         | MA	     | IND_PREEFF_PFNY     |
	    | 1-04  | F437767 | kkumard   | mnrs786@  | Abayne01          | MAPD     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | kkumard   | mnrs786@  | BEVERLY_BOB5      | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | kkumard   | mnrs786@  | Pramila1946       | SHIP	 | IND_PFNY            |
			
	@prod_pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                 |
	    | 1-07  | F437767 | kkumard   | mnrs786@  | JSENFYFDRE#ERY2GO | PDP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-08  | F437767 | kkumard   | mnrs786@  | JSENFYFDRE#ERY2GO | SSP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
		
	@prod_pfny01_comboMaPdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                |
	    | 1-09  | F443004 | kkumard   | mnrs786@  | rc4614            | MA	     | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | kkumard   | mnrs786@  | rc4614            | PDP	     | COMBO_MA_GRP_PDP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny02 @hasTab
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content

	@prod_pfny02_ind_mapd_aarp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | kkumard   | mnrs786@  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_mapd_uhc
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | kkumard   | mnrs786@  | LMHOCHSCHILD11            | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-02  | F437767 | kkumard   | mnrs786@  | nawal1215                 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_ind_ma
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | kkumard   | mnrs786@  | haradaty32                | MA	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_medica
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-04  | F437767 | kkumard   | mnrs786@  | ALREALESTATE@AOL.COM      | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 2-05  | F437767 | kkumard   | mnrs786@  | BATLLOT@AOL.COM           | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_grp_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-06  | F437767 | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_pdp
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-07  | F437767 | kkumard   | mnrs786@  | 7547MCGEE                 | PDP	  | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_ma
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F437767 | kkumard   | mnrs786@  | 1GIRL4DEAN                | MA	      | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #@prod_pfny02_ind_zh
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-09  | F437767 | kkumard   | mnrs786@  | testUserName             | MAPD	 | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false | false | false | false | true        |

    #@prod_pfny02_ind_1act
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-10  | F437767 | kkumard   | mnrs786@  | testUserName             | MAPD	 | UHC_IND_1ACT_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true        |

	@prod_pfny02_combo_ship_fed
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-11  | F437767 | kkumard   | mnrs786@  | phleauxdailles43          | MA       | COMBO_SHIP_MA_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_combo_fed_ship
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-12  | F437767 | kkumard   | mnrs786@  | PAULAROTH2                | PDP	     | COMBO_PDP_IND_SHIP_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
	    
  @prod_pfny03 @hasTab @noCombTabOnPfny
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
=======
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
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

	@prod_pfny03a
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-01  | F437767 | kkumard   | mnrs786@  | phleauxdailles43        | SHIP_HIP | COMBO_SHIP_MA_GRP_PFNY  |
			
	@prod_pfny03b
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-02  | F437767 | kkumard   | mnrs786@  | PAULAROTH2              | SHIP	   | COMBO_PDP_IND_SHIP_PFNY |

  @prod_pfny04 @hasTab
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

    @prod_pfny04_sars
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              | showNxtYrPlan |
	 #note: cannot locate applicable user yet    
	 #  | 4-01  | F443004 | kkumard   | mnrs786@  | testUserName            | MAPD     | UHC_SARS_PFNY           | false         |
	    | 4-02  | F443004 | kkumard   | mnrs786@  | XrayBobby36512          | MAPD     | SARS_PFNY               | false         |
=======
@prepareForNextYear
Feature: 1.25.2 Member Prepare For Next Year - PROD

  #----- begin sanity
  #note: code will skip some validations for sanity when it see the sanity tag
  @prod_sanity01
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	##note: will only valiate timeline box for sanity
    Then the user validates Prepare For Next Year page content

	@prod_pfny_ind_mapd_aarp_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-01 | F437767 | kkumard   | tnps459#  | kirit1976           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_grp_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | S2-06 | F437767 | kkumard   | tnps459#  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |


  
  #----- begin regression
  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny01 @noTab
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    # note: no MA/MAPD offcycle user available at the moment
    @prod_pfny01_offcycle
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	   #| 1-01  | F437767 | kkumard   | tnps459#  |  1MGriffin2       | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 1-02  | F437767 | kkumard   | tnps459#  |  testUserName     | MA	     | GRP_OFFCYC_PFNY     |
        | 1-03  | F437767 | kkumard   | tnps459#  |  mkdteach1        | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prod_pfny01_preTermShip
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	   #| 1-04  | F437767 | kkumard   | tnps459#  | Ranch1955         | MA	     | IND_PREEFF_PFNY     |
	    | 1-04  | F437767 | kkumard   | tnps459#  | Beaver34          | MAPD     | IND_PREEFF_PFNY     |
	    | 1-05  | F437767 | kkumard   | tnps459#  | Patkeving       | MA	     | IND_TERM_PFNY       |
	    | 1-06  | F437767 | kkumard   | tnps459#  | Pramila1946       | SHIP	 | IND_PFNY            |
			
	@prod_pfny01_comboPdpSsp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                 |
	    | 1-07  | F437767 | kkumard   | tnps459#  | DKELLY27          | PDP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
	    | 1-08  | F437767 | kkumard   | tnps459#  | DKELLY27          | SSP      | COMBO_PDP_GRP_SSP_GRP_PFNY |
		
	@prod_pfny01_comboMaPdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType                |
	    | 1-09  | F443004 | kkumard   | tnps459#  | rc4614            | MA	     | COMBO_MA_GRP_PDP_GRP_PFNY |
	    | 1-10  | F443004 | kkumard   | tnps459#  | rc4614            | PDP	     | COMBO_MA_GRP_PDP_GRP_PFNY |

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_pfny02 @hasTab
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content

	#@prod_pfny02_ind_mapd_aarp
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-01  | F437767 | kkumard   | tnps459#  | kirit1976           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_mapd_uhc
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-01  | F437767 | kkumard   | tnps459#  | LMHOCHSCHILD11            | MAPD	 | UHC_IND_PFNY| true | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-02  | F437767 | kkumard   | tnps459#  | Branford910                 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_ind_ma
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-03  | F437767 | kkumard   | tnps459#  | ssmhi1                    | MA	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_medica
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	  #x| 2-04  | F437767 | kkumard   | tnps459#  | ALREALESTATE@AOL.COM      | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |
	    | 2-04  | F437767 | kkumard   | tnps459#  | TCZUNIGA52                | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_ind_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	  #x| 2-05  | F437767 | kkumard   | tnps459#  | BATLLOT@AOL.COM           | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |
	    | 2-05  | F437767 | kkumard   | tnps459#  | SOFYABAKMAN@MSN.COM       | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | true          |

	@prod_pfny02_grp_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-06  | F437767 | kkumard   | tnps459#  | Andersonga1@Bellsouth.Net | MAPD     | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_pdp
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-07  | F437767 | kkumard   | tnps459#  | 7547MCGEE                 | PDP	  | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #note: no suitable user with 2021 doc for validation
	#@prod_pfny02_grp_ma
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName               | planType | memberType   | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	#    | 2-08  | F437767 | kkumard   | tnps459#  | 1GIRL4DEAN                | MA	      | UHC_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

    #@prod_pfny02_ind_zh
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-09  | F437767 | kkumard   | tnps459#  | testUserName             | MAPD	 | IND_ESZH_PFNY     | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | true  | false | false | false | false | false | false | true        |

    #@prod_pfny02_ind_1act
    #Examples: 
	#    | index | FID     | username  | password  | MemUserName              | planType | memberType        | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
    #    | 2-10  | F437767 | kkumard   | tnps459#  | testUserName             | MAPD	 | UHC_IND_1ACT_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true        |

	@prod_pfny02_combo_ship_fed
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	  #x| 2-11  | F437767 | kkumard   | tnps459#  | phleauxdailles43          | MA       | COMBO_SHIP_MA_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
	    | 2-11  | F437767 | kkumard   | tnps459#  | VirginiaRuth1936          | MA       | COMBO_SHIP_MA_GRP_PFNY | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |

	@prod_pfny02_combo_fed_ship
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType             | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 2-12  | F437767 | kkumard   | tnps459#  | PAULAROTH2                | PDP	     | COMBO_PDP_IND_SHIP_PFNY| true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | false | false | false | false | false | false | true          |
	    
  @prod_pfny03 @hasTab @noCombTabOnPfny
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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

	@prod_pfny03a
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-01  | F437767 | kkumard   | tnps459#  | VirginiaRuth1936        | SHIP_HIP | COMBO_SHIP_MA_GRP_PFNY  |
	  #x| 3-01  | F437767 | kkumard   | tnps459#  | phleauxdailles43        | SHIP_HIP | COMBO_SHIP_MA_GRP_PFNY  |
			
	@prod_pfny03b
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              |
	    | 3-02  | F437767 | kkumard   | tnps459#  | PAULAROTH2              | SHIP	   | COMBO_PDP_IND_SHIP_PFNY |

  @prod_pfny04 @hasTab
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page content will display when conditions are met 
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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

    @prod_pfny04_sars
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType              | showNxtYrPlan |
	 #note: cannot locate applicable user yet    
	 #  | 4-01  | F443004 | kkumard   | tnps459#  | testUserName            | MAPD     | UHC_SARS_PFNY           | false         |
	 #  | 4-02  | F443004 | kkumard   | tnps459#  | testUserName            | MAPD     | SARS_PFNY               | false         |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
	    