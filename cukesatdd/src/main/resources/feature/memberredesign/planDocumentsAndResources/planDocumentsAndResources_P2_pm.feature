@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.1 Member Plans and Documents - section: Plan Materials

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments02 @planMaterials
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Plan Materials
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 01-020 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
      | 02-021 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |
      | 03-022 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 04-023 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false | false | false | false | false | false |
      | 05-024 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false | false | false | false | false | false |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 06-025 | xxxxx       | MA       | IND_TERM_PDnR         | true  | false | true  | true  | true  | false |
      | 07-026 | xxxxx       | MA       | GROUP_TERM_PDnR       | true  | false | true  | false | false | false |
      | 08-027 | xxxxx       | MAPD     | IND_TERM_PDnR         | true  | false | true  | false | false | false |

	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 09-028 | 15129       | MA       | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false | 
      | 10-029 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |

	@active_mapd @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 11-030 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false | 

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 12-031 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-032 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | true  | false | false |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 14-033 | 15128       | PCP      | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |
      | 15-034 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 16-035 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | false |
      | 17-036 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | true  | false |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 18-037 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | false | false |

	@active_ship @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 19-038 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true  | true  | true  | true  | false | false |  



    