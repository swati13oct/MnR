#@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  # 	Removing this scenario, added new validation step for
  #		combined validation for all 3 stages text validation fro LIS buydown plans
  # 	Added to LISbuydown validation - @DCE_DrugDetailsLISBuyDown
  #@dceRedesignExtraHelpAlertDetailPage @F478554 @F492102 @F519757
  Scenario Outline: Test to Verify that Extra help Warning messgae on drug detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user verify the extra help alert message on Drug Detail Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    And the user verifies the coverage gap message
      | coverageGap | <coverageGapMessage> |
    And the user verifies the catastrophic coverage message
      | catastrophicCoverage | <catastrophicCoverageMessage> |

    #    @dceRedesignExtraHelpAlertDetailPage_AARP @extraHelpSNPAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | AARP |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |

    #   @dceRedesignExtraHelpAlertDetailPage_UHC @extraHelpDSNUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | UHC  |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |

  # Removing this scenario - LIS validation is covered as part of end2end UAT scenario6
  #  @dceRedesignExtraHelpAlert @F477268 @F470669
  Scenario Outline: Test to Verify that Extra help Warning messgae on view drug pricing modal up
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup

    #		@dceRedesignExtraHelpAlert_AARP @extraHelpSNPAARP
    Examples: 
      | site | zipCode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      | AARP |   10001 | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #    @dceRedesignExtraHelpAlert_UHC @extraHelpSNPUHC
    Examples: 
      | site | zipCode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      | UHC  |   10001 | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  #@dceRedesignExtraHelpAlertDetailPage @F478554 @F492102
  Scenario Outline: Test to Verify that Extra help Warning messgae on drug detail page
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    And verify the default tab displayed on VPP details page
      | TabName | <tabName> |
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on drug cost estimator on vpp plan detail page in AARP
    Then User validates planName matches plan Name in DCE detail page in AARP

    #    @drugDetailsDCEViewPlanSummaryButton_MAPD @dceViewPlanSummaryButton_AARP @F501519
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | planname                                       | tabName                       |
      | AARP |   90210 | future   | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage Freedom Plus (HMO-POS) | Medical Benefits and Programs |

    #   @drugDetailsDCEViewPlanSummaryButton_PDP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                        | tabName                    |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | Lipitor | AARP MedicareRx Walgreens (PDP) | Prescription Drug Benefits |

    #    @drugDetailsDCEViewPlanSummaryButton_SNP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | AARP |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

    #   @drugDetailsDCEViewPlanSummaryButton_MAPD_MAPD_UHC @F501519 @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | planname                                       | tabName                       |
      | UHC  |   90210 | future   | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage Freedom Plus (HMO-POS) | Medical Benefits and Programs |

    #  @drugDetailsDCEViewPlanSummaryButton_PDP_UHC @F501519 @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                        | tabName                    |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | Lipitor | AARP MedicareRx Walgreens (PDP) | Prescription Drug Benefits |

    # @drugDetailsDCEViewPlanSummaryButton_SNP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | UHC  |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

  #@DCE_Redesign_DCEViewPlanSummaryBtnNotExist
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary are not visible when user navigate away from DCE and navigate to VPP detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    And verify the default tab displayed on VPP details page
      | TabName | <tabName> |
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on view plan summary on vpp detail page
    Then user click on view plan details on summary page in AARP

    #@DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    # @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | tabName                       | planname                        |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | meloxicam | Medical Benefits and Programs | AARP MedicareRx Walgreens (PDP) |

    #  @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | AARP |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

    #   @DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #    @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | tabName                       | planname                        |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | meloxicam | Medical Benefits and Programs | AARP MedicareRx Walgreens (PDP) |

    #    @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | UHC  |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

  #  @noPrescriptionCoverage @F492445
  Scenario Outline: Test to verify No Prescription Coverage for Pharmacies on DCE Details Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    And user clicks on change pharmacy link from details page
    Then user change the pharmacy to view no prescription coverage

    #   @noPrescriptionCoverge_MAPD_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | AARP |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

    #    @noPrescriptionCoverge_MAPD_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  #  @noPrescriptionCoverage @F492445
  Scenario Outline: Test to verify No Prescription Coverage for Pharmacies on DCE Details Page
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign on aarp site from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    #Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    And user clicks on change pharmacy link from details page in AARP
    Then user change the pharmacy to view no prescription coverage

    #Then user validate the monthly premium value on detail page
    #  @noPrescriptionCoverge_MAPD
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  # @noPrescriptionCoverge_SNP
  #  Examples:
  # | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              | planyear |
  #|   78006 | SNP      | Bexar County | yes             | Lipitor | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Dual Complete (HMO D-SNP) | future |
  # @noPrescriptionCoverge_PDP
  #  Examples:
  # | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              | planyear |
  #|   78006 | PDP      | Bexar County | yes             | Lipitor | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor |  AARP MedicareRx Walgreens (PDP) | future |
  #  @dceNBADrugSummaryPage @F465679 @decRelease
  Scenario Outline: Test to Verify that DCE NBA on Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    # And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And verify DCE NBA is displayed on drug summary page

    #		@dceNBADrugSummaryPage_AARP
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | AARP |   10001 | none   | no              | Orkambi |

    #     @dceNBADrugSummaryPage_UHC
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | UHC  |   10001 | none   | no              | Orkambi |

  #  @dceNBADetailPageNBA @F509520 @decRelease
  Scenario Outline: Test to Verify the DCE NBA on drug detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    And verify DCE NBA is displayed on drug details page

    #  @dceNBADetailPageNBA_MAPD_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    # @dceNBADetailPageNBA_PDP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      | AARP |   10001 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    #  @dceNBADetailPageNBA_SNP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planname                                   | planyear |
      | AARP |   78006 | SNP      | Bexar County | yes             | Emsam | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    #   @dceNBADetailPageNBA_MAPD_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #    @dceNBADetailPageNBA_PDP_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      | UHC  |   10001 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    #    @dceNBADetailPageNBA_SNP_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planname                                   | planyear |
      | UHC  |   78006 | SNP      | Bexar County | yes             | Emsam | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  #      @DCERedesign_DCE-VPPDetails_DrugSummary
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary button on VPP detail page from Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    When user clicks on view plan details button on drug summary page
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP details page
    And verify the default tab displayed on VPP details page
      | TabName | <tabName> |
    Then the user verify the drug cost estimator and view plan summary buttons on VPP detail page
    When the user click on drug cost estimator button on vpp plan detail page
    Then user verify the drug summary page

    Examples: 
      | site | drug1   | zipCode | planName                            | tabName                       |
      | AARP | Lipitor |   10001 | AARP Medicare Advantage Prime (HMO) | Medical Benefits and Programs |

    Examples: 
      | site | drug1   | zipCode | planName                            | tabName                       |
      | UHC  | Lipitor |   10001 | AARP Medicare Advantage Prime (HMO) | Medical Benefits and Programs |

  #   @dceRedesignDrugDetailsDefaultPharmacy @F497405
  Scenario Outline: Test to Verify default Retail chain pharmacy on detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user verify the Retail chain pharmacy on detail page
    And user clicks on change pharmacy link from details page
    Then user clicks on Keep Using This Pharmacy on change pharmacy page
    Then user validate "WALGREENS" pharmacy on detail page

    #  @dceRedesignDrugDetailsDefaultPharmacy_MAPD_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #   @dceRedesignDrugDetailsDefaultPharmacy_MAPD_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  # @editPharmacyFromVPPDetail @decRelease
  Scenario Outline: Test to verify user can edit the pharmacy from vpp detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    #And clicks on Review drug cost button for detail page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user verify and edit the Pharmacy from vpp detail page
    Then user clicks on change pharmacy link from details page

    #   @editPharmacyFromVPPDetail_AARP
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | planyear | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | AARP |   90210 | MAPD     | none   | no              | meloxicam | future   | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #    @editPharmacyFromVPPDetail_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  #  @drugDetailPharmacyFunctionality @decRelease
  Scenario Outline: Test to verify sort, pagination, invalid zipcode error functionality for change pharmacy on drug detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    When user clicks on change pharmacy link from details page
    Then user verify details page change pharmacy modal
    When user selects Preferred mail order pharmacy from drug details page
    Then the message "OptumRx Home Delivery only provides 90-day refill for your drugs." should be displayed on change pharmacy modal from drug detail page
    And user verify the default distance on change pharmacy modal from drug details
    When user sort the pharmacy list by "A to Z" from drug details
    Then pharmacy list should be displayed in ascending order from drug details
    When user sort the pharmacy list by "Z to A" from drug details
    Then pharmacy list should be displayed in descending order from drug details
    When user clicks on next button on change pharmacy modal from drug details
    Then user should be navigated to second page of pharmacy list from drug details
    When user clicks on back button on change pharmacy modal from drug details
    Then user should be navigated to first page of pharmacy list from drug details
    When user search with zipcode with no pharamacies from drug details
      | ZipCode | <zipCode1> |
    When user search with incorrect zipcode from drug details
      | ZipCode | <zipCode2> |
    Then error message "Please enter a valid ZIP code." should be displayed on change pharmacy modal from drug details

    #    @drugDetailPharmacyFunctionality_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | planname                                           |
      | AARP |   90001 | MAPD     | none   | no              | meloxicam |    96799 |    78456 | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #  @drugDetailPharmacyFunctionality_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | drug4         | drug5            | drug6   | planname                                           |
      | UHC  |   90001 | MAPD     | none   | no              | meloxicam |    96799 |    78456 | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  # @dCERedesign_ChangePharmacy_DetailsPage @F472598
  Scenario Outline: Test to verify change pharmacy functionality from Drug details page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
    And user clicks on change pharmacy link from details page
    Then details page change pharmacy modal should be displayed
    And user verify details page change pharmacy modal
    When user saves and updates pharmacy from list on details page
    Then the pharmacy name should be updated on details page

    #		@dCERedesign_ChangePharmacy_DetailsPage_AARP
    Examples: 
      | site | drug1   | zipCode |
      | AARP | Lipitor |   90001 |

    #     @dCERedesign_ChangePharmacy_DetailsPage_UHC
    Examples: 
      | site | drug1   | zipCode |
      | UHC  | Lipitor |   90001 |

  #    @drugSummary_DefaultPlanType @F504721
  Scenario Outline: Test to verify plan toggle functionality on Drug summary page when no MAPD plans available
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Prescription Drug Plans" by default

    #		@drugSummary_DefaultPlanType_AARP
    Examples: 
      | site | drug1   | zipCode |
      | AARP | Lipitor |   41311 |

    #    @drugSummary_DefaultPlanType_UHC
    Examples: 
      | site | drug1   | zipCode |
      | UHC  | Lipitor |   41311 |

  #   @drugSummary_DefaultPlanType @F504721
  Scenario Outline: To verify default plan type on drug summary page when no MAPD plans available -home page -DCE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default

    #	@drugSummary_DefaultPlanType_AARP
    Examples: 
      | drug1   | zipCode | site |
      | Orkambi |   74562 | AARP |

    #		@drugSummary_DefaultPlanType_UHC
    Examples: 
      | drug1   | zipCode | site |
      | Orkambi |   74562 | UHC  |

  # @DCE_DrugSummary_ValidatePage
  Scenario Outline: Test to verify the Drug summary page in AARP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user verify the drug summary page

    #@DCE_DrugSummary_ValidatePage_AARP
    Examples: 
      | site | zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      | AARP |   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    #    @DCE_DrugSummary_ValidatePage_UHC
    Examples: 
      | site | zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      | UHC  |   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  #  @drugSummary_SAM_Icon_AARP
  Scenario Outline: Test to verify SAM icon is visible on Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible

    Examples: 
      | site | drug1   | zipCode |
      | AARP | Lipitor |   90210 |

    Examples: 
      | site | drug1   | zipCode |
      | UHC  | Lipitor |   90210 |

  #  @drugSummary_PlanToggle @F477157 @F472327 @F493728 @F504721
  Scenario Outline: Test to verify plan toggle functionality on Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user should be able to toggle between plan types

    #		@drugSummary_PlanToggle_AARP
    Examples: 
      | site | drug1   | zipCode |
      | AARP | Lipitor |   90210 |

    #    @drugSummary_PlanToggle_UHC
    Examples: 
      | site | drug1   | zipCode |
      | UHC  | Lipitor |   90210 |

  # @dceRedesignSwitchToGenericDrug @F484185 @F495366 @decRelease
  Scenario Outline: Test to Verify that user can update drug dosage, quantity and supply length in switch to generic drug modal
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user click on View Drug Pricing Modal
    And user click on Switch To Generic link for "<drug1>" on drug pricing modal
    And user updates dosage quantity and supply length in switch to generic modal
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName1> |

    #      @dceRedesignSwitchToGenericDrug_Summary_AARP
    Examples: 
      | site | zipCode | drug1   | drugName1                     |
      | AARP |   10001 | Lipitor | atorvastatin calcium TAB 20MG |

    #      @dceRedesignSwitchToGenericDrug_Summary_UHC
    Examples: 
      | site | zipCode | drug1   | drugName1                     |
      | UHC  |   10001 | Lipitor | atorvastatin calcium TAB 20MG |

  # @dceSaveplanandBacktoplans @F492270
  Scenario Outline: Test to verify that user can Save plan on DCE summary page and navigating back to homepage to retain the cart value
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    Then user saves plan as favorite on drug summary page AARP site
      | Test Plans | <testPlans> |
    Then user save PDP plan as favorite on drug summary page AARP site
      | PDP Plans | <pdptestPlans> |
    Then user save SNP plan as favorite on drug summary page AARP site
      | SNP Plans | <snptestPlans> |
    And user click on return to home on drug summary in AARP site
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <testPlansName> |

    Examples: 
      | site | drug1   | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               | testPlansName                                                                                                                               |
      | AARP | Orkambi |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP MedicareRx Preferred (PDP),UnitedHealthcare Dual Complete (HMO D-SNP) |

    Examples: 
      | site | drug1   | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               | testPlansName                                                                                                                               |
      | UHC  | Orkambi |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP MedicareRx Preferred (PDP),UnitedHealthcare Dual Complete (HMO D-SNP) |

  @dCERedesign_PlanSave @F476042
  Scenario Outline: Test to verify unauthenticated user save the plan on drug summary page and see the saved plan on guest profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    Then user saves plan as favorite on drug summary page AARP site
      | Test Plans | <testPlans> |
    Then user save PDP plan as favorite on drug summary page AARP site
      | PDP Plans | <pdptestPlans> |
    Then user save SNP plan as favorite on drug summary page AARP site
      | SNP Plans | <snptestPlans> |
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <testPlans>    |
      | PDP Plans  | <pdptestPlans> |
      | SNP Plans  | <snptestPlans> |

    Examples: 
      | site | drug1 | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               |
      | AARP | Emsam |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

    Examples: 
      | site | drug1 | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               |
      | UHC  | Emsam |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |
