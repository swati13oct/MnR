@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.5 Member Plans and Documents - section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments05 @providerPharmacyDirectories
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories
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
	Then user validates jumplink and listing of mandatory documents for section Provider Directory or Pharmacy Directory or Provider and Pharmacy Directories
	  | Section Display                    | <pd_sd>    | 
	  | Provider Search                    | <pd_ps>    | 
	  | Pharmacy Locator                   | <pd_pl>    | 
	  | English Current Year               | <pd_en_cy> | 
	  | Spanish Current Year               | <pd_es_cy> | 
	  | Chinese Current Year               | <pd_zh_cy> | 
	  | English Next Year                  | <pd_en_ny> | 
	  | Spanish Next Year                  | <pd_es_ny> | 
	  | Chinese Next Year                  | <pd_zh_ny> | 

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 01-077 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | false | true     | true     | false    | false    | false    | false    |
      | 02-078 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | true  | true  | false | false    | false    | false    | false    | false    | false    |
      | 03-079 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 04-080 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | true  | false | true  | true     | true     | false    | false    | false    | false    |
      | 05-081 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 06-082 | xxxxx       | MA       | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |
      | 07-083 | xxxxx       | MA       | GROUP_TERM_PDnR       | false | false | false | false    | false     | false    | false    | false    | false    |
      | 08-084 | xxxxx       | MAPD     | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |


	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 09--085 | 15129      | MA       | AARP_IND_EFF_PDnR     | true  | true  | false | true     | true     | false    | false    | false    | false    |
      | 10-086 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true  | false | false    | false    | false    | false    | false    | false    |

	@active_mapd @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 11-087 | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 12-088 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true  | true  | false    | false    | false    | false    | false    | false    |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-089 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | false    | false    | false    | false    | false    | false    |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 14-090 | 15128       | PCP      | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |
      | 15-091 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 16-092 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | false | true  | true     | true     | false    | false    | false    | false    |
      | 17-093 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 18-094 | 15131,15233 | SSP      | COMBO_GROUP_EFF_PDnR  | false | false | false | false    | false    | false    | false    | false    | false    |

	@active_ship @devRegression
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 19-095 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | false | false | false    | false    | false    | false    | false    | false    | 
      | 20-119 | 15119,15304 | SHIP     | MULTI_IND_EFF_PDnR    | false | false | false | false    | false    | false    | false    | false    | false    | 
  
  
