@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.4.2 Member Plans and Documents - section: Annual Notice of Changes Documents - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments04 @anoc 
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

	@prod_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#     | 01-058 | xxxxx       | kkumard   | tnps459#  | Ranch1955       | MA       | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
#     | 02-059 | xxxxx       | kkumard   | tnps459#  | testusername    | MA       | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |
      | 03-060 | xxxxx       | kkumard   | tnps459#  | Mino77003        | MAPD     | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

#	@prod_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#      | 04-061 | xxxxx       | kkumard   | tnps459#  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false | false    | false    | false    | false    | false    | false    |
#      | 05-062 | xxxxx       | kkumard   | tnps459#  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false | false    | false    | false    | false    | false    | false    |


	@prod_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#     | 06-063 | xxxxx       | kkumard   | tnps459#  | testusername    | MA       | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |
#     | 07-064 | xxxxx       | kkumard   | tnps459#  | testusername    | MA       | GROUP_TERM_PDnR       | false | false    | false    | false    | false    | false    | false    |
      | 08-065 | xxxxx       | kkumard   | tnps459#  | Patkeving    | MAPD     | IND_TERM_PDnR         | false | false    | false    | false    | false    | false    | false    |


	@prod_active_ma @prod_active_ma_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 09-066 | 15129       | kkumard   | tnps459#  | ssmhi1      | MA       | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |

	@prod_active_ma @prod_active_ma_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 10-067 | 15130       | kkumard   | tnps459#  | ExDesertrat      | MA       | GROUP_EFF_PDnR        | true  | true     | false    | false    | true     | false    | false    |
#     | 10-067 | 15130       | kkumard   | tnps459#  | SPENCEPR1       | MA       | NICE_GROUP_EFF_PDnR   | true  | true     | false    | false    | false    | false    | false    |

	@prod_active_mapd @prod_active_mapd_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 11-068 | 15108       | kkumard   | tnps459#  | LMHOCHSCHILD11 | MAPD     | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |

	@prod_active_mapd @prod_active_mapd_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 12-069 | 15303       | kkumard   | tnps459#  | SHERMANJAFFE65  | MAPD     | NICE_GROUP_EFF_PDnR   | true  | true     | false    | false    | false    | false    | false    |
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-070 | 15130       | kkumard  | tnps459#  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | false    | false    | false    | false    | false    | false    |

	@prod_active_pcp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 14-071 | 15128       | kkumard   | tnps459#  | SOFYABAKMAN@MSN.COM    | PCP      | IND_EFF_PDnR       | true  | true     | true     | false    | true     | true     | false    |

	@prod_active_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 15-072 | 15128       | kkumard   | tnps459#  | TCZUNIGA52    | MEDICA   | IND_EFF_PDnR | true  | true     | true     | false    | true     | true     | false    |

	@prod_active_pdp @prod_active_pdp_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 16-073 | 15126,15127 | kkumard   | tnps459#  | PWINSAUER51       | PDP      | AARP_IND_EFF_PDnR     | true  | true     | true     | false    | true     | true     | false    |

	@prod_active_pdp @prod_active_pdp_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 17-074 | 15131,15233 | kkumard   | tnps459#  | DKELLY27        | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true     | false    | false    | true     | false    | false    |

	@prod_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 18-075 | 15131,15233 | kkumard   | tnps459#  | DKELLY27        | SSP      | COMBO_GROUP_EFF_PDnR  | false | false    | false    | false    | false    | false    | false    |

	@prod_active_ship
    Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
      | 19-076 | 15119,15304 | kkumard   | tnps459#  | Pramila1946     | SHIP     | IND_EFF_PDnR          | false | false    | false    | false    | false    | false    | false    |
#     | 20-118 | 15119,15304 | kkumard   | tnps459#  | q1_feb_2020SHIP_001 | SHIP | MULTI_IND_EFF_PDnR    | false | false    | false    | false    | false    | false    | false    |

	@prod_preeffective_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | an_sd | an_en_cy | an_es_cy | an_zh_cy | an_en_ny | an_es_ny | an_zh_ny |
#     | 21-121 | xxxxx       | kkumard   | tnps459#  | testusername | SHIP     | IND_PREEFF_PDnR       | false | false    | false    | false    | false    | false    | false    |
