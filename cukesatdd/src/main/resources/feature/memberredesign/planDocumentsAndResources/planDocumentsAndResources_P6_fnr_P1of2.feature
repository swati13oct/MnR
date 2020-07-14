@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.6 Member Plans and Documents - section: Forms And Resources Part 1 of 2

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments06_1of2 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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

	@preeffective_ma_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 01-096 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  |
      | 02-097 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false  | false    | false   | false  | false  |

	@preeffective_mapd_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 03-098 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  |

	@preeffective_pdp_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 04-099 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false  | false    | false   | false  | false  |
      | 05-100 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false  | false    | false   | false  | false  |

	@terminated_ma_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 06-103 | xxxxx       | MA       | IND_TERM_PDnR         | true   | false    | true    | true   | true   |
      | 07-102 | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | false    | false   | true   | true   |

	@terminated_mapd_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 07-101 | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true     | true    | true   | true   |

	@active_ma_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 09-104 | 15129       | MA       | AARP_IND_EFF_PDnR     | true   | false    | true    | true   | true   |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | false    | false   | true   | true   |

	@active_mapd_1of2 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 11-106 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true   | true     | true    | true   | true   |

	@active_mapd_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | false    | false   | true   | true   |  
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false    | false   | true   | true   |

	@active_pcp_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true     | true    | true   | true   |

	@active_medica_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true     | true    | true   | true   |

	@active_pdp_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true     | true    | true   | true   |
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true     | false   | true   | true   |

	@active_ssup_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 18-113 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false    | false   | true   | true   |

	@active_ship_1of2
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false    | false   | false  | false  |

	@active_ship_1of2 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af |
      | 19-120 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | true   | false    | false   | false  | false  |
    