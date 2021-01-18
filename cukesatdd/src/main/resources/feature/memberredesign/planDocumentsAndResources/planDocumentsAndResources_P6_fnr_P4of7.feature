<<<<<<< HEAD
@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.6 Member Plans and Documents - section: Forms And Resources Part 4 of 7 - Authorization Forms and Information

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments06_4of7 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Authorization Forms and Information
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
	Then user validate Forms and Resources section Authorization Forms and Information
	  | Section Display                    | <fnr_sd>   | 
	  | Authorization Forms and Information| <fnr_af>   | 

	@preeffective_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 01-096 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false  | false  |
      | 02-097 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false  | false  |

	@preeffective_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 03-098 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false  |

	@preeffective_pdp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 04-099 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false  | false  |
      | 05-100 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false  | false  |

	@terminated_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 06-103 | xxxxx       | MA       | IND_TERM_PDnR         | true   | true   |
      | 07-102 | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | true   |

	@terminated_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 07-101 | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true   |

	@active_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 09-104 | 15129       | MA       | AARP_IND_EFF_PDnR     | true   | true   |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | true   |

	@active_mapd_4of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 11-106 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true   | true   |

	@active_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | true   |  
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | true   |

	@active_pcp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true   |

	@active_medica_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true   |

	@active_pdp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true   |
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@active_ssup_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 18-113 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@active_ship_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false  |

	@active_ship_4of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 19-120 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | true   | false  |

	@preeffective_ship_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 20-121 | xxxxx       | SHIP     | IND_PREEFF_PDnR       | true   | false  |        
=======
@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.6 Member Plans and Documents - section: Forms And Resources Part 4 of 7 - Authorization Forms and Information

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments06_4of7 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Authorization Forms and Information
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
	Then user validate Forms and Resources section Authorization Forms and Information
	  | Section Display                    | <fnr_sd>   | 
	  | Authorization Forms and Information| <fnr_af>   | 

	@preeffective_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 01-096 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false  | false  |
      | 02-097 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false  | false  |

	@preeffective_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 03-098 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false  |

	@preeffective_pdp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 04-099 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false  | false  |
	#note: no test user available for now
    #  | 05-100 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false  | false  |

	@terminated_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 06-103 | xxxxx       | MA       | IND_TERM_PDnR         | true   | true   |
      | 07-102 | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | true   |

	@terminated_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 07-101 | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true   |

	@active_ma_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 09-104 | 15129       | MA       | AARP_IND_EFF_PDnR     | true   | true   |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | true   |

	@active_mapd_4of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 11-106 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true   | true   |

	@active_mapd_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | true   |  
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | true   |

	@active_pcp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true   |

	@active_medica_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true   |

	@active_pdp_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true   |
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@active_ssup_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 18-113 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@active_ship_4of7
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false  |

	@active_ship_4of7 @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
      | 19-120 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | true   | false  |

	#note: no test user available for now
	#@preeffective_ship_4of7
	#Examples: 
    #  | index  | TID         | planType | memberType            | fnr_sd | fnr_af |
    #  | 20-121 | xxxxx       | SHIP     | IND_PREEFF_PDnR       | true   | false  |        
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
