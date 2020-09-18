@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.5.2 Member Plans and Documents - section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments05 @providerPharmacyDirectories
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Provider Directory -or- Pharmacy Directory -or- Provider and Pharmacy Directories
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

	@prod_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 01-077 | xxxxx       | kkumard  | mnrs786@  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | false | true     | true     | false    | false    | false    | false    |
#      | 02-078 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_PREEFF_PDnR     | true  | true  | false | false    | false    | false    | false    | false    | false    |
#      | 03-079 | xxxxx       | kkumard  | mnrs786@  | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | true     | true     | false    | false    | false    | false    |

#	@prod_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
#      | 04-080 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | true  | false | true  | true     | true     | false    | false    | false    | false    |
#      | 05-081 | xxxxx       | kkumard  | mnrs786@  | testusername    | PDP      | GROUP_PREEFF_PDnR     | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@prod_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
#      | 06-082 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |
#      | 07-083 | xxxxx       | kkumard  | mnrs786@  | testusername    | MA       | GROUP_TERM_PDnR       | false | false | false | false    | false     | false    | false    | false    | false    |
      | 08-084 | xxxxx       | kkumard  | mnrs786@  | BEVERLY_BOB5    | MAPD     | IND_TERM_PDnR         | false | false | false | false    | false    | false    | false    | false    | false    |


	@prod_active_ma @prod_active_ma_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 09-085 | 15129       | kkumard  | mnrs786@  | ERNIE2450    | MA       | AARP_IND_EFF_PDnR     | true  | true  | false | true     | true     | false    | false    | false    | false    |

	@prod_active_ma @prod_active_ma_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 10-086 | 15130       | kkumard  | mnrs786@  | 1GIRL4DEAN    | MA       | GROUP_EFF_PDnR        | true  | true  | false | false    | false    | false    | false    | false    | false    |
#      | 10-086 | 15130       | kkumard  | mnrs786@  | SPENCEPR1    | MA       | NICE_GROUP_EFF_PDnR        | true  | true  | false | false    | false    | false    | false    | false    | false    |

	@prod_active_mapd @prod_active_mapd_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 11-087 | 15108       | kkumard  | mnrs786@  | BILL.ROSNER123#    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@prod_active_mapd @prod_active_mapd_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 12-088 | 15303       | kkumard  | mnrs786@  | SHERMANJAFFE65    | MAPD     | NICE_GROUP_EFF_PDnR        | true  | true  | true  | false    | false    | false    | false    | false    | false    |
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-089 | 15130       | kkumard  | mnrs786@  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | true  | false    | false    | false    | false    | false    | false    |

	@prod_active_pcp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 14-090 | 15128       | kkumard  | mnrs786@  | BATLLOT@AOL.COM    | PCP      | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@prod_active_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 15-091 | 15128       | kkumard  | mnrs786@  | SUSICHAPMAN@GMAIL.COM    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | true     | true     | false    | false    | false    | false    |

	@prod_active_pdp @prod_active_pdp_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 16-092 | 15126,15127 | kkumard  | mnrs786@  | nawal1215    | PDP      | AARP_IND_EFF_PDnR     | true  | false | true  | true     | true     | false    | false    | false    | false    |

	@prod_active_pdp @prod_active_pdp_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 17-093 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | false | true  | false    | false    | false    | false    | false    | false    |

	@prod_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 18-094 | 15131,15233 | kkumard  | mnrs786@  | DKELLY27    | SSP      | COMBO_GROUP_EFF_PDnR  | false | false | false | false    | false    | false    | false    | false    | false    |

	@prod_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | pd_sd | pd_ps | pd_pl | pd_en_cy | pd_es_cy | pd_zh_cy | pd_en_ny | pd_es_ny | pd_zh_ny |
      | 19-095 | 15119,15304 | kkumard  | mnrs786@  | Pramila1946    | SHIP     | IND_EFF_PDnR          | false | false | false | false    | false    | false    | false    | false    | false    | 
#      | 20-119 | 15119,15304 | kkumard  | mnrs786@  | q1_feb_2020SHIP_001    | SHIP     | MULTI_IND_EFF_PDnR    | false | false | false | false    | false    | false    | false    | false    | false    | 
  
  
