@prepareForNextYear
Feature: 1.21 Member Prepare For Next Year

  @prepareForNextYear01 @noTab @regressionMember
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will NOT display when conditions are NOT met
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
      | AEM Show Tab StartDate | 09/01/2020     |
      | AEM Show Tab EndDate   | 01/05/2021     |
      | AEM Toggle             | ON             |

    @prepareForNextYear01a @noTab @devRegression
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  |
	   # note: all available PDP group offcycle users are COMBO user, tab will not show for combo user anyway 
       # note: no MA offcycle user available at the moment
	   #| 01    | F437767 | PDP	     | GRP_OFFCYC_PreNexYr    | FALSE                                          |
	   #| 02    | F437767 | MA	     | GRP_OFFCYC_PreNexYr    | FALSE                                          |
	    | 03    | F437767 | MAPD	 | GRP_OFFCYC_PreNexYr    | FALSE                                          |

    # caution: if changing system time for testing, the PREEFF or TERM user may no longer be true
    @prepareForNextYear01b @noTab
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 04    | F437767 | MA	     | IND_PREEFF_PreNexYr    | FALSE                                          |
	    | 05    | F437767 | MA	     | IND_TERM_PreNexYr      | FALSE                                          |
	    | 06    | F437767 | SHIP	 | IND_PreNexYr           | FALSE                                          |
			
	@prepareForNextYear01c @noTab
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 07    | F437767 | SHIP	 | COMBO_SHIP_MA_PreNexYr | FALSE                                          |
	    | 08    | F437767 | MA	     | COMBO_SHIP_MA_PreNexYr | FALSE                                          |
			
	@prepareForNextYear01d @noTab
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 09    | F437767 | PDP	     | COMBO_PDP_SHIP_PreNexYr| FALSE                                          |
	    | 10    | F437767 | SHIP	 | COMBO_PDP_SHIP_PreNexYr| FALSE                                          |
			

  @prepareForNextYear02 @hasTab @regressionMember
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab will display when conditions are met and page content is displaying as expected
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
      | Plan Start Type        | <planStartType>|
      | AEM Show Tab StartDate | 09/01/2020     |
      | AEM Show Tab EndDate   | 01/05/2021     |
      | AEM Toggle             | ON             |
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |

	@prepareForNextYear02a @hasTab @devRegression
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 11    | F437767 | PDP	     | IND_PreNexYr           | TRUE                                           |
	    | 12    | F437767 | MAPD	 | IND_PreNexYr           | TRUE                                           |
	    | 13    | F437767 | MA	     | IND_PreNexYr           | TRUE                                           |

	@prepareForNextYear02b @hasTab
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 14    | F437767 | PDP	     | GRP_PreNexYr           | TRUE                                           |
	    | 15    | F437767 | MAPD	 | GRP_PreNexYr           | TRUE                                           |
	    | 16    | F437767 | MA	     | GRP_PreNexYr           | TRUE                                           |

	@prepareForNextYear02c @hasTab
    Examples: 
	    | index | FID     | planType | memberType             | note expectTab if date in range and toggle ON  | 
	    | 17    | F437767 | MEDICA	 | IND_PreNexYr           | TRUE                                           |
	    | 18    | F437767 | PCP	     | IND_PreNexYr           | TRUE                                           |