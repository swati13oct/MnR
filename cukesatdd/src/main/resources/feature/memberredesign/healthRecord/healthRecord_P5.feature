@healthRecord
Feature: 1.24.e Member Individual Health Record - P5 - PharmacyLocator, DCE

  @healthRecord01 @regressionMember @US2471601 @F424804
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table - P5 - PharmacyLocator, DCE
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user store expected link behavior
      | Expect Link | <expectLink>       |
	Then the user navigates to Pharmacy Locator page and validate Health Record link display behavior
	Then the user navigates to DCE page and validate Health Record link display behavior

    #----------- begin - cases with NO IHR link
    @no_ihr_p5_ship_exclude
    Examples: 
	    | index | FID     | planType                 | memberType         | expectLink  | 
	    | 01    | F424804 | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |
	    | 02    | F424804 | MA                       | EXCLUDE_IHR        | false       |

    @no_ihr_p5_shipCombo
    Examples: 
	    | index | FID     | planType                 | memberType         | expectLink | 
	    | 03    | F424804 | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_IHR | false      |
	    | 04    | F424804 | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_MAPD_IHR| false      |

    @no_ihr_p5_boaGrp1
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 05    | F424804 | MA       | BOA12322_GROUP_IHR | false      |
	    | 06    | F424804 | MA       | BOA12323_GROUP_IHR | false      |

    @no_ihr_p5_boaGrp2
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 07    | F424804 | MA       | BOA12324_TERM_GROUP_IHR | false |

    #----------- begin - cases with IHR link
    @ihr_p5_ma_mapd @devRegression
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 08    | F424804 | MA       | IHR                | true       |
	    | 09    | F424804 | MAPD     | NONBOA_GROUP_IHR   | true       |

    @ihr_p5_pdp
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 10    | F424804 | PDP      | IHR                | true       |

	#note: MA user was having new Benefits UI and not behaving the same as prior PREEFF user
    @ihr_p5_preeff_term
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 11    | F424804 | PDP      | PREEFF_IHR         | true       |
	    | 12    | F424804 | MAPD     | TERM_IHR           | true       |

    @ihr_p5_pdpSspCombo
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 13    | F424804 | SSP      | COMBO_PDP_SSP_IHR  | true       |
	    | 14    | F424804 | PDP      | COMBO_PDP_SSP_IHR  | true       |

    @ihr_p5_fedShipCombo_shipFedCombo
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 15    | F424804 | PDP      | COMBO_PDP_SHIP_IHR | true       |
	    | 16    | F424804 | MAPD     | COMBO_SHIP_MAPD_IHR| true       |

    @ihr_p5_medica_pcp
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 17    | F424804 | MEDICA   | IHR                | true       |
	    | 18    | F424804 | PCP      | IHR                | true       |

	    