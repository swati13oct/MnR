@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.1.2 Member Plans and Documents - section: Plan Materials - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments02 @planMaterials
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Plan Materials
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
    And documents are able to load successfully
	And I want to customize test setup
	  | Validate API                     | true |
	  | Skip Link Destination Validation | false |
	Then user validates jumplink and listing of mandatory documents for section Plan Materials
	  | Section Display                    | <pm_sd> | 
	  | Order Plan Materials               | <pm_op> | 
	  | View Member Card ID                | <pm_mi> | 
	  | English Documents                  | <pm_en> | 
	  | Spanish Documents                  | <pm_es> | 
	  | Chinese Documents                  | <pm_zh> | 

	@prod_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
#      | 01-020 | xxxxx       | kkumard  | mnrs786@  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
#      | 02-021 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |
      | 03-022 | xxxxx       | kkumard  | mnrs786@  | Teripappas          | MAPD     | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |

#	@prod_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
#      | 04-023 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
#      | 05-024 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |

	@prod_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
#      | 06-025 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | IND_TERM_PDnR         | true  | false | true  | true  | true  | false |
#      | 07-026 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_TERM_PDnR       | true  | false | true  | true  | false | false |
      | 08-027 | xxxxx       | kkumard  | mnrs786@  | BEVERLY_BOB5    | MAPD     | IND_TERM_PDnR         | true  | false | true  | false | false | false |

	@prod_active_ma @prod_active_ma_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 09-028 | 15129       | kkumard   | mnrs786@  | haradaty32 | MA       | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false | 

	@prod_active_ma @prod_active_ma_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 10-029 | 15130       | kkumard  | mnrs786@  | 1GIRL4DEAN    | MA       | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
#      | 10-029 | 15130       | kkumard  | mnrs786@  | SPENCEPR1    | MA       | NICE_GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
 
	@prod_active_mapd @prod_active_mapd_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 11-030 | 15108       | kkumard  | mnrs786@  | BILL.ROSNER123#    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false | 

	@prod_active_mapd @prod_active_mapd_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 12-031 | 15303       | kkumard  | mnrs786@  | SHERMANJAFFE65    | MAPD     | NICE_GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-032 | 15130       | kkumard  | mnrs786@  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | true  | false | false |

	@prod_active_pcp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 14-033 | 15128       | kkumard  | mnrs786@  | BATLLOT@AOL.COM    | PCP      | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |

	@prod_active_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 15-034 | 15128       | kkumard  | mnrs786@  | SUSICHAPMAN@GMAIL.COM    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |

	@prod_active_pdp @prod_active_pdp_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 16-035 | 15126,15127 | kkumard  | mnrs786@  | nawal1215    | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false |

	@prod_active_pdp @prod_active_pdp_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 17-036 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | true  | false |

	@prod_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 18-037 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27    | SSP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | false | false |

	@prod_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 19-038 | 15119,15304 | kkumard  | mnrs786@  | Pramila1946    | SHIP     | IND_EFF_PDnR          | true  | true  | true  | true  | false | false |  
#      | 20-116 | 15119,15304 | kkumard  | mnrs786@  | q1_feb_2020SHIP_001    | SHIP     | MULTI_IND_EFF_PDnR   | true  | true  | true  | true  | false | false |  

	@prod_preeffective_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
#     | 21-121 | xxxxx       | kkumard   | mnrs786@  | testusername | SHIP     | IND_PREEFF_PDnR       | true  | false | false | true  | false | false | 


    