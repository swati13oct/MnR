@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  @DCE_Redesign_VPP_PlanDetails
  Scenario Outline: 1.10.2.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Details
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page

    @DCE_Redesign_VPP_PlanDetails_MAPD_AARP
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | AARP |   90210 | future   | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanDetails_MAPD_UHC
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | UHC  |   90210 | future   | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanDetails_PDP_AARP
    Examples: 
      | site | zipcode | planyear | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | AARP |   80002 | future   | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPP_PlanDetails_PDP_UHC
    Examples: 
      | site | zipcode | planyear | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | UHC  |   80002 | future   | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPP_PlanDetails_SNP_AARP
    Examples: 
      | site | zipcode | planyear | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                                   |
      | AARP |   78006 | future   | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |

    @DCE_Redesign_VPP_PlanDetails_SNP_UHC
    Examples: 
      | site | zipcode | planyear | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                                   |
      | UHC  |   78006 | future   | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |

  @drugDetailsDCEViewPlanSummaryButton
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary buttons on VPP detail page
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
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on drug cost estimator on vpp plan detail page in AARP
    Then User validates planName matches plan Name in DCE detail page in AARP

    @DCE_Redesign_DCE_Detail_to_Vpp_Details_MAPD
    Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1     | planname                                           | planyear |
      |   90210 | MAPD     | none   | no              | meloxicam | AARP Medicare Advantage SecureHorizons Focus (HMO) | future   |

    @DCE_Redesign_DCE_Detail_to_Vpp_Details_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      |   80002 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    @DCE_Redesign_DCE_Detail_to_Vpp_Details_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                                              | planyear |
      |   78006 | SNP      | Bexar County | yes             | meloxicam | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | future   |

  @DCE_Redesign_VPPSummary_to_Vpp_Details
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary are not visible when user navigate away from DCE and navigate to VPP detail page
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
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on view plan summary on vpp detail page
    Then user click on veiw plan details on summary page in AARP

    #Then user verifiy drug cost estomator and view plan summary is not exist in vpp detail page in ARRP
    @DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD
    Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1     | planname                                           | planyear |
      |   90210 | MAPD     | none   | no              | meloxicam | AARP Medicare Advantage SecureHorizons Focus (HMO) | future   |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      |   80002 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                                              | planyear |
      |   78006 | SNP      | Bexar County | yes             | meloxicam | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | future   |

  
  @dceRedesignExtraHelpAlertDetailPage @F478554 @F492102
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

    @drugDetailsDCEViewPlanSummaryButton_MAPD @dceViewPlanSummaryButton_AARP @F501519
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | planname                                       | tabName                       |
      | AARP |   90210 | future   | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage Freedom Plus (HMO-POS) | Medical Benefits and Programs |

    @drugDetailsDCEViewPlanSummaryButton_PDP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                        | tabName                    |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | Lipitor | AARP MedicareRx Walgreens (PDP) | Prescription Drug Benefits |

    @drugDetailsDCEViewPlanSummaryButton_SNP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | AARP |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

    @drugDetailsDCEViewPlanSummaryButton_MAPD_MAPD_UHC @F501519 @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | planname                                       | tabName                       |
      | UHC  |   90210 | future   | MAPD     | none   | no              | Lipitor | AARP Medicare Advantage Freedom Plus (HMO-POS) | Medical Benefits and Programs |

    @drugDetailsDCEViewPlanSummaryButton_PDP_UHC @F501519 @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                        | tabName                    |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | Lipitor | AARP MedicareRx Walgreens (PDP) | Prescription Drug Benefits |

    @drugDetailsDCEViewPlanSummaryButton_SNP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | UHC  |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

  @DCE_Redesign_DCEViewPlanSummaryBtnNotExist
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

    @DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | tabName                       | planname                        |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | meloxicam | Medical Benefits and Programs | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP_AARP @dceViewPlanSummaryButton_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | AARP |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | tabName                       | planname                        |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | meloxicam | Medical Benefits and Programs | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP_UHC @dceViewPlanSummaryButton_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                                              | tabName                       |
      | UHC  |   78006 | SNP      | future   | Bexar County | yes             | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | Medical Benefits and Programs |

  @noPrescriptionCoverage @F492445
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

    @noPrescriptionCoverge_MAPD_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | AARP |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

    @noPrescriptionCoverge_MAPD_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  @dceRedesignExtraHelpAlertDetailPage @F478554 @F492102 @F519757
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

    @dceRedesignExtraHelpAlertDetailPage_AARP @extraHelpSNPAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | AARP |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |

    @dceRedesignExtraHelpAlertDetailPage_UHC @extraHelpDSNUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | UHC  |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |

  @dceRedesignDrugDetailsDefaultPharmacy @F497405
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

    @dceRedesignDrugDetailsDefaultPharmacy_MAPD_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dceRedesignDrugDetailsDefaultPharmacy_MAPD_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @dceNBADetailPageNBA @F509520 @decRelease
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

    @dceNBADetailPageNBA_MAPD_AARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dceNBADetailPageNBA_PDP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      | AARP |   10001 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    @dceNBADetailPageNBA_SNP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planname                                   | planyear |
      | AARP |   78006 | SNP      | Bexar County | yes             | Emsam | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @dceNBADetailPageNBA_MAPD_UHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | tabName                       | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | meloxicam | Medical Benefits and Programs | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dceNBADetailPageNBA_PDP_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      | UHC  |   10001 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    @dceNBADetailPageNBA_SNP_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planname                                   | planyear |
      | UHC  |   78006 | SNP      | Bexar County | yes             | Emsam | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  @dceRedesing_PlanCost @F501519 @decRelease
  Scenario Outline: Test to Verify Prescription Drug benefit and plan cost tab on vpp details
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Prescription Drug Benefits and validates in AARP site
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | planName                                       | monthlyPremium | yearlyPremium | planyear |
      |   53503 | No              | Iowa County | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | $47            | $564          | current  |

  @dceSwitchtoGenericNBA @F505210 @decRelease
  Scenario Outline: Test to verify Switch to generic NBA on DCE Details Page
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
    Then user verify and click on switch to generic NBA on drug detail page
    Then verify drug is switched to generic on detail page

    @dceSwitchtoGenericNBA_MAPD_AARP  @switchtoGenericAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | drug2   | planname                             |
      | AARP |   78006 | MAPD     | Bexar County | yes             | Lipitor | orfadin | AARP Medicare Advantage Choice (PPO) |

    @dceSwitchtoGenericNBA_MAPD_UHC @switchtoGenericUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | drug2   | planname                             |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | orfadin | AARP Medicare Advantage Choice (PPO) |

  @detailPageChangePharmacy @decRelease
  Scenario Outline: Test to verify default distance and zip code, miles dropdown for pharmacy from vpp detail page
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
    Then user verify details page change pharmacy modal

    @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | AARP |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

    @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  @editPharmacyFromVPPDetail @decRelease
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

    @editPharmacyFromVPPDetail_AARP
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | planyear | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | AARP |   90210 | MAPD     | none   | no              | meloxicam | future   | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @editPharmacyFromVPPDetail_UHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                             | planyear |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | AARP Medicare Advantage Choice (PPO) | future   |

  @drugDetailPharmacyFunctionality @decRelease
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

    @drugDetailPharmacyFunctionality_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | planname                                           |
      | AARP |   90001 | MAPD     | none   | no              | meloxicam |    96799 |    78456 | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @drugDetailPharmacyFunctionality_UHC @drugDetailschangePharmacyUHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | drug4         | drug5            | drug6   | planname                                           |
      | UHC  |   90001 | MAPD     | none   | no              | meloxicam |    96799 |    78456 | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @dCERedesign_ChangePharmacyDetailsNoResults @decRelease
  Scenario Outline: Test to verify no results message displayed for change pharmacy modal on drug details page
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
    Then user clicks on change pharmacy link from details page
    Then user verify details page change pharmacy modal
    When user search with zipcode with no pharamacies from drug details
      | ZipCode | <zipCode1> |
    When user updates the distance to "2 Miles" from drug details
    Then no results message should be displayed from drug details
      | NoResultsMessage | <message> |

    @dCERedesign_ChangePharmacyDetailsNoResults_AARP111 @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | message                                                                                                    | planname                                           |
      | AARP |   90001 | MAPD     | future   | none   | no              | meloxicam |    78006 |    78456 | Prescription drug home delivery is available through OptumRx. Learn more about OptumRx Mail Order Pharmacy | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dCERedesign_ChangePharmacyDetailsNoResults_UHC @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | zipCode1 | zipCode2 | message                                                                                                    | planname                                           |
      | AARP |   90001 | MAPD     | future   | none   | no              | meloxicam |    78006 |    78456 | Prescription drug home delivery is available through OptumRx. Learn more about OptumRx Mail Order Pharmacy | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @dCERedesign_PlanSave_AARP @F476042 @decRelease
  Scenario Outline: Test to verify unauthenticated user save the plan on drug details page and see the saved plan on guest profile
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
    When the user saves plan from drug details page
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <planname> |

    @dCERedesign_PlanSave_MAPD_AARP @dceDrugDetailSaveAARP
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | planname                                       | planyear |
      | AARP |   90210 | MAPD     | none   | no              | meloxicam | AARP Medicare Advantage Freedom Plus (HMO-POS) | future   |

    @dCERedesign_PlanSave_PDP_AARP @dceDrugDetailSaveAARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1   | planname                        | planyear |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | Lipitor | AARP MedicareRx Walgreens (PDP) | future   |

    @dCERedesign_PlanSave_PDP_AARP @dceDrugDetailSaveAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1   | planname                                   | planyear |
      | AARP |   10001 | SNP      | future   | none   | no              | Lipitor | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @dCERedesign_PlanSave_MAPD_UHC @dceDrugDetailSaveUHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | planname                                       | planyear |
      | UHC  |   90210 | MAPD     | none   | no              | meloxicam | AARP Medicare Advantage Freedom Plus (HMO-POS) | future   |

    @dCERedesign_PlanSave_PDP_UHC @dceDrugDetailSaveUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | planname                        | planyear |
      | UHC  |   80002 | PDP      | Adams County | yes             | meloxicam | AARP MedicareRx Walgreens (PDP) | future   |

    @dCERedesign_PlanSave_SNP_UHC @dceDrugDetailSaveUHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | planname                                   | planyear |
      | AARP |   10001 | SNP      | none   | no              | meloxicam | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  @dce_Redesign_VPP_PlanDetails_Pharmacy_PDP @decRelease
  Scenario Outline: Test to verify preferred and Standard tab on drug detail change pharmacy
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
    # And clicks on Review drug cost button for detail page
    Then user clicks on change pharmacy link from details page
    Then user verify details page change pharmacy modal for preferred tab
    Then user click on standard tab from drug details

    @dce_Redesign_VPP_PlanDetails_Pharmacy_PDP_AARP @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | planyear | planyear | plantype | county       | isMultutiCounty | drug1     | zipCode1 | planyear | planname                        |
      | AARP |   80002 | current  | future   | PDP      | Adams County | yes             | meloxicam |    78006 | future   | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanDetails_Pharmacy_PDP_UHC @drugDetailschangePharmacyAARP
    Examples: 
      | site | zipcode | planyear | planyear | plantype | county       | isMultutiCounty | drug1     | zipCode1 | planyear | planname                        |
      | UHC  |   80002 | current  | future   | PDP      | Adams County | yes             | meloxicam |    78006 | future   | AARP MedicareRx Walgreens (PDP) |
