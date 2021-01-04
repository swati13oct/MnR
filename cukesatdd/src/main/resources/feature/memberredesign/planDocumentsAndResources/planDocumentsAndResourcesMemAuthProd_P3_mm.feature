@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.3.2 Member Plans and Documents - section: Membership Materials - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments03 @membershipMaterials 
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Membership Materials
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
	Then user validates jumplink and listing of mandatory documents for section Membership Materials or Welcome Guide
	  | Section Display                    | <mm_sd> | 
	  | English Documents                  | <mm_en> |
	  | Spanish Documents                  | <mm_es> | 
	  | Chinese Documents                  | <mm_zh> | 

	@prod_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 01-039 | xxxxx       | kkumard  | tnps459#  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
#      | 02-040 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | GROUP_PREEFF_PDnR     | true  | false | false | false |
      | 03-041 | xxxxx       | kkumard  | tnps459#  | Beaver34          | MAPD     | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |

#	@prod_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 04-042 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | true  | true  | true  | false |
#      | 05-043 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | GROUP_PREEFF_PDnR     | true  | true  | false | false |

	@prod_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#      | 06-044 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | IND_TERM_PDnR         | false | false | false | false |
#      | 07-045 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | GROUP_TERM_PDnR       | false | false | false | false |
      | 08-046 | xxxxx       | kkumard  | tnps459#  | Patkeving    | MAPD     | IND_TERM_PDnR         | false | false | false | false |

	@prod_active_ma @prod_active_ma_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 09-047 | 15129       | kkumard   | tnps459#  | ssmhi1    | MA       | AARP_IND_EFF_PDnR     | true  | true  | true  | false |

	@prod_active_ma @prod_active_ma_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 10-048 | 15130       | kkumard  | tnps459#  | ExDesertrat    | MA       | GROUP_EFF_PDnR        | true  | true  | false | false | 
#      | 10-048 | 15130       | kkumard  | tnps459#  | SPENCEPR1    | MA       | NICE_GROUP_EFF_PDnR        | true  | true  | false | false | 

	@prod_active_mapd @prod_active_mapd_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 11-049 | 15108       | kkumard  | tnps459#  | LMHOCHSCHILD11    | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | false | 

	@prod_active_mapd @prod_active_mapd_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 12-050 | 15303       | kkumard  | tnps459#  | SHERMANJAFFE65    | MAPD     | NICE_GROUP_EFF_PDnR        | true  | true  | false | false |
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-051 | 15130       | kkumard  | tnps459#  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true  | false | false | 

	@prod_active_pcp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 14-052 | 15128       | kkumard  | tnps459#  | SOFYABAKMAN@MSN.COM    | PCP      | IND_EFF_PDnR          | true  | true  | true  | false |

	@prod_active_medica
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 15-053 | 15128       | kkumard  | tnps459#  | TCZUNIGA52    | MEDICA   | IND_EFF_PDnR          | true  | true  | true  | false |

	@prod_active_pdp @prod_active_pdp_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 16-054 | 15126,15127 | kkumard  | tnps459#  | PWINSAUER51    | PDP      | AARP_IND_EFF_PDnR     | true  | true  | true  | false | 

	@prod_active_pdp @prod_active_pdp_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 17-055 | 15131,15233 | kkumard  | tnps459#  | DKELLY27    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true  | true  | false |

	@prod_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 18-056 | 15131,15233 | kkumard  | tnps459#  | DKELLY27    | SSP      | COMBO_GROUP_EFF_PDnR  | true  | true  | false | false | 

	@prod_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
      | 19-057 | 15119,15304 | kkumard  | tnps459#  | Pramila1946    | SHIP     | IND_EFF_PDnR          | false | false | false | false |
#      | 20-117 | 15119,15304 | kkumard  | tnps459#  | q1_feb_2020SHIP_001    | SHIP     | MULTI_IND_EFF_PDnR    | false | false | false | false |

	@prod_preeffective_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | mm_sd | mm_en | mm_es | mm_zh |
#     | 21-121 | xxxxx       | kkumard   | tnps459#  | testusername | SHIP     | IND_PREEFF_PDnR       | false | false | false | false |

     