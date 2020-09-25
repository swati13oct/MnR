@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.4.1 Member Plans and Documents - section: Annual Notice of Changes Documents - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @memAuth_planAndDocuments04 @anoc 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Annual Notice of Changes Documents 
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
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

#	@memAuth_preeffective_ma_mapd
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#      | 01-058 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
#      | 02-059 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |
#      | 03-060 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

#	@memAuth_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#      | 04-061 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
#      | 05-062 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |


#	@memAuth_terminated_ma_mapd
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#      | 06-063 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |
#      | 07-064 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_TERM_PDnR       | false | false    | false    | false    | false    | false    | false    |
#      | 08-065 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |


	@memAuth_active_ma
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 09-066 | 15129       | qavgogine | qavgogine | q2_june_NiceSeg_1595 | MA  | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | false    | false    | false    |
      | 10-067 | 15130       | qavgogine | qavgogine | q3_sep_UAT4_Group289 | MA  | GROUP_EFF_PDnR        | true  | true     | false    | false    | false    | false    | false    |

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 11-068 | 15108       | qavgogine | qavgogine | q2_apr_aarp0250 | MAPD     | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | false    | false    | false    |

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 12-069 | 15303       | qavgogine | qavgogine | q3_sep_UAT4_Group029 | MAPD| GROUP_EFF_PDnR        | true  | true     | false    | false    | false    | false    | false    |
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-070 | 15130       | qavgogine | qavgogine | testusername   | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | false    | false    | false    | false    | false    | false    |

#	@memAuth_active_pcp_medica
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#      | 14-071 | 15128       | qavgogine | qavgogine | testusername    | PCP      | IND_EFF_PDnR          | true  | true     | true     | false    | false    | false    | false    |
#      | 15-072 | 15128       | qavgogine | qavgogine | testusername    | MEDICA   | IND_EFF_PDnR          | true  | true     | true     | false    | false    | false    | false    |

	@memAuth_active_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny  | an_es_ny | an_zh_ny |
      | 16-073 | 15126,15127 | qavgogine | qavgogine | q3_sep_UAT4_AARP057 | PDP  | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | false     | false    | false    |
      | 17-074 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | PDP    | COMBO_GROUP_EFF_PDnR  | true  | true     | false    | false    | true      | false    | false    |

	@memAuth_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 18-075 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255  | SSP      | COMBO_GROUP_EFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

	@memAuth_active_ship
    Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 19-076 | 15119,15304 | qavgogine | qavgogine | PaidInFullShip0011 | SHIP  | IND_EFF_PDnR          | false | false    | false    | false    | false    | false    | false    |
      | 20-118 | 15119,15304 | qavgogine | qavgogine | q3_SEP_2020SHIP_012| SHIP  | MULTI_IND_EFF_PDnR    | false | false    | false    | false    | false    | false    | false    |


