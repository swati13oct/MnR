@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.6.1 Member Plans and Documents - section: Forms And Resources Part 4 of 7 - Authorization Forms and Information - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @memAuth_planAndDocuments06_4of7 @formsAndResources_4of7
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Authorization Forms and Information
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
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    ## note: no need for this section but keep it here for consistent with other scenarios  
    ## And documents are able to load successfully
	## And I want to customize test setup
	##   | Validate API                     | true  |
	##   | Skip Link Destination Validation | false |
	Then user validate Forms and Resources section Authorization Forms and Information
	  | Section Display                    | <fnr_sd>   | 
	  | Authorization Forms and Information| <fnr_af>   | 

#	@memAuth_preeffective_ma_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 01-096 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | AARP_IND_PREEFF_PDnR  | false  | false  |
#      | 02-097 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_PREEFF_PDnR     | false  | false  |

#	@memAuth_preeffective_mapd_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 03-098 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false  |

#	@memAuth_preeffective_pdp_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 04-099 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false  | false  |
#      | 05-100 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | GROUP_PREEFF_PDnR     | false  | false  |

#	@memAuth_terminated_ma_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 06-103 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | IND_TERM_PDnR         | true   | true   |
#      | 07-102 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_TERM_PDnR       | true   | true   |

#	@memAuth_terminated_mapd_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 07-101 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | IND_TERM_PDnR         | true   | true   |

	@memAuth_active_ma_ind_4of7 @memAuth_active_ma_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 09-104 | 15129       | qavgogine | qavgogine | q3_sep_UAT4_AARP203 | MA   | AARP_IND_EFF_PDnR     | true   | true   |

	@memAuth_active_ma_grp_4of7 @memAuth_active_ma_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 10-105 | 15130       | qavgogine | qavgogine | q3_sep_UAT4_Group289 | MA  | GROUP_EFF_PDnR        | true   | true   |

	@memAuth_active_mapd_ind_4of7 @memAuth_active_mapd_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 11-106 | 15108       | qavgogine | qavgogine | q2_apr_aarp0250 | MAPD     | AARP_IND_EFF_PDnR     | true   | true   |

	@memAuth_active_mapd_grp_4of7 @memAuth_active_mapd_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 12-107 | 15303       | qavgogine | qavgogine | q3_sep_UAT4_Group029 | MAPD| GROUP_EFF_PDnR        | true   | true   |  
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-108 | 15130       | qavgogine | qavgogine | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | true   |

#	@memAuth_active_pcp_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 14-109 | 15128       | qavgogine | qavgogine | testusername    | PCP      | IND_EFF_PDnR          | true   | true   |

#	@memAuth_active_medica_4of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
#      | 15-110 | 15128       | qavgogine | qavgogine | testusername    | MEDICA   | IND_EFF_PDnR          | true   | true   | 

	@memAuth_active_pdp_ind_4of7 @memAuth_active_pdp_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 16-111 | 15126,15127 | qavgogine | qavgogine | q3_sep_UAT4_AARP057  | PDP | AARP_IND_EFF_PDnR     | true   | true   |

	@memAuth_active_pdp_grp_4of7 @memAuth_active_pdp_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 17-112 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255  | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@memAuth_active_ssup_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 18-113 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255  | SSP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@memAuth_active_ship_4of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_af |
      | 19-114 | 15119,15304 | qavgogine | qavgogine | q1_feb_ship_20_001  | SHIP | IND_EFF_PDnR          | true   | false  |
      | 19-120 | 15119,15304 | qavgogine | qavgogine | q1_feb_2020SHIP_001 | SHIP | MULTI_IND_EFF_PDnR    | true   | false  |    