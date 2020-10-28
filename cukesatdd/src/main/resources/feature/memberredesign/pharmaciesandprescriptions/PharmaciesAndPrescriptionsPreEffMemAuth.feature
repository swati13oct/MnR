@pharmaciesandprescriptionsPreEff
Feature: 1.18.1.1 Member Pharamcies And Prescriptions page - Pre-Effective - Member Auth

#----- being regression section --------------------

  @memAuth_pnpPreEff01
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
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
    Then check if user is a preeffective user
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
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

	@memAuth_pnpPreEff_mapd_ind @devRegression
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | q2_june_NiceSeg_100       | MAPD     | IND_PREEFF_PnP      | yes        |

	@memAuth_pnpPreEff_mapd_grp
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffectivegroupmapd_001 | MAPD     | GRP_PREEFF_PnP      | yes        |

	@memAuth_pnpPreEff_mapd_grp_lghib
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | testGrpLghibUser01        | MAPD     | GRP_LGHIB_PREEFF_PnP| yes        |

	@memAuth_pnpPreEff_mapd_grp_seib
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | testGrpSeibUser01         | MAPD     | GRP_SEIB_PREEFF_PnP | yes        |

	@memAuth_pnpPreEff_pdp_ind
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffectiveFEDPDP_001    | PDP      | IND_PREEFF_PnP      | yes        |

	@memAuth_pnpPreEff_pdp_grp
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffectiveGroupPDP_001  | PDP      | GRP_PREEFF_PnP      | yes        |

	@memAuth_pnpPreEff_snp_ind
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | testSnpUser01             | SNP      | IND_PREEFF_PnP      | yes        |

	@memAuth_pnpPreEff_ssp_grp
    Examples: 
	  | FID     | username  | password  | MemUserName               | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffectiveGroupSSUP01   | SSP      | GRP_PREEFF_PnP      | yes        |

  @memAuth_pnpPreEff02
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
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
    Then check if user is a preeffective user
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the plan documents and resources page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link

	@memAuth_pnpPreEff_ma_ind
    Examples: 
	  | FID     | username  | password  | MemUserName             | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffectiveFEDMA_001   | MA       | IND_PREEFF_PnP      | no         |

	@memAuth_pnpPreEff_ma_grp
    Examples: 
	  | FID     | username  | password  | MemUserName             | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | preeffective_GroupMA_001| MA       | GRP_PREEFF_PnP      | no         |

	@memAuth_pnpPreEff_ship_ind
    Examples: 
	  | FID     | username  | password  | MemUserName             | planType | memberType          | expectLink |
	  | F493942 | qavgogine | qavgogine | shipPreeffective707     | SHIP     | IND_PREEFF_PnP      | no         |
	  