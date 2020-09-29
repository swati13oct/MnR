@pharmaciesandprescriptionsPreEff
Feature: 1.18.1 Member Pharamcies And Prescriptions page - Pre-Effective

#----- being regression section --------------------

  @pharmaciesandprescriptionsPreEff01 @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    ##Then user navigates to the plan documents and resources page to validate Pharamcies and Prescriptions link
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

	@pnpPreff_mapd_ind @devRegression
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | IND_PREEFF_PnP      | yes        |

	@pnpPreff_mapd_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_PREEFF_PnP      | yes        |

	@pnpPreff_mapd_grp_lghib
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_LGHIB_PREEFF_PnP| yes        |

	@pnpPreff_mapd_grp_seib
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MAPD     | GRP_SEIB_PREEFF_PnP | yes        |

	@pnpPreff_pdp_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | PDP      | IND_PREEFF_PnP      | yes        |

	@pnpPreff_pdp_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | PDP      | GRP_PREEFF_PnP      | yes        |

	@pnpPreff_snp_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SNP      | IND_PREEFF_PnP      | yes        |

	@pnpPreff_ssp_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SSP      | GRP_PREEFF_PnP      | yes        |

  @pharmaciesandprescriptionsPreEff02 @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    ##Then user navigates to the plan documents and resources page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link

	@pnpPreff_ma_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MA       | IND_PREEFF_PnP      | no         |

	@pnpPreff_ma_grp
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | MA       | GRP_PREEFF_PnP      | no         |

	@pnpPreff_ship_ind
    Examples: 
	  | FID     | planType | memberType          | expectLink |
	  | F493942 | SHIP     | IND_PREEFF_PnP      | no         |
	  