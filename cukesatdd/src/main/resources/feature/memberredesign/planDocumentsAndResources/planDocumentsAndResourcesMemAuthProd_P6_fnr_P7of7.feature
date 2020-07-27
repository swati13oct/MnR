@planAndDocuments @thePredators @E2E @feature-F368974
Feature: 1.06.6.2 Member Plans and Documents - section: Forms And Resources Part 7 of 7 -Disenrollment Information - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments06_7of7 @formsAndResources_7of7
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content for section: Forms And Resources - Disenrollment Information
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
	Then user validate Forms and Resources section Disenrollment Information
	  | Section Display                    | <fnr_sd>   | 
	  | Disenrollment Information          | <fnr_di>   | 

#	@prod_preeffective_ma_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 01-096 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MA       | AARP_IND_PREEFF_PDnR  | false  | false  | 
#      | 02-097 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MA       | GROUP_PREEFF_PDnR     | false  | false  |

#	@prod_preeffective_mapd_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 03-098 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MAPD     | AARP_IND_PREEFF_PDnR  | false  | false  | 

#	@prod_preeffective_pdp_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 04-099 | xxxxx       | ashah120  | Mnrqa003  | testusername    | PDP      | AARP_IND_PREEFF_PDnR  | false  | false  |
#      | 05-100 | xxxxx       | ashah120  | Mnrqa003  | testusername    | PDP      | GROUP_PREEFF_PDnR     | false  | false  |

#	@prod_terminated_ma_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 06-103 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MA       | IND_TERM_PDnR         | true   | true   |
#      | 07-102 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MA       | GROUP_TERM_PDnR       | true   | true   |

#	@prod_terminated_mapd_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 07-101 | xxxxx       | ashah120  | Mnrqa003  | testusername    | MAPD     | IND_TERM_PDnR         | true   | true   | 

	@prod_active_ma_ind_7of7 @prod_active_ma_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 09-104 | 15129       | ashah120  | Mnrqa003  | ERNIE2450       | MA       | AARP_IND_EFF_PDnR     | true   | true   |

	@prod_active_ma_grp_7of7 @prod_active_ma_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 10-105 | 15130       | ashah120  | Mnrqa003  | 1GIRL4DEAN      | MA       | GROUP_EFF_PDnR        | true   | true   |
#      | 10-105 | 15130       | ashah120  | Mnrqa003  | SPENCEPR1      | MA       | NICE_GROUP_EFF_PDnR        | true   | true   |

	@prod_active_mapd_ind_7of7 @prod_active_mapd_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 11-106 | 15108       | ashah120  | Mnrqa003  | BILL.ROSNER123# | MAPD     | AARP_IND_EFF_PDnR     | true   | true   |

	@prod_active_mapd_grp_7of7 @prod_active_mapd_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 12-107 | 15303       | ashah120  | Mnrqa003  | SHERMANJAFFE65 | MAPD | NICE_GROUP_EFF_PDnR  | true   | true   |	  
#     ### note: PEEHIP group terminated as of 12/31/2019
#     #| 13-108 | 15130       | ashah120  | Mnrqa003  | testusername    | MAPD     | PEEHIP_GROUP_EFF_PDnR | true   | true   |

#	@prod_active_pcp_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 14-109 | 15128       | ashah120  | Mnrqa003  | testusername    | PCP      | IND_EFF_PDnR          | true   | true   | 

#	@prod_active_medica_7of7
#	Examples: 
#      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
#      | 15-110 | 15128       | ashah120  | Mnrqa003  | testusername    | MEDICA   | IND_EFF_PDnR          | true   | true   | 

	@prod_active_pdp_ind_7of7 @prod_active_pdp_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 16-111 | 15126,15127 | ashah120  | Mnrqa003  | nawal1215       | PDP      | AARP_IND_EFF_PDnR     | true   | true   | 

	@prod_active_pdp_grp_7of7 @prod_active_pdp_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 17-112 | 15131,15233 | ashah120  | Mnrqa003  | DKELLY27        | PDP      | COMBO_GROUP_EFF_PDnR  | true   | true   |

	@prod_active_ssup_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 18-113 | 15131,15233 | ashah120  | Mnrqa003  | DKELLY27        | SSP      | COMBO_GROUP_EFF_PDnR  | true   | false  |

	@prod_active_ship_7of7
	Examples: 
      | index  | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | fnr_di |
      | 19-114 | 15119,15304 | ashah120  | Mnrqa003  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true   | false  |
#     | 19-120 | 15119,15304 | ashah120  | Mnrqa003  | q1_feb_2020SHIP_0   | SHIP | MULTI_IND_EFF_PDnR    | true   | false  |    