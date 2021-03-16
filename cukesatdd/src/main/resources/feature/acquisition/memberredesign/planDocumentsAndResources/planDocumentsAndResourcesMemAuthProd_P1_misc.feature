@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.2.2 Member Plans and Documents - section: header -and- My Documents -and- EOB -and- Renew magine -and- Adobe -and- NeedHelp - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments01 @header @myDocuments @eob @renewMagazine @adobe @needHelp
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: header -and- My Documents -and- EOB -and- Renew magine -and- Adobe -and- NeedHelp 
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

	#note: Teripappas is MAPD IND with plan 2021
	@prod_preeffective_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
#      | 01-001 | xxxxx       | kkumard  | tnps459#  | Ranch1955       | MA       | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |
#      | 02-002 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | GROUP_PREEFF_PDnR     | true  | false  | false | false | false |
      | 03-003 | xxxxx       | kkumard  | tnps459#  | Mino77003          | MAPD     | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |

#	@prod_preeffective_pdp
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
#      | 04-004 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | true  | false  | false | false | false |
#      | 05-005 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | GROUP_PREEFF_PDnR     | true  | false  | false | false | false |

	@prod_terminated_ma_mapd
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
#      | 06-006 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | IND_TERM_PDnR         | true  | true   | true  | false | false |
#      | 07-007 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | GROUP_TERM_PDnR       | true  | true   | true  | false | false |
      | 08-008 | xxxxx       | kkumard  | tnps459#  | Patkeving    | MAPD     | IND_TERM_PDnR         | true  | true   | true  | true  | false |

	@prod_active_ma @prod_active_ma_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 09-009 | 15129       | kkumard  | tnps459#  | ssmhi1   | MA       | AARP_IND_EFF_PDnR     | true  | true   | true  | false | true  |

	@prod_active_ma @prod_active_ma_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 10-010 | 15130       | kkumard  | tnps459#  | ExDesertrat     | MA       | GROUP_EFF_PDnR        | true  | true   | true  | false | true  |
#      | 10-010 | 15130       | kkumard  | tnps459#  | SPENCEPR1     | MA       | NICE_GROUP_EFF_PDnR        | true  | true   | true  | false | true  |

	@prod_active_mapd @prod_active_mapd_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 11-011 | 15108       | kkumard  | tnps459#  | LMHOCHSCHILD11    | MAPD     | AARP_IND_EFF_PDnR     | true  | true   | true  | true  | true  |	

	@prod_active_mapd @prod_active_mapd_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 12-012 | 15303       | kkumard  | tnps459#  | SHERMANJAFFE65    | MAPD     | NICE_GROUP_EFF_PDnR        | true  | true   | true  | true  | true  |	  
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-013 | 15130       | kkumard  | tnps459#  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true  | true   | true  | true  | true  |

	@prod_active_pcp      
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 14-014 | 15128       | kkumard  | tnps459#  | SOFYABAKMAN@MSN.COM    | PCP      | IND_EFF_PDnR       | true  | true   | true  | true  | false |

	@prod_active_medica      
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 15-015 | 15128       | kkumard  | tnps459#  | TCZUNIGA52    | MEDICA   | IND_EFF_PDnR | true  | true   | true  | true  | false |

	@prod_active_pdp @prod_active_pdp_ind
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 16-016 | 15126,15127 | kkumard  | tnps459#  | PWINSAUER51    | PDP      | AARP_IND_EFF_PDnR     | true  | true   | false | true  | true  |

	@prod_active_pdp @prod_active_pdp_grp
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 17-017 | 15131,15233 | kkumard  | tnps459#  | DKELLY27    | PDP      | COMBO_GROUP_EFF_PDnR  | true  | true   | false | true  | false |

	@prod_active_ssup
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 18-018 | 15131,15233 | kkumard  | tnps459#  | DKELLY27    | SSP      | COMBO_GROUP_EFF_PDnR  | true  | false  | false | false | false |

	@prod_active_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName      | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
      | 19-019 | 15119,15304 | kkumard  | tnps459#  | Pramila1946| SHIP     | IND_EFF_PDnR          | false | true   | true  | false | false |
#     | 20-115 | 15119,15304 | kkumard  | tnps459#  | testusername    | SHIP     | MULTI_IND_EFF_PDnR    | false | true   | true  | false | false |

	@prod_preeffective_ship
	Examples: 
      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | md_sd | eob_sd | eob_m | eob_d | rm_sd |
#     | 21-121 | xxxxx       | kkumard   | tnps459#  | testusername | SHIP     | IND_PREEFF_PDnR       | false | false  | false | false | false |


    