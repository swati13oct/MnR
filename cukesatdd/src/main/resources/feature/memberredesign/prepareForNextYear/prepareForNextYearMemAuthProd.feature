@prepareForNextYear
Feature: 1.25.2 Member Prepare For Next Year - PROD

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would NOT expect to see tab even if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_prepareForNextYear01 @noTab
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
      | AEM Show Tab StartDate | 09/01/2020     |
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
    @prod_prepareForNextYear01a
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	   #| 01    | F437767 | ashah120  | Mnrqa003  |  testUserName     | PDP	     | GRP_OFFCYC_PFNY     |
	   #| 02    | F437767 | ashah120  | Mnrqa003  |  testUserName     | MA	     | GRP_OFFCYC_PFNY     |
#TBD	    | 03    | F437767 | ashah120  | Mnrqa003  |  testUserName     | MAPD	 | GRP_OFFCYC_PFNY     |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prod_prepareForNextYear01b
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
#	    | 04    | F437767 | ashah120  | Mnrqa003  | testUserName      | MA	     | IND_PREEFF_PFNY     |
#	    | 05    | F437767 | ashah120  | Mnrqa003  | testUserName      | MA	     | IND_TERM_PFNY       |
	    | 06    | F437767 | ashah120  | Mnrqa003  | Pramila1946       | SHIP	 | IND_PFNY            |
			
	@prod_prepareForNextYear01c
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	    | 07    | F437767 | ashah120  | Mnrqa003  | phleauxdailles43  | SHIP_HIP | COMBO_SHIP_MA_PFNY  |
	    | 08    | F437767 | ashah120  | Mnrqa003  | phleauxdailles43  | MA	     | COMBO_SHIP_MA_PFNY  |
			
	@prod_prepareForNextYear01d @noTab
    Examples: 
	    | index | FID     | username  | password  | MemUserName       | planType | memberType          |
	    | 09    | F437767 | ashah120  | Mnrqa003  | PAULAROTH2        | PDP	     | COMBO_PDP_SHIP_PFNY |
	    | 10    | F437767 | ashah120  | Mnrqa003  | PAULAROTH2        | SHIP	 | COMBO_PDP_SHIP_PFNY |
			

  #-------------------------------------------------
  # note: for cases below -
  # note: UserType and memberType that would expect to see tab if current system date is within AEM range and toggle is ON
  # note: current system date will be determined at run time
  #-------------------------------------------------
  @prod_prepareForNextYear02 @hasTab
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
    #Then the user validate bookmark behavior if tab hasn't met the condition to be displayed
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content for individual

	@prod_prepareForNextYear02a
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 11    | F437767 | ashah120  | Mnrqa003  | nawal1215                 | PDP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 12    | F437767 | ashah120  | Mnrqa003  | BILL.ROSNER123#           | MAPD	 | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 13    | F437767 | ashah120  | Mnrqa003  | haradaty32                | MA	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prod_prepareForNextYear02b
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan |
	    | 14    | F437767 | ashah120  | Mnrqa003  | 7547MCGEE                 | PDP	     | GRP_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 15    | F437767 | ashah120  | Mnrqa003  | Andersonga1@Bellsouth.Net | MAPD     | GRP_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 16    | F437767 | ashah120  | Mnrqa003  | 1GIRL4DEAN                | MA	     | GRP_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |

	@prod_prepareForNextYear02c
    Examples: 
	    | index | FID     | username  | password  | MemUserName               | planType | memberType | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | co_us | co_es | co_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh | showNxtYrPlan | 
	    | 17    | F437767 | ashah120  | Mnrqa003  | ALREALESTATE@AOL.COM      | MEDICA   | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    | 18    | F437767 | ashah120  | Mnrqa003  | BATLLOT@AOL.COM           | PCP	     | IND_PFNY   | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true  | true  | false | true          |
	    
