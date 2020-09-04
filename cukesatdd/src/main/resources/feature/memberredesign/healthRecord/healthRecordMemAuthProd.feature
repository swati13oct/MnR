@healthRecord
Feature: 1.24.2 Member Individual Health Record - PROD

  @prod__healthRecord01 @US2471601 @F424804
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table
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
    Then the user validates Health Record link display behavior on Account Profile dropdown base on test input
      | Expect Link | <expectLink>       |
    Then the user validates clicking Health Record link will open to the target page
	Then the user navigates to Find Care page if applicable and validate Health Record link display behavior
	#Then the user navigates to Claims page if applicable and validate Health Record link display behavior
	Then the user navigates to EOB page and validate Health Record link display behavior
	Then the user navigates to Benefits page and validate Health Record link display behavior
	Then the user navigates to Plan Documents and Resources page and My Documents page and validate Health Record link display behavior
	Then the user navigates to Order Plan Material page and validate Health Record link display behavior
	Then the user navigates to Payments page and validate Health Record link display behavior
	#Then the user navigates to Pharmacies and Prescriptions page and validate Health Record link display behavior
	Then the user navigates to Health and Wellness page and validate Health Record link display behavior
	Then the user navigates to Account Settings page and validate Health Record link display behavior
	Then the user navigates to Contact Us page and validate Health Record link display behavior
	Then the user navigates to Pharmacy Locator page and validate Health Record link display behavior
	Then the user navigates to DCE page and validate Health Record link display behavior

    #----------- begin - cases with NO IHR link
    @prod__no_ihr_ship_exclude
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | 01    | F424804 | kkumard   | mnrs786@  | Pramila1946             | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |
#note: need to find user
#	    | 02    | F424804 | kkumard   | mnrs786@  | testUserName            | MA                       | EXCLUDE_IHR        | false       |

    @prod__no_ihr_shipCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink | 
	    | 03    | F424804 | kkumard   | mnrs786@  | MaryLouMichels2         | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_IHR | false      |
	 #  | 04    | F424804 | kkumard   | mnrs786@  | testUserName            | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_IHR | false      |
	    | 04    | F424804 | kkumard   | mnrs786@  | phleauxdailles43        | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MA_IHR | false      |

#note: need to find user
#    @prod__no_ihr_boaGrp1
#    Examples: 
#	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
#	    | 05    | F424804 | kkumard   | mnrs786@  | testUserName            | MA       | BOA12322_GROUP_IHR | false      |
#	    | 06    | F424804 | kkumard   | mnrs786@  | testUserName            | MA       | BOA12323_GROUP_IHR | false      |

#note: need to find user
#    @prod__no_ihr_boaGrp2
#    Examples: 
#	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
#	    | 07    | F424804 | kkumard   | mnrs786@  | testUserName            | MA       | BOA12324_TERM_GROUP_IHR | false |

    #----------- begin - cases with IHR link
    @prod__ihr_ma_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 08    | F424804 | kkumard   | mnrs786@  | ERNIE2450               | MA       | IHR                | true       |
#note: need to find user
#	    | 09    | F424804 | kkumard   | mnrs786@  | testUserName            | MAPD     | NONBOA_GROUP_IHR   | true       |

    @prod__ihr_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 10    | F424804 | kkumard   | mnrs786@  | nawal1215               | PDP      | IHR                | true       |

	#note: MA user was having new Benefits UI and not behaving the same as prior PREEFF user
    @prod__ihr_preeff_term
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 11    | F424804 | kkumard   | mnrs786@  | Ranch1955               | MA       | PREEFF_IHR         | true       |
	    | 12    | F424804 | kkumard   | mnrs786@  | BEVERLY_BOB5            | MAPD     | TERM_IHR           | true       |

    @prod__ihr_pdpSspCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 13    | F424804 | kkumard   | mnrs786@  | DKELLY27                | SSP      | COMBO_PDP_SSP_IHR  | true       |
	    | 14    | F424804 | kkumard   | mnrs786@  | DKELLY27                | PDP      | COMBO_PDP_SSP_IHR  | true       |

    @prod__ihr_fedShipCombo_shipFedCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 15    | F424804 | kkumard   | mnrs786@  | MaryLouMichels2         | PDP      | COMBO_PDP_SHIP_IHR | true       |
	    | 16    | F424804 | kkumard   | mnrs786@  | phleauxdailles43        | MAPD       | COMBO_SHIP_MA_IHR  | true       |

    @prod__ihr_medica_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 17    | F424804 | kkumard   | mnrs786@  | SUSICHAPMAN@GMAIL.COM    | MEDICA   | IHR                | true       |
	    | 18    | F424804 | kkumard   | mnrs786@  | BATLLOT@AOL.COM          | PCP      | IHR                | true       |


	    