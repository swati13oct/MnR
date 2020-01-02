Feature: 1.06.1 Member Plans and Documents - section: Membership Materials

  #------------------------------------------
  @planAndDocuments03 @membershipMaterials 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Membership Materials
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validates jumplink and listing of mandatory documents for section Membership Materials or Welcome Guide
	  | Section Display                    | <mm_sd> | 
	  | English Documents                  | <mm_en> |
	  | Spanish Documents                  | <mm_es> | 
	  | Chinese Documents                  | <mm_zh> | 

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 01-039 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
      | 02-040 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | true  | false | false | false |
      | 03-041 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 04-042 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
      | 05-043 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | true  | true  | false | false |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 06-044 | xxxxx       | MA       | IND_TERM_PDnR         | true  | true  | true  | false |
      | 07-045 | xxxxx       | MA       | GROUP_TERM_PDnR       | true  | false | false | false |
      | 08-046 | xxxxx       | MAPD     | IND_TERM_PDnR         | true  | true  | true  | false |

	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 08-047 | 15129       | MA       | IND_EFF_PDnR          | true  | true  | false | false |
      | 10-048 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true  | true  | false | 

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 11-049 | 15108       | MAPD     | IND_EFF_PDnR          | true  | true  | true  | false | 
	  | 12-050 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true  | false | false |
      | 13-051 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | false | false | 

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 14-052 | 15128       | PCP      | IND_EFF_PDnR          | true  | true  | true  | false |
      | 15-053 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | false |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 16-054 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | false | 
      | 17-055 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | false |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 18-056 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | true  | true  | false | false | 

	@active_ship
	Examples: 
      | index  | TID         | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 19-057 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | false | false | false |


     