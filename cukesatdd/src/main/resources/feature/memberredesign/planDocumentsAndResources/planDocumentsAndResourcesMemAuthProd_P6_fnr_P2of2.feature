@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.6.2 Member Plans and Documents - section: Forms And Resources Part 2 of 2 - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments06_2of2 @formsAndResources_2of2
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources
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
	##   | Validate API                     | true  |
	##   | Skip Link Destination Validation | false |
	Then user validate Forms and Resources section Part 2 of 2
	  | Section Display                    | <fnr_sd>   | 
	  | Medication Authorization Forms     | <fnr_maf>  | 
	  | Other Resources                    | <fnr_or>   | 
	  | Disenrollment Information          | <fnr_di>   | 

#	@prod_preeffective_ma_2of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
#      | 01-096 | xxxxx       | kkumard  | tnps459#  | Ranch1955    | MA       | AARP_IND_PREEFF_PDnR  | false  | false   | false  | false  | 
#      | 02-097 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | GROUP_PREEFF_PDnR     | false  | false   | false  | false  |

	@prod_preeffective_mapd_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 03-098 | xxxxx       | kkumard  | tnps459#  | Mino77003          | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false   | false  | false  | 

#	@prod_preeffective_pdp_2of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
#      | 04-099 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false  | false   | false  | false  |
#      | 05-100 | xxxxx       | kkumard  | tnps459#  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false  | false   | false  | false  |

	@prod_terminated_ma_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
#      | 06-103 | xxxxx       | kkumard  | tnps459#  | testusername    | MA       | IND_TERM_PDnR         | true   | false   | true   | true   |
      | 07-102 | xxxxx       | kkumard  | tnps459#  | pkarels    | MA       | GROUP_TERM_PDnR       | true   | false   | true   | true   |

#	@prod_terminated_mapd_2of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
#      | 07-101 | xxxxx       | kkumard  | tnps459#  | Patkeving    | MAPD     | IND_TERM_PDnR         | true   | true    | true   | true   | 

	@prod_active_ma_ind_2of2 @prod_active_ma_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 09-104 | 15129       | kkumard  | tnps459#  | ssmhi1      | MA       | AARP_IND_EFF_PDnR     | true   | false   | true   | true   |

	@prod_active_ma_grp_2of2 @prod_active_ma_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 10-105 | 15130       | kkumard  | tnps459#  | ExDesertrat      | MA       | GROUP_EFF_PDnR        | true   | false   | true   | true   |
#      | 10-105 | 15130       | kkumard  | tnps459#  | SPENCEPR1      | MA       | NICE_GROUP_EFF_PDnR        | true   | false   | true   | true   |

	@prod_active_mapd_ind_2of2 @prod_active_mapd_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 11-106 | 15108       | kkumard  | tnps459#  | LMHOCHSCHILD11 | MAPD     | AARP_IND_EFF_PDnR     | true   | true    | true   | true   |

	@prod_active_mapd_grp_2of2 @prod_active_mapd_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 12-107 | 15303       | kkumard  | tnps459#  | SHERMANJAFFE65 | MAPD | NICE_GROUP_EFF_PDnR  | true   | false   | true   | true   |	  
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-108 | 15130       | kkumard  | tnps459#  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | false   | true   | true   |

	@prod_active_pcp_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 14-109 | 15128       | kkumard  | tnps459#  | SOFYABAKMAN@MSN.COM    | PCP      | IND_EFF_PDnR          | true   | true    | true   | true   | 

	@prod_active_medica_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 15-110 | 15128       | kkumard  | tnps459#  | TCZUNIGA52    | MEDICA   | IND_EFF_PDnR          | true   | true    | true   | true   | 

	@prod_active_pdp_ind_2of2 @prod_active_pdp_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 16-111 | 15126,15127 | kkumard  | tnps459#  | PWINSAUER51       | PDP      | AARP_IND_EFF_PDnR     | true   | true    | true   | true   | 

	@prod_active_pdp_grp_2of2 @prod_active_pdp_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 17-112 | 15131,15233 | kkumard  | tnps459#  | DKELLY27        | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true    | true   | true   |

	@prod_active_ssup_2of2
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
      | 18-113 | 15131,15233 | kkumard  | tnps459#  | DKELLY27        | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false   | true   | false  |

    #note - covered by P1of2 already
	#@prod_active_ship_2of2
	#Examples: 
    #  | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
    #  | 19-114 | 15119,15304 | kkumard  | tnps459#  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true   | false   | false  | false  |
#     | 19-120 | 15119,15304 | kkumard  | tnps459#  | q1_feb_2020SHIP_0   | SHIP | MULTI_IND_EFF_PDnR    | true   | false   | false  | false  |  

#	@prod_preeffective_ship_2of2
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName  | planType | memberType            | fnr_sd | fnr_maf | fnr_or | fnr_di |
#     | 21-121 | xxxxx       | kkumard   | tnps459#  | testusername | SHIP     | IND_PREEFF_PDnR       | true   | false   | false  | false  |
   