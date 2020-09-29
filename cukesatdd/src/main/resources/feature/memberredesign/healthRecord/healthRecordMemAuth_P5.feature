@healthRecord
Feature: 1.24.1.e Member Individual Health Record - Member Auth - P5 - PharmacyLocator, DCE

  @memAuth_healthRecord01 @US2471601 @F424804
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P5 - PharmacyLocator, DCE
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
	Then the user navigates to Pharmacy Locator page and validate Health Record link display behavior
	Then the user navigates to DCE page and validate Health Record link display behavior

    #----------- begin - cases with NO IHR link
    @memAuth_no_ihr_p5_ship_exclude
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink  | 
	    | 01    | F424804 | qavgogine | qavgogine | PaidInFullShip0011      | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |
	    | 02    | F424804 | qavgogine | qavgogine | q2_may_rally032         | MA                       | EXCLUDE_IHR        | false       |

    @memAuth_no_ihr_p5_shipCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType                 | memberType         | expectLink | 
	    | 03    | F424804 | qavgogine | qavgogine | q3_sep_UAT4_AARP023 | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_IHR | false      |
	 #  | 04    | F424804 | qavgogine | qavgogine | Dream_EOB_PDP_001       | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_IHR | false      |
	    | 04    | F424804 | qavgogine | qavgogine | q3_sept_UAT4_AARP_011   | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MAPD_IHR | false      |

    @memAuth_no_ihr_p5_boaGrp1
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 05    | F424804 | qavgogine | qavgogine | q2_jun_grp0154          | MA       | BOA12322_GROUP_IHR | false      |
	    | 06    | F424804 | qavgogine | qavgogine | q2_jun_grp0155          | MA       | BOA12323_GROUP_IHR | false      |

    @memAuth_no_ihr_p5_boaGrp2
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 07    | F424804 | qavgogine | qavgogine | q2_jun_grp0156          | MA       | BOA12324_TERM_GROUP_IHR | false |

    #----------- begin - cases with IHR link
    @memAuth_ihr_p5_ma_mapd
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 08    | F424804 | qavgogine | qavgogine | q3_sep_UAT4_AARP203     | MA       | IHR                | true       |
	    | 09    | F424804 | qavgogine | qavgogine | q3_sep_UAT4_Group074    | MAPD     | NONBOA_GROUP_IHR   | true       |

    @memAuth_ihr_p5_pdp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 10    | F424804 | qavgogine | qavgogine | q2_jun_aarp0179         | PDP      | IHR                | true       |

	#note: MA user was having new Benefits UI and not behaving the same as prior PREEFF user
	#note: term user will have IHR link suppressed
    @memAuth_ihr_p5_preeff_term
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	 #  | 11    | F424804 | qavgogine | qavgogine | preeffectiveFEDMA_001   | MA       | PREEFF_IHR         | true       |
	    | 11    | F424804 | qavgogine | qavgogine | preeffectiveFEDPDP_001  | PDP      | PREEFF_IHR         | true       |
	    | 12    | F424804 | qavgogine | qavgogine | q2_jun_grp0440          | MAPD     | TERM_IHR           | false      |

    @memAuth_ihr_p5_pdpSspCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 13    | F424804 | qavgogine | qavgogine | q2_jun_grp0255          | SSP      | COMBO_PDP_SSP_IHR  | true       |
	    | 14    | F424804 | qavgogine | qavgogine | q2_jun_grp0255          | PDP      | COMBO_PDP_SSP_IHR  | true       |

    @memAuth_ihr_p5_fedShipCombo_shipFedCombo
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 15    | F424804 | qavgogine | qavgogine | q3_sep_UAT4_AARP023 | PDP      | COMBO_PDP_SHIP_IHR | true       |
	    | 16    | F424804 | qavgogine | qavgogine | q3_sept_UAT4_AARP_011       | MAPD       | COMBO_SHIP_MAPD_IHR  | true       |

    @memAuth_ihr_p5_medica_pcp
    Examples: 
	    | index | FID     | username  | password  | MemUserName             | planType | memberType         | expectLink | 
	    | 17    | F424804 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020     | MEDICA   | IHR                | true       |
	    | 18    | F424804 | qavgogine | qavgogine | q2_jun_sofl0002         | PCP      | IHR                | true       |


	    