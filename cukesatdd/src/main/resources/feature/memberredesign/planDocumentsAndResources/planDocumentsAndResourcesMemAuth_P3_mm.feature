@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.3.1 Member Plans and Documents - section: Membership Materials - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @memAuth_planAndDocuments03 @membershipMaterials 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Membership Materials
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
	Then user validates jumplink and listing of mandatory documents for section Membership Materials or Welcome Guide
	  | Section Display                    | <mm_sd> | 
	  | English Documents                  | <mm_en> |
	  | Spanish Documents                  | <mm_es> | 
	  | Chinese Documents                  | <mm_zh> | 

#	@memAuth_preeffective_ma_mapd
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 01-039 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
#      | 02-040 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_PREEFF_PDnR     | true  | false | false | false |
#      | 03-041 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |

#	@memAuth_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 04-042 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
#      | 05-043 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | GROUP_PREEFF_PDnR     | true  | true  | false | false |

#	@memAuth_terminated_ma_mapd
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 06-044 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | IND_TERM_PDnR         | false | false | false | false |
#      | 07-045 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_TERM_PDnR       | false | false | false | false |
#      | 08-046 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | IND_TERM_PDnR         | false | false | false | false |

	@memAuth_active_ma
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 09-047 | 15129       | qavgogine | qavgogine | q3_sep_UAT4_AARP203    | MA       | AARP_IND_EFF_PDnR     | true  | true  | true  | false |
      | 10-048 | 15130       | qavgogine | qavgogine | q3_sep_UAT4_Group289    | MA       | GROUP_EFF_PDnR        | true  | true  | false | false | 

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 11-049 | 15108       | qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | false | 

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 12-050 | 15303       | qavgogine | qavgogine | q3_sep_UAT4_Group029    | MAPD     | GROUP_EFF_PDnR        | true  | true  | false | false |
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-051 | 15130       | qavgogine | qavgogine | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | false | false | 

#	@memAuth_active_pcp_medica
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 14-052 | 15128       | qavgogine | qavgogine | testusername    | PCP      | IND_EFF_PDnR          | true  | true  | true  | false |
#      | 15-053 | 15128       | qavgogine | qavgogine | testusername    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | false |

	@memAuth_active_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 16-054 | 15126,15127 | qavgogine | qavgogine | q3_sep_UAT4_AARP057    | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | false | 
      | 17-055 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | false |

	@memAuth_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 18-056 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | SSP      | COMBO_GROUP_EFF_PDnR  | true  | true  | false | false | 

	@memAuth_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 19-057 | 15119,15304 | qavgogine | qavgogine | PaidInFullShip0011    | SHIP     | IND_EFF_PDnR          | false | false | false | false |
      | 20-117 | 15119,15304 | qavgogine | qavgogine | q1_feb_2020SHIP_002    | SHIP     | MULTI_IND_EFF_PDnR    | false | false | false | false |


     