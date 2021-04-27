<<<<<<< HEAD
@DCE_Redesign_VPP_Details @regressionAARP
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  @DCE_Redesign_VPP_PlanDetails
  Scenario Outline: 1.10.2.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Details
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page

    @DCE_Redesign_VPP_PlanDetails_MAPD_AARP @OnlyProd
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | AARP |   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanDetails_PDP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | AARP |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPP_PlanDetails_SNP_AARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                                   |
      | AARP |   78006 | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |
=======
@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site


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
    

    @dceSwitchtoGenericNBA_MAPD_AARP  @switchtoGenericAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | drug2   | planname                             |
      | AARP |   78006 | MAPD     | Bexar County | yes             | Lipitor | orfadin | AARP Medicare Advantage Choice (PPO) |

    @dceSwitchtoGenericNBA_MAPD_UHC @switchtoGenericUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1   | drug2   | planname                             |
      | UHC  |   78006 | MAPD     | Bexar County | yes             | Lipitor | orfadin | AARP Medicare Advantage Choice (PPO) |


  @DCE_Redesign_VPP_PlanDetails 
  Scenario Outline: 1.10.2.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Details
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
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
    
         
  @dCERedesign_PlanSave_AARP @F476042 @decRelease
  Scenario Outline: Test to verify unauthenticated user save the plan on drug details page and see the saved plan on guest profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
   Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And the user validates the available plans for selected plan types
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    When the user saves plan from drug details page
    | Plan Name | <planname> |
    Then Navigate to Visitor Profile page
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
      
>>>>>>> branch 'develop' of https://github.optum.com/gov-prog-digital/mratdd.git
