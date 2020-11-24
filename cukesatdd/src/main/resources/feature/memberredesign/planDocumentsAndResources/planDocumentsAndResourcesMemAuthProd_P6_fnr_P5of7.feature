@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.6.2 Member Plans and Documents - section: Forms And Resources Part 5 of 7 - Medication Authorization Forms - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments06_5of7 @formsAndResources_5of7
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Medication Authorization Forms
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
	Then user validate Forms and Resources section Medication Authorization Forms
	  | Section Display                    | <fnr_sd>   | 
	  | Medication Authorization Forms     | <fnr_maf>  | 

#	@prod_preeffective_ma_5of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
#      | 01-096 | xxxxx       | kkumard  | mnrs786@  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | false  | false   |
#      | 02-097 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_PREEFF_PDnR     | false  | false   |

	@prod_preeffective_mapd_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
<<<<<<< HEAD
      | 03-098 | xxxxx       | kkumard  | mnrs786@  | Abayne01          | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false   |
=======
      | 03-098 | xxxxx       | kkumard  | mnrs786@  | UHCjanicejohn          | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false   |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

#	@prod_preeffective_pdp_5of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
#      | 04-099 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false  | false   |
#      | 05-100 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false  | false   |

	@prod_terminated_ma_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
#      | 06-103 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | IND_TERM_PDnR         | true   | false   |
      | 07-102 | xxxxx       | kkumard  | mnrs786@  | PJVANEKRIS65    | MA       | GROUP_TERM_PDnR       | true   | false   |

#	@prod_terminated_mapd_5of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
#      | 07-101 | xxxxx       | kkumard  | mnrs786@  | BEVERLY_BOB5    | MAPD     | IND_TERM_PDnR         | true   | true    |

	@prod_active_ma_ind_5of7 @prod_active_ma_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 09-104 | 15129       | kkumard  | mnrs786@  | haradaty32      | MA       | AARP_IND_EFF_PDnR     | true   | false   |

	@prod_active_ma_grp_5of7 @prod_active_ma_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 10-105 | 15130       | kkumard  | mnrs786@  | 1GIRL4DEAN      | MA       | GROUP_EFF_PDnR        | true   | false   |
#      | 10-105 | 15130       | kkumard  | mnrs786@  | SPENCEPR1      | MA       | NICE_GROUP_EFF_PDnR        | true   | false   |

	@prod_active_mapd_ind_5of7 @prod_active_mapd_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 11-106 | 15108       | kkumard  | mnrs786@  | BILL.ROSNER123# | MAPD     | AARP_IND_EFF_PDnR     | true   | true    |

	@prod_active_mapd_grp_5of7 @prod_active_mapd_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 12-107 | 15303       | kkumard  | mnrs786@  | SHERMANJAFFE65 | MAPD | NICE_GROUP_EFF_PDnR  | true   | false   | 
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-108 | 15130       | kkumard  | mnrs786@  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false   |

	@prod_active_pcp_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 14-109 | 15128       | kkumard  | mnrs786@  | BATLLOT@AOL.COM    | PCP      | IND_EFF_PDnR          | true   | true    |

	@prod_active_medica_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 15-110 | 15128       | kkumard  | mnrs786@  | SUSICHAPMAN@GMAIL.COM    | MEDICA   | IND_EFF_PDnR          | true   | true    |

	@prod_active_pdp_ind_5of7 @prod_active_pdp_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 16-111 | 15126,15127 | kkumard  | mnrs786@  | nawal1215       | PDP      | AARP_IND_EFF_PDnR     | true   | true    |

	@prod_active_pdp_grp_5of7 @prod_active_pdp_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 17-112 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27        | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true    |

	@prod_active_ssup_5of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
      | 18-113 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27        | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false   |

    #note - covered by P1of7 already
	#@prod_active_ship_5of7
	#Examples: 
    #  | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf |
    #  | 19-114 | 15119,15304 | kkumard  | mnrs786@  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true   | false   |
    #  | 19-120 | 15119,15304 | kkumard  | mnrs786@  | q1_feb_2020SHIP_0   | SHIP | MULTI_IND_EFF_PDnR    | true   | false   |

	#@prod_preeffective_ship_5of7
	#Examples: 
    #   | index  | TID         | username  | password  | MemUserName  | planType | memberType            | fnr_sd | fnr_maf |
    #   | 21-121 | xxxxx       | kkumard   | mnrs786@  | testusername | SHIP     | IND_PREEFF_PDnR       | true   | false   |
