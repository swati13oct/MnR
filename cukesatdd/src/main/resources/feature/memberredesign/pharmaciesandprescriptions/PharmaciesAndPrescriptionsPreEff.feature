@pharmaciesandprescriptionsPreEff
Feature: 1.18.1 Member Pharamcies And Prescriptions page - Pre-Effective

  #----- being sanity section --------------------
  @sanity01
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    Then check if user is a preeffective user
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    Then user validates preeffective content for header section
    Then user validate preeffective content for plan start date and links section
    Then user validate preeffective content for important note section
    Then user validates Need Help section content for pharmacies and prescriptions page
	Then user validates footer section content for pharmacies and prescriptions page

	@pnpPreEff_mapd_ind_sanity
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | IND_PREEFF_PnP      | yes        |
	  
	  
  #----- being regression section --------------------
  # note: pre-eff user has no EOB, skip eob page validation
  @pnpPreEff01 @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then check if user is a preeffective user
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    #Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the plan documents and resources page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    Then user validates preeffective content for header section
    Then user validate preeffective content for plan start date and links section
    Then user validate preeffective content for important note section
    Then user validates Need Help section content for pharmacies and prescriptions page
	Then user validates footer section content for pharmacies and prescriptions page

	@pnpPreEff_mapd_ind @devRegression
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | IND_PREEFF_PnP      | yes        |

	@pnpPreEff_mapd_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_PREEFF_PnP      | yes        |

	@pnpPreEff_mapd_grp_lghib
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_LGHIB_PREEFF_PnP| yes        |

	@pnpPreEff_mapd_grp_seib
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_SEIB_PREEFF_PnP | yes        |

	@pnpPreEff_pdp_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | PDP      | IND_PREEFF_PnP      | yes        |

	@pnpPreEff_pdp_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | PDP      | GRP_PREEFF_PnP      | yes        |

	@pnpPreEff_snp_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SNP      | IND_PREEFF_PnP      | yes        |

	@pnpPreEff_ssp_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SSP      | GRP_PREEFF_PnP      | yes        |

  @pnpPreEff02 @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then check if user is a preeffective user
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    #Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the plan documents and resources page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link

	@pnpPreEff_ma_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MA       | IND_PREEFF_PnP      | no         |

	@pnpPreEff_ma_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MA       | GRP_PREEFF_PnP      | no         |

	@pnpPreEff_ship_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SHIP     | IND_PREEFF_PnP      | no         |
	  