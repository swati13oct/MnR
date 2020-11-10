@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.6.2 Member Plans and Documents - section: Forms And Resources Part 1 of 2 - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments06_1of2 @formsAndResources_1of2
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources
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
	Then user validate Forms and Resources section Part 1 of 2
	  | Section Display                    | <fnr_sd>   | 
	  | Prescription Drug Mail Order Form  | <fnr_pdmo> | 
	  | Premium Payment Information        | <fnr_ppi>  | 
	  | Reimbursement Forms                | <fnr_rf>   | 
	  | Authorization Forms and Information| <fnr_af>   | 

#	@prod_preeffective_ma_1of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
#      | 01-096 | xxxxx       | kkumard  | mnrs786@  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  | false   | false  | false  | 
#      | 02-097 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_PREEFF_PDnR     | false  | false    | false   | false  | false  | false   | false  | false  |

	@prod_preeffective_mapd_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
<<<<<<< HEAD
      | 03-098 | xxxxx       | kkumard  | mnrs786@  | Abayne01          | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  | false   | false  | false  | 
=======
      | 03-098 | xxxxx       | kkumard  | mnrs786@  | UHCjanicejohn          | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  | false   | false  | false  | 
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

#	@prod_preeffective_pdp_1of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
#      | 04-099 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  | false   | false  | false  |
#      | 05-100 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false  | false    | false   | false  | false  | false   | false  | false  |

	@prod_terminated_ma_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
#      | 06-103 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | IND_TERM_PDnR         | true   | false    | true    | true   | true   | false   | true   | true   |
      | 07-102 | xxxxx       | kkumard  | mnrs786@  | PJVANEKRIS65    | MA       | GROUP_TERM_PDnR       | true   | false    | false   | true   | true   | false   | true   | true   |

#	@prod_terminated_mapd_1of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
#      | 07-101 | xxxxx       | kkumard  | mnrs786@  | BEVERLY_BOB5    | MAPD     | IND_TERM_PDnR         | true   | true     | true    | true   | true   |

	@prod_active_ma_ind_1of2 @prod_active_ma_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 09-104 | 15129       | kkumard  | mnrs786@  | haradaty32      | MA       | AARP_IND_EFF_PDnR     | true   | false    | true    | true   | true   |

	@prod_active_ma_grp_1of2 @prod_active_ma_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 10-105 | 15130       | kkumard  | mnrs786@  | 1GIRL4DEAN      | MA       | GROUP_EFF_PDnR        | true   | false    | false   | true   | true   |
#      | 10-105 | 15130       | kkumard  | mnrs786@  | SPENCEPR1      | MA       | NICE_GROUP_EFF_PDnR        | true   | false    | false   | true   | true   |

	@prod_active_mapd_ind_1of2 @prod_active_mapd_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 11-106 | 15108       | kkumard  | mnrs786@  | BILL.ROSNER123# | MAPD     | AARP_IND_EFF_PDnR     | true   | true     | true    | true   | true   |

	@prod_active_mapd_grp_1of2 @prod_active_mapd_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 12-107 | 15303       | kkumard  | mnrs786@  | SHERMANJAFFE65 | MAPD | NICE_GROUP_EFF_PDnR  | true   | false    | false   | true   | true   |	  
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-108 | 15130       | kkumard  | mnrs786@  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false    | false   | true   | true   |

	@prod_active_pcp_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 14-109 | 15128       | kkumard  | mnrs786@  | BATLLOT@AOL.COM    | PCP      | IND_EFF_PDnR          | true   | true     | true    | true   | true   |

	@prod_active_medica_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 15-110 | 15128       | kkumard  | mnrs786@  | SUSICHAPMAN@GMAIL.COM    | MEDICA   | IND_EFF_PDnR          | true   | true     | true    | true   | true   |

	@prod_active_pdp_ind_1of2 @prod_active_pdp_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 16-111 | 15126,15127 | kkumard  | mnrs786@  | nawal1215       | PDP      | AARP_IND_EFF_PDnR     | true   | true     | true    | true   | true   |

	@prod_active_pdp_grp_1of2 @prod_active_pdp_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 17-112 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27        | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true     | false   | true   | true   |

	@prod_active_ssup_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 18-113 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27        | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false    | false   | true   | true   |

	@prod_active_ship_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 19-114 | 15119,15304 | kkumard  | mnrs786@  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true   | false    | false   | false  | false  |
#     | 19-120 | 15119,15304 | kkumard  | mnrs786@  | q1_feb_2020SHIP_001 | SHIP | MULTI_IND_EFF_PDnR    | true   | false    | false   | false  | false  |

	@prod_preeffective_ship_1of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
#     | 21-121 | xxxxx       | kkumard   | mnrs786@  | testusername | SHIP     | IND_PREEFF_PDnR       | true   | false    | false   | false  | false  |
    