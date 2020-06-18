@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.6 Member Plans and Documents - section: Forms And Resources Part 2 of 7 - Premium Payment Information

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments06_2of7 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Premium Payment Information
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
	Then user validate Forms and Resources section Premium Payment Information
	  | Section Display                    | <fnr_sd>   | 
	  | Premium Payment Information        | <fnr_ppi>  | 

	@preeffective_ma_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 01-096 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false  | false   |
      | 02-097 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false  | false   |

	@preeffective_mapd_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 03-098 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false   |

	@preeffective_pdp_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 04-099 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false  | false   |
      | 05-100 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false  | false   |

	@terminated_ma_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 06-103 | xxxxx       | MA       | IND_TERM_PDnR         | true   | true    |
      | 07-102 | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | false   |

	@terminated_mapd_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 07-101 | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true    |

	@active_ma_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 09-104 | 15129       | MA       | AARP_IND_EFF_PDnR     | true   | true    |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | false   |

	@active_mapd_2of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 11-106 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true   | true    |

	@active_mapd_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | false   | 
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false   |

	@active_pcp_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true    |

	@active_medica_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true    |

	@active_pdp_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true    |
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | false   |

	@active_ssup_2of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 18-113 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false   |

	@active_ship_2of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_ppi |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false   |
      | 19-120 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | true   | false   |
    