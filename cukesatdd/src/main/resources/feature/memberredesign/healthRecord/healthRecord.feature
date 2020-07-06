@healthRecord
Feature: 1.24 Member Individual Health Record

  @healthRecord01 @regressionMember @US2471601 @F424804
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user validates Health Record link display behavior on Account Profile dropdown base on test input
      | Expect Link | <expectLink>       |
    Then the user validates clicking Health Record link will open new tab to the target page
	Then the user navigates to Find Care page if applicable and validate Health Record link display behavior
	Then the user navigates to Claims page if applicable and validate Health Record link display behavior
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

    @no_ihr_a
    Examples: 
	    | index | FID     | planType                 | memberType         | expectLink  | 
	    | 01    | F424804 | SHIP_MEDICARE SUPPLEMENT | NO_IHR             | false       |
	    | 02    | F424804 | MA                       | EXCLUDE_IHR        | false       |

    @no_ihr_b
    Examples: 
	    | index | FID     | planType                 | memberType         | expectLink | 
	    | 03    | F424804 | SHIP_MEDICARE SUPPLEMENT | COMBO_PDP_SHIP_IHR | false      |
	    | 04    | F424804 | SHIP_MEDICARE SUPPLEMENT | COMBO_SHIP_PDP_IHR | false      |

    @ihr_a @devRegression
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 05    | F424804 | MA       | IHR                | true       |
	    | 06    | F424804 | MAPD     | GROUP_IHR          | true       |
	    | 07    | F424804 | PDP      | IHR                | true       |

    @ihr_b
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 08    | F424804 | MA       | PREEFF_IHR         | true       |
	    | 09    | F424804 | MAPD     | TERM_IHR           | true       |

    @ihr_c
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 10    | F424804 | SSP      | COMBO_PDP_SSP_IHR  | true       |
	    | 11    | F424804 | PDP      | COMBO_PDP_SSP_IHR  | true       |

    @ihr_d
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 12    | F424804 | PDP      | COMBO_PDP_SHIP_IHR | true       |
	    | 13    | F424804 | PDP      | COMBO_SHIP_PDP_IHR | true       |

    @ihr_e
    Examples: 
	    | index | FID     | planType | memberType         | expectLink | 
	    | 14    | F424804 | MEDICA   | IHR                | true       |
	    | 15    | F424804 | PCP      | IHR                | true       |
	    