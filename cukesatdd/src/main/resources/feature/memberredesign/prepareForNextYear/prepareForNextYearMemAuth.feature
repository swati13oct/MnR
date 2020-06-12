@prepareForNextYear
Feature: 1.21.1 Member Prepare For Next Year - Member Auth

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
      | AEM Show Tab StartDate | 06/01/2020     |
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
	    | 06    | F437767 | qavgogine | qavgogine | q1_feb_ship_20_001      | SHIP	   | IND_PFNY            |
			
	@memAuth_prepareForNextYear01c
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 07    | F437767 | qavgogine | qavgogine | Dream_EOB_MA_002        | SHIP	   | COMBO_SHIP_MA_PFNY  |
	    | 08    | F437767 | qavgogine | qavgogine | Dream_EOB_MA_002        | MA	   | COMBO_SHIP_MA_PFNY  |
			
	@memAuth_prepareForNextYear01d
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType          |
	    | 09    | F437767 | qavgogine | qavgogine | q3_sep_Active_combo_005 | PDP	   | COMBO_PDP_SHIP_PFNY |
	    | 10    | F437767 | qavgogine | qavgogine | q3_sep_Active_combo_005 | SHIP	   | COMBO_PDP_SHIP_PFNY |
			

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
      | AEM Show Tab StartDate | 06/01/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
    Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content

	@memAuth_prepareForNextYear02a
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType |
	    | 11    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_AARP238    | PDP	  | IND_PFNY   |
	    | 12    | F437767 | qavgogine | qavgogine | q2_apr_aarp0250        | MAPD	  | IND_PFNY   |
	    | 13    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_AARP203    | MA	      | IND_PFNY   |

	@memAuth_prepareForNextYear02b
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType |
	    | 14    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group316   | PDP	  | GRP_PFNY   |
	    | 15    | F437767 | qavgogine | qavgogine | q3_sep_UAT4_Group074   | MAPD	  | GRP_PFNY   |
	    | 16    | F437767 | qavgogine | qavgogine | q2_jun_grp0428         | MA	      | GRP_PFNY   |

	@memAuth_prepareForNextYear02c
    Examples: 
	    | index | FID     | username  | password  | MemUserName            | planType | memberType | 
	    | 17    | F437767 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020    | MEDICA   | IND_PFNY   |
	    | 18    | F437767 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022    | PCP	  | IND_PFNY   |
	    
