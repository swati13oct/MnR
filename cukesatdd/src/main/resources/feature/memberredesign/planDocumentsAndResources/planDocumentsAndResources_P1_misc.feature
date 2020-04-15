@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.2 Member Plans and Documents - section: header -and- My Documents -and- EOB -and- Renew magine -and- Adobe -and- NeedHelp

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments01 @header @myDocuments @eob @renewMagazine @adobe @needHelp
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: header -and- My Documents -and- EOB -and- Renew magine -and- Adobe -and- NeedHelp 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    ## note: no need for this section but keep it here for consistent with other scenarios  
    ## And documents are able to load successfully
	## And I want to customize test setup
	##   | Validate API                     | true |
	##   | Skip Link Destination Validation | false |
	Then user validates header section content for Plan Documents and Resources page
	Then user validate My Documents section
	  | Section Display                    | <md_sd>  | 
	Then user validate Explanation of Benefits section
	  | Section Display                    | <eob_sd> | 
	  | Search Medical EOB History         | <eob_m>  | 
	  | Search Drug EOB History            | <eob_d>  | 
	Then user validate Renew Magazine section
	  | Section Display                    | <rm_sd>  | 
	Then user validate Adobe section
    #note: moved to footer feature
	#Then user validate Need Help section

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 01-001 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |
      | 02-002 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | true  | false  | false | false | false |
      | 03-003 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 04-004 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |
      | 05-005 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | true  | false  | false | false | false |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 06-006 | xxxxx       | MA       | IND_TERM_PDnR         | true  | true   | true  | false | false |
      | 07-007 | xxxxx       | MA       | GROUP_TERM_PDnR       | true  | true   | true  | false | false |
      | 08-008 | xxxxx       | MAPD     | IND_TERM_PDnR         | true  | true   | true  | true  | false |

	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 09-009 | 15129       | MA       | IND_EFF_PDnR          | true  | true   | true  | false | true  |
      | 10-010 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true   | true  | false | true  |

	@active_mapd @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 11-011 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true  | true   | true  | true  | true  |	

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 12-012 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true   | true  | true  | true  |	  
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-013 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true   | true  | true  | true  |

	@active_pcp_medica      
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 14-014 | 15128       | PCP      | IND_EFF_PDnR          | true  | true   | true  | true  | true  |
      | 15-015 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true   | true  | true  | true  |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 16-016 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | true   | false | true  | true  |
      | 17-017 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true   | false | true  | false |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 18-018 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | true  | false  | false | false | false |

	@active_ship @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 19-019 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | true   | true  | false | false |
      | 20-115 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | false | true   | true  | false | false |



    