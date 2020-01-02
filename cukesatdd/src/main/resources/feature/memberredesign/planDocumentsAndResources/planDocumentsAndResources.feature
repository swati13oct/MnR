Feature: 1.06.1 Member Plans and Documents

  #------------------------------------------
  @planAndDocuments01 @header @myDocuments @eob @renewMagazine @adobe @needHelp
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: header -and- My Documents -and- EOB -and- Renew magine -and- Adobe -and- NeedHelp 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
	Then user validate Need Help section

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

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 11-011 | 15108       | MAPD     | IND_EFF_PDnR          | true  | true   | true  | true  | true  |	
	  | 12-012 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true   | true  | true  | true  |	  
      | 13-013 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true   | true  | true  | true  |

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
      | 18-018 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | true  | false  | false | false | false |

	@active_ship
	Examples: 
      | index  | TID         | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 19-019 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | true   | true  | false | false |


  #------------------------------------------
  @planAndDocuments02 @planMaterials
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Plan Materials
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
      | 09-028 | 15129       | MA       | IND_EFF_PDnR          | true  | true  | true  | true  | false | false | 
      | 10-029 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true  | true  | true  | true  | false |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 11-030 | 15108       | MAPD     | IND_EFF_PDnR          | true  | true  | true  | true  | true  | false | 
	  | 12-031 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true  | true  | true  | false | false |
      | 13-032 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | true  | false | false |

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
      | 18-037 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | true  | false | false |

	@active_ship
	Examples: 
      | index  | TID         | planType | memberType            | pm_sd | pm_op | pm_mi | pm_en | pm_es | pm_zh |
      | 19-038 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true  | true  | true  | true  | false | false |  


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


  #------------------------------------------
  @planAndDocuments04 @anoc 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Annual Notice of Changes Documents 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validates jumplink and listing of mandatory documents for section Annual Notice of Changes Documents
	  | Section Display                    | <an_sd>    | 
	  | English Current Year               | <an_en_cy> | 
	  | Spanish Current Year               | <an_es_cy> | 
	  | Chinese Current Year               | <an_zh_cy> | 
	  | English Next Year                  | <an_en_ny> | 
	  | Chinese Next Year                  | <an_es_ny> | 
	  | Chinese Next Year                  | <an_zh_ny> | 

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 01-058 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
      | 02-059 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |
      | 03-060| xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

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
      | 09-066 | 15129       | MA       | IND_EFF_PDnR          | true  | false    | true     | false    | true     | false    | false    |
      | 10-067 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true    | false     | false    | true     | false    | false    |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 11-068 | 15108       | MAPD     | IND_EFF_PDnR          | true  | false    | false     | false    | true     | false    | false    |
	  | 12-069 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true     | true     | false    | false    | false    | false    |
      | 13-070 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | false     | false    | false    | false    | false    | false    |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 14-071 | 15128       | PCP      | IND_EFF_PDnR          | true  | false     | false     | false     | true     | false    | false    |
      | 15-072 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | false     | false     | false     | true     | true    | false    |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 16-073 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | false     | false     | false     | true     | false    | false    |
      | 17-074 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true     | true     | true     | true     | false    | false    |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 18-075 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

	@active_ship
    Examples: 
      | index  | TID         | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 19-076 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | false    | false    | false    | false    | false    | false    |


  #------------------------------------------
  @planAndDocuments05 @providerPharmacyDirectories
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
      | 01-077 | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | false | false    | true     | false    | true     | false    | false    |
      | 02-078 | xxxxx       | MA       | GROUP_PREEFF_PDnR     | true  | true  | false | false    | false    | false    | false    | false    | false    |
      | 03-079 | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false    | true     | false    | true     | false    | false    |

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 04-080 | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | true  | false | true  | false   | false     | false    | true     | true    | false    |
      | 05-081 | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 06-082 | xxxxx       | MA       | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |
	  ## note: 07 not sure if it should have provider directory section, Medical Reimb form also wrong URL
      | 07-083 | xxxxx       | MA       | GROUP_TERM_PDnR       | true  | false | false | true     | true     | false    | true     | true     | false    |
      | 08-084 | xxxxx       | MAPD     | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |


	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 09-085 | 15129       | MA       | IND_EFF_PDnR          | true  | true  | false | false     | false     | false     | true     | false    | false    |
      | 10-086 | 15130       | MA       | GROUP_EFF_PDnR        | true  | true  | false | false     | false     | false     | false     | false    | false    |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
		## 11 has no section
      | 11-087 | 15108       | MAPD     | IND_EFF_PDnR          | true  | true | true  | false     | false     | false     | true     | true     | false    |
	  | 12-088 | 15303       | MAPD     | GROUP_EFF_PDnR        | true  | true | true | false     | false     | false    | false     | false     | false    |
      | 13-089 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | false    | false    | false    | false    | false    | false    |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 14-090 | 15128       | PCP      | IND_EFF_PDnR          | true  | true  | true  | false     | false     | false     | true     | false    | false    |
      | 15-091 | 15128       | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | false     | false     | false     | true    | true    | false    |

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 16-092 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true  | false | true  | false     | false     | false     | true    | true    | false    |
      | 17-093 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 18-094 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | false | false | false | false    | false    | false    | false    | false    | false    |

	@active_ship
	Examples: 
      | index  | TID         | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 19-095 | 15119,15304 | SHIP     | IND_EFF_PDnR          | false | false | false | false    | false    | false    | false    | false    | false    | 
  
  
  #------------------------------------------
  @planAndDocuments06 @formsAndResources
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validate Forms and Resources section
	  | Section Display                    | <fnr_sd>   | 
	  | Prescription Drug Mail Order Form  | <fnr_pdmo> | 
	  | Premium Payment Information        | <fnr_ppi>  | 
	  | Reimbursement Forms                | <fnr_rf>   | 
	  | Authorization Forms and Information| <fnr_af>   | 
	  | Medication Authorization Forms     | <fnr_maf>  | 
	  | Other Resources                    | <fnr_or>   | 
	  | Disenrollment Information          | <fnr_di>   | 

	@preeffective_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 01-096    | xxxxx       | MA       | AARP_IND_PREEFF_PDnR  | true   | false    | true    | true   | true   | false   | true   | true   | 
      | 02-097    | xxxxx       | MA       | GROUP_PREEFF_PDnR     | true   | false    | false   | true   | true   | false   | true   | true   |
      | 03-098    | xxxxx       | MAPD     | AARP_IND_PREEFF_PDnR  | true   | false    | true    | true   | true   | true    | true   | true   | 

	@preeffective_pdp
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 04-099    | xxxxx       | PDP      | AARP_IND_PREEFF_PDnR  | true   | true     | true    | true   | true   | true    | true   | true   |
      | 05-100    | xxxxx       | PDP      | GROUP_PREEFF_PDnR     | true   | true     | false   | true   | true   | true    | true   | true   |

	@terminated_ma_mapd
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 06-101    | xxxxx       | MAPD     | IND_TERM_PDnR         | true   | true     | true    | true   | true   | true    | true   | true   | 
	  ##BAD how to appoint vs Medical Reimburse
      | 07-102    | xxxxx       | MA       | GROUP_TERM_PDnR       | true   | false    | false   | true   | true   | false   | true   | true   |
      | 08-103    | xxxxx       | MA       | IND_TERM_PDnR         | true   | false    | true    | true   | true  | false    | true   | true   |

	@active_ma
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 09-104 | 15129       | MA       | IND_EFF_PDnR          | true   | false    | true    | true   | true   | false   | true   | true   |
      | 10-105 | 15130       | MA       | GROUP_EFF_PDnR        | true   | false    | false   | true   | true   | false   | true   | true   |

	@active_mapd
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 11-106 | 15108       | MAPD     | IND_EFF_PDnR          | true   | false    | true    | true   | true   | true    | true   | true   |
      | 12-107 | 15303       | MAPD     | GROUP_EFF_PDnR        | true   | false    | false   | true   | true   | false   | true   | true   |	  
      | 13-108 | 15130       | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false    | false   | true   | true   | false   | true   | true   |

	@active_pcp_medica
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 14-109 | 15128       | PCP      | IND_EFF_PDnR          | true   | true     | true    | true   | true   | true    | true   | true   | 
      | 15-110 | 15128       | MEDICA   | IND_EFF_PDnR          | true   | true     | true    | true   | true   | true    | true   | true   | 

	@active_pdp
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 16-111 | 15126,15127 | PDP      | AARP_IND_EFF_PDnR     | true   | true     | true    | true   | true   | true    | true   | true   | 
      | 17-112 | 15131,15233 | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true     | false   | true   | true   | true    | true   | true   |

	@active_ssup
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 18-113 | 15131,15233 | SSUP     | COMBO_GROUP_EFF_PDnR  | true   | false    | false   | true   | true   | false   | true   | false  |

	@active_ship
	Examples: 
      | index  | TID         | planType | memberType            | fnr_sd | fnr_pdmo | fnr_ppi | fnr_rf | fnr_af | fnr_maf | fnr_or | fnr_di |
      | 19-114 | 15119,15304 | SHIP     | IND_EFF_PDnR          | true   | false    | false   | false  | false  | false   | false  | false  |
    