@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.5 Member Plans and Documents - section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @memAuth_planAndDocuments05 @providerPharmacyDirectories
  Scenario Outline: To validate via member authorization access for Plan Documents and Resources page
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

	@memAuth_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 01-077 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | false | true     | true     | false    | false    | false    | false    |
      | 02-078 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_PREEFF_PDnR     | true  | true  | false | false    | false    | false    | false    | false    | false    |
      | 03-079 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@memAuth_preeffective_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 04-080 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | true  | false | true  | true     | true     | false    | false    | false    | false    |
      | 05-081 | xxxxx       | qavgogine | qavgogine | testusername    | PDP      | GROUP_PREEFF_PDnR     | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@memAuth_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 06-082 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |
      | 07-083 | xxxxx       | qavgogine | qavgogine | testusername    | MA       | GROUP_TERM_PDnR       | false | false | false | false    | false     | false    | false    | false    | false    |
      | 08-084 | xxxxx       | qavgogine | qavgogine | testusername    | MAPD     | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |


	@memAuth_active_ma
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 09--085 | 15129      | qavgogine | qavgogine | q2_may_rally017    | MA       | IND_EFF_PDnR          | true  | true  | false | true     | true     | false    | false    | false    | false    |
      | 10-086 | 15130       | qavgogine | qavgogine | q3_sep_UAT4_Group289    | MA       | GROUP_EFF_PDnR        | true  | true  | false | false    | false    | false    | false    | false    | false    |

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 11-087 | 15108       | qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@memAuth_active_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 12-088 | 15303       | qavgogine | qavgogine | q3_sep_UAT4_Group029    | MAPD     | GROUP_EFF_PDnR        | true  | true  | true  | false    | false    | false    | false    | false    | false    |
     ### note: PEEHIP group terminated as of 12/31/2019
     #| 13-089 | 15130       | qavgogine | qavgogine | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | false    | false    | false    | false    | false    | false    |

	@memAuth_active_pcp_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 14-090 | 15128       | qavgogine | qavgogine | testusername    | PCP      | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |
      | 15-091 | 15128       | qavgogine | qavgogine | testusername    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@memAuth_active_pdp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 16-092 | 15126,15127 | qavgogine | qavgogine | q3_sep_UAT4_AARP057    | PDP      | AARP_IND_EFF_PDnR     | true  | false | true  | true     | true     | false    | false    | false    | false    |
      | 17-093 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@memAuth_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 18-094 | 15131,15233 | qavgogine | qavgogine | q2_jun_grp0255    | SSP      | COMBO_GROUP_EFF_PDnR  | false | false | false | false    | false    | false    | false    | false    | false    |

	@memAuth_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 19-095 | 15119,15304 | qavgogine | qavgogine | q1_feb_ship_20_001    | SHIP     | IND_EFF_PDnR          | false | false | false | false    | false    | false    | false    | false    | false    | 
      | 20-119 | 15119,15304 | qavgogine | qavgogine | q1_feb_2020SHIP_001    | SHIP     | MULTI_IND_EFF_PDnR    | false | false | false | false    | false    | false    | false    | false    | false    | 
  
  
