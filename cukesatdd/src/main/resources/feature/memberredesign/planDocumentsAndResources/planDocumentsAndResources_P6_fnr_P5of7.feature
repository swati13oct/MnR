@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.6 Member Plans and Documents - section: Forms And Resources Part 5 of 7 - Medication Authorization Forms

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments06_5of7 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Medication Authorization Forms
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
	Then user validate Forms and Resources section Medication Authorization Forms
	  | Section Display                    | <fnr_sd>   | 
	  | Medication Authorization Forms     | <fnr_maf>  | 

	@preeffective_ma_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 01-096 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false  | false   |
      | 02-097 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false  | false   |

	@preeffective_mapd_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 03-098 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false   |

	@preeffective_pdp_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 04-099 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false  | false   |
      | 05-100 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false  | false   |

	@terminated_ma_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 06-103 | xxxxx       | MA       | IND_TERM_PDnR         | true   | false   |
      | 07-102 | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | false   |

	@terminated_mapd_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 07-101 | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true    |

	@active_ma_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 09-104 | 15129       | MA       | AARP_IND_EFF_PDnR     | true   | false   |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | false   |

	@active_mapd_5of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 11-106 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true   | true    |

	@active_mapd_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | false   |  
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false   |

	@active_pcp_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true    |

	@active_medica_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true    |

	@active_pdp_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true    |
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true    |

	@active_ssup_5of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 18-113 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false   |

	@active_ship_5of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_maf |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false   |
      | 19-120 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | true   | false   |
    