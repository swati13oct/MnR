@healthRecord
Feature: 1.24.2.c Member Individual Health Record - PROD - P3 - EOB, OrderPlan, PharmaciesAndPrescriptions

  #----- begin sanity
  @prod_sanity01
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P3 - EOB
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
    Then the user store expected link behavior
      | Expect Link | <expectLink>       |
	Then the user navigates to EOB page and validate Health Record link display behavior

    @prod_no_ihr_p3_ship_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | S01   | F424804 | kkumard   | tnps459#  | Pramila1946             | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |

    @prod_ihr_p3_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | S09   | F424804 | kkumard   | tnps459#  | Grandmagrey123          | MAPD     | NONBOA_GROUP_IHR   | true       |

  @prod_sanity02
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P3 - OrderPlan
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
    Then the user store expected link behavior
      | Expect Link | <expectLink>       |
	Then the user navigates to Order Plan Material page and validate Health Record link display behavior

    @prod_no_ihr_p3_ship_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | S01   | F424804 | kkumard   | tnps459#  | Pramila1946             | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |

    @prod_ihr_p3_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | S09   | F424804 | kkumard   | tnps459#  | Grandmagrey123          | MAPD     | NONBOA_GROUP_IHR   | true       |

  @prod_sanity03
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P3 - PharmaciesAndPrescriptions
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
    Then the user store expected link behavior
      | Expect Link | <expectLink>       |
	Then the user navigates to Pharmacies and Prescriptions page and validate Health Record link display behavior

    @prod_no_ihr_p3_ship_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | S01   | F424804 | kkumard   | tnps459#  | Pramila1946             | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |

    @prod_ihr_p3_mapd_sanity
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | S09   | F424804 | kkumard   | tnps459#  | Grandmagrey123          | MAPD     | NONBOA_GROUP_IHR   | true       |

  #----- begin regression
  @prod_healthRecord01 @US2471601 @F424804
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P3 - EOB, OrderPlan, PharmaciesAndPrescriptions
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
    Then the user store expected link behavior
      | Expect Link | <expectLink>       |
	Then the user navigates to EOB page and validate Health Record link display behavior
	Then the user navigates to Order Plan Material page and validate Health Record link display behavior
	Then the user navigates to Pharmacies and Prescriptions page and validate Health Record link display behavior

    #----------- begin - cases with NO IHR link
    @prod_no_ihr_p3_ship_exclude
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | 01    | F424804 | kkumard   | tnps459#  | Pramila1946             | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |
#note: need to find user
#	    | 02    | F424804 | kkumard   | tnps459#  | testUserName            | MA                       | EXCLUDE_IHR        | false       |

    @prod_no_ihr_p3_shipCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink | 
	    | 03    | F424804 | kkumard   | tnps459#  | MaryLouMichels2         | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_IHR | false      |
	 #  | 04    | F424804 | kkumard   | tnps459#  | testUserName            | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_IHR | false      |
	    | 04    | F424804 | kkumard   | tnps459#  | phleauxdailles43        | SHIP_HIP                 | COMBO_SHIP_MA_BOA_IHR  | false      |

    @prod_no_ihr_p3_boaGrp1
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 05    | F424804 | kkumard   | tnps459#  | sks1947                 | MA       | BOA12322_GROUP_IHR | false      |
	    | 06    | F424804 | kkumard   | tnps459#  | colombia114@            | MA       | BOA12323_GROUP_IHR | false      |

    @prod_no_ihr_p3_boaGrp2
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 07    | F424804 | kkumard   | tnps459#  | jeanne132               | MA       | BOA12324_TERM_GROUP_IHR | false |

    #----------- begin - cases with IHR link
    @prod_ihr_p3_ma_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 08    | F424804 | kkumard   | tnps459#  | haradaty32              | MA       | IHR                | true       |
	    | 09    | F424804 | kkumard   | tnps459#  | Grandmagrey123          | MAPD     | NONBOA_GROUP_IHR   | true       |

    @prod_ihr_p3_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 10    | F424804 | kkumard   | tnps459#  | nawal1215               | PDP      | IHR                | true       |

	#note: MA user was having new Benefits UI and not behaving the same as prior PREEFF user
	#note: term user will have IHR link suppressed
    @prod_ihr_p3_preeff_term
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	   #| 11    | F424804 | kkumard   | tnps459#  | Ranch1955               | MA       | PREEFF_IHR         | true       |
	    | 11    | F424804 | kkumard   | tnps459#  | Teripappas                | MAPD     | PREEFF_IHR         | true       |
	    | 12    | F424804 | kkumard   | tnps459#  | BEVERLY_BOB5            | MAPD     | TERM_IHR           | false      |

    @prod_ihr_p3_pdpSspCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 13    | F424804 | kkumard   | tnps459#  | DKELLY27                | SSP      | COMBO_PDP_SSP_IHR  | true       |
	    | 14    | F424804 | kkumard   | tnps459#  | DKELLY27                | PDP      | COMBO_PDP_SSP_IHR  | true       |

    @prod_ihr_p3_fedShipCombo_shipFedCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 15    | F424804 | kkumard   | tnps459#  | MaryLouMichels2         | PDP      | COMBO_PDP_SHIP_IHR | true       |
	    #note: this user is BOA group
	    | 16    | F424804 | kkumard   | tnps459#  | phleauxdailles43        | MA       | COMBO_SHIP_MA_BOA_IHR  | false      |

    @prod_ihr_p3_medica_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 17    | F424804 | kkumard   | tnps459#  | SUSICHAPMAN@GMAIL.COM   | MEDICA   | IHR                | true       |
	    | 18    | F424804 | kkumard   | tnps459#  | BATLLOT@AOL.COM         | PCP      | IHR                | true       |


	    