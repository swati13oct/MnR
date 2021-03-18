
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
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |AARP|   10001 | MAPD     | none   | no              | Lipitor    | AARP Medicare Advantage SecureHorizons Focus (HMO) |
     
 #    @dceRedesignExtraHelpAlert_UHC @extraHelpSNPUHC
      Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |UHC|   10001 | MAPD     | none   | no              | Lipitor    | AARP Medicare Advantage SecureHorizons Focus (HMO) |


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
      |site| zipcode | county | isMultutiCounty | drug1   |
      |AARP|   10001 | none   | no              | Orkambi |
      
 #     @dceNBADrugSummaryPage_UHC
      Examples: 
      |site| zipcode | county | isMultutiCounty | drug1   |
      |UHC|   10001 | none   | no              | Orkambi |

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

       