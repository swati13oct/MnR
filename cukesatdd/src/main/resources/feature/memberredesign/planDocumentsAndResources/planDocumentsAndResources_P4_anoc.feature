@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.4 Member Plans and Documents - section: Annual Notice of Changes Documents

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments04 @anoc 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Annual Notice of Changes Documents 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And documents are able to load successfully
	And I want to customize test setup
	  | Validate API                     | true  |
	  | Skip Link Destination Validation | false |
	Then user validates jumplink and listing of mandatory documents for section Annual Notice of Changes Documents
	  | Section Display                    | <an_sd>    | 
	  | English Current Year               | <an_en_cy> | 
	  | Spanish Current Year               | <an_es_cy> | 
	  | Chinese Current Year               | <an_zh_cy> | 
	  | English Next Year                  | <an_en_ny> | 
	  | Spanish Next Year                  | <an_es_ny> | 
	  | Chinese Next Year                  | <an_zh_ny> | 

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 01-058 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
      | 02-059 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |
      | 03-060 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 04-061 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
      | 05-062 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |


	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 06-063 | xxxxx       | MA       | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |
      | 07-064 | xxxxx       | MA       | GROUP_TERM_PDnR       | false | false    | false    | false    | false    | false    | false    |
      | 08-065 | xxxxx       | MAPD     | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |


	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 09-066 | 15129       | MA       | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |
      | 10-067 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true     | false    | false    | false    | false    | false    |

	@active_mapd @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 11-068 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 12-069 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true     | false    | false    | true     | false    | false    |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-070 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | false    | false    | false    | false    | false    | false    |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 14-071 | 15128       | PCP      | IND_EFF_PDnR          | true  | true     | true     | false    | true     | true     | false    |
      | 15-072 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true     | true     | false    | true     | true     | false    |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 16-073 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |
      | 17-074 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true     | false    | false    | true     | false    | false    |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 18-075 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

	@active_ship
    Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 19-076 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | false    | false    | false    | false    | false    | false    |

	@active_ship @devRegression
    Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 20-118 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | false | false    | false    | false    | false    | false    | false    |


