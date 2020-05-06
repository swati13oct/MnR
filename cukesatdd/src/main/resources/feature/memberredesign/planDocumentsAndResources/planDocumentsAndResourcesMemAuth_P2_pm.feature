@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.1.1 Member Plans and Documents - section: Plan Materials - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @memAuth_planAndDocuments02 @planMaterials
  Scenario Outline: To validate via member authorization access for health and wellness
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

	@memAuth_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 01-020 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
      | 02-021 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |
      | 03-022 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |

	@memAuth_preeffective_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 04-023 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
      | 05-024 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |

	@memAuth_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 06-025 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | IND_TERM_PDnR         | true  | false | true  | true  | true  | false |
      | 07-026 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_TERM_PDnR       | true  | false | true  | true  | false | false |
      | 08-027 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | IND_TERM_PDnR         | true  | false | true  | false | false | false |

	@memAuth_active_ma
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 09-028 | 15129       | qavgogine | qavgogine | q2_may_rally017 | MA       | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false | 
      | 10-029 | 15130       | qavgogine | qavgogine | q3_sep_UAT4_Group289    | MA       | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
 
	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 11-030 | 15108       | qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false | 

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 12-031 | 15303       | qavgogine | qavgogine | q3_sep_UAT4_Group029    | MAPD     | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-032 | 15130       | qavgogine | qavgogine | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | true  | false | false |

	@memAuth_active_pcp_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 14-033 | 15128       | qavgogine | qavgogine | testusername    | PCP      | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |
      | 15-034 | 15128       | qavgogine | qavgogine | testusername    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |

	@memAuth_active_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 16-035 | 15126,15127 | qavgogine | qavgogine | q3_sep_UAT4_AARP057    | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false |
      | 17-036 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | true  | false |

	@memAuth_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 18-037 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | SSP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | false | false |

	@memAuth_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 19-038 | 15119,15304 | qavgogine | qavgogine | q1_feb_ship_20_001    | SHIP     | IND_EFF_PDnR          | true  | true  | true  | true  | false | false |  
      | 20-116 | 15119,15304 | qavgogine | qavgogine | q1_feb_2020SHIP_001    | SHIP     | MULTI_IND_EFF_PDnR   | true  | true  | true  | true  | false | false |  



    